package com.example.contactapp.mvmarch

import android.content.Context
import com.example.contactapp.roomdb.Database
import com.example.contactapp.roomdb.DbBuilder
import com.example.contactapp.roomdb.entity.Contact

class repo( var context: Context,
      ) {
    var database : Database? = null
    init {
         database = DbBuilder.getdb(context)
    }

    fun getData(): List<Contact>? {
       return database?.contactDao()?.readContact()
    }
    fun insertData(contact: Contact){
       database?.contactDao()?.createContact(contact)
    }
    fun deleteData(contact: Contact){
        database?.contactDao()?.deleteContact(contact)
    }

    fun updateData(contact: Contact){
        database?.contactDao()?.updateContact(contact)
    }
}