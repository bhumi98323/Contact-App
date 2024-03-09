package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactapp.databinding.ActivityMainBinding
import com.example.contactapp.roomdb.DbBuilder
import com.example.contactapp.roomdb.entity.Contact

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBar = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBar.left, systemBar.top, systemBar.right, systemBar.bottom)
            insets
        }
        binding.button.setOnClickListener {
            val intent = Intent(this, AddEditActivity2::class.java)
            startActivity(intent)
//        DbBuilder.getdb(this)?.contactDao()?.createContact(Contact(name = "Bhumika", phoneNumber = "788545151"))
//
        }
    }
}
