package com.example.localhost.Activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.localhost.Adaptor.User_Adaptor
import com.example.localhost.Interface.ApiClient
import com.example.localhost.Interface.InterfaceClicke
import com.example.localhost.Modal.User
import com.example.localhost.Modal.student
import com.example.localhost.R
import com.example.localhost.Shareprefrence.PrefrenceClass
import com.example.localhost.databinding.ActivityHomeBinding
import com.example.localhost.databinding.CustomdilogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    var userList = mutableListOf<User>()
    lateinit var mAdapter: User_Adaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datasetup()


    }

    private fun datasetup() {

        adddata()

        mAdapter = User_Adaptor(this, userList)
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = mAdapter


        //clike event
        mAdapter.Clickelistenr(object : InterfaceClicke {
            override fun updatadata(pos: Int, user: User) {
                customedilog(pos, user)
            }

            override fun delatedata(user: User) {
                ApiClient.init().DeleteUser(3, user.id).enqueue(object : Callback<student> {
                    override fun onResponse(call: Call<student>, response: Response<student>) {

                        if (response.isSuccessful) {
                            response.body()?.let {
                                mAdapter.delete(user)
                                Toast.makeText(this@HomeActivity, "${user.id}", Toast.LENGTH_SHORT)
                                    .show()

                            }
                        }
                    }

                    override fun onFailure(call: Call<student>, t: Throwable) {
                        Toast.makeText(this@HomeActivity, "$t.message", Toast.LENGTH_SHORT)
                            .show()
                    }


                })
            }

        })


    }

    private fun customedilog(pos: Int, user: User) {

        var bind: CustomdilogBinding

        var diloge = Dialog(this)
        diloge.requestWindowFeature(Window.FEATURE_NO_TITLE)
        diloge.setCancelable(false)
        bind = CustomdilogBinding.inflate(LayoutInflater.from(this))
        diloge.setContentView(bind.root)
        diloge.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        bind.btSubmit.setOnClickListener {
            var name = bind.etName.text.toString().trim()
            var email = bind.etEmail.text.toString().trim()
            var contect = bind.etContect.text.toString().trim()

            ApiClient.init().UpdateData(3, user.id, name, email, contect)
                .enqueue(object : Callback<student> {
                    override fun onResponse(call: Call<student>, response: Response<student>) {

                        if (response.isSuccessful) {
                            var userdata = user.copy(
                                name = name,
                                email = email,
                                contact = contect,
                                password = ""
                            )
                            mAdapter.updatedata(pos, userdata)
                            Toast.makeText(this@HomeActivity, "${user.id}", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                    override fun onFailure(call: Call<student>, t: Throwable) {
                        Toast.makeText(this@HomeActivity, t.message, Toast.LENGTH_SHORT).show()
                    }

                })
            diloge.dismiss()

        }
        bind.btCancle.setOnClickListener {
            diloge.dismiss()
        }
        diloge.show()


    }

    private fun adddata() {

        ApiClient.init().getUserList(4).enqueue(object : Callback<student> {
            override fun onResponse(call: Call<student>, response: Response<student>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        mAdapter.setItem(it.student)
                    }
                }

            }

            override fun onFailure(call: Call<student>, t: Throwable) {
                Toast.makeText(this@HomeActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }


        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.item_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_Logout -> {
                var dialog = AlertDialog.Builder(this)
                dialog.setMessage("Do You Want to Logout ?")
                    .setTitle("Logout")
                    .setCancelable(false)
                    .setPositiveButton(
                        "Yes",
                        DialogInterface.OnClickListener { dialogInterface, id ->
                            PrefrenceClass(this).setlogin(false)
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        })
                    .setNegativeButton(
                        "cancle",
                        DialogInterface.OnClickListener { dialogInterface, i ->
                            dialogInterface.cancel()
                        })
                var alert = dialog.create()
                alert.show()
                true


            }
            else -> return false


        }
    }


}
