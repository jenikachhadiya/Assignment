package com.example.`object`

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.objects.objects

class Second : AppCompatActivity() {


    val tv_result : TextView
    get() = findViewById(R.id.tv_result)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        var objec = intent.getParcelableExtra<objects>("OBJ")

        objec?.let {
            tv_result.text = "Name = ${objec.name} \n Email = ${objec.email}"
        }




    }
}