package com.example.utsmobile.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.utsmobile.Adapter.ProfileAdapter
import com.example.utsmobile.Data.profileData
import com.example.utsmobile.MainActivity
import com.example.utsmobile.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Retrieve the stored values from SharedPreferences
        val sharedPreferences = activity?.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val email = sharedPreferences?.getString("email", "")
        val name = sharedPreferences?.getString("name", "")
        val nim = sharedPreferences?.getString("nim", "")
        val kelas = sharedPreferences?.getString("kelas", "")

        // Display the values
        view.findViewById<TextView>(R.id.emailTXT).text = "Email: $email"
        view.findViewById<TextView>(R.id.namaTXT).text = "Nama: $name"
        view.findViewById<TextView>(R.id.nimTXT).text = "NIM: $nim"
        view.findViewById<TextView>(R.id.kelasTXT).text = "Kelas: $kelas"

        // Handle logout button click
        val logoutButton = view.findViewById<Button>(R.id.logout)
        logoutButton.setOnClickListener {
            // Clear the shared preferences
            sharedPreferences?.edit()?.clear()?.apply()

            // Navigate back to MainActivity
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()  // Optional: close the current activity
        }

        return view
    }

}