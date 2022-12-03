package com.example.storage_sharedprefrence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storage_sharedprefrence.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding

    var name :String = ""
    var email:String = ""
    var age :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            name = binding.etName.text.toString().trim()
            email = binding.etEmail.text.toString().trim()
            age = binding.etAge.text.toString().trim().toInt()

           //save data
            saveRecord(name ,email,age)


        }
        binding.btnRead.setOnClickListener {
            //read data
            readRecord()
        }

    }

    private fun readRecord() {
        var prafrence = getSharedPreferences("Tops-Tecnology", MODE_PRIVATE)
        var name = prafrence.getString("Name","Not Updata")
        var email = prafrence.getString("Email","Not Updata")
        var age = prafrence.getInt("Age",0)


        //set data in text view
        binding.tvData.text ="""
            name = $name
            email = $email
            age = $age
            
        """.trimIndent()

    }

    //save data
    private fun saveRecord(name:String,email:String,age:Int) {
        //set data class get sherd prefrance
        var prefrance = getSharedPreferences("Tops-Tecnology", MODE_PRIVATE)


        var edits = prefrance.edit()
        edits.putString("Name",name)
        edits.putString("Email",email)
        edits.putInt("Age",age)
        edits.commit()

    }
}