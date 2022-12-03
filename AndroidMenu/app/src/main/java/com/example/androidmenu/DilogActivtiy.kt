package com.example.androidmenu

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.icu.text.DecimalFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.androidmenu.databinding.ActivityDilogActivtiyBinding
import com.example.androidmenu.databinding.CustomDialogBinding
import java.sql.Time
import java.util.*

class DilogActivtiy : AppCompatActivity() {

    lateinit var binding: ActivityDilogActivtiyBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDilogActivtiyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var Time = Calendar.getInstance()
        var Hours = Time.get(Calendar.HOUR)
        var Min = Time.get(Calendar.MINUTE)

        //Time Picker dialoges
        binding.ivTime.setOnClickListener {

            var timepick = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener
            { timePicker,HH, MM ->

              /* var fometer = DecimalFormat("00")
                var Hou = fometer.format(Hours)
                var mint = fometer.format(Min)*/

                var time = "$HH:$MM"
                binding.etHMS.setText(time)

            },Hours,Min,true)
               timepick.show()

        }

        //Date picker dialog
        // imege Calunder click events
        binding.ivCalender.setOnClickListener{

            var calunder = Calendar.getInstance()
            var year = calunder.get(Calendar.YEAR)
            var month = calunder.get(Calendar.MONTH)
            var DOM = calunder.get(Calendar.DATE)



            var dialog = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, mYear, mMonth, mDOM ->

                var formeter = DecimalFormat("00")

                var dayofMonth = formeter.format(mDOM)
                var month = formeter.format(mMonth+1)


                //a peremiter ma avti ditails e date ma store thy and settext to edit text ma show thay che
                var Date = "$dayofMonth/$month/$mYear"
                binding.etDMY.setText(Date)



            },year,month,DOM).show()

        }
    }

    // button nu clicked event using xml
    //alart diloge clicked event
    fun onButtonCliked(view: View) {
        //swich case to use karvano atle id vises selected thay

        when (view.id) {
            //function of alrte dialoge
            R.id.btn_alrtdialoge -> setAlertdialog() //calling
            R.id.btn_Singal_alrtdialoge -> setSingalAlartdialog() // singal _alter dialoge calling
            R.id.btn_multi_alrtdialoge -> setMultipalAlartdialog()
            R.id.btn_custum_alrtdialoge -> SetCustomAlartdilog() //custom_alrt diloge calling
        }


    }

    // custome dialog function
    private fun SetCustomAlartdilog() {
        var bind = CustomDialogBinding.inflate(layoutInflater)

        var builde = AlertDialog.Builder(this)
            .setView(bind.root)

        val dilog = builde.create()
        dilog.show()

        //button click event
        bind.btnCustumDilog.setOnClickListener {
            //first dismisss thase pachi tost thase
            dilog.dismiss()
            Toast.makeText(applicationContext, "Button clicked", Toast.LENGTH_SHORT).show()

        }

    }




    //Multipal choice alart dialoge
    private fun setMultipalAlartdialog() {
        //return type List return karse
        var ChakList = mutableListOf<String>()
        //refrence to String array //value get karva mate getstringArray
        var lungArray = resources.getStringArray(R.array.Lunguage)
        // var selectitem = colorArray[2]

        var builder: AlertDialog = AlertDialog.Builder(this)
            .setTitle("choice your launguage")
            .setMultiChoiceItems(
                lungArray,
                null,
                DialogInterface.OnMultiChoiceClickListener { dialogInterface, i,
                                                             ischeck ->
                    var lung = lungArray[i]
                    if (ischeck) {
                        ChakList.add(lung)
                    } else {
                        ChakList.remove(lung)
                    }
                    Toast.makeText(applicationContext, "$ChakList", Toast.LENGTH_SHORT).show()
                }).setPositiveButton("Done", DialogInterface.OnClickListener { dialogInterface, i ->

            }).show()
          // builder.show()

    }

    private fun setSingalAlartdialog() {

        /* // singal alart dialoges

         var colorArray = arrayOf("Red","Blue","Oreange","pink","Black")

         //traditionnal singal choice dialoge

         var builder:AlertDialog = AlertDialog.Builder(this)
             .setTitle("Pick color")
             .setItems(colorArray, DialogInterface.OnClickListener { dialogInterface, i ->
                     var color = colorArray[i]
                 binding.tvView.text = color
                 Toast.makeText(applicationContext, "$color", Toast.LENGTH_SHORT).show()
             })
             .show()
             */


        //with redio button
        var colorArray = arrayOf("Red", "Blue", "Oreange", "pink", "Black")

        //traditionnal singal choice dialoge

        var selectitem = colorArray[2]
        var builder: AlertDialog = AlertDialog.Builder(this)
            .setTitle("Pick color")
            .setSingleChoiceItems(
                colorArray,
                2,
                DialogInterface.OnClickListener { dialogInterface, i ->
                    selectitem = colorArray[i]
                    //Toast.makeText(applicationContext, "$color", Toast.LENGTH_SHORT).show()
                }).setPositiveButton("Done", DialogInterface.OnClickListener { dialogInterface, i ->

                binding.tvView.text = selectitem

            }).show()
    }

    //with multipal choice dialoge


    //Alart diloge function
    private fun setAlertdialog() {

        var builder: AlertDialog = AlertDialog.Builder(this)
            .setTitle("Alert")
            .setMessage("Are you sure you want to delate this selecetd items")
            .setPositiveButton("Delate", DialogInterface.OnClickListener { dialogInterface, i ->
                //positive button click event
                //customer delete select kare tyare a block excuted thavo joy
                Toast.makeText(applicationContext, "Delate button clicked", Toast.LENGTH_SHORT)
                    .show()
            }).setNegativeButton("Cancle", DialogInterface.OnClickListener { dialogInterface, i ->
                //negative button no click event
                //customer cancle kare tyare a block excuted thavo joy
                Toast.makeText(applicationContext, "Cancle button clicked", Toast.LENGTH_SHORT)
                    .show()
            }).show()

    }


}