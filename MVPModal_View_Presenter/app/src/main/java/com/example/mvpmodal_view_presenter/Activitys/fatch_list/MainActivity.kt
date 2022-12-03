package com.example.mvpmodal_view_presenter.Activitys.fatch_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpmodal_view_presenter.Adaptor.recycle_adaptor
import com.example.mvpmodal_view_presenter.Modal.user
import com.example.mvpmodal_view_presenter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),MainView {
    lateinit var binding: ActivityMainBinding


    private var userlist = mutableListOf<user>()
    lateinit var UAdoptors: recycle_adaptor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //api cline valo code aya che
        UAdoptors = recycle_adaptor(this, userlist)
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = UAdoptors

        getlist()


    }

    private fun getlist() {
        var presenter = MainPresenter(this)
        presenter.loadUserList()

    }

    override fun showprogres() {
        binding.progressbar.visibility = View.VISIBLE
    }

    override fun hideprogres() {
        binding.progressbar.visibility = View.GONE
    }


    override fun success(userlist: List<user>) {
        UAdoptors.setItem(userlist as MutableList<user>)
    }

    override fun failer(message: String) {
        Toast.makeText(applicationContext, "$message", Toast.LENGTH_SHORT).show()
    }

}