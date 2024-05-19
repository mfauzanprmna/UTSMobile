package com.example.utsmobile.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ArrayAdapter
import com.example.utsmobile.Data.Profile
import com.example.utsmobile.Data.profileData
import com.example.utsmobile.R

class ProfileAdapter(context: Context, private val beritaList: ArrayList<Profile>) : ArrayAdapter<Profile>(context, 0, beritaList) {
    override fun getCount(): Int {
        return profileData.size
    }

    override fun getItem(position: Int): Profile? {
        return profileData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_profile, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = profileData[position]
        viewHolder.imageView.setImageResource(item.imageResId)
        viewHolder.emailView.text = item.email
        viewHolder.nimView.text = item.nim
        viewHolder.namaView.text = item.nama
        viewHolder.kelasView.text = item.kelas

        return view
    }

    fun updateData(newData: ArrayList<Profile>) {
        profileData = newData
        notifyDataSetChanged()
    }

    private class ViewHolder(view: View) {
        val imageView: ImageView = view.findViewById(R.id.imageProfile)
        val emailView: TextView = view.findViewById(R.id.emailTXT)
        val nimView: TextView = view.findViewById(R.id.nimTXT)
        val namaView: TextView = view.findViewById(R.id.namaTXT)
        val kelasView: TextView = view.findViewById(R.id.kelasTXT)
    }
}