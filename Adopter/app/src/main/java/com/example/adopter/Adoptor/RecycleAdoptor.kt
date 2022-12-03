package com.example.adopter.Adoptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.adopter.Activity.Recycle_Activity_Sec
import com.example.adopter.Modal.ItemRecycle
import com.example.adopter.Modal.OnItemClickLitener
import com.example.adopter.databinding.CustomRecycleDailogBinding
import com.example.adopter.databinding.RecycleCustomLayoutBinding

//Therd step create adoptor


//adoptor 1.create class
          //adoptor 3.inherit Recycle view.adoptor(Adoptor<VH>)
         //adoptor 4.import methodes alt+enter
//adoptor 5.RecycleAdoptor in pass paramiter
class RecycleAdoptor (var context: Context,var Recycle :MutableList<ItemRecycle>):RecyclerView.Adapter<RecycleAdoptor.MyviewHolder>(){

    //Interface clike event
    //3.stor interface into variable
    private lateinit var clickLitener: OnItemClickLitener
    private lateinit var binding: RecycleCustomLayoutBinding
    //adoptor.2 create Inner class
        //adoptor 2.1 Inherit view holder and alt + enter (add constroucter parameter)
    //adoptor 7 view ma lyout ne ten bind ma stor karavu VH ma bind.root
    class MyviewHolder(var bind: RecycleCustomLayoutBinding) : RecyclerView.ViewHolder(bind.root) {

    }
    //interface
    //4.craeate methode and pass paramiter in variable clicklistentr
    fun setonItemclickListner(clickLitener: OnItemClickLitener){
        this.clickLitener = clickLitener
    }

    // a Method ma Layout Binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        //adoptor 6 binding layout
        binding = RecycleCustomLayoutBinding.inflate(LayoutInflater.from(context),parent,false)

        //adoptor 8 ma return binding
        return MyviewHolder(binding)

    }
   //A Methord ma data binding thy che //data set karav
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
       //adoptor 9 variable ma list ni position vise store karav
        var Item  = Recycle[position]

      //adoptor 10 holder.bind kari data set karva
        holder.bind.ivIcon.setImageResource(Item.image)
        holder.bind.ivPr.text = Item.price.toFloat().toString()
        holder.bind.tvName.text = Item.name

       //1.Adoptor class to click events
       holder.bind.liner.setOnClickListener {

           /*var intent = Intent(context,Recycle_Activity_Sec::class.java)
           intent.putExtra("Item",)
           context.startActivity(intent)
*/


           //Toast.makeText(context, "${Item.name}", Toast.LENGTH_SHORT).show()
       }
    }

    override fun getItemCount(): Int {
//adoptor 11 mlist ni size return karavi

        return Recycle.size

    }


}