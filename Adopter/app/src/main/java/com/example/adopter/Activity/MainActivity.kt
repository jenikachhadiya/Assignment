package com.example.adopter.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.adopter.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    //Adaptor data
    private var lunguage = arrayOf("Java","Javascript","Kotlin","Pytone","Json","C++")
    //declaration adpter view
    private lateinit var madapter: ArrayAdapter<String>


    //spinneer data
    private var contries = arrayOf("India","Japan","Pakistan","China","Russian","Ingland","Thailand")
    //Declaration spinner adaptor
    private lateinit var mSpinner :ArrayAdapter<String>


    //grid data
    private var Stats = arrayOf("Gujrat","Mharasht","UP","MP","Bihar","Odisa")
    //Declaration adopter view

    private lateinit var mGrid:ArrayAdapter<String>
    //Auto Complate text view

    private lateinit var mautotext :ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //passing data to adaptor
        madapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,lunguage)

        //set data adaptor to adaptor view
        binding.listView.adapter = madapter

        //data <item> click event
        binding.listView.setOnItemClickListener { adapterView, view, Pos, l ->

            //Position viez valiwe get karvani
            var lung = lunguage[Pos]
            Toast.makeText(applicationContext, "$lung", Toast.LENGTH_SHORT)
                .show()


        }


        //Spinner adapoter

        //passing data to adaptor
        mSpinner = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,contries)
        //set data adoptor to adopter view
        binding.spinnerView.adapter = mSpinner
        // spinner adopter item click event
        binding.spinnerView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                var coun = contries[pos]
                Toast.makeText(applicationContext, "$coun", Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?){
                TODO("Not yet implemented")

            }

        }


        //Grid adapotor
        //passing data to adopter
        mGrid = ArrayAdapter(this,android.R.layout.simple_list_item_1,Stats)
        //set data adoptor to adopter view
        binding.gridView.adapter = mGrid
        //grid adopter item selected event
        binding.gridView.setOnItemClickListener{ adapterView, view, pos, l ->
            var stu = Stats[pos]
            Toast.makeText(applicationContext, "$stu", Toast.LENGTH_SHORT).show()
        }
        //Auto complate text view
        mautotext = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,lunguage)
        //set data adoptor to adopter view
        binding.autoText.setAdapter(mautotext)
        //auto complate item selected event
        binding.autoText.setOnItemClickListener {adapterView, view, Pos, l ->
            var lang = adapterView.getItemAtPosition(Pos)
            Toast.makeText(applicationContext, "$lang", Toast.LENGTH_SHORT).show()
        }


    }
}