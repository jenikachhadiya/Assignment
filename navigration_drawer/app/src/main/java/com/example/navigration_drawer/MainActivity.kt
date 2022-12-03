package com.example.navigration_drawer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.navigration_drawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var topbar = binding.topAppBar
        var drawer = binding.drawerlayout
        var navigrtion = binding.navigationView

        toggle = ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigrtion.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.item1 ->{
                    addContainer(HomeFragment())
                }
                 //   Toast.makeText(applicationContext, "Home Clicke", Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(applicationContext, "Cycling Clicke", Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(applicationContext, "Bus Clicke", Toast.LENGTH_SHORT).show()
                R.id.item4 -> Toast.makeText(applicationContext, "Plane Clicke", Toast.LENGTH_SHORT).show()
                R.id.item5 -> Toast.makeText(applicationContext, "Login Clicke", Toast.LENGTH_SHORT).show()
                R.id.item6 -> Toast.makeText(applicationContext, "Share Clicke", Toast.LENGTH_SHORT).show()
                R.id.item7 -> Toast.makeText(applicationContext, "Rateing us Clicke", Toast.LENGTH_SHORT).show()

            }
            true

        }

           topbar.setNavigationOnClickListener {
                drawer.open()
            }

        navigrtion.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
           drawer.close()
            true
        }



    }
    fun addContainer(frag:Fragment){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container,frag)
            .commit()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}