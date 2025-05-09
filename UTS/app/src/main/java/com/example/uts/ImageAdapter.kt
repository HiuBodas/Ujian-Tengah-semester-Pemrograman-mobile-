package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ImageAdapter(
    private val context: Context,
    private val images: Array<Int>,
    private val descriptions: Array<String>
) : BaseAdapter() {

    override fun getCount(): Int = images.size

    override fun getItem(position: Int): Any = images[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.grid_item, parent, false)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textView: TextView = view.findViewById(R.id.textView)

        imageView.setImageResource(images[position])
        textView.text = descriptions[position]

        return view
    }
}
