package com.example.pharmacy_ex1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    String message;

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context );
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification(message);
        notificationHelper.getManager().notify(1,nb.build());
    }
}