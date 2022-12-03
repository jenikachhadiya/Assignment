package com.example.brodcastresiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brodcastresiver.Modal.MyBroadcastReciever

class MainActivity : AppCompatActivity() {

    var receiver = MyBroadcastReciever()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var intentfilter = IntentFilter()
        intentfilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        intentfilter.addAction(Intent.ACTION_DATE_CHANGED)
        registerReceiver(receiver,intentfilter)




    }

    override fun onDestroy() {
        super.onDestroy()
        receiver?.let {
            unregisterReceiver(it)
        }
    }
}