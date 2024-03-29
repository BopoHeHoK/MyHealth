package com.test.myhealth.app.receiver.schedule.weight

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.test.myhealth.R
import com.test.myhealth.app.presentation.AppActivity

class WeightTimeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val i = Intent(context, AppActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(context!!, "weightTime")
            .setSmallIcon(R.drawable.ic_app_fg)
            .setContentTitle("Напоминание: вес")
            .setContentText("Измерение веса")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManagerCompat = NotificationManagerCompat.from(context)
        notificationManagerCompat.notify(113, builder.build())
    }
}