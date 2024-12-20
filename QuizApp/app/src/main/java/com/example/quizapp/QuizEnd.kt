package com.example.quizapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizEnd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_end)

        val resultText: TextView = findViewById(R.id.result)
        val emojiText: TextView = findViewById(R.id.emoji)

        val correctAns = intent.getIntExtra("correctAns", 0)
        val ansAnz = intent.getIntExtra("ansAnz", 0)

        resultText.text = "Du hast " + correctAns + " von " + ansAnz + " Fragen richtig beantwortet."

        val emoji = when (correctAns) {
            ansAnz -> "🏆"
            in 8..9 -> "🥳"
            in 6..7 -> "😊"
            in 4..5 -> "😐"
            in 1..3 -> "😥"
            else -> "\uD83E\uDECF"
        }
        emojiText.text = emoji
    }
}
