package com.example.roomdatabase2

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.roomdatabase2.Adaptor.Custom_Adaptor
import com.example.roomdatabase2.DAOs.CustomDAOs
import com.example.roomdatabase2.database.DataBase
import com.example.roomdatabase2.databinding.ActivityMainBinding
import com.example.roomdatabase2.databinding.CustomDilogBinding
import com.example.roomdatabase2.entity.Customer

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    //initilation data base
    lateinit var db: DataBase

    //pass data in adaptor
    lateinit var Cadaptor: Custom_Adaptor
    var Cuslist = mutableListOf<Customer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //set data in data base
        db = Room.databaseBuilder(this, DataBase::class.java, "data base")
            .allowMainThreadQueries()
            .build()

        //pass data in adaptor
        Cadaptor = Custom_Adaptor(this, Cuslist)
        var manger = LinearLayoutManager(applicationContext)
        binding.recView.layoutManager = manger
        binding.recView.adapter = Cadaptor
//adaptor item clicke event
        Cadaptor.setOnListItemClickListener(object : Custom_Adaptor.OnListItemClickListener {

            override fun onDeleteItemClicked(customer: Customer) {
                ShowDeleteDilogs(customer)
            }

            override fun onUpdateItemClicked(customer: Customer) {
                UpdateData(customer)
            }

        })
        //show data when app open
        UpdateRecord()


        //save data Dose in
        binding.btnSave.setOnClickListener {
            Toast.makeText(applicationContext, "record save", Toast.LENGTH_SHORT).show()
            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            //todo validation

            insertRecord(name, email)


        }

    }

    private fun UpdateData(customer: Customer) {
        var bind = CustomDilogBinding.inflate(layoutInflater)
        var builder = AlertDialog.Builder(this)
            .setView(bind.root)

        bind.etName.setText(customer.Name)
        bind.etEmail.setText(customer.Email)

        var alert = builder.create()
        alert.show()
        bind.btnUpdate.setOnClickListener {
            var name = bind.etName.text.toString().trim()
            var email = bind.etEmail.text.toString().trim()
            var cust = Customer(id = customer.id, Name = name, Email = email)

            db.customDaos().UpdateData(cust)
            UpdateRecord()
            alert.dismiss()

        }


    }

    //data insert Record
    private fun insertRecord(name: String, email: String) {
        var custom = Customer(Name = name, Email = email)
        db.customDaos().InsertData(custom)
        Toast.makeText(applicationContext, "Record Added", Toast.LENGTH_SHORT).show()
        UpdateRecord()
    }

    //update
    private fun UpdateRecord() {
        var list = db.customDaos().GetAllList() as MutableList<Customer>
        Cadaptor.setItems(list)
    }

    private fun ShowDeleteDilogs(customer: Customer) {
        AlertDialog.Builder(this)
            .setTitle("Delete")
            .setMessage("Are you Sure ??")
            .setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
                db.customDaos().DeleteData(customer)
                UpdateRecord()

            }).setNegativeButton("Cancle", DialogInterface.OnClickListener { dialogInterface, i ->

            }).show()


    }
}


