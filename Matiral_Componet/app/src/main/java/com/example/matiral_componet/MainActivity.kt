package com.example.matiral_componet

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.matiral_componet.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var country = arrayOf("India","Pakistan","Shrilanka","China","UK","Japan")

    lateinit var adoptor :ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        adoptor = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,country)
        binding.autoComplete.setAdapter(adoptor)
        binding.btnClicke.setOnClickListener {
            showAlrtDailog()

        }

    }

    private fun showAlrtDailog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Alart")
            .setMessage("Are you Sure?")
            .setPositiveButton("Done", DialogInterface.OnClickListener { dialogInterface, i ->

            }).show()
    }
}