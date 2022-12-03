package com.example.nestredrecycleview.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestredrecycleview.Adoptors.Nestred_Adoptor
import com.example.nestredrecycleview.Modal.Categary
import com.example.nestredrecycleview.Modal.SubCategary
import com.example.nestredrecycleview.R
import com.example.nestredrecycleview.databinding.ActivityNestredRecycleBinding

class NestredRecycle_Activity : AppCompatActivity() {
    lateinit var binding: ActivityNestredRecycleBinding
    //parent list
    lateinit var categarylist: MutableList<Categary>
//parent adoptor
    private lateinit var Padoptor: Nestred_Adoptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNestredRecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ParpareData()

        Padoptor = Nestred_Adoptor(this,categarylist)
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = Padoptor

        Padoptor.SetOnClickListner(object :Nestred_Adoptor.ItemonClickListner{
            override fun ViewClick(id: Int, position: Int, tital: String) {
                Toast.makeText(applicationContext, "$tital,$position", Toast.LENGTH_SHORT).show()


            }

            override fun childclick(view: View, subCategary: SubCategary) {
                view.setBackgroundResource(R.color.purple_200)
                //view.setBackgroundResource(getColor(applicationContext,R.color.black))
                Toast.makeText(applicationContext, "${subCategary.Name}", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun ParpareData() {

        var subcatagrylist = mutableListOf<SubCategary>()

        subcatagrylist.apply {
            this.add(SubCategary(1, "Thor The Dark World", R.drawable.m1))
            this.add(SubCategary(2, "The Secrets of DumbulDoor", R.drawable.m2))
            this.add(SubCategary(3, "Blake Faster Wakenda Forevers", R.drawable.m3))
            this.add(SubCategary(4, "Avengers Endgame", R.drawable.m4))
            this.add(SubCategary(5, "Jungle Crusies", R.drawable.m5))



            categarylist = mutableListOf()
            categarylist.add(Categary(1, "Top 10 Movies",subcatagrylist))
           // categarylist.add(Categary(2, "Top 10 WebSerices", subcatagrylist))
            //categarylist.add(Categary(3, "Top 10 Cartoon Movie", subcatagrylist))
           // categarylist.add(Categary(4, "Top 10  Serials", subcatagrylist))

        }

    }
}