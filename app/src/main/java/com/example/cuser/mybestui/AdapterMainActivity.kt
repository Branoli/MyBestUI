package com.example.cuser.mybestui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AdapterMainActivity(private val mDataset: Array<String>) : RecyclerView.Adapter<AdapterMainActivity.ViewHolder>()  {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTextView: TextView

        init {
            mTextView = v.findViewById<View>(R.id.tv_recycler_item) as TextView
        }
    }

    override fun onBindViewHolder(holder: AdapterMainActivity.ViewHolder, position: Int) {
        holder.mTextView.text = mDataset[position]
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMainActivity.ViewHolder{
        val inflatedView = parent.inflate(R.layout.my_text_view, false)
        return ViewHolder(inflatedView)
    }
}