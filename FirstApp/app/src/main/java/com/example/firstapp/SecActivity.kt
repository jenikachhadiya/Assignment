package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class SecActivity : AppCompatActivity() {

    val tvName :TextView
    get() = findViewById(R.id.tv_name)

    val tvEmail :TextView
    get() = findViewById(R.id.tv_email)

    val tvAge : TextView
    get() = findViewById(R.id.tv_age)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

       var user = intent.getParcelableExtra<User>("USER")

/*

        var name = intent.getStringExtra("NAME")
        var email = intent.getStringExtra("EMAIL")
        var age = intent.getIntExtra("AGE",0)

*/
   user?.let {
    tvName.text = "Name = $it.name"
    tvEmail.text = "Email = $it.email"
    tvAge.text = "age = $it.age"
   }

    }
}