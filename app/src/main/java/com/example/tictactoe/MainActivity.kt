package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.Settings
import android.widget.Toast
import com.example.tictactoe.api.GameService
import com.example.tictactoe.api.data.Game
import com.example.tictactoe.databinding.ActivityMainBinding
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val TAG:String = "MainActivity"



    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uniqID = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        lateinit var timer:CountDownTimer
        var timeToCountDownInMs = 6000L
        val timeTicks = 1000L


        binding.startGameButton.setOnClickListener {
            GameManger.player = binding.playerName.text.toString()
            if (GameManger.player!!.isEmpty()){
                Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show()
            }else{
                GameManger.createGame(GameManger.player.toString())
                GameManger.playerNr = 1
                GameManger.gameUp = true
                val intent = Intent(this,GameActivity::class.java)
                timer = object : CountDownTimer(timeToCountDownInMs,timeTicks) {
                    override fun onFinish() {
                        startActivity(intent)
                    }
                    override fun onTick(millisUntilFinished: Long) {

                    }
                }

                timer.start()

            }
        }
        binding.joinGameButton.setOnClickListener {
            GameManger.player = binding.playerName.text.toString()
            GameManger.gameId = binding.gameId.text.toString()
            if (GameManger.player!!.isEmpty() && GameManger.gameId!!.isEmpty()){
                Toast.makeText(this, "Enter Name and GameId", Toast.LENGTH_SHORT).show()
            }else if (GameManger.player!!.isNotEmpty() && GameManger.gameId!!.isEmpty()){
                Toast.makeText(this, "Enter GameId", Toast.LENGTH_SHORT).show()
            }else if (GameManger.player!!.isEmpty() && GameManger.gameId!!.isNotEmpty()){
                Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show()
            }else{
                GameManger.joinGame(GameManger.player.toString(), GameManger.gameId.toString())
                GameManger.playerNr = 2
                GameManger.gameUp = true
                val intent = Intent(this,GameActivity::class.java)
                timer = object : CountDownTimer(timeToCountDownInMs,timeTicks) {
                    override fun onFinish() {
                        startActivity(intent)
                    }
                    override fun onTick(millisUntilFinished: Long) {

                    }
                }
                timer.start()

            }
        }

    }
}