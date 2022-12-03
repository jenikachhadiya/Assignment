package com.example.firebase_push_notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private val channalName = "Live Stream"
    private val channalDeas = "Live Ddesc"
    private val channalId = "LVSTM"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (it.isSuccessful){
                print(it.result)
            }
        }

        findViewById<Button>(R.id.btn_notification).setOnClickListener {
            shownotificaton()
        }


    }

    private fun shownotificaton() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel =
                NotificationChannel(channalId, channalName, NotificationManager.IMPORTANCE_HIGH)
            channel.description = channalDeas

            //Rajiste chancl with  the system
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)   }




        var builder = NotificationCompat.Builder(this,channalId)
            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
            .setContentTitle("Tops Tecnologies")
            .setContentText("Welcome to tops tecnology")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        var notificationMnager = NotificationManagerCompat.from(this)
        notificationMnager.notify(1, builder.build())


    }


}