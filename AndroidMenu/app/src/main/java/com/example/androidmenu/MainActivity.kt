package com.example.androidmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    val btncontext :Button
    get() = findViewById(R.id.btn_contextmenu)

    val btnpopup :Button
    get() = findViewById(R.id.btn_Popupmenu)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button click thse toj e show thshe nu ter nhi
        registerForContextMenu(btncontext)

        /*//contetxt no button click event
        btncontext.setOnClickListener {

            Toast.makeText(applicationContext, "context button click", Toast.LENGTH_SHORT).show()

        }*/

        //popup menu nu click event
        btnpopup.setOnClickListener {

            var popupMenu = PopupMenu(this,it)
            menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.show()

            //second way
            popupMenu.setOnMenuItemClickListener(this@MainActivity)


            //first way
           /* popupMenu.setOnMenuItemClickListener {

                return@setOnMenuItemClickListener when(it.itemId){
                    R.id.menu_search ->{
                        Toast.makeText(applicationContext, " popup search item selected", Toast.LENGTH_SHORT).show()
                        true


                    }R.id.menu_setting ->{
                        Toast.makeText(applicationContext, "popup setting item selected", Toast.LENGTH_SHORT).show()
                        true

                    }R.id.menu_logout ->{
                        Toast.makeText(applicationContext, "popup logout item selected", Toast.LENGTH_SHORT).show()
                        true

                    }else -> false


                }



            }
*/


        }


    }

    // option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.menu_search ->{
                Toast.makeText(applicationContext, "search item selected", Toast.LENGTH_SHORT).show()
                true


            }R.id.menu_setting ->{
                Toast.makeText(applicationContext, "setting item selected", Toast.LENGTH_SHORT).show()
                true

            }R.id.menu_logout ->{
                Toast.makeText(applicationContext, "logout item selected", Toast.LENGTH_SHORT).show()
                true

            }else -> super.onOptionsItemSelected(item)


        }
    }


    // Context menu

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu,menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.menu_search ->{
                Toast.makeText(applicationContext, " Context search item selected", Toast.LENGTH_SHORT).show()
                true


            }R.id.menu_setting ->{
                Toast.makeText(applicationContext, "Context setting item selected", Toast.LENGTH_SHORT).show()
                true

            }R.id.menu_logout ->{
                Toast.makeText(applicationContext, " Context logout item selected", Toast.LENGTH_SHORT).show()
                true

            }else -> super.onContextItemSelected(item)


        }
    }


    //popup click event nu second methode
    override fun onMenuItemClick(item: MenuItem?): Boolean {

        return when(item!!.itemId){
            R.id.menu_search ->{
                Toast.makeText(applicationContext, " popup search item selected", Toast.LENGTH_SHORT).show()
                true


            }R.id.menu_setting ->{
                Toast.makeText(applicationContext, " popup setting item selected", Toast.LENGTH_SHORT).show()
                true

            }R.id.menu_logout ->{
                Toast.makeText(applicationContext, " popup logout item selected", Toast.LENGTH_SHORT).show()
                true

            }else -> super.onOptionsItemSelected(item)


        }

    }


}