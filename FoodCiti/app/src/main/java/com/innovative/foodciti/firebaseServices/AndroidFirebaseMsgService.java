package com.innovative.foodciti.firebaseServices;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.innovative.foodciti.R;
import com.innovative.foodciti.activities.OrderSummaryActivity;
import com.innovative.foodciti.utils.SharedPrefernceValue;

import java.util.Map;

/**
 * Created by pulkit on 28/10/17.
 */

public class AndroidFirebaseMsgService extends FirebaseMessagingService {

    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
        try {
            Map<String, String> data = remoteMessage.getData();
            createNotification(data, data.get("tickerText"),data.get("message"), data.get("subtitle"), data.get("title"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createNotification(Map<String, String> data, String orderId, String message, String restId, String title) {

        sharedPreferences = getSharedPreferences(SharedPrefernceValue.MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Intent orderSummaryIntent = new Intent(this, OrderSummaryActivity.class);
        orderSummaryIntent.putExtra("rest_id",restId);
        orderSummaryIntent.putExtra("order_id",orderId);
        orderSummaryIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        editor.putString(SharedPrefernceValue.REST_ID, restId);
        editor.putString(SharedPrefernceValue.ORDER_ID, orderId);
        editor.commit();

        PendingIntent fee_resultIntent = PendingIntent.getActivity(this, 0, orderSummaryIntent, PendingIntent.FLAG_ONE_SHOT);

        Uri fee_notificationSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder fee_mNotificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.noti_foodcity_3)
                .setContentTitle("Food citi")
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(fee_notificationSoundURI)
                .setContentIntent(fee_resultIntent);

        NotificationManager feenotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        feenotificationManager.notify(0, fee_mNotificationBuilder.build());
    }

}
