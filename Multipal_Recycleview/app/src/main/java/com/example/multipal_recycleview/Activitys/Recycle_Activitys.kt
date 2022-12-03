package com.example.multipal_recycleview.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multipal_recycleview.Adoptores.Rec_Adop
import com.example.multipal_recycleview.Adoptores.Recycle_Adoptors
import com.example.multipal_recycleview.ClickEvent.OnItemClick
import com.example.multipal_recycleview.Modal.Item
import com.example.multipal_recycleview.Modal.Recycle
import com.example.multipal_recycleview.R
import com.example.multipal_recycleview.databinding.ActivityRecycleActivitysBinding
import com.example.multipal_recycleview.databinding.CustomDailogBinding
import com.example.multipal_recycleview.ClickEvent.OnRecClicke
import com.example.multipal_recycleview.databinding.ItemDailogBinding

class Recycle_Activitys : AppCompatActivity() {
   private lateinit var binding: ActivityRecycleActivitysBinding

    private var Reclist = mutableListOf<Recycle>()

    lateinit var rAdoptors: Recycle_Adoptors

    private var Itemlist = mutableListOf<Item>()

    lateinit var IAdoptor:Rec_Adop


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecycleActivitysBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adddata()

        rAdoptors = Recycle_Adoptors(this,Reclist)

        IAdoptor = Rec_Adop(this,Itemlist)

        var manger = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        binding.recView.layoutManager = manger


        var Itemmanger = LinearLayoutManager(applicationContext)
        binding.rec2.layoutManager = Itemmanger



        binding.recView.adapter = rAdoptors
        binding.rec2.adapter =IAdoptor


        //clicke event
        rAdoptors.SetonClick(object:OnItemClick{
            override fun onCardClick(recycle:Recycle,pos:Int) {

                setdailog(recycle)

                //Toast.makeText(applicationContext, "$name", Toast.LENGTH_SHORT).show()
            }

        })

        //second one clike event
        IAdoptor.Itemclikeevent(object :OnRecClicke{
            override fun onviewclicke(item: Item, pos: Int) {

                setcusdailog(item)

               // Toast.makeText(applicationContext, "${item.name}", Toast.LENGTH_SHORT).show()
            }

        })





    }

    //vartical view clicke function
    private fun setcusdailog(item: Item) {
        var bind = ItemDailogBinding.inflate(layoutInflater)
        var builder = AlertDialog.Builder(this)
        builder.setView(bind.root)

        bind.varI.setImageResource(item.ig)
        bind.varM.text = item.mess
        bind.varN.text = item.name
        bind.varR.rating = item.rating
        bind.varT.text=item.timedText

        var Dailog = builder.create()
            .show()

    }

    private fun setdailog(recycle: Recycle) {

        var bind = CustomDailogBinding.inflate(layoutInflater)
        var builder = AlertDialog.Builder(this)
         builder.setView(bind.root)


        bind.cusD.setImageResource(recycle.Img)
        bind.cusN.text = recycle.Tital
        bind.cusP.text = recycle.price
        bind.cusR.rating = recycle.rating

        var dailog = builder.create()
            .show()


    }

    private fun adddata() {
        Reclist.add(Recycle(1,"Burger","$568.9f",4.5f,R.drawable.burger))
        Reclist.add(Recycle(2,"HotDog","$568.9f",2.2f,R.drawable.hotdog))
        Reclist.add(Recycle(3,"CupCake","$568.9f",4.5f,R.drawable.cupcake))
        Reclist.add(Recycle(4,"GreenTea","$568.9f",3.5f,R.drawable.greentea))
        Reclist.add(Recycle(5,"PopCorn","$568.9f",2.5f,R.drawable.popcorn))
        Reclist.add(Recycle(6,"Smoothie","$568.9f",1.5f,R.drawable.smoothie))
        Reclist.add(Recycle(7,"SoftDrink","$568.9f",4.5f,R.drawable.softdrink))
        Reclist.add(Recycle(8,"Wheat","$568.9f",3.5f,R.drawable.wheat))
        Reclist.add(Recycle(9,"Coffee","$568.9f",3.2f,R.drawable.coffee))
        Reclist.add(Recycle(10,"Burger","$568.9f",2.5f,R.drawable.burger))
        Reclist.add(Recycle(11,"HotDog","$568.9f",4.5f,R.drawable.hotdog))
        Reclist.add(Recycle(12,"GreenTea","$568.9f",4.5f,R.drawable.greentea))

        //second view

        Itemlist.add(Item(1,"Fashion",R.drawable.fashoin,"How Are You??????",4.1f,"12:08Am"))
        Itemlist.add(Item(2,"Beaty",R.drawable.beauty,"Can you..",2.1f,"11:55pm"))
        Itemlist.add(Item(3,"Book",R.drawable.book,"My Name is .....",4.5f,"08:08Am"))
        Itemlist.add(Item(4,"Deals",R.drawable.deals,"Can you pic up me in my Home",3.1f,"03:08Am"))
        Itemlist.add(Item(5,"Electronic",R.drawable.electronic,"Bas...",1.12f,"05:13pm"))
        Itemlist.add(Item(6,"Fresh",R.drawable.fresh,"I Know",3.5f,"08:08Am"))
        Itemlist.add(Item(7,"Furnicher",R.drawable.furnicher,"I am fine",2.1f,"10:08Am"))
        Itemlist.add(Item(8,"Home",R.drawable.home,"Can you are Online 5Min",2.5f,"11:09pm"))
        Itemlist.add(Item(9,"MiniTv",R.drawable.minitv,"Mast haiiiiii",1.6f,"01:08Am"))
        Itemlist.add(Item(10,"Movies",R.drawable.movies,"Jakas Movie hai....",3.1f,"7:02pm"))


    }
}