package com.example.brodcastresiver.Modal

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReciever:BroadcastReceiver() {

    override fun onReceive(contex: Context?, intent: Intent?) {
    intent?.let {
        if (it.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){

            //checke user airplane mode is on is off
            val isAirplaneModeOn = intent.getBooleanExtra("state", false)
            if (isAirplaneModeOn) {

                // handle Airplane Mode on
                Toast.makeText(contex, "Airplane Mode on", Toast.LENGTH_SHORT).show()
            } else {
                // handle Airplane Mode off
                Toast.makeText(contex, "Airplane Mode off", Toast.LENGTH_SHORT).show()
            }


        }else if (it.action == Intent.ACTION_DATE_CHANGED){

            Toast.makeText(contex, "date modifiy", Toast.LENGTH_SHORT).show()

        }
    }


    }
}