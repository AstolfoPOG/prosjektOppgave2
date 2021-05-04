package com.example.tictactoe

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.api.data.Game
import com.example.tictactoe.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding:ActivityGameBinding

    //lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)

        setContentView(binding.root)


        GameUpdater.instance.onGame = {

            println(GameManger.currentGame.state)
            if(GameManger.currentGame.players.size > 1){
                binding.user2.text = GameManger.currentGame.players[1]
            }
            moveChecker()
        }



        binding.user1.text = GameManger.currentGame.players[0]



        binding.x1y2.setOnClickListener {
            GameUpdater.instance.updateGameState(0,0)
        }
        binding.x2y2.setOnClickListener {
            GameUpdater.instance.updateGameState(0,1)
        }
        binding.x3y2.setOnClickListener {
            GameUpdater.instance.updateGameState(0,2)
        }
        binding.x1y1.setOnClickListener {
            GameUpdater.instance.updateGameState(1,0)
        }
        binding.x2y1.setOnClickListener {
            GameUpdater.instance.updateGameState(1,1)
        }
        binding.x3y1.setOnClickListener {
            GameUpdater.instance.updateGameState(1,2)
        }
        binding.x1y0.setOnClickListener {
            GameUpdater.instance.updateGameState(2,0)
        }
        binding.x2y0.setOnClickListener {
            GameUpdater.instance.updateGameState(2,1)
        }
        binding.x3y0.setOnClickListener {
            GameUpdater.instance.updateGameState(2,2)
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
}