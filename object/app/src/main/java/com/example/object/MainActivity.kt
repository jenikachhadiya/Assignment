package com.example.`object`

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    val tv_result:TextView
    get() = findViewById(R.id.tv_result)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)



    }
}