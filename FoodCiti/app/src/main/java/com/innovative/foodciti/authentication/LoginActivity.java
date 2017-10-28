package com.innovative.foodciti.authentication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.text.TextUtilsCompat;
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
import com.google.firebase.iid.FirebaseInstanceId;
import com.innovative.foodciti.R;
import com.innovative.foodciti.constant.AppConstant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private String refreshedToken, android_id, str_user_name, str_password;

    private EditText et_username, et_password;
    private Button btn_login;
    private ProgressBar progressbar;

    private HashMap<String, String> map = new HashMap<>();
    private RequestQueue queue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findIds();
        init();
    }

    private void findIds() {

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);

    }

    private void init() {

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str_user_name = et_username.getText().toString();
                str_password = et_password.getText().toString();

                if(TextUtils.isEmpty(str_user_name)){
                    et_username.setError("Username Required");
                    return;
                }
                if(TextUtils.isEmpty(str_password)){
                    et_password.setError("Password Required");
                    return;
                }
                loginRequest(str_user_name,str_password);
            }
        });

    }

    private void loginRequest(String str_user_name, String str_password) {

        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        progressbar.setVisibility(View.VISIBLE);
        map.put("username", str_user_name);
        map.put("password", str_password);
        map.put("deviceid", refreshedToken);
        map.put("username", android_id);

        loginResponse(AppConstant.BASE_URL + "/login", map);
    }

    private void loginResponse(String url, final HashMap<String, String> map) {
        System.out.println("url.." + url + "map parameter----" + map);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //
                Log.e("response----", response);

                progressbar.setVisibility(View.GONE);



            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                progressbar.setVisibility(View.GONE);
                try {
                    //  Log.e("error", new String(String.valueOf(error.networkResponse)));
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
