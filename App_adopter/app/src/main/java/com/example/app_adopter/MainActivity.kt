package com.example.app_adopter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.app_adopter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var customadapter:CustomList
    //create data view
    private var lunguage = arrayOf("Java", "Python", "Kotlin", "Laravel", "PHP", ".net")
    private var detalis = arrayOf("JAVA IS GOOD","Python IS GOOD","Kotlin IS GOOD","Laravel  IS GOOD","PHP IS GOOD",".net IS GOOD")

    //Declaration adopter
    private lateinit var MAdapter: ArrayAdapter<String>


    //adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         customadapter=CustomList(this@MainActivity,lunguage,detalis)
         binding.listView.adapter=customadapter

        //data to passing adopter
        //MAdapter = (this, android.R.layout.simple_list_item_1, lunguage)

        //data <item> set
        // binding.listView.adapter = MAdapter

            binding.listView.setOnItemClickListener { adapterView, view, Pos, l ->
            var lung = lunguage[Pos]
            Toast.makeText(applicationContext, "$lung", Toast.LENGTH_SHORT).show()

        }

    }
}