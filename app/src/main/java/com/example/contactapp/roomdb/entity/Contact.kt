package com.example.contactapp.roomdb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contact(
  @PrimaryKey  var id: Int? = null,
    var profile: Int? = null,
    var name: String,
    var phoneNumber: String,
    var email:String? =null,
//    var date : Date

    )