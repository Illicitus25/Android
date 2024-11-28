package com.example.gptkadabdaba

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ContactListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val contactListView: ListView = findViewById(R.id.contactListView)
        val contactList = intent.getStringArrayListExtra("contacts") ?: arrayListOf()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactList)
        contactListView.adapter = adapter
    }
}
