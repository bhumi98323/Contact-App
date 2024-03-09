package com.example.contactapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ContactItemBinding
import com.example.contactapp.roomdb.entity.Contact

class ContactAdapter(var contactList: List<Contact>, var  context: Context ): RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ContactItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var binding = ContactItemBinding.inflate(LayoutInflater.from(context), parent , false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return contactList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var contact = contactList.get(position)
        holder.binding.sign.text = ""
        holder.binding.name.text = contact.name
        holder.binding.phone.text = contact.phoneNumber
        holder.binding.email.text = contact.email
    }
}