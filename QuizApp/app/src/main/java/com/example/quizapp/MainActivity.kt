package com.example.quizapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var questionNR = 0

    private val questions = arrayOf(
        arrayOf("Wie viele Bundesländer hat Deutschland?", "10", "16", "17", "19", "16"),
        arrayOf("An welchem Datum fiel die Berliner Mauer?", "20. Novermeber 1989", "12. Juni 1989", "7. Oktober 1989", "9. November 1989", "9. November 1989"),
        arrayOf("Wie viele Stunden hat eine Woche?", "168", "120", "154", "196", "168"),
        arrayOf("Wer war der erste Präsident der USA?", "John Adams", "Benjamin Franklin", "George Washington", "Barack Obama", "George Washington"),
        arrayOf("Welcher Fluss ist der längste Fluss der Welt", "Der Nil", "Der Amazonas", "Der Rhein", "Der Mississippi", "Der Nil"),
        arrayOf("Wann fand die erste Mondlandung statt?", "1959", "1969", "1965", "1972", "1969"),
        arrayOf("Wer komponierte die Oper 'Die Zauberflöte'?", "Ludwig van Beethoven", "Johann Sebastian Bach", "Frédéric Chopin", "Wolfgang Amadeus Mozart", "Wolfgang Amadeus Mozart"),
        arrayOf("Welcher berühmte Entdecker erreichte 1492 Amerika?", "Marco Polo", "Christopher Columbus", "Vasco da Gama", "Ferdinand Magellan", "Christopher Columbus"),
        arrayOf("Wer schrieb die Erzählung 'Die Verwandlung'", "Hermann Hesse", "Thomas Mann", "Franz Kafka", "Johann Wolfgang von Goethe", "Franz Kafka"),
        arrayOf("Was für ein mythologisches Wesen ist Polyphem?", "Minotaurus", "Sirene", "Zyklop", "Hydra", "Zyklop")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val questionText: TextView = findViewById(R.id.questionText)
        val ansText1: TextView = findViewById(R.id.AnsText1)
        val ansText2: TextView = findViewById(R.id.AnsText2)
        val ansText3: TextView = findViewById(R.id.AnsText3)
        val ansText4: TextView = findViewById(R.id.AnsText4)
        val infoText: TextView = findViewById(R.id.infoText)

        setQuestion(questionText, ansText1, ansText2, ansText3, ansText4, infoText)

        findViewById<ImageButton>(R.id.btn1).setOnClickListener {
            checkAnswer(ansText1.text.toString(), infoText)
        }
        findViewById<ImageButton>(R.id.btn2).setOnClickListener {
            checkAnswer(ansText2.text.toString(), infoText)
        }
        findViewById<ImageButton>(R.id.btn3).setOnClickListener {
            checkAnswer(ansText3.text.toString(), infoText)
        }
        findViewById<ImageButton>(R.id.btn4).setOnClickListener {
            checkAnswer(ansText4.text.toString(), infoText)
        }
    }

    private fun setQuestion(questionText: TextView, ansText1: TextView, ansText2: TextView,
        ansText3: TextView, ansText4: TextView, infoText: TextView) {

        if (questionNR < questions.size) {
            val question = questions[questionNR]
            questionText.text = question[0]
            ansText1.text = question[1]
            ansText2.text = question[2]
            ansText3.text = question[3]
            ansText4.text = question[4]
            infoText.text = "Frage " + (questionNR + 1) + " / " + questions.size
        } else {
            // Quizende
        }
    }

    private fun checkAnswer(selectedAnswer: String, infoText: TextView) {
        val question = questions[questionNR]
        if (selectedAnswer == question[5]) {
            alert(true, question[5])
        } else {
            alert(false, question[5])
        }

        questionNR++
        val questionText: TextView = findViewById(R.id.questionText)
        val ansText1: TextView = findViewById(R.id.AnsText1)
        val ansText2: TextView = findViewById(R.id.AnsText2)
        val ansText3: TextView = findViewById(R.id.AnsText3)
        val ansText4: TextView = findViewById(R.id.AnsText4)
        setQuestion(questionText, ansText1, ansText2, ansText3, ansText4, infoText)
    }

    private fun alert(correct: Boolean, correctAns: String) {
        val msg = AlertDialog.Builder(this)
        if (correct) {
            msg.setTitle("Richtig!")
            msg.setMessage("Die Lösung war: " + correctAns)
        } else {
            msg.setTitle("Falsch!")
            msg.setMessage("Die Lösung war: " + correctAns)
        }
        msg.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        msg.show()
    }
}
