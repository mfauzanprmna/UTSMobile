package com.example.utsmobile.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.utsmobile.Adapter.BeritaAdapter
import com.example.utsmobile.Data.beritaData
import com.example.utsmobile.DetailBeritaActivity
import com.example.utsmobile.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BeritaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BeritaFragment : Fragment() {
    lateinit var listView: ListView
    lateinit var adatepter: BeritaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_berita,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView: ListView = view.findViewById(R.id.listBerita)
        val adapter = BeritaAdapter(requireContext(), beritaData)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val item = beritaData[position]
            val intent = Intent(requireContext(), DetailBeritaActivity::class.java).apply {
                putExtra("imageResId", item.imageResId)
                putExtra("title", item.title)
                putExtra("isi", item.isi)
            }
            startActivity(intent)
        }
    }
}