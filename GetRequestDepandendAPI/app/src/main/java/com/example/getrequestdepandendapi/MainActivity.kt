package com.example.getrequestdepandendapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.getrequestdepandendapi.Modal.City
import com.example.getrequestdepandendapi.Modal.Country
import com.example.getrequestdepandendapi.Modal.State
import com.example.getrequestdepandendapi.Network.Api_Clints
import com.example.getrequestdepandendapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var Country_apator: ArrayAdapter<Country>
    lateinit var State_apator: ArrayAdapter<State>
    lateinit var city_apator: ArrayAdapter<City>

    var Countrylist = mutableListOf<Country>()
    var Statelist = mutableListOf<State>()
    var citylist = mutableListOf<City>()

    var country = ""
    var state = ""
    var city = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadcountryList()

    }

    private fun loadcountryList() {
        Api_Clints.init().getcountry().enqueue(object : Callback<List<Country>> {

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful) {
                    Countrylist = response.body() as MutableList<Country>

                    Country_apator = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_dropdown_item,
                        Countrylist
                    )
                    binding.autoContry.setAdapter(Country_apator)
                    binding.autoContry.setOnItemClickListener { adapterView, view, i, l ->

                        country = Countrylist[i].name
                        Toast.makeText(applicationContext, "$country", Toast.LENGTH_SHORT).show()
                         binding.autoSteat.setText("")
                        getStateList()

                    }

                }
            }
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {

            }

        })
    }

    private fun getStateList(){

        Api_Clints.init().getstates(country).enqueue(object : Callback<List<State>> {
            override fun onResponse(call: Call<List<State>>, response: Response<List<State>>) {

                if (response.isSuccessful)
                {

                    Statelist = response.body() as MutableList<State>
                    State_apator = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_dropdown_item,
                        Statelist
                    )

                }
                binding.autoSteat.setAdapter(State_apator)
                binding.autoSteat.setOnItemClickListener { adapterView, view, i, l ->
                    state = Statelist[i].stateName
                    Toast.makeText(applicationContext, "$state", Toast.LENGTH_SHORT).show()
                    binding.autoCity.setText("")
                    getCitylist()
                }

            }

            override fun onFailure(call: Call<List<State>>, t: Throwable) {

            }

        })

    }

    private fun getCitylist() {

        Api_Clints.init().getcity(state).enqueue(object :Callback<List<City>>{

            override fun onResponse(call: Call<List<City>>, response: Response<List<City>>){

             if (response.isSuccessful){
                citylist = response.body() as MutableList<City>
                 city_apator = ArrayAdapter(
                     applicationContext,
                     android.R.layout.simple_spinner_dropdown_item,
                     citylist
                 )
             }
                binding.autoCity.setAdapter(city_apator)
                binding.autoCity.setOnItemClickListener { adapterView, view, i, l ->
                    city = citylist[i].cName
                    Toast.makeText(applicationContext, "$city", Toast.LENGTH_SHORT).show()

                }



            }

            override fun onFailure(call: Call<List<City>>, t: Throwable) {

            }

        })
    }
}