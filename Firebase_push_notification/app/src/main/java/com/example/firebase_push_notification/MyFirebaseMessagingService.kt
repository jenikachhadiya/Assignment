package com.example.firebase_push_notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {


    private val channalName = "Live Stream"
    private val channalDeas = "Live Ddesc"
    private val channalId = "LVSTM"


    override fun onMessageReceived(message: RemoteMessage) {
        message?.let {
            shownotificaton(it)
        }
    }


    override fun onNewToken(token: String) {

        super.onNewToken(token)
    }

    private fun shownotificaton(message: RemoteMessage) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel =
                NotificationChannel(channalId, channalName, NotificationManager.IMPORTANCE_HIGH).apply {
                   description = channalDeas
                    enableVibration(true)
                    lightColor = Color.YELLOW
                    vibrationPattern = longArrayOf(100,200,300,400,500,400,300,200,100)

                }


            //Rajiste chancl with  the system
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        var intent = Intent(this,BasicAcitvity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        }


        var pandingIntent :PendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE)



        var builder = NotificationCompat.Builder(this, channalId)
            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
            .setContentTitle(message.notification!!.title)
            .setContentText(message.notification!!.body)
            .setContentIntent(pandingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Munay amdhjjd jdiuwx bhyfwd y dytw dftf tMunay amdhjjd jdiuwx bhyfwd y dytw dftf tMunay amdhjjd jdiuwx bhyfwd y dytw dftf tMunay amdhjjd jdiuwx bhyfwd y dytw dftf tMunay amdhjjd jdiuwx bhyfwd y dytw dftf t")
            )
            //.setContentIntent(pendingIntent)
            .setDefaults(Notification.DEFAULT_ALL)
            .setVibrate(longArrayOf(100,200,300,400,500,400,300,200,100))


        var notificationMnager = NotificationManagerCompat.from(this)
        notificationMnager.notify(1, builder.build())


    }


}