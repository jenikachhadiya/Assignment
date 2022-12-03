package app.projectbbs.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.projectbbs.ClickEvent.ClickData
import app.projectbbs.databinding.RowHomeBinding
import app.projectbbs.model.homeModel

class HomeAdapter(var context: Context, var list: MutableList<homeModel>) :
    RecyclerView.Adapter<HomeAdapter.ViewData>() {

    lateinit var binding: RowHomeBinding
    lateinit var listiner:ClickData


    fun SetItemClickEvent(listiner:ClickData){
        this.listiner=listiner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        binding = RowHomeBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewData(binding)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        var listdata = list.get(position)

        holder.bind.tv1.text = listdata.no1.toString()
        holder.bind.tv2.text = listdata.no2.toString()
        holder.bind.tv3.text = listdata.no3.toString()
        holder.bind.tv4.text = listdata.no4.toString()
        holder.bind.tv5.text = listdata.no5.toString()
        holder.bind.tv6.text = listdata.no6.toString()
        holder.bind.tv7.text = listdata.no7.toString()

        holder.itemView.setOnClickListener {
            listiner.onItemClicked(it,listdata.no1)
            //listiner.onItemClicked(it,listdata.no2)
           // listiner.onItemClicked(it,listdata.no3)
           // listiner.onItemClicked(it,listdata.no4)
           // listiner.onItemClicked(it,listdata.no5)
           // listiner.onItemClicked(it,listdata.no6)
          //  listiner.onItemClicked(it,listdata.no7)
        }

      }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewData(var bind: RowHomeBinding) : RecyclerView.ViewHolder(bind.root) {

    }
}