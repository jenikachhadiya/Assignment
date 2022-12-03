package com.example.roomdatabase

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.Update
import com.example.roomdatabase.Adaptor.RecyclerUserAdapter
import com.example.roomdatabase.database.AppDatabase
import com.example.roomdatabase.databinding.ActivityMainBinding
import com.example.roomdatabase.databinding.CustomDilogLayoutBinding
import com.example.roomdatabase.entity.User

class MainActivity : AppCompatActivity() {
    //data base stor in variable
    lateinit var binding: ActivityMainBinding
    lateinit var db: AppDatabase

    //adoptor in set data
    lateinit var Dadaptor: RecyclerUserAdapter
    var userlist = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //data base in call
        db = Room.databaseBuilder(this, AppDatabase::class.java, "tops-user.db")
            .allowMainThreadQueries()
            .build()

        // pass data to adapter using constructor (vertical)
        Dadaptor = RecyclerUserAdapter(this, userlist)
        var manager = LinearLayoutManager(applicationContext)       // vertical
        binding.recView.layoutManager = manager
        // set mAdapter to adapterView
        binding.recView.adapter = Dadaptor


        //set data setonlistItemclicek listner
        Dadaptor.setOnListItemClickListener(object : RecyclerUserAdapter.OnListItemClickListener {
            override fun onDeleteItemClicked(user: User){
                ShowDilog(user)


            }

            override fun onUpdateItemClicked(user: User) {
                ShowUpdate(user)
            }

        })


        //app open thy tyare data show karava
        Updatelist()

        binding.btnSave.setOnClickListener{

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()

            //todo validation
            insertRecord(name, email)


        }

    }

    //access data Doas in
    private fun insertRecord(name: String, email: String) {

        var user = User(name = name, email = email)
        //assess daos
        db.userdao().InsertData(user)
        Toast.makeText(applicationContext, "Record added", Toast.LENGTH_SHORT).show()
        Updatelist()

    }

    private fun Updatelist() {
        var list = db.userdao().GetAllData() as MutableList<User>
        Dadaptor.setItems(list)

    }

    private fun ShowDilog(user: User) {
        AlertDialog.Builder(this)
            .setTitle("Delate Record")
            .setMessage("Are You Sure You Want to Delate This Items??")
            .setPositiveButton("Delate", DialogInterface.OnClickListener { dialogInterface, i ->
                db.userdao().DelateData(user)
                Updatelist()
            }).setNegativeButton("Cancle", DialogInterface.OnClickListener { dialogInterface, i ->

            }).show()


    }

    private fun ShowUpdate(user: User) {

        var bind = CustomDilogLayoutBinding.inflate(layoutInflater)
        var builder = AlertDialog.Builder(this)
            .setView(bind.root)

        bind.etName.setText(user.name)
        bind.etEmail.setText(user.email)

        var alert = builder.create()
        alert.show()
        bind.btnUpdate.setOnClickListener {
            var name  = bind.etName.text.toString().trim()
            var email = bind.etEmail.text.toString().trim()
            var Uuser = User(id = user.id,name = name,email = email)

            db.userdao().UpdateData(Uuser)
            Updatelist()
            alert.dismiss()
        }


    }
}
