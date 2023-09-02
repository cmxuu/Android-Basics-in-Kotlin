package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get Button & Click
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            /** 置底浮動式訊息
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
             */
        }

        // Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        // Create Dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Get image Obj
        val diceImage: ImageView = findViewById(R.id.imageView)                                     // ID可從activity_main.xml右方Attribute查看
        // Roll & Get image file
        val drawableRec = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update image
        diceImage.setImageResource(drawableRec)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}