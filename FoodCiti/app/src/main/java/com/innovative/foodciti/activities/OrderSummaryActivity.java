package com.innovative.foodciti.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.innovative.foodciti.R;
import com.innovative.foodciti.adapter.OrderSummaryAdapter;
import com.innovative.foodciti.constant.AppConstant;
import com.innovative.foodciti.models.Items;
import com.innovative.foodciti.models.OrderSummary;
import com.innovative.foodciti.models.SubItem;
import com.innovative.foodciti.utils.CommonUtil;
import com.innovative.foodciti.utils.SharedPrefernceValue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderSummaryActivity extends AppCompatActivity {

    private RecyclerView rvItems;
    LinearLayout containerLayout;

    private TextView tvOrderNumber;
    private TextView tvDateTime;
    private TextView tvSubTotal;
    private TextView tvDiscount;
    private TextView tvDeliveryCharge;
    private TextView tvTotalCharge;
    private TextView tvMoneyStatus, tvCashStatus;
    private TextView tvCustomerAddress;
    private TextView tvCustomerCity;
    private TextView tvCustomerCityPin;
    private TextView tvCustomerContact, tvRestaurantName, tvRestaurantContact, tvDeliveryWay;

    private String orderId, restId;
    private Toolbar toolbar;

    private HashMap<String, String> map = new HashMap<>();
    private RequestQueue queue;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

//        orderId = getIntent().getStringExtra("order_id");
//        restId = getIntent().getStringExtra("rest_id");

        queue = Volley.newRequestQueue(getApplicationContext());

        sharedPreferences = getSharedPreferences(SharedPrefernceValue.MyPREFERENCES, Context.MODE_PRIVATE);
        orderId = sharedPreferences.getString(SharedPrefernceValue.ORDER_ID, "");
        restId = sharedPreferences.getString(SharedPrefernceValue.REST_ID, "");

        findIds();
        setToolBar();
        init();

    }

    private void findIds() {

        containerLayout = (LinearLayout) findViewById(R.id.container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvOrderNumber = (TextView) findViewById(R.id.tv_order_number);
        tvDateTime = (TextView) findViewById(R.id.tv_date_time);
        rvItems = (RecyclerView) findViewById(R.id.rv_items);
        tvSubTotal = (TextView) findViewById(R.id.tv_sub_total);
        tvDiscount = (TextView) findViewById(R.id.tv_discount);
        tvDeliveryCharge = (TextView) findViewById(R.id.tv_delivery_charge);
        tvTotalCharge = (TextView) findViewById(R.id.tv_total_charge);
        tvMoneyStatus = (TextView) findViewById(R.id.tv_money_status);
        tvCashStatus = (TextView) findViewById(R.id.tv_cash_status);
        tvCustomerAddress = (TextView) findViewById(R.id.tv_customer_address);
        tvCustomerCity = (TextView) findViewById(R.id.tv_customer_city);
        tvCustomerCityPin = (TextView) findViewById(R.id.tv_customer_city_pin);
        tvCustomerContact = (TextView) findViewById(R.id.tv_customer_contact);
        tvRestaurantName = (TextView) findViewById(R.id.tv_restaurant_name);
        tvRestaurantContact = (TextView) findViewById(R.id.tv_restaurant_contact);
        tvDeliveryWay = (TextView) findViewById(R.id.tv_delivery_way);
    }

    private void setToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("FoodCiti");
    }

    private void init() {
        rvItems.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvItems.setNestedScrollingEnabled(false);
        orderSummaryRequest();
    }

    private void orderSummaryRequest() {

        CommonUtil.showProgressDilaog(this);
        containerLayout.setVisibility(View.GONE);

        map.put("order_id", orderId);
        map.put("rest_id", restId);

        orderSummaryResponse(AppConstant.BASE_URL + "view-order-summary.php", map);
    }

    private void orderSummaryResponse(String url, final HashMap<String, String> map) {

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CommonUtil.dismissProgressDilaog();
                containerLayout.setVisibility(View.VISIBLE);
                Log.e("response----", response);

                //Gson gson = new Gson();
                //OrderSummary orderSummary = gson.fromJson(gson.toJson(response), OrderSummary.class);
                //Toast.makeText(OrderSummaryActivity.this, orderSummary.getResturants().getName() + "", Toast.LENGTH_SHORT).show();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    //order
                    JSONObject showingData = new JSONObject(jsonObject.get("orders").toString());

                    //address
                    JSONObject childData = new JSONObject(new JSONObject(jsonObject.get("orders").toString()).get("address").toString());

                    //restaurant
                    JSONObject restaurantData = new JSONObject(jsonObject.get("resturants").toString());

                    if (jsonObject.get("orders") != null) {
                        tvCustomerAddress.setText(childData.get("name").toString());
                        tvCustomerCity.setText(childData.get("address").toString() + ", " + childData.get("city").toString());
                        tvCustomerCityPin.setText(childData.get("post_code").toString());
                        tvCustomerContact.setText(childData.get("ph").toString());
                    }

                    tvRestaurantName.setText(restaurantData.get("name").toString());
                    tvRestaurantContact.setText("tel : " + restaurantData.get("phone").toString());

                    tvDeliveryWay.setText(jsonObject.get("order_method").toString());
                    if (new JSONObject(jsonObject.get("orders").toString()).get("master_id") != null) {
                        tvOrderNumber.setText("Order number : " + showingData.get("transaction_id"));
                    }
                    tvDateTime.setText(jsonObject.get("order_time").toString());

                    tvSubTotal.setText(jsonObject.get("cart_amt").toString());
                    tvDiscount.setText(jsonObject.get("discount").toString());
                    tvDeliveryCharge.setText(jsonObject.get("extra").toString());
                    tvTotalCharge.setText(jsonObject.get("cart_total_amt").toString());
                    tvCashStatus.setText("transaction method : " + showingData.get("transaction_method").toString());

                    if (!showingData.get("transaction_method").toString().equalsIgnoreCase("cash")) {
                        tvMoneyStatus.setText("ORDER PENDING");
                    } else {
                        tvMoneyStatus.setText("ORDER HAS BEEN PAID");
                    }

                    List<Items> itemsList = new ArrayList<>();
                    //order items
                    JSONArray jsonArray = new JSONArray(showingData.get("items").toString());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject json = jsonArray.getJSONObject(i);

                        Items items = new Items();
                        items.setItem(json.get("item").toString());
                        items.setPrice(json.get("price").toString());


                        JSONArray subItemArray = new JSONArray(json.get("subitem").toString());

                        if (json.get("subitem").toString() != null || json.get("subitem").toString() != "" ||
                                json.get("subitem").toString() != "null") {

                            ArrayList<SubItem> subItemsList = new ArrayList<>();
                            for (int j = 0; j < subItemArray.length(); j++) {
                                JSONObject subItemJson = subItemArray.getJSONObject(j);

                                SubItem subItem = new SubItem();
                                subItem.setSubitem(subItemJson.get("subitem").toString());
                                subItem.setPrice(subItemJson.get("price").toString());

                                subItemsList.add(subItem);
                            }
                            items.setSubitem(subItemsList);
                        }

                        itemsList.add(items);
                        System.out.println("");
                    }

                    // Log.v("hello", itemsList.size()+"");

                    OrderSummaryAdapter adapter = new OrderSummaryAdapter(OrderSummaryActivity.this, itemsList);
                    rvItems.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                containerLayout.setVisibility(View.GONE);
                CommonUtil.dismissProgressDilaog();
                try {
                    Toast.makeText(OrderSummaryActivity.this, "try again!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(OrderSummaryActivity.this, "try again", Toast.LENGTH_LONG).show();
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
