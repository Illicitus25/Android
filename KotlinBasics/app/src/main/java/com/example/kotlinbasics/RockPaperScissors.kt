package com.example.kotlinbasics

fun main(){
    println("How many rounds do you want to play?")
    val n=readln().toInt()
    var playerWin=0
    var computerWin=0
    for(i in 1..n) {
        println("Round $i:")
        println("Rock, Paper or Scissors? Enter your Choice")
        var player = readln()
        while(player!="Rock"&&player!="Paper"&&player!="Scissors"){
            println("Please enter a valid choice!")
            player= readln()
        }
        var computer = ""
        val randomNumber = (1..3).random()
        if (randomNumber == 1) {
            computer = "Rock"
        } else if (randomNumber == 2) {
            computer = "Paper"
        } else {
            computer = "Scissors"
        }
        val winner = when {
            player == "Rock" && computer == "Paper" -> "Computer Wins"
            player == "Rock" && computer == "Scissors" -> "Player Wins"
            player == "Paper" && computer == "Rock" -> "Player Wins"
            player == "Paper" && computer == "Scissors" -> "Computer Wins"
            player == "Scissors" && computer == "Rock" -> "Computer Wins"
            player == "Scissors" && computer == "Paper" -> "Player Wins"
            else -> "Tie"
        }
        println(computer)
        println(winner)
        if(winner=="Computer Wins"){
            computerWin++
        }
        else if(winner=="Player Wins") {
            playerWin++
        }
        println()
    }
    println("\nPlayer Score: $playerWin\nComputer Score: $computerWin")
    if(playerWin==computerWin){
        println("Tie")
    }
    else if(playerWin>computerWin){
        println("Player Wins!!!")
    }
    else{
        println("Computer Wins!!!")
    }
}