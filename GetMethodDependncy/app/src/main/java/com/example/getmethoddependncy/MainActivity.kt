package com.example.getmethoddependncy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.getmethoddependncy.Modal.City
import com.example.getmethoddependncy.Modal.Country
import com.example.getmethoddependncy.Modal.State
import com.example.getmethoddependncy.databinding.ActivityMainBinding
import com.example.getmethoddependncy.network.API_Service
import com.example.getmethoddependncy.network.Api_Clinte
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var CAadaptor:ArrayAdapter<Country>
    lateinit var SAadaptor:ArrayAdapter<State>
    lateinit var cadaptor:ArrayAdapter<City>

    private var Countrylist = mutableListOf<Country>()
    private var Statelist= mutableListOf<State>()
    private var Citylist =mutableListOf<City>()

    var country = ""
    var state = ""
    var city = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadCountryList()





    }
    private fun loadCountryList(){
        Api_Clinte.init().getcountry().enqueue( object :Callback<List<Country>>{
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful){
                    Countrylist = response.body() as MutableList<Country>
                    CAadaptor = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_dropdown_item,
                        Countrylist
                    )
                binding.autoCountry.setAdapter(CAadaptor)
                binding.autoCountry.setOnItemClickListener { adapterView, view, i, l ->
                country = Countrylist[i].CName
                    Toast.makeText(applicationContext, "$country", Toast.LENGTH_SHORT).show()
                      binding.autoState.setText("")
                      getstateList()

                }
                }

            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {

            }

        })
    }

    private fun getstateList() {

        Api_Clinte.init().getState(country).enqueue(object :Callback<List<State>>{

            override fun onResponse(call:Call<List<State>>, response: Response<List<State>>) {
                if (response.isSuccessful) {
                    Statelist = response.body() as MutableList<State>
                    SAadaptor = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_dropdown_item,
                        Statelist
                    )
                }
                    binding.autoState.setAdapter(SAadaptor)
                    binding.autoState.setOnItemClickListener { adapterView, view, i, l ->
                        state = Statelist[i].SName
                        Toast.makeText(applicationContext, "$state", Toast.LENGTH_SHORT).show()
                        binding.autoCity.setText("")
                        getcityList()
                    }




            }

            override fun onFailure(call: Call<List<State>>, t: Throwable) {


            }

        })
    }

    private fun getcityList() {
        Api_Clinte.init().getCity(state).enqueue(object :Callback<List<City>>{
            override fun onResponse(call: Call<List<City>>, response: Response<List<City>>) {
                if (response.isSuccessful){
                    Citylist = response.body() as MutableList<City>
                    cadaptor = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_dropdown_item,
                        Citylist
                    )
                    binding.autoCity.setAdapter(cadaptor)
                    binding.autoCity.setOnItemClickListener { adapterView, view, i, l ->
                        city = Citylist[i].CName
                        Toast.makeText(applicationContext, "$city", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<List<City>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}