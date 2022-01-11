package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var b11 : Button
    private lateinit var b12 : Button
    private lateinit var b13 : Button
    private lateinit var b21 : Button
    private lateinit var b22 : Button
    private lateinit var b23 : Button
    private lateinit var b31 : Button
    private lateinit var b32 : Button
    private lateinit var b33 : Button
    private lateinit var b4 : Button
    private lateinit var b41 : Button
    var buttonNumber = 0
    private var winnerPlayer = 0
    private var p1Points = 0
    private var p2Points = 0
    private lateinit var p1 : TextView
    private lateinit var p2 : TextView
    private var activePlayer = 1
    private var firstPlayer = arrayListOf<Int>()
    private var secondPlayer = arrayListOf<Int>()
    private lateinit var tu :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        p1 = findViewById(R.id.p1)
        p2 = findViewById(R.id.p2)
        tu = findViewById(R.id.tu)
        b11 = findViewById(R.id.b11)
        b11.setOnClickListener(this)
        b12 = findViewById(R.id.b12)
        b12.setOnClickListener(this)
        b13 = findViewById(R.id.b13)
        b13.setOnClickListener(this)
        b21 = findViewById(R.id.b21)
        b21.setOnClickListener(this)
        b22 = findViewById(R.id.b22)
        b22.setOnClickListener(this)
        b23 = findViewById(R.id.b23)
        b23.setOnClickListener(this)
        b31 = findViewById(R.id.b31)
        b31.setOnClickListener(this)
        b32 = findViewById(R.id.b32)
        b32.setOnClickListener(this)
        b33 = findViewById(R.id.b33)
        b33.setOnClickListener(this)
        b4 = findViewById(R.id.b4)
        b4.setOnClickListener {
            b11.text = ""
            b12.text = ""
            b13.text = ""
            b21.text = ""
            b22.text = ""
            b23.text = ""
            b31.text = ""
            b32.text = ""
            b33.text = ""
            firstPlayer.clear()
            secondPlayer.clear()
            b11.setBackgroundColor(Color.parseColor("#FF5722"))
            b12.setBackgroundColor(Color.parseColor("#FF5722"))
            b13.setBackgroundColor(Color.parseColor("#FF5722"))
            b21.setBackgroundColor(Color.parseColor("#FF5722"))
            b22.setBackgroundColor(Color.parseColor("#FF5722"))
            b23.setBackgroundColor(Color.parseColor("#FF5722"))
            b31.setBackgroundColor(Color.parseColor("#FF5722"))
            b32.setBackgroundColor(Color.parseColor("#FF5722"))
            b33.setBackgroundColor(Color.parseColor("#FF5722"))
            b11.isEnabled = true
            b12.isEnabled = true
            b13.isEnabled = true
            b21.isEnabled = true
            b22.isEnabled = true
            b23.isEnabled = true
            b31.isEnabled = true
            b32.isEnabled = true
            b33.isEnabled = true
            //activePlayer = 1  X always starts first
            winnerPlayer = 0

        }
        b41 = findViewById(R.id.b41)
        b41.setOnClickListener {
            b11.text = ""
            b12.text = ""
            b13.text = ""
            b21.text = ""
            b22.text = ""
            b23.text = ""
            b31.text = ""
            b32.text = ""
            b33.text = ""
            firstPlayer.clear()
            secondPlayer.clear()
            b11.setBackgroundColor(Color.parseColor("#FF5722"))
            b12.setBackgroundColor(Color.parseColor("#FF5722"))
            b13.setBackgroundColor(Color.parseColor("#FF5722"))
            b21.setBackgroundColor(Color.parseColor("#FF5722"))
            b22.setBackgroundColor(Color.parseColor("#FF5722"))
            b23.setBackgroundColor(Color.parseColor("#FF5722"))
            b31.setBackgroundColor(Color.parseColor("#FF5722"))
            b32.setBackgroundColor(Color.parseColor("#FF5722"))
            b33.setBackgroundColor(Color.parseColor("#FF5722"))
            b11.isEnabled = true
            b12.isEnabled = true
            b13.isEnabled = true
            b21.isEnabled = true
            b22.isEnabled = true
            b23.isEnabled = true
            b31.isEnabled = true
            b32.isEnabled = true
            b33.isEnabled = true
            //activePlayer = 1  X always starts first
            winnerPlayer = 0
            p1Points = 0
            p2Points = 0
            p1.text = "Player X: 0"
            p2.text = "Player O: 0"



        }





    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button){

            when(clickedView.id){
                R.id.b11 -> buttonNumber = 1
                R.id.b12 -> buttonNumber = 2
                R.id.b13 -> buttonNumber = 3
                R.id.b21 -> buttonNumber = 4
                R.id.b22 -> buttonNumber = 5
                R.id.b23 -> buttonNumber = 6
                R.id.b31 -> buttonNumber = 7
                R.id.b32 -> buttonNumber = 8
                R.id.b33 -> buttonNumber = 9
            }
            if(buttonNumber !=0){
                playGame(clickedView, buttonNumber)
            }
        }
    }
    private fun playGame(clickedView: Button, buttonNumber: Int){
        if (activePlayer == 1){
            clickedView.text ="x"
            clickedView.setBackgroundColor(Color.CYAN)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedView.text ="o"
            clickedView.setBackgroundColor(Color.GRAY)
            secondPlayer.add(buttonNumber)
            activePlayer = 1
        }
        clickedView.isEnabled = false
        if (activePlayer == 1){
            tu.text = "Turn: X"
        }else
            tu.text = "Turn: O"

        check()

    }
    private fun check() {


        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
            Toast.makeText(applicationContext, "Player X won", Toast.LENGTH_SHORT).show()
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
            Toast.makeText(applicationContext, "Player O won", Toast.LENGTH_SHORT).show()

        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
            Toast.makeText(applicationContext, "Player X won", Toast.LENGTH_SHORT).show()

        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
            Toast.makeText(applicationContext, "Player O won", Toast.LENGTH_SHORT).show()
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
            Toast.makeText(applicationContext, "Player X won", Toast.LENGTH_SHORT).show()

        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
            Toast.makeText(applicationContext, "Player O won", Toast.LENGTH_SHORT).show()
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
            Toast.makeText(applicationContext, "Player X won", Toast.LENGTH_SHORT).show()

        }
        if (firstPlayer.contains(8) && firstPlayer.contains(5) && firstPlayer.contains(2)) {
            winnerPlayer = 1
            Toast.makeText(applicationContext, "Player X won", Toast.LENGTH_SHORT).show()

        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
            Toast.makeText(applicationContext, "Player X won", Toast.LENGTH_SHORT).show()

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
            Toast.makeText(applicationContext, "Player O won", Toast.LENGTH_SHORT).show()
        }
        if (secondPlayer.contains(8) && secondPlayer.contains(5) && secondPlayer.contains(2)) {
            winnerPlayer = 2
            Toast.makeText(applicationContext, "Player O won", Toast.LENGTH_SHORT).show()
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
            Toast.makeText(applicationContext, "Player O won", Toast.LENGTH_SHORT).show()
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
            Toast.makeText(applicationContext, "Player O won", Toast.LENGTH_SHORT).show()
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
            Toast.makeText(applicationContext, "Player O won", Toast.LENGTH_SHORT).show()
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
            Toast.makeText(applicationContext, "Player O won", Toast.LENGTH_SHORT).show()
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
            Toast.makeText(applicationContext, "Player X won", Toast.LENGTH_SHORT).show()

        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
            Toast.makeText(applicationContext, "Player X won", Toast.LENGTH_SHORT).show()

        }
        if (firstPlayer.count() == 5 && winnerPlayer == 0 && secondPlayer.count() == 4) {
            Toast.makeText(applicationContext, "Draw", Toast.LENGTH_SHORT).show()
        }
        if (firstPlayer.count() == 4 && winnerPlayer == 0 && secondPlayer.count() == 5) {
            Toast.makeText(applicationContext, "Draw", Toast.LENGTH_SHORT).show()
        }
        if (winnerPlayer == 1 || winnerPlayer == 2) {
            b11.isEnabled = false
            b12.isEnabled = false
            b13.isEnabled = false
            b21.isEnabled = false
            b22.isEnabled = false
            b23.isEnabled = false
            b31.isEnabled = false
            b32.isEnabled = false
            b33.isEnabled = false


        }

        if (winnerPlayer == 1) {
            p1Points += 1
            val point1 = p1Points.toString()
            p1.text = "Player X: $point1"

        }
        if (winnerPlayer == 2) {
            p2Points += 1
            val point2 = p2Points.toString()
            p2.text = "Player O: $point2"
        }
    }
    }