package com.example.roomcredoperation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.roomcredoperation.database.Appdatabase
import com.example.roomcredoperation.database.entity.User
import com.example.roomcredoperation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var db: Appdatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(this, Appdatabase::class.java, "tops-user.db")
            .allowMainThreadQueries().build()

        binding.uvSave.setOnClickListener {
            var name = binding.uvName.text.toString().trim()
            var email = binding.uvEmail.text.toString().trim()

            insertRecord(name, email)
        }
    }

    private fun insertRecord(name: String, email: String) {

        var user = User(Name = name, Email = email)

        db.userDao.insertRecord(user)
        Toast.makeText(applicationContext, "Record added", Toast.LENGTH_SHORT).show()
    }
}