package com.example.adoptor2.Adoptors

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptor2.Modal.Movie
import com.example.adoptor2.Modal.OnItemClickLitener
import com.example.adoptor2.databinding.RecycleLayoutBinding


//Therd step create adoptor


//adoptor 1.create class
//adoptor 3.inherit Recycle view.adoptor(Adoptor<VH>)
//adoptor 4.import methodes alt+enter
//adoptor 5.RecycleAdoptor in pass paramiter
class Movie_Adoptor (var context: Context, var Movielist :MutableList<Movie>)
    : RecyclerView.Adapter<Movie_Adoptor.MyviewHolder>(){

    //Interface clike event
    //3.stor interface into variable
    private lateinit var clickLitener: OnItemClickLitener
    private lateinit var binding: RecycleLayoutBinding
    //adoptor.2 create Inner class
    //adoptor 2.1 Inherit view holder and alt + enter (add constroucter parameter)
    //adoptor 7 view ma lyout ne ten bind ma stor karavu VH ma bind.root
    class MyviewHolder(var bind: RecycleLayoutBinding) : RecyclerView.ViewHolder(bind.root) {

    }

    //interface
    //4.craeate methode and pass paramiter in variable clicklistentr
    fun setonItemclickListner(clickLitener: OnItemClickLitener){
        this.clickLitener = clickLitener

    }

    // a Method ma Layout Binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        //adoptor 6 binding layout
        binding = RecycleLayoutBinding.inflate(LayoutInflater.from(context),parent,false)

        //adoptor 8 ma return binding
        return MyviewHolder(binding)



    }
    //A Methord ma data binding thy che //data set karav
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        //adoptor 9 variable ma list ni position vise store karav
        var movie  = Movielist[position]

        //adoptor 10 holder.bind kari data set karva
        holder.bind.ivMovie.setImageResource(movie.image)
        holder.bind.tvTital.text=movie.name
        holder.bind.rbRat.rating = movie.rating
        holder.bind.tvYer.text = "${movie.year}"
        holder.bind.tvDes.text = movie.Des
        //1.Adoptor class to click events
        holder.bind.linear.setOnClickListener {

            /*var intent = Intent(context,Recycle_Activity_Sec::class.java)
            intent.putExtra("Item",)
            context.startActivity(intent)
 */


            //Toast.makeText(context, "${Item.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
//adoptor 11 mlist ni size return karavi

        return Movielist.size

    }


}
