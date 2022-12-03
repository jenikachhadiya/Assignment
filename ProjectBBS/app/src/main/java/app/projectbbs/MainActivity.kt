package app.projectbbs

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.projectbbs.CustomDilogBox.CustomDilogBox
import app.projectbbs.databinding.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClicke.setOnClickListener {
            var bind = NextDilogboxBinding.inflate(layoutInflater)
            var builder = AlertDialog.Builder(this)
                .setView(bind.root)
            var dailog = builder.create()
            dailog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
            dailog.show()


        }




    }
}