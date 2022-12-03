package com.example.internal_external_storage

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.internal_external_storage.databinding.ActivityExternalStorageBinding
import java.util.jar.Manifest

class External_Storage : AppCompatActivity() {
    lateinit var binding: ActivityExternalStorageBinding
    private val REQ_STORAGE = 100

    var cameraLauncer = registerForActivityResult(ActivityResultContracts.RequestPermission(),{
        if (it){
            Toast.makeText(applicationContext, "Permission granted (camera)", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext, "Permission Dieaned (camera)", Toast.LENGTH_SHORT).show()
        }

    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExternalStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStorage.setOnClickListener {

            askPermission()

        }
        binding.btnCamere.setOnClickListener {

            cameraPermission()


        }


    }
    //camera  external permission
    private fun cameraPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //ask runtime parmittion
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ){
                // permission already granted
                Toast.makeText(applicationContext, "Permission granted(camera)", Toast.LENGTH_SHORT).show()
            }else if(shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA)) {
                //Show alert dilog how to give your permission
                showDilog()

            }else{
                // permission denied so ask run time permission
               cameraLauncer.launch(android.Manifest.permission.CAMERA)
                // Toast.makeText(applicationContext, "Permisssion Denid", Toast.LENGTH_SHORT).show()
            }
        }else{
            // below api 23
            Toast.makeText(applicationContext, "Permission Allowed(camera)", Toast.LENGTH_SHORT).show()
        }

    }
    //wriet external storage
    private fun askPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //ask runtime parmittion
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ){
                // permission already granted
                Toast.makeText(applicationContext, "Permission granted", Toast.LENGTH_SHORT).show()
            }else if(shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
               //Show alert dilog how to give your permission
                showDilog()
            }else{
                //permission denied so ask run time permission
                requestPermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), REQ_STORAGE)
               // Toast.makeText(applicationContext, "Permisssion Denid", Toast.LENGTH_SHORT).show()
            }
        }else{
            // below api 23
            Toast.makeText(applicationContext, "Permission Allowed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDilog() {
         AlertDialog.Builder(this)
             .setTitle("Permisssion Requed")
             .setMessage("for update your Profile Image you must have to allow external storge permission")
             .setPositiveButton("Allowed", DialogInterface.OnClickListener { dialogInterface, i ->

                 //navigetaion to  setting page
                 var intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                 var uri = Uri.fromParts("package",packageName,null)
                 intent.data = uri
                 startActivity(intent)

                 Toast.makeText(applicationContext, "click Positive Button ", Toast.LENGTH_SHORT).show()
             }).setNegativeButton("Cancle", DialogInterface.OnClickListener { dialogInterface, i ->
                 Toast.makeText(applicationContext, "click Negetive Button ", Toast.LENGTH_SHORT).show()
             }).show()
    }

      override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray)
      {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQ_STORAGE ->{
                if((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    // permission granted
                    Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show()
                }else{
                    // permission denied
                    Toast.makeText(applicationContext, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}