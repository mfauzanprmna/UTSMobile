package com.example.utsmobile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val email = findViewById<TextInputEditText>(R.id.email)
        val password = findViewById<TextInputEditText>(R.id.password)
        val Login = findViewById<Button>(R.id.login)

        // Set up the login button click listener
        Login.setOnClickListener {
            // Hardcoded values
            val emailText = "admin@admin.com"
            val nameText = "Muhammad Fauzan Permana"
            val NIMText = "2207411035"
            val KelasText = "TI-4B"
            val passwordText = "admin"

            // Store values in SharedPreferences
            val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("email", emailText)
            editor.putString("name", nameText)
            editor.putString("nim", NIMText)
            editor.putString("kelas", KelasText)
            editor.putString("password", passwordText)
            editor.apply()

            // Get the email and password from the text fields
            val emailtxt = email.text.toString()
            val passwordtxt = password.text.toString()

            // Check if the email and password are correct
            if (emailtxt == emailText && passwordtxt == passwordText) {
                // Start the next activity
                val intent = Intent(this, MainFragmentActivity::class.java)
                startActivity(intent)
            } else {
                // Show an error message
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun enableEdgeToEdge() {
        // Implement this method if necessary to enable edge-to-edge display
    }
}