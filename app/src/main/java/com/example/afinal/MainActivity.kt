package com.example.afinal

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.adapter.SnackAdapter
import com.example.afinal.databinding.ActivityMainBinding
import com.example.afinal.databinding.AmDialogAddSnackBinding
import com.example.afinal.model.Snack
import com.example.afinal.viewmodel.SnackViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var amBinding: ActivityMainBinding
    private val amSnackViewModel: SnackViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amBinding.root)

        // Setup Toolbar
        setSupportActionBar(amBinding.amToolbar)

        // Setup RecyclerView
        val adapter = SnackAdapter()
        amBinding.amRvSnacks.adapter = adapter
        amBinding.amRvSnacks.layoutManager = LinearLayoutManager(this)

        // Observe ViewModel
        amSnackViewModel.amAllSnacks.observe(this) { snacks ->
            snacks?.let { adapter.submitList(it) }
        }

        // Add Button
        amBinding.amFabAddSnack.setOnClickListener {
            amShowAddSnackDialog()
        }
    }

    private fun amShowAddSnackDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.am_add_snack))

        val dialogBinding = AmDialogAddSnackBinding.inflate(layoutInflater)
        builder.setView(dialogBinding.root)

        builder.setPositiveButton("Add") { _, _ ->
            val name = dialogBinding.amEtSnackName.text.toString()
            val price = dialogBinding.amEtSnackPrice.text.toString().toDoubleOrNull() ?: 0.0
            val desc = dialogBinding.amEtSnackDescription.text.toString()

            if (name.isNotEmpty()) {
                val snack = Snack(amName = name, amPrice = price, amDescription = desc)
                amSnackViewModel.amInsert(snack)
            }
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.am_main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.amMenuDeleteAll -> {
                amSnackViewModel.amDeleteAll()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
