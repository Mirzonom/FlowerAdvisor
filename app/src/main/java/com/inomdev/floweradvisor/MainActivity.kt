package com.inomdev.floweradvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findFlowerBtn = findViewById<Button>(R.id.find_flower_btn)
        val chooseFlowerTypes = findViewById<Spinner>(R.id.choose_fl_types)
        val outputTypes = findViewById<TextView>(R.id.output_types)


        findFlowerBtn.setOnClickListener {
            val selectFlower = chooseFlowerTypes.selectedItem
            val flowersList = getFlowers(selectFlower.toString())
            val flowers = flowersList.reduce { str, item -> str + '\n' + item }
            outputTypes.text = flowers

        }


    }

    fun getFlowers(selectFlower: String): List<String> {
        return when (selectFlower) {
            "Роза" -> listOf(
                "Роза считается королевой сада.",
                "Данным прекрасным цветком восхищались и поклонялись ему с очень давних времён."
            )
            "Орхидея" -> listOf(
                "Орхидеи больше, чем просто цветы.",
                "В Индии орхидеи являются очень действенным противоядием."
            )
            "Лилия" -> listOf(
                "Лилии Загадочные утонченные цветы.",
                "Увенчанные душистым ароматом."
            )
            else -> listOf(
                "Гвоздика красивый, кружевной.",
                "Очень стойкий цветок с большим количеством расцветок."
            )
        }
    }
}