package com.example.tictactoe

import com.example.tictactoe.api.GameService
import com.example.tictactoe.api.data.Game
import com.example.tictactoe.api.data.GameState

object GameManger{

    var player:String? = null
    var state:GameState? = null
    var gameId:String? = null

    val InitialGameState:GameState = listOf(listOf(0,0,0),listOf(0,0,0),listOf(0,0,0))

    fun createGame(player:String){

        GameService.createGame(player,InitialGameState) { game: Game?, err: Int? ->
            if(err != null){
                println(err)
            }else{
                if (game != null) {
                    println("${player} har joinet ${game.gameId}")
                }
            }
        }
    }
    fun joinGame(player: String, gameId: String){
        GameService.joinGame(player, gameId){ game: Game?, err: Int? ->
            if(err != null){
                println(err)
            }else{
                if (game!= null){
                    println("du joinet ${game.gameId}")
                }
            }
        }
    }
    fun updateGame(gameId: String, gameState: GameState){
        GameService.updateGame(gameId, gameState){ game: Game?, err: Int? ->
            if(err != null){
                println(err)
            }else{
                if (game!= null){
                    println("du updatet ${game.gameId}")
                }
            }
        }
    }
    fun pollGame(gameId: String){
        GameService.pollGame(gameId){ game: Game?, err: Int? ->
            if(err != null){
                println(err)
            }else{
                if (game!= null){
                    println("du pollet ${game.gameId}")
                }
            }
        }
    }
}