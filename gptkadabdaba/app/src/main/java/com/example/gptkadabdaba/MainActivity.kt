package com.example.gptkadabdaba

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recentCallsListView: ListView
    private val recentCalls = mutableListOf("1234567890", "9876543210", "5556667777", "4445556666", "2223334444")
    private val contactList = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recentCallsListView = findViewById(R.id.recentCallsListView)

        // Set up the adapter for the ListView
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, recentCalls)
        recentCallsListView.adapter = adapter

        // Register the ListView for context menu
        registerForContextMenu(recentCallsListView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val selectedNumber = recentCalls[info.position]

        return when (item.itemId) {
            R.id.save -> {
                contactList.add(selectedNumber)
                Toast.makeText(this, "Saved $selectedNumber", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.delete -> {
                recentCalls.removeAt(info.position)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Deleted $selectedNumber", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.send_sms -> {
                val smsIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("smsto:$selectedNumber")
                    putExtra("sms_body", "Hello!")
                }
                startActivity(smsIntent)
                true
            }
            R.id.history -> {
                Toast.makeText(this, "Already on History", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.view_contacts -> {
                val intent = Intent(this, ContactListActivity::class.java)
                intent.putStringArrayListExtra("contacts", ArrayList(contactList))
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
