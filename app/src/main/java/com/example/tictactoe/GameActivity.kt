package com.example.tictactoe

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.api.data.Game
import com.example.tictactoe.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding:ActivityGameBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)

        var oldTurn: MutableList<MutableList<Int>>
        oldTurn = GameManger.currentGame.state

        setContentView(binding.root)

        binding.user1.text = GameManger.currentGame.players[0]
        binding.gameIdDisplay.text = "GameID:".plus(GameManger.gameId)

        GameUpdater.instance.onGame = {

            if(GameManger.currentGame.players.size > 1){
                binding.user2.text = GameManger.currentGame.players[1]
            }
            if (GameManger.gameUp) {
                if (GameManger.playerNr == 1) {
                    moveChecker()
                    enemyTurn(oldTurn)
                    gameOver()
                } else if (GameManger.playerNr == 2) {
                    moveChecker()
                    if (GameManger.currentGame.state == GameManger.InitialGameState) {
                        enemyMove()
                    } else {
                        enemyTurn(oldTurn)
                        gameOver()
                    }
                }
            }
        }







        binding.x1y2.setOnClickListener {
            if (binding.x1y2.text == ""){
                GameUpdater.instance.updateGameState(0,0)
                enemyMove()
                oldTurn = GameManger.currentGame.state
                enemyTurn(oldTurn)
            }else{
                println("not possible")
            }

        }
        binding.x2y2.setOnClickListener {
            if(binding.x2y2.text == ""){
                GameUpdater.instance.updateGameState(0,1)
                enemyMove()
                oldTurn = GameManger.currentGame.state
                enemyTurn(oldTurn)
            }else{
                println("not possible")
            }

        }
        binding.x3y2.setOnClickListener {
            if(binding.x3y2.text == ""){
                GameUpdater.instance.updateGameState(0,2)
                enemyMove()
                oldTurn = GameManger.currentGame.state
                enemyTurn(oldTurn)
            }else{
                println("not possible")
            }

        }
        binding.x1y1.setOnClickListener {
            if(binding.x1y1.text == ""){
                GameUpdater.instance.updateGameState(1,0)
                enemyMove()
                oldTurn = GameManger.currentGame.state
                enemyTurn(oldTurn)
            }else{
                println("not possible")
            }


        }
        binding.x2y1.setOnClickListener {
            if(binding.x2y1.text == ""){
                GameUpdater.instance.updateGameState(1,1)
                enemyMove()
                oldTurn = GameManger.currentGame.state
                enemyTurn(oldTurn)
            }else{
                println("not possible")
            }

        }
        binding.x3y1.setOnClickListener {
            if(binding.x3y1.text == ""){
                GameUpdater.instance.updateGameState(1,2)
                enemyMove()
                oldTurn = GameManger.currentGame.state
                enemyTurn(oldTurn)
            }else{
                println("not possible")
            }

        }
        binding.x1y0.setOnClickListener {
            if(binding.x1y0.text == ""){
                GameUpdater.instance.updateGameState(2,0)
                enemyMove()
                oldTurn = GameManger.currentGame.state
                enemyTurn(oldTurn)
            }else{
                println("not possible")
            }

        }
        binding.x2y0.setOnClickListener {
            if(binding.x2y0.text == ""){
                GameUpdater.instance.updateGameState(2,1)
                enemyMove()
                oldTurn = GameManger.currentGame.state
                enemyTurn(oldTurn)
            }else{
                println("not possible")
            }

        }
        binding.x3y0.setOnClickListener {
            if(binding.x3y0.text == ""){
                GameUpdater.instance.updateGameState(2,2)
                enemyMove()
                oldTurn = GameManger.currentGame.state
                enemyTurn(oldTurn)
            }else{
                println("not possible")
            }

        }


        }

    fun moveChecker(){
        if(GameManger.currentGame.state[0][0] == 1){
            binding.x1y2.setText("X")
        }else if(GameManger.currentGame.state[0][0] == 2){
            binding.x1y2.setText("O")
        }else{
            binding.x1y2.setText("")
        }
        if(GameManger.currentGame.state[0][1] == 1){
            binding.x2y2.setText("X")
        }else if(GameManger.currentGame.state[0][1] == 2){
            binding.x2y2.setText("O")
        }else{
            binding.x2y2.setText("")
        }
        if(GameManger.currentGame.state[0][2] == 1){
            binding.x3y2.setText("X")
        }else if(GameManger.currentGame.state[0][2] == 2){
            binding.x3y2.setText("O")
        }else{
            binding.x3y2.setText("")
        }
        if(GameManger.currentGame.state[1][0] == 1){
            binding.x1y1.setText("X")
        }else if(GameManger.currentGame.state[1][0] == 2){
            binding.x1y1.setText("O")
        }else{
            binding.x1y1.setText("")
        }
        if(GameManger.currentGame.state[1][1] == 1){
            binding.x2y1.setText("X")
        }else if(GameManger.currentGame.state[1][1] == 2){
            binding.x2y1.setText("O")
        }else{
            binding.x2y1.setText("")
        }
        if(GameManger.currentGame.state[1][2] == 1){
            binding.x3y1.setText("X")
        }else if(GameManger.currentGame.state[1][2] == 2){
            binding.x3y1.setText("O")
        }else{
            binding.x3y1.setText("")
        }
        if(GameManger.currentGame.state[2][0] == 1){
            binding.x1y0.setText("X")
        }else if(GameManger.currentGame.state[2][0] == 2){
            binding.x1y0.setText("O")
        }else{
            binding.x1y0.setText("")
        }
        if(GameManger.currentGame.state[2][1] == 1){
            binding.x2y0.setText("X")
        }else if(GameManger.currentGame.state[2][1] == 2){
            binding.x2y0.setText("O")
        }else{
            binding.x2y0.setText("")
        }
        if(GameManger.currentGame.state[2][2] == 1){
            binding.x3y0.setText("X")
        }else if(GameManger.currentGame.state[2][2] == 2){
            binding.x3y0.setText("O")
        }else{
            binding.x3y0.setText("")
        }


    }
    fun enemyMove(){
        binding.x1y2.isClickable = false
        binding.x2y2.isClickable = false
        binding.x3y2.isClickable = false
        binding.x1y1.isClickable = false
        binding.x2y1.isClickable = false
        binding.x3y1.isClickable = false
        binding.x1y0.isClickable = false
        binding.x2y0.isClickable = false
        binding.x3y0.isClickable = false
    }
    fun yourMove(){
        binding.x1y2.isClickable = true
        binding.x2y2.isClickable = true
        binding.x3y2.isClickable = true
        binding.x1y1.isClickable = true
        binding.x2y1.isClickable = true
        binding.x3y1.isClickable = true
        binding.x1y0.isClickable = true
        binding.x2y0.isClickable = true
        binding.x3y0.isClickable = true
    }
    fun enemyTurn(oldTurn: MutableList<MutableList<Int>>){
        if (oldTurn == GameManger.currentGame.state){
            //wait
        }else{
            yourMove()
        }
    }
    fun gameOver(){
        val x = listOf(1,2)
        for (i in x) {
            if (GameManger.currentGame.state[0][0] == i && GameManger.currentGame.state[0][1] == i && GameManger.currentGame.state[0][2] == i) {
                if (GameManger.playerNr != i){
                    Toast.makeText(this, "Du tapte", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }else{
                    Toast.makeText(this, "Du vant", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }
            }
            else if(GameManger.currentGame.state[1][0] == i && GameManger.currentGame.state[1][1] == i && GameManger.currentGame.state[1][2] == i){
                if (GameManger.playerNr != i){
                    Toast.makeText(this, "Du tapte", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }else{
                    Toast.makeText(this, "Du vant", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }
            }
            else if(GameManger.currentGame.state[2][0] == i && GameManger.currentGame.state[2][1] == i && GameManger.currentGame.state[2][2] == i){
                if (GameManger.playerNr != i){
                    Toast.makeText(this, "Du tapte", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }else{
                    Toast.makeText(this, "Du vant", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }
            }
            else if(GameManger.currentGame.state[0][0] == i && GameManger.currentGame.state[1][0] == i && GameManger.currentGame.state[2][0] == i){
                if (GameManger.playerNr != i){
                    Toast.makeText(this, "Du tapte", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }else{
                    Toast.makeText(this, "Du vant", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }
            }
            else if(GameManger.currentGame.state[0][1] == i && GameManger.currentGame.state[1][1] == i && GameManger.currentGame.state[2][1] == i){
                if (GameManger.playerNr != i){
                    Toast.makeText(this, "Du tapte", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }else{
                    Toast.makeText(this, "Du vant", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }
            }
            else if(GameManger.currentGame.state[0][2] == i && GameManger.currentGame.state[1][2] == i && GameManger.currentGame.state[2][2] == i){
                if (GameManger.playerNr != i){
                    Toast.makeText(this, "Du tapte", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }else{
                    Toast.makeText(this, "Du vant", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }
            }
            else if(GameManger.currentGame.state[0][0] == i && GameManger.currentGame.state[1][1] == i && GameManger.currentGame.state[2][2] == i){
                if (GameManger.playerNr != i){
                    Toast.makeText(this, "Du tapte", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }else{
                    Toast.makeText(this, "Du vant", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }
            }
            else if(GameManger.currentGame.state[0][2] == i && GameManger.currentGame.state[1][1] == i && GameManger.currentGame.state[2][0] == i){
                if (GameManger.playerNr != i){
                    Toast.makeText(this, "Du tapte", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }else{
                    Toast.makeText(this, "Du vant", Toast.LENGTH_SHORT).show()
                    GameManger.gameUp = false
                    enemyMove()
                }
            }
        }
        if(GameManger.currentGame.state[0][0] != 0 && GameManger.currentGame.state[0][1] != 0 && GameManger.currentGame.state[0][2] != 0 &&
            GameManger.currentGame.state[1][0] != 0 && GameManger.currentGame.state[1][1] != 0 && GameManger.currentGame.state[1][2] != 0 &&
            GameManger.currentGame.state[2][0] != 0 && GameManger.currentGame.state[2][1] != 0 && GameManger.currentGame.state[2][2] != 0 &&
                GameManger.gameUp){
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
            GameManger.gameUp = false
            enemyMove()
        }
    }
}