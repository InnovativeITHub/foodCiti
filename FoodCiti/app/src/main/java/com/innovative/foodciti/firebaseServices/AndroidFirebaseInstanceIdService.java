package com.innovative.foodciti.firebaseServices;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class AndroidFirebaseInstanceIdService extends FirebaseInstanceIdService {


    @Override
    public void onTokenRefresh() {
//        super.onTokenRefresh();

        //Get hold of the registration token
        Log.i("Service class","service started");

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        //Implement this method if you want to store the token on your server
    }

}
