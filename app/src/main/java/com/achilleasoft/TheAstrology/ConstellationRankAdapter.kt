package com.achilleasoft.TheAstrology

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ConstellationRankAdapter (val context: Context, val ConstellationRankList: ArrayList<ConstellationRank>) : BaseAdapter() {
    override fun getCount(): Int {
        return ConstellationRankList.size
    }

    override fun getItem(position: Int): Any {
        return ConstellationRankList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_constellation_rank, null)
        val rank = view.findViewById<TextView>(R.id.list_rank_text)
        val constellation = view.findViewById<TextView>(R.id.list_constellation_text)

        val constellationRank = ConstellationRankList[position]

        rank.text = constellationRank.rank
        constellation.text = constellationRank.constellation
        return view
    }
}
