package com.example.contactapp.roomdb

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactapp.dbName
import kotlin.math.truncate

object DbBuilder {
    private var database:  Database?=null
        fun getdb(context: Context): Database? {
            if
                    (database == null)
                database = Room.databaseBuilder(
                    context,
                    Database::class.java, dbName
                ).setJournalMode(RoomDatabase.JournalMode.TRUNCATE).fallbackToDestructiveMigration().allowMainThreadQueries().build()

            return database

        }
}