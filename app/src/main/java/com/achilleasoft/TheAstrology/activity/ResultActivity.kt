package com.achilleasoft.TheAstrology.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.achilleasoft.TheAstrology.ConstellationRank
import com.achilleasoft.TheAstrology.ConstellationRankAdapter
import com.achilleasoft.TheAstrology.R
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        val constellation = intent.extras?.getString("constellation")?:""

        val ranking = getSharedPreferences("ranking", Context.MODE_PRIVATE)
        val dateData = ranking.getString("date", null)

        if (SimpleDateFormat("yyyy/MM/dd").format(Date()) != dateData) {

            val constellations : List<String> = arrayListOf(
                    "おひつじ座", "おうし座", "ふたご座", "かに座", "しし座", "おとめ座",
                    "てんびん座", "さそり座", "いて座", "やぎ座", "みずがめ座", "うお座").toList()
            val constellationsShuffled = constellations.shuffled()

            val editor = ranking.edit()
            val today = SimpleDateFormat("yyyy/MM/dd").format(Date())
            // 今日の日付を取得
            editor.putString("date", today)
            for (index in 0 until 12) {
                val rank = index + 1
                // 星座ごとのランキングを保存
                editor.putInt(constellationsShuffled.get(index), rank)
                // 順位から星座も出せるようにする
                editor.putString(rank.toString(), constellationsShuffled.get(index))
            }
            editor.apply()
        }

        findViewById<TextView>(R.id.rank).text = getString(R.string.user_rank, constellation, ranking.getInt(constellation, 0))

        val todayRankList = arrayListOf<ConstellationRank>(
                ConstellationRank("第1位", ranking.getString("1", "").toString()),
                ConstellationRank("第2位", ranking.getString("2", "").toString()),
                ConstellationRank("第3位", ranking.getString("3", "").toString()),
                ConstellationRank("第4位", ranking.getString("4", "").toString()),
                ConstellationRank("第5位", ranking.getString("5", "").toString()),
                ConstellationRank("第6位", ranking.getString("6", "").toString()),
                ConstellationRank("第7位", ranking.getString("7", "").toString()),
                ConstellationRank("第8位", ranking.getString("8", "").toString()),
                ConstellationRank("第9位", ranking.getString("9", "").toString()),
                ConstellationRank("第10位", ranking.getString("10", "").toString()),
                ConstellationRank("第11位", ranking.getString("11", "").toString()),
                ConstellationRank("第12位", ranking.getString("12", "").toString()),
        )

        val listView = findViewById<ListView>(R.id.rank_list)
        val adapter = ConstellationRankAdapter(this, todayRankList)
        listView.adapter = adapter
        listView.setOnItemClickListener { adapterView, _, position, _ ->
            val intent = Intent(applicationContext, DetailActivity::class.java)
            val rank = (position + 1).toString()
            intent.putExtra("rank", rank)
            intent.putExtra("constellation", ranking.getString(rank, "").toString())
            startActivity(intent)
        }
    }
}
