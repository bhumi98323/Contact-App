package com.example.contactapp

import android.app.Dialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactapp.databinding.ActivityAddEdit2Binding
import com.example.contactapp.roomdb.Database
import com.example.contactapp.roomdb.DbBuilder
import com.example.contactapp.roomdb.entity.Contact
import java.util.jar.Attributes.Name

class AddEditActivity2 : AppCompatActivity() {
    val binding by lazy {
        ActivityAddEdit2Binding.inflate(layoutInflater)
    }


    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBar = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBar.left, systemBar.top, systemBar.right, systemBar.bottom)
            insets
        }

        binding.imageView2.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.image_dialog)
            val image = dialog.findViewById<ImageView>(R.id.imageView)

            val imageDrawable = binding.imageView2.drawable
            if (imageDrawable != null) {
                image.setImageDrawable(imageDrawable)

                // Adjust the layout parameters
                val lp = WindowManager.LayoutParams()
                lp.width = WindowManager.LayoutParams.WRAP_CONTENT
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT
                lp.blurBehindRadius = 100
                dialog.window?.attributes = lp
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                dialog.show()
            }


        }
            binding.savecontact.setOnClickListener {
                var contact = Contact(
                    name = binding.name.editText?.text.toString(),
                    phoneNumber = binding.phone.editText?.text.toString(),
                    email = binding.email.editText?.text.toString(),
                )


                var db: Database? = DbBuilder.getdb(this)
               val i =db?.contactDao()?.createContact(contact)

                if (i != null) {
                    if(i>0){
                        Toast.makeText(this@AddEditActivity2, i.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}