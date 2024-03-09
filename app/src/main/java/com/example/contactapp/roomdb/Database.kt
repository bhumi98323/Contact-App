package com.example.contactapp.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactapp.DB_VERSION
import com.example.contactapp.roomdb.Dao.ContactDao
import com.example.contactapp.roomdb.entity.Contact

@Database(entities = [Contact::class], version = DB_VERSION )
  abstract class Database:RoomDatabase() {

     abstract fun contactDao(): ContactDao

}