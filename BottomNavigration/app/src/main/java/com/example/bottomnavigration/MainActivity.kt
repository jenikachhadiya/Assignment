package com.example.bottomnavigration

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigration.databinding.ActivityMainBinding
import com.example.bottomnavigration.fragments.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //top app bar
        setSupportActionBar(binding.toolBar)
        //Set By Defalat page
        addFregment(ShopFregment(),"Shop")

        binding.bottomNavigation.setOnItemSelectedListener {


            return@setOnItemSelectedListener when(it.itemId){
                R.id.shop ->{
                    addFregment(ShopFregment(),"Shop")

                    true
                }
                R.id.supercoin ->{
                    addFregment(SuperCoin(),"SuperCoin")
                    true
                }
                R.id.credit ->{
                    addFregment(CreditFregments(),"Credit")
                    true
                }
                R.id.gamezone ->{
                    addFregment(GameZoneFragments(),"GameZ..")
                    true
                }
                R.id.profile ->{
                    addFregment(ProfileFregement(),"Profile")
                    true
                }
               else ->{
                   false
               }


            }

        }





    }

    private fun addFregment(fregment:Fragment ,tag: String) {
        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container,fregment,tag)
        transaction.commit()

        //toolbar ma set
        binding.toolBar.title = tag



    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()

        return super.onSupportNavigateUp()

    }
}