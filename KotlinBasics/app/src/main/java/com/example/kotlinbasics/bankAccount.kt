package com.example.kotlinbasics

class bankAccount(var accountHolder:String,private var balance: Double) {
    private val transactionHistory= mutableListOf<String>()
    fun deposit(amount: Double){
        balance+=amount
        transactionHistory.add("$accountHolder debited $amount ")
    }
    fun withdraw(amount: Double){
        if(balance>=amount){
        balance-=amount
        transactionHistory.add("$accountHolder credited $amount ")}
        else{
            println("You Dont have the funds to withdraw $amount")
        }
    }
    fun displayTransactionHistory(){
        println("Transaction History for $accountHolder")
        for( i in transactionHistory.indices){
            println(transactionHistory[i])
        }
    }
    fun returnBalance(){
        println("$accountHolder has $balance")
    }
}
fun main(){
    println("Enter your name")
    val name= readln()
    println("Enter Account Balance")
    val balance:Double= readln().toDouble()
    println("")
    val obj=bankAccount(name,balance)
    println("Enter 1 to Deposit")
    println("Enter 2 to WithDraw")
    println("Enter 3 to view Transaction History")
    println("Enter 4 to view Balance")
    println("Enter 5 to exit")
    var choice= readln().toInt()
    while(choice!=5) {
        when (choice) {
            1 -> {
                println("Enter amount to be deposited")
                val depositAmount: Double = readln().toDouble()
                obj.deposit(depositAmount)
            }

            2 -> {
                println("Enter amount to be withdrawn")
                val withdrawAmount: Double = readln().toDouble()
                obj.withdraw(withdrawAmount)
            }

            3 -> {
                obj.displayTransactionHistory()
            }
            4 -> {
                obj.returnBalance()
            }

            else -> {
                println("Wrong Input")
            }
        }
        println("Enter 1 to Deposit")
        println("Enter 2 to WithDraw")
        println("Enter 3 to view Transaction History")
        println("Enter 4 to view Balance")
        println("Enter 5 to exit")
        choice= readln().toInt()
    }
}