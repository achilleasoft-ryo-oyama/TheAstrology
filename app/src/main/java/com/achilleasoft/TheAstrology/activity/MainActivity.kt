package com.achilleasoft.TheAstrology.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.achilleasoft.TheAstrology.R
import com.airbnb.lottie.LottieAnimationView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constellations = arrayOf(
                "おひつじ座", "おうし座", "ふたご座", "かに座", "しし座", "おとめ座",
                "てんびん座", "さそり座", "いて座", "やぎ座", "みずがめ座", "うお座")
        val constellationNumberPicker = findViewById<NumberPicker>(R.id.constellation_picker)
        constellationNumberPicker.displayedValues = null
        constellationNumberPicker.minValue = 0
        constellationNumberPicker.maxValue = 11
        constellationNumberPicker.value = 0
        constellationNumberPicker.displayedValues = constellations
        constellationNumberPicker.descendantFocusability = ViewGroup.FOCUS_BLOCK_DESCENDANTS

        val buttonAnimation = findViewById<LottieAnimationView>(R.id.constellation_choose_button)
        val divineButton = findViewById<LottieAnimationView>(R.id.divine_button)

        buttonAnimation.setOnClickListener{
            findViewById<TextView>(R.id.constellation_text).text = "あなたの星座は" + constellations[constellationNumberPicker.value] + "でよろしいでしょうか？"

            buttonAnimation.setAnimation(R.raw.button1push)
            buttonAnimation.setProgress(0f)
            buttonAnimation.playAnimation()

            val animation = findViewById<LottieAnimationView>(R.id.constellation_animation)
            animation.visibility = View.VISIBLE
            when (constellations[constellationNumberPicker.value]) {
                "おひつじ座" -> animation.setAnimation(R.raw.image1)
                "おうし座" -> animation.setAnimation(R.raw.image2)
                "ふたご座" -> animation.setAnimation(R.raw.image3)
                "かに座" -> animation.setAnimation(R.raw.image4)
                "しし座" -> animation.setAnimation(R.raw.image5)
                "おとめ座" -> animation.setAnimation(R.raw.image6)
                "てんびん座" -> animation.setAnimation(R.raw.image7)
                "さそり座" -> animation.setAnimation(R.raw.image8)
                "いて座" -> animation.setAnimation(R.raw.image9)
                "やぎ座" -> animation.setAnimation(R.raw.image10)
                "みずがめ座" -> animation.setAnimation(R.raw.image11)
                "うお座" -> animation.setAnimation(R.raw.image12)
                else -> null
            }
            animation.setProgress(0f)
            animation.playAnimation()

            if (divineButton.visibility == View.INVISIBLE) {
                divineButton.visibility = View.VISIBLE
                divineButton.setProgress(0f)
                divineButton.playAnimation()
            }
        }

        divineButton.setOnClickListener{
            if (findViewById<TextView>(R.id.constellation_text).text != getText(R.string.constellation_text)) {
                val intent = Intent(applicationContext, ResultActivity::class.java)
                intent.putExtra("constellation", constellations[constellationNumberPicker.value])
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            } else {
                val toast = Toast.makeText(applicationContext, getText(R.string.constellation_toast_message), Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }
    }
}
