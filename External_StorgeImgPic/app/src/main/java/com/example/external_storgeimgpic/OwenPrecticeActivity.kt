package com.example.external_storgeimgpic

import android.Manifest
import android.content.ContentResolver
import android.content.ContentValues
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.external_storgeimgpic.databinding.ActivityOwenPrecticeBinding
import java.io.File
import java.io.FileDescriptor
import java.io.FileOutputStream
import java.io.IOException

class OwenPrecticeActivity : AppCompatActivity() {
    lateinit var binding: ActivityOwenPrecticeBinding
    lateinit var imageuri: Uri

    //gellary content
    var gellarycontent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.ivImage.setImageURI(null)
        if (it != null) {
            binding.ivImage.setImageURI(it)

            uritobitmap(it)?.let {
                saveImageExternalStorege(it)
            }

        }
    }


    //camera content
    var Cameracontent = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        binding.ivImage.setImageURI(null)
        if (it) {
            binding.ivImage.setImageURI(imageuri)

            uritobitmap(imageuri)?.let {
                saveImageExternalStorege(it)
            }

        }
    }

    private var requestMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {

            it.entries.forEach {
                (Log.e("DEBUG", "${it.key} = ${it.value}"))
            }


        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOwenPrecticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageuri = createuri()!!


        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
        } else {

            requestMultiplePermissions.launch(
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            )

        }



        binding.ivImage.setOnClickListener {
            ShowOptionDiloge()
        }


    }

    private fun createuri(): Uri {
        val image = File(applicationContext.filesDir, "my Pictures.png")
        return FileProvider.getUriForFile(
            this,
            "com.example.external_storgeimgpic.fileProvider",
            image
        )

    }

    private fun ShowOptionDiloge() {
        var option = arrayOf("From Gellary", "From Camera")
        AlertDialog.Builder(this)
            .setTitle("Pick Option")
            .setItems(option, DialogInterface.OnClickListener { dialogInterface, i ->
                if (i == 0) {
                    //gelary luncer
                    gellarycontent.launch("image/*")
                } else if (i == 1) {
                    Cameracontent.launch(imageuri)
                }

            }).show()
    }

    //TODO tack image to uri and convert Bitmap
    private fun uritobitmap(it: Uri): Bitmap? {
        try {
            var parcelFileDescriptor = contentResolver.openFileDescriptor(it, "r")
            var fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor
            var image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
            parcelFileDescriptor.close()
            return image
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    private fun saveImageExternalStorege(bitmap: Bitmap){
        var imageuri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        else
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            var resolver = contentResolver
            var contentValues = ContentValues()
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME,"${System.currentTimeMillis()}.jpg")
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE,"Img/jpg")
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH,
                Environment.DIRECTORY_PICTURES+File.separator+"PHOTOS")
            var imguri =resolver.insert(imageuri,contentValues)

            if (imguri!=null){
                contentResolver.openOutputStream(imguri)?.let {
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,it)
                }
            }
        } else {
            var root = Environment.getExternalStorageDirectory()
            var path = File(root, "External")
            if (!path.exists()){
                path.mkdir()
            }
            var file = File(path, "${System.currentTimeMillis()}.png")
            if (!file.exists()) {
                try {
                    var fos = FileOutputStream(file)

                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                    fos.flush()
                    fos.close()
                    Toast.makeText(applicationContext, "Image Saved", Toast.LENGTH_SHORT).show()


                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}


