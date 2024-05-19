package com.example.utsmobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.utsmobile.Alumni.AlumniActivity
import com.example.utsmobile.Alumni.TambahActivity
import com.example.utsmobile.Data.DataModel
import com.example.utsmobile.fragment.BeritaFragment
import com.example.utsmobile.fragment.HomeFragment
import com.example.utsmobile.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        val dropdownMenuIcon = findViewById<ImageView>(R.id.moreIcon)

        dropdownMenuIcon.setOnClickListener { view ->
            showPopupMenu(view)
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_berita -> {
                    loadFragment(BeritaFragment())
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        // Load the default fragment
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_tambah_data -> {
                    startActivity(Intent(this, TambahActivity::class.java))
                    true
                }
                R.id.action_data_alumni -> {
                    startActivity(Intent(this, AlumniActivity::class.java))
                    true
                }
                R.id.action_logout -> {
                    // Handle Logout action
                    finish()
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}