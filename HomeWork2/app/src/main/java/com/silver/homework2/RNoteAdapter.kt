package com.silver.homework2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class RNoteAdapter(val context: Context, val notes:List<RNoteEntity>): BaseAdapter(){

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val vh: ViewHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.card_note, parent, false)
            vh = ViewHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }
        vh.tviName.text = notes[position].name
        return view
    }

    override fun getItem(position: Int): Any {
        return notes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return notes.size
    }

    class ViewHolder(view: View){
        val iviNote= view.findViewById<ImageView>(R.id.iv_note)
        val tviName= view.findViewById<TextView>(R.id.tv_name)
    }
}