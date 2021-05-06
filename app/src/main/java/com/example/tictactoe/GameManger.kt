package com.example.tictactoe

import com.example.tictactoe.api.GameService
import com.example.tictactoe.api.data.Game
import com.example.tictactoe.api.data.GameState

object GameManger{
    lateinit var currentGame: Game
    var player:String? = null
    var playerNr:Int = 0
    var state:GameState? = null
    var gameId:String? = null
    var gameUp:Boolean = false


    val InitialGameState:GameState = mutableListOf(mutableListOf(0,0,0),mutableListOf(0,0,0),mutableListOf(0,0,0))

    fun createGame(player:String){

        GameService.createGame(player,InitialGameState) { game: Game?, err: Int? ->
            if(err != null){
                println(err)
            }else{
                if (game != null) {
                    println("${player} har joinet ${game.gameId}")
                    currentGame = game
                    gameId = game.gameId
                    GameUpdater.instance.pollUpdate()
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
                    currentGame = game
                    GameUpdater.instance.pollUpdate()
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
                    GameUpdater.instance.pollUpdate()

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
                    currentGame = game
                }
            }
        }
    }
}