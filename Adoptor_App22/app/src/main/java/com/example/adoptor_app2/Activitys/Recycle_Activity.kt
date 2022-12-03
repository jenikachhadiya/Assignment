package com.example.adoptor_app2.Activitys

import android.app.Dialog
import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adoptor_app2.Adoptors.Recycle_Adoptor
import com.example.adoptor_app2.Adoptors.Vartical_Adoptor
import com.example.adoptor_app2.Classes.OnClickevent
import com.example.adoptor_app2.Classes.Recycleclass
import com.example.adoptor_app2.Classes.Vartical
import com.example.adoptor_app2.R
import com.example.adoptor_app2.databinding.ActivityRecycleBinding
import com.example.adoptor_app2.databinding.CustomDailogBinding
import com.example.adoptor_app2.databinding.VarticalCustomDailogBinding

class Recycle_Activity : AppCompatActivity() {
    lateinit var binding: ActivityRecycleBinding


     private  var Reclist = mutableListOf<Recycleclass>()

     private lateinit var adoptor: Recycle_Adoptor

     //second adoptor nu

     private var Itemlist = mutableListOf<Vartical>()

     private lateinit var iadoptor:Vartical_Adoptor
  


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecycleBinding.inflate(layoutInflater)

        setContentView(binding.root)


        adddata()
        adoptor = Recycle_Adoptor(this,Reclist)
        iadoptor = Vartical_Adoptor(this,Itemlist)


        var manager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        binding.recView.layoutManager = manager
        binding.recView.adapter = adoptor


        var manaVart = LinearLayoutManager(applicationContext)
        binding.verticalView.layoutManager = manaVart

        binding.verticalView.adapter = iadoptor

        //adoptor first clicek evnet

       adoptor.SetRecClicke(object :OnClickevent{
           override fun RecClick(recycle: Recycleclass, pos: Int) {

               setDailog(recycle)

               //Toast.makeText(applicationContext, "${recycle.Tital}", Toast.LENGTH_SHORT).show()
           }

           override fun VarClick(vartical: Vartical, pos: Int) {
               TODO("Not yet implemented")
           }

       })

        iadoptor.VarClickEvent(object :OnClickevent{
            override fun RecClick(recycle: Recycleclass, pos: Int) {
                TODO("Not yet implemented")
            }

            override fun VarClick(vartical: Vartical, pos: Int) {

                setDailogVart(vartical)

                //Toast.makeText(applicationContext, "${vartical.name}", Toast.LENGTH_SHORT).show()

            }


        })



    }

    private fun setDailogVart(vartical: Vartical) {
        var bind = VarticalCustomDailogBinding.inflate(layoutInflater)
        var builder = AlertDialog.Builder(this)
            .setView(bind.root)

        bind.varI.setImageResource(vartical.ig)
        bind.varM.text =vartical.mess
        bind.varN.text =vartical.name
        bind.varR.rating = vartical.rating
        bind.varT.text =vartical.timedText
        var dailog = builder.create()
            .show()


    }

    private fun setDailog(recycle: Recycleclass) {

        var bind = CustomDailogBinding.inflate(layoutInflater)
        var builder = AlertDialog.Builder(this)
            .setView(bind.root)

        bind.cusD.setImageResource(recycle.Img)
        bind.cusN.text = recycle.Tital
        bind.cusP.text = recycle.price
        bind.cusR.rating = recycle.rating
        var dialog = builder.create()
           .show()



    }

    private fun adddata() {

        Reclist.add(Recycleclass(1,"Burger","$568.9f",4.5f,R.drawable.burger))
        Reclist.add(Recycleclass(2,"HotDog","$568.9f",2.2f,R.drawable.hotdog))
        Reclist.add(Recycleclass(3,"CupCake","$568.9f",4.5f,R.drawable.cupcake))
        Reclist.add(Recycleclass(4,"GreenTea","$568.9f",3.5f,R.drawable.greentea))
        Reclist.add(Recycleclass(5,"PopCorn","$568.9f",2.5f,R.drawable.popcorn))
        Reclist.add(Recycleclass(6,"Smoothie","$568.9f",1.5f,R.drawable.smoothie))
        Reclist.add(Recycleclass(7,"SoftDrink","$568.9f",4.5f,R.drawable.softdrink))
        Reclist.add(Recycleclass(8,"Wheat","$568.9f",3.5f,R.drawable.wheat))
        Reclist.add(Recycleclass(9,"Coffee","$568.9f",3.2f,R.drawable.coffee))
        Reclist.add(Recycleclass(10,"Burger","$568.9f",2.5f,R.drawable.burger))
        Reclist.add(Recycleclass(11,"HotDog","$568.9f",4.5f,R.drawable.hotdog))
        Reclist.add(Recycleclass(12,"GreenTea","$568.9f",4.5f,R.drawable.greentea))


        //second recycle view
        Itemlist.add(Vartical(1,"Fashion",R.drawable.fashoin,"How Are You??????",4.1f,"12:08Am"))
        Itemlist.add(Vartical(2,"Beaty",R.drawable.beauty,"Can you..",2.1f,"11:55pm"))
        Itemlist.add(Vartical(3,"Book",R.drawable.book,"My Name is .....",4.5f,"08:08Am"))
        Itemlist.add(Vartical(4,"Deals",R.drawable.deals,"Can you pic up me in my Home",3.1f,"03:08Am"))
        Itemlist.add(Vartical(5,"Electronic",R.drawable.electronic,"Bas...",1.12f,"05:13pm"))
        Itemlist.add(Vartical(6,"Fresh",R.drawable.fresh,"I Know",3.5f,"08:08Am"))
        Itemlist.add(Vartical(7,"Furnicher",R.drawable.furnicher,"I am fine",2.1f,"10:08Am"))
        Itemlist.add(Vartical(8,"Home",R.drawable.home,"Can you are Online 5Min",2.5f,"11:09pm"))
        Itemlist.add(Vartical(9,"MiniTv",R.drawable.minitv,"Mast haiiiiii",1.6f,"01:08Am"))
        Itemlist.add(Vartical(10,"Movies",R.drawable.movies,"Jakas Movie hai....",3.1f,"7:02pm"))




    }
}