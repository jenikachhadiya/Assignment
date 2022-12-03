package com.example.calculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.ScrollCaptureCallback
import com.example.calculater.databinding.ActivityMainBinding
import java.io.IOException
import javax.script.ScriptEngine
import javax.script.ScriptEngineFactory
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var check = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.etInputnumber.movementMethod = ScrollingMovementMethod()
        binding.etInputnumber.setActivated(true)
        binding.etInputnumber.setPressed(true)

        var text: String
        binding.btn1.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "1"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn2.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "2"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn3.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "3"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn4.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "4"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn5.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "5"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn6.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "6"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn7.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "7"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn8.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "8"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn9.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "9"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn0.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "0"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btn00.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "00"
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btnDots.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "."
            binding.etInputnumber.setText(text)
            result(text)
        }
        binding.btnAdd.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "+"
            binding.etInputnumber.setText(text)
            check = check + 1
        }
        binding.btnSub.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "-"
            binding.etInputnumber.setText(text)
            check = check + 1
        }
        binding.btnMul.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "×"
            binding.etInputnumber.setText(text)
            check = check + 1
        }
        binding.btnDiv.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "÷"
            binding.etInputnumber.setText(text)
            check = check + 1
        }
        binding.btnPr.setOnClickListener {
            text = binding.etInputnumber.text.toString() + "%"
            binding.etInputnumber.setText(text)
            check = check + 1
        }
        binding.btnEquel.setOnClickListener {
            text = binding.result.text.toString()
            binding.etInputnumber.setText(text)
            binding.result.setText(null)
        }
        binding.clear.setOnClickListener {
            binding.etInputnumber.setText(null)
            binding.result.setText(null)
        }
        binding.btnBackspace.setOnClickListener {
            var backspace: String? = null
            if (binding.etInputnumber.text.length > 0) {
                var stringbuilder: StringBuilder = StringBuilder(binding.etInputnumber.text)
                val find = binding.etInputnumber.text.toString()
                var find1 = find.last()

                if (find1.equals('+') || find1.equals('-') || find1.equals('*') || find1.equals('/') || find1.equals(
                        '%'
                    )
                ) {
                    check = check - 1
                }
                stringbuilder.deleteCharAt(binding.etInputnumber.text.length-1)
                backspace=stringbuilder.toString()
                binding.etInputnumber.setText(backspace)
                result(backspace)
            }


        }


    }

    private fun result(text: String) {

        var engine:ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try{
            var result : Any=engine.eval(text)
            var mainr = result.toString()
            if (check==0){
                binding.result.setText(null)
            }
            else{
                binding.result.setText(mainr)
            }

        }catch (e:ScriptException){
           Log.d("TAG","ERROR")
        }

    }
}