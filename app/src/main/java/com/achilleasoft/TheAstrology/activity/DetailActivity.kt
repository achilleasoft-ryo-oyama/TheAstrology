package com.achilleasoft.TheAstrology.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.achilleasoft.TheAstrology.R

class DetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        val rank = intent.extras?.getString("rank")?:""
        val constellation = intent.extras?.getString("constellation")?:""
        findViewById<TextView>(R.id.today_constellation_text).text = getString(R.string.today_constellation_text, rank, constellation)

        when (rank.toIntOrNull()) {
            1, 2, 3 -> {
                setAWord(resources.getStringArray(R.array.first_short_array), resources.getStringArray(
                        R.array.first_short_array
                ).size)
            }
            4, 5, 6 -> {
                setAWord(resources.getStringArray(R.array.second_short_array), resources.getStringArray(
                        R.array.second_short_array
                ).size)
            }
            7, 8 -> {
                setAWord(resources.getStringArray(R.array.third_short_array), resources.getStringArray(
                        R.array.third_short_array
                ).size)
            }
            9, 10 -> {
                setAWord(resources.getStringArray(R.array.fourth_short_array), resources.getStringArray(
                        R.array.fourth_short_array
                ).size)
            }
            11, 12 -> {
                setAWord(resources.getStringArray(R.array.fifth_short_array), resources.getStringArray(
                        R.array.fifth_short_array
                ).size)
            }
        }
        setStars(rank.toInt())
    }

    private fun setAWord(array: Array<String>, arraySize: Int) {
        findViewById<TextView>(R.id.today_a_word_text).text = array.get((0..arraySize-1).random())
    }

    private fun setStars(rankNum: Int) {
        when (rankNum) {
            1 -> {
                viewChangeStar("total", 5)
                viewChangeStar("love", 5)
                viewChangeStar("money", 5)
                viewChangeStar("work", 5)
                viewChangeStar("health", 5)
            }
            2 -> {
                viewChangeStar("total", 5)
                viewChangeStar("love", (4..5).random())
                viewChangeStar("money", (4..5).random())
                viewChangeStar("work", (4..5).random())
                viewChangeStar("health", (4..5).random())
            }
            3 -> {
                viewChangeStar("total", 4)
                viewChangeStar("love", (4..5).random())
                viewChangeStar("money", (4..5).random())
                viewChangeStar("work", (4..5).random())
                viewChangeStar("health", (4..5).random())
            }
            4, 5 -> {
                viewChangeStar("total", 4)
                viewChangeStar("love", (3..4).random())
                viewChangeStar("money", (3..4).random())
                viewChangeStar("work", (3..4).random())
                viewChangeStar("health", (3..4).random())
            }
            6, 7 -> {
                viewChangeStar("total", 3)
                viewChangeStar("love", (2..4).random())
                viewChangeStar("money", (2..4).random())
                viewChangeStar("work", (2..4).random())
                viewChangeStar("health", (2..4).random())
            }
            8, 9 -> {
                viewChangeStar("total", 3)
                viewChangeStar("love", (2..3).random())
                viewChangeStar("money", (2..3).random())
                viewChangeStar("work", (2..3).random())
                viewChangeStar("health", (2..3).random())
            }
            10 -> {
                viewChangeStar("total", (2..3).random())
                viewChangeStar("love", (1..3).random())
                viewChangeStar("money", (1..3).random())
                viewChangeStar("work", (1..3).random())
                viewChangeStar("health", (1..3).random())
            }
            11 -> {
                viewChangeStar("total", (1..2).random())
                viewChangeStar("love", (1..2).random())
                viewChangeStar("money", (1..2).random())
                viewChangeStar("work", (1..2).random())
                viewChangeStar("health", (1..2).random())
            }
            12 -> {
                viewChangeStar("total", (1..2).random())
                viewChangeStar("love", 1)
                viewChangeStar("money", 1)
                viewChangeStar("work", 1)
                viewChangeStar("health", 1)
            }
        }
    }

    private fun viewChangeStar(type: String, num: Int) {
        for (i in 1..num) {
            val idString = type + "_star_" + i.toString()
            val viewId = resources.getIdentifier(idString, "id", packageName)
            findViewById<ImageView>(viewId).visibility = View.VISIBLE
        }
    }
}
