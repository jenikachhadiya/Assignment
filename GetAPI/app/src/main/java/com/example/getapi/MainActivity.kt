package com.example.getapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.getapi.Modal.country
import com.example.getapi.Modal.state
import com.example.getapi.databinding.ActivityMainBinding
import com.example.getapi.network.API_Clinets
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var CAdaptor: ArrayAdapter<country>
    lateinit var SAdsptor: ArrayAdapter<state>

    var Clist = mutableListOf<country>()
    var Slist = mutableListOf<state>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadCountryList()
        getstetes()


    }

    private fun loadCountryList() {

        /*  API_Clinets.init().getcountry().enqueue(object : Callback<MutableList<country>> {
              override fun onResponse(call: Call<MutableList<country>>, response: Response<MutableList<country>>) {
                  if (response.isSuccessful) {
                      Clist = response.body() as ArrayList<country>
                      CAdaptor = ArrayAdapter(
                          applicationContext,
                          android.R.layout.simple_spinner_dropdown_item,
                          Clist
                      )
                      binding.autoCountry.setAdapter(CAdaptor)
                      binding.autoCountry.setOnItemClickListener { adapterView, view, i, l ->
                          country = Clist[i].response[i]
                          Toast.makeText(applicationContext, "$country", Toast.LENGTH_SHORT).show()
                      }

                  }


              }

              override fun onFailure(call: Call<MutableList<country>>, t: Throwable) {

              }

          })*/

        API_Clinets.init().getcountry().enqueue(object : Callback<country> {
            override fun onResponse(call: Call<country>, response: Response<country>) {

                if (response.isSuccessful) {
                    Clist = response.body()?.response as MutableList<country>

                    CAdaptor = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_dropdown_item,
                        Clist
                    )
                    binding.autoCountry.setAdapter(CAdaptor)
                    binding.autoCountry.setOnItemClickListener { adapterView, view, i, l ->

                        Toast.makeText(
                            applicationContext,
                            "${Clist.get(i).toString()}",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                }

            }

            override fun onFailure(call: Call<country>, t: Throwable) {

            }

        })


    }

    private fun getstetes() {

        API_Clinets.init().getstate().enqueue(object : Callback<state> {

            override fun onResponse(call: Call<state>, response: Response<state>) {
                if (response.isSuccessful) {
                    Slist = response.body()?.res as MutableList<state>
                    SAdsptor = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_dropdown_item,
                        Slist
                    )
                    binding.autoState.setAdapter(SAdsptor)
                    binding.autoState.setOnItemClickListener { adapterView, view, i, l ->
                        Toast.makeText(applicationContext, "${Slist.get(i).toString()}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<state>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}