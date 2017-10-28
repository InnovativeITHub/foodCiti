package com.innovative.foodciti.firebaseServices;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by pulkit on 28/10/17.
 */

public class AndroidFirebaseMsgService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        try {
            Map<String, String> stringMap = remoteMessage.getData();


        } catch (Exception e) {
            e.printStackTrace();
        }
//        createNotification(data,data.get("message"), data.get("title"));

    }
    
}
