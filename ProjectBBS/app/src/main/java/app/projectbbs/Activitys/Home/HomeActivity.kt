package app.projectbbs.Activitys.Home

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import app.projectbbs.Adapter.HomeAdapter
import app.projectbbs.ClickEvent.ClickData
import app.projectbbs.CustomDilogBox.CustomDilogBox
import app.projectbbs.R
import app.projectbbs.databinding.ActivityHomeBinding

import app.projectbbs.databinding.PlayDilogboxBinding
import app.projectbbs.gameSteps.FirstActivity
import app.projectbbs.model.homeModel

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var adapter: HomeAdapter
    var list = mutableListOf<homeModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init() {

        addData()

        adapter = HomeAdapter(this, list)
        binding.rvHomeList.layoutManager = LinearLayoutManager(this)
        binding.rvHomeList.adapter = adapter


        adapter.SetItemClickEvent(object : ClickData{
            override fun onItemClicked(view: View, postion: Int) {
                Toast.makeText(this@HomeActivity, "$postion", Toast.LENGTH_SHORT).show()

                //show Dilogbox
                var custom = CustomDilogBox(this@HomeActivity)
                custom.ShowDilog()


               // ShowDilog("$postion")

               // binding.btSubmit.text="Lavel $postion"
            }
        })

    }
    /*fun ShowDilog(title:String){

        // lateinit var binding1: PlayDilogboxBinding
        var bind=PlayDilogboxBinding.inflate(LayoutInflater.from(this))
        var dilog=Dialog(this)
        dilog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dilog.setCancelable(false)
        dilog.setContentView(bind.root)
       // bind.tvTitle.text=title

      *//*  bind.btPlay.setOnClickListener {
            var intent=Intent(this,FirstActivity::class.java)
            startActivity(intent)
            dilog.dismiss()
        }*//*

        dilog.show()

    }
*/
    private fun addData(){
      //  for (i in 1..7) {
            list.add(homeModel(1,2,3,4,5,6,7))
      //  }
    }
}