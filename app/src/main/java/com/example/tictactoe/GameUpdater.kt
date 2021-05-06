package com.example.tictactoe

import android.os.CountDownTimer
import android.widget.Toast
import com.example.tictactoe.api.GameService
import com.example.tictactoe.api.data.Game





class GameUpdater{

    lateinit var timer:CountDownTimer
    var timeToCountDownInMs = 4000L
    val timeTicks = 1000L


    var onGame: ((Game) -> Unit)? = null

    fun updater(){
        onGame?.invoke(GameManger.currentGame)
    }

    fun pollUpdate(){
        timer = object : CountDownTimer(timeToCountDownInMs,timeTicks) {
            override fun onFinish() {
                GameManger.pollGame(GameManger.gameId.toString())
                updater()
                if(GameManger.gameUp){
                    pollUpdate()
                }

            }
            override fun onTick(millisUntilFinished: Long) {

            }
        }

        timer.start()
    }

    fun updateGameState(l: Int, i: Int){

        GameManger.currentGame.state[l].set(i, GameManger.playerNr)
        GameManger.updateGame(GameManger.gameId.toString(),GameManger.currentGame.state)

    }




    companion object {
        val instance = GameUpdater()
    }

}