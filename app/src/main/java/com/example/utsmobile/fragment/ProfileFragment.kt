package com.example.utsmobile.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.utsmobile.Adapter.ProfileAdapter
import com.example.utsmobile.Data.profileData
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
    lateinit var listView: ListView
    lateinit var adatepter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile,container,false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var containerProfile : FrameLayout = view.findViewById(R.id.containerProfile)
        // Ambil data dari beritaData
        val dataProfile = profileData

        // Loop melalui data berita dan tambahkan item ke LinearLayout
        for (berita in dataProfile) {
            val itemView = layoutInflater.inflate(R.layout.fragment_profile,containerProfile,false)

            val imageProfile: ImageView = itemView.findViewById(R.id.imageProfile)
            val emailProfile: TextView = itemView.findViewById(R.id.emailTXT)
            val nimProfile: TextView = itemView.findViewById(R.id.nimTXT)
            val namaProfile: TextView = itemView.findViewById(R.id.namaTXT)
            val kelasProfile: TextView = itemView.findViewById(R.id.kelasTXT)

            imageProfile.setImageResource(berita.imageResId)
            emailProfile.text = "Email : " + berita.email
            nimProfile.text = "NIM : " + berita.nim
            namaProfile.text = "Nama : " + berita.nama
            kelasProfile.text = "Kelas: " + berita.kelas

            containerProfile.addView(itemView)
        }

    }

}