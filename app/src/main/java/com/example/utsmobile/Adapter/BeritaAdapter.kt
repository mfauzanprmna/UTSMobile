package com.example.utsmobile.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ArrayAdapter
import com.example.utsmobile.Data.DataModel
import com.example.utsmobile.Data.Profile
import com.example.utsmobile.Data.beritaData
import com.example.utsmobile.R

class BeritaAdapter(context: Context, private val beritaList: ArrayList<DataModel>) : ArrayAdapter<DataModel>(context, 0, beritaList) {
    override fun getCount(): Int {
        return beritaData.size
    }

    override fun getItem(position: Int): DataModel? {
        return beritaData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_berita, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = beritaData[position]
        viewHolder.imageView.setImageResource(item.imageResId)
        viewHolder.titleView.text = item.title
        viewHolder.descriptionView.text = item.desc

        return view
    }

    fun updateData(newData: ArrayList<DataModel>) {
        beritaData = newData
        notifyDataSetChanged()
    }

    private class ViewHolder(view: View) {
        val imageView: ImageView = view.findViewById(R.id.imageBerita)
        val titleView: TextView = view.findViewById(R.id.judulBerita)
        val descriptionView: TextView = view.findViewById(R.id.descBerita)
    }
}