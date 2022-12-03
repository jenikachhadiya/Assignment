package com.example.external_storgeimgpic

import android.Manifest
import android.content.ContentValues
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.external_storgeimgpic.databinding.ActivityMainBinding
import java.io.File
import java.io.FileDescriptor
import java.io.FileOutputStream
import java.io.IOException
import android.net.Uri as Uri

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //lateinit var camerauri : Uri
    lateinit var imageUri: Uri

    private val requestMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            it.entries.forEach {
                Log.e("DEBUG", "${it.key} = ${it.value}")
            }

        }


    var gallerycontract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        if (it != null) {
            binding.ivImage.setImageURI(it)

            uriToBitmap(it)?.let {
                saveimagetoExternalStorage(it)
            }
        }
    }


    var cameraContract = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        binding.ivImage.setImageURI(null)
        if (it) {
            binding.ivImage.setImageURI(imageUri)

            uriToBitmap(imageUri)?.let {
                saveimagetoExternalStorage(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageUri = createImageUri()!!

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

    private fun ShowOptionDiloge() {
        var opitionarray = arrayOf("Gellary", "Camera")
        AlertDialog.Builder(this)
            .setTitle("Pick Image")
            .setItems(opitionarray, DialogInterface.OnClickListener { dialogInterface, i ->
                if (i == 0) {
                    //gellary pic
                    gallerycontract.launch("image/*")
                } else if (i == 1) {
                    //camera pic
                    cameraContract.launch(imageUri)
                }


            }).show()


    }

    private fun createImageUri(): Uri? {
        val image = File(applicationContext.filesDir, "mypicture.png")
        return FileProvider.getUriForFile(
            applicationContext,
            "com.example.external_storgeimgpic.fileProvider",
            image
        )
    }

    private fun saveimagetoExternalStorage(bitmap: Bitmap) {

        val imagecollation = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)

            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)

        else

            MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            var resolver = contentResolver
            var contentValues = ContentValues()
            contentValues.put(
                MediaStore.MediaColumns.DISPLAY_NAME, "${System.currentTimeMillis()}.jpg"
            )
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
            contentValues.put(
                MediaStore.MediaColumns.RELATIVE_PATH,
                Environment.DIRECTORY_PICTURES + File.separator + "Jenu"
            )
            var imageuri = resolver.insert(imagecollation, contentValues)
            if (imageuri != null){
                contentResolver.openOutputStream(imageuri)?.let {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
                    Toast.makeText(this, "Image Saved", Toast.LENGTH_SHORT).show()

                }
            }
        } else {
            var root = Environment.getExternalStorageDirectory()
            var path = File(root, "my directory")
            if (!path.exists())
            {
                path.mkdir()
            }
            val file = File(path, "${System.currentTimeMillis()}.jpg")
            if (!file.exists()) {
                try {
                    val fos = FileOutputStream(file)

                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                    fos.flush()
                    fos.close()
                    Toast.makeText(applicationContext, "Image Saved", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }


        }

    }


    //TODO takes URI of the image and returns bitmap
    private fun uriToBitmap(selectedFileUri: Uri): Bitmap? {

        try {
            val parcelFileDescriptor = contentResolver.openFileDescriptor(selectedFileUri, "r")
            val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor
            val image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
            parcelFileDescriptor.close()
            return image
        } catch (e:IOException){
            e.printStackTrace()
        }
        return null
    }


}