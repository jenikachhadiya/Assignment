package com.example.internal_storage

import android.Manifest
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
import com.example.internal_storage.databinding.ActivityExternalStorageBinding
import com.example.internal_storage.databinding.ActivityMainBinding

class External_Storage : AppCompatActivity() {
    lateinit var binding: ActivityExternalStorageBinding
    private var REQ_STORAGE = 100
     var cameraluncer =registerForActivityResult(ActivityResultContracts.RequestPermission(),{
     if (it){
         Toast.makeText(applicationContext, "Permission granted (camera)", Toast.LENGTH_SHORT).show()
     }else{
         Toast.makeText(applicationContext, "Permission Dinaed (camera)", Toast.LENGTH_SHORT).show()
     }

    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExternalStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStorage.setOnClickListener {

            requestData()
        }
        binding.btnCamera.setOnClickListener {

            cameraData()

        }


    }
    private fun cameraData(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ){
                // permission already granted
                Toast.makeText(applicationContext, "Permission granted", Toast.LENGTH_SHORT).show()
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                DilogeShow()
            } else {
                cameraluncer.launch(Manifest.permission.CAMERA)
                Toast.makeText(applicationContext, "Permisssion Denid", Toast.LENGTH_SHORT).show()
            }

        }else{
            // below api 23
            Toast.makeText(applicationContext, "Permission Allowed", Toast.LENGTH_SHORT).show()

        }

    }

    private fun requestData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // permission already granted
                Toast.makeText(applicationContext, "Permission granted", Toast.LENGTH_SHORT).show()
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                DilogeShow()
            } else {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQ_STORAGE)
                Toast.makeText(applicationContext, "Permisssion Denid", Toast.LENGTH_SHORT).show()
            }

        }else{
            // below api 23
            Toast.makeText(applicationContext, "Permission Allowed", Toast.LENGTH_SHORT).show()

        }

    }

    private fun DilogeShow() {
        AlertDialog.Builder(this)
            .setTitle("Permissition Requed..")
            .setMessage("for update your Profile Image you must have to allow external storge permission")
            .setPositiveButton("Allowed", DialogInterface.OnClickListener { dialogInterface, i ->

                //permisstion granted navigration to setting page
                var intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                var uri = Uri.fromParts("package",packageName,null)
                intent.data = uri
                startActivity(intent)
                Toast.makeText(applicationContext, "permission granded", Toast.LENGTH_SHORT).show()
            }).setNegativeButton("Cancle", DialogInterface.OnClickListener { dialogInterface, i ->
                //permisstion Denied
                Toast.makeText(applicationContext, "permission Denied", Toast.LENGTH_SHORT).show()
            }).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQ_STORAGE -> {
                if ((grantResults.isEmpty()
                            &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)
                ) {
                    Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(applicationContext, "Permission Denied", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }


    }
}