package com.innovative.foodciti.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.innovative.foodciti.R;
import com.innovative.foodciti.constant.AppConstant;
import com.innovative.foodciti.utils.CommonUtil;
import com.innovative.foodciti.utils.SharedPrefernceValue;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private String refreshedToken, android_id, str_email, str_password;

    private EditText et_email, et_password;
    private Button btn_login;

    private HashMap<String, String> map = new HashMap<>();
    private RequestQueue queue;

    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        queue = Volley.newRequestQueue(getApplicationContext());

        sharedPreferences = getSharedPreferences(SharedPrefernceValue.MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        findIds();
        init();
    }

    private void findIds() {

        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);

    }

    private void init() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str_email = et_email.getText().toString();
                str_password = et_password.getText().toString();

                if (TextUtils.isEmpty(str_email)) {
                    et_email.setError("Username Required");
                    return;
                }
                if (TextUtils.isEmpty(str_password)) {
                    et_password.setError("Password Required");
                    return;
                }
                loginRequest(str_email, str_password);
            }
        });

    }

    private void loginRequest(String str_email, String str_password) {
        CommonUtil.showProgressDilaog(this);
        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        map.put("email", str_email);
        map.put("password", str_password);
        map.put("devicetoken", refreshedToken);
        map.put("deviceid", android_id);

        loginResponse(AppConstant.BASE_URL + "login.php", map);
    }
//    7a3e6f963538082ce5199d421e9ba5e1
    private void loginResponse(String url, final HashMap<String, String> map) {
        System.out.println("url.." + url + "map parameter----" + map);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CommonUtil.dismissProgressDilaog();
                Log.e("response----", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String jsonResponse = jsonObject.getString("response");

                    JSONObject jsonObjectResponse = new JSONObject(jsonResponse);
                    String result = jsonObjectResponse.getString("result");

                    JSONObject resultJsonObject = new JSONObject(result);
                    String status = resultJsonObject.getString("status");
                    String message = resultJsonObject.getString("msg");
                    boolean isloggedIn = Boolean.parseBoolean(resultJsonObject.getString("isloggedIn"));

                    editor.putString(SharedPrefernceValue.IS_LOGGED_IN, String.valueOf(isloggedIn));
                    editor.commit();

                    et_email.setText("");
                    et_password.setText("");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                CommonUtil.dismissProgressDilaog();
                try {
                    Toast.makeText(LoginActivity.this, "username and password is invalid!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, "try again", Toast.LENGTH_LONG).show();
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return map;
            }
        };
        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(
                300000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }


}
