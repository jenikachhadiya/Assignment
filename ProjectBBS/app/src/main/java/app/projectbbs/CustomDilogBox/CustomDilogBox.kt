package app.projectbbs.CustomDilogBox

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import android.widget.Toast
import app.projectbbs.R
import app.projectbbs.databinding.*

class CustomDilogBox(var context: Context) {


    //Setting Dailog Methode
    fun ShowDilog(){
        //layout binding
         lateinit var binding1: SettingDilogboxBinding
        binding1=SettingDilogboxBinding.inflate(LayoutInflater.from(context))
        var dilog=Dialog(context)
        dilog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dilog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dilog.setCancelable(false)
        dilog.setContentView(binding1.root)

        //close clicke event
        binding1.close.setOnClickListener {
            dilog.dismiss()
        }
        dilog.show()

    }

    //next DilogBox
    fun NextDilog(title: String){
        //layout binding
        lateinit var binding1: NextDilogboxBinding
        var bind=NextDilogboxBinding.inflate(LayoutInflater.from(context))
        var dilog=Dialog(context)
        dilog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dilog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dilog.setCancelable(false)
        dilog.setContentView(bind.root)

        //next button clicke event
        bind.btnNext.setOnClickListener {
            Toast.makeText(context.applicationContext, "next clicke", Toast.LENGTH_SHORT).show()
        }
        //repate button clicke event
        bind.btnRepeat.setOnClickListener {
            Toast.makeText(context.applicationContext, "Repeat button clicke", Toast.LENGTH_SHORT).show()
        }
        //close clicke event
        bind.close.setOnClickListener {
            dilog.dismiss()
        }
        dilog.show()
    }
    //Pause DilogBox
    fun PauseDilog(title:String){
        //layout binding
        lateinit var binding1: PauseDilogboxBinding
        var bind=PauseDilogboxBinding.inflate(LayoutInflater.from(context))
        var dilog=Dialog(context)
        dilog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dilog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dilog.setCancelable(false)
        dilog.setContentView(bind.root)
        //Back clicke event
        bind.btnBack.setOnClickListener {
            Toast.makeText(context.applicationContext, "Back Clicke", Toast.LENGTH_SHORT).show()
        }
        //Retry Clicke event
        bind.btnRetry.setOnClickListener {
            Toast.makeText(context.applicationContext, "Retry Clicke", Toast.LENGTH_SHORT).show()
        }
        //close clicke event
        bind.close.setOnClickListener {
            dilog.dismiss()
        }
        dilog.show()
    }

    //Play DilogBox
    fun PlayDilogBox(title: String){
            //layout binding
            lateinit var binding1: PlayDilogboxBinding
            var bind=PlayDilogboxBinding.inflate(LayoutInflater.from(context))
            var dilog=Dialog(context)
            dilog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dilog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dilog.setCancelable(false)
            dilog.setContentView(bind.root)

           //Play Button Clicke event
           bind.btnPlay.setOnClickListener {
               Toast.makeText(context.applicationContext, "Play Button", Toast.LENGTH_SHORT).show()
           }
            //close clicke event
            bind.close.setOnClickListener {
                dilog.dismiss()
            }
            dilog.show()
    }
    //Quit DilogBox
    fun QuitDilog(title:String){
        //layout binding
        lateinit var binding1: QuitDilogboxBinding
        var bind=QuitDilogboxBinding.inflate(LayoutInflater.from(context))
        var dilog=Dialog(context)
        dilog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dilog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dilog.setCancelable(false)
        dilog.setContentView(bind.root)
        //quit clicke event
        bind.btnQuit.setOnClickListener {
            Toast.makeText(context.applicationContext, "Quit", Toast.LENGTH_SHORT).show()
        }
        //playOn Button
        bind.btnPlay.setOnClickListener {
            Toast.makeText(context.applicationContext, "PlayOn!!", Toast.LENGTH_SHORT).show()
        }

        //close clicke event
        bind.close.setOnClickListener {
            dilog.dismiss()
        }
        dilog.show()

    }




}