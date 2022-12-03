package com.example.fregment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class HostActivity : AppCompatActivity() ,ThirdFregment.communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
    }

    override fun sendValue(name: String, message: String) {

        var freg = supportFragmentManager.findFragmentById(R.id.fourt_fregment)
        if (freg is FourthFregment){
            freg.updateResult(name, message)
        }


       // Toast.makeText(this,"Name :$name \n message :$message",Toast.LENGTH_SHORT).show()

    }
}