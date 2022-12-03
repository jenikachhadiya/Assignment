package com.example.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchview.databinding.ActivityMainBinding
import androidx.appcompat.widget.SearchView.OnQueryTextListener as

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var rec = listOf<recycle>()
    lateinit var Radaptor: recycle_adaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.serchView.clearFocus()
        setData()

        binding.serchView.setOnQueryTextListener(object:OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }


        })

        // recycle view adaptor
       // Radaptor = Radaptor(this,rec)
         Radaptor = recycle_adaptor(this,rec)
        binding.recView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recView.adapter = Radaptor


        setContentView(binding.root)
    }

    private fun setData() {
     var item = ArrayList<recycle>()
        item.add(recycle(1,R.drawable.img,"Amiras","13,simada naka","12:30pm",4.2f))
        item.add(recycle(2,R.drawable.img,"Surbhi","13,simada naka","12:30pm",4.2f))
        item.add(recycle(3,R.drawable.img,"A-One","13,simada naka","12:30pm",4.2f))
        item.add(recycle(4,R.drawable.img,"Dilgital","13,simada naka","12:30pm",4.2f))
        item.add(recycle(5,R.drawable.img,"subway","13,simada naka","12:30pm",4.2f))
        item.add(recycle(6,R.drawable.img,"Mc-Donld","13,simada naka","12:30pm",4.2f))
        item.add(recycle(7,R.drawable.img,"Pasta Purim","13,simada naka","12:30pm",4.2f))
        item.add(recycle(1,R.drawable.img,"Amiras","13,simada naka","12:30pm",4.2f))
        item.add(recycle(2,R.drawable.img,"Surbhi","13,simada naka","12:30pm",4.2f))
        item.add(recycle(3,R.drawable.img,"A-One","13,simada naka","12:30pm",4.2f))
        item.add(recycle(4,R.drawable.img,"Dilgital","13,simada naka","12:30pm",4.2f))
        item.add(recycle(5,R.drawable.img,"subway","13,simada naka","12:30pm",4.2f))
        item.add(recycle(6,R.drawable.img,"Mc-Donld","13,simada naka","12:30pm",4.2f))
        item.add(recycle(7,R.drawable.img,"Pasta Purim","13,simada naka","12:30pm",4.2f))


    }
}