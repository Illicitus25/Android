package com.example.kotlinbasics

fun main(){
    println(add(4,5))
//    println("Enter the portion of coffee:")
//    val coffeeCount= readln().toInt()
//    println("Enter the portion of sugar:")
//    val sugarCount=readln().toInt()
//    println("Enter your name")
//    val name=readln()
//    makeCoffee(coffeeCount,sugarCount,name)
}
fun makeCoffee(coffeeCount:Int,sugarCount:Int,name:String) {
    if(coffeeCount==0){
        println("There is no coffee without coffee lad!")
    }
    else if(sugarCount==0){
        println("Making Coffee with $coffeeCount spoon of coffee and no sugar for $name")
    }
    else if (coffeeCount == 1 && sugarCount == 1) {
        println("Making Coffee with $coffeeCount spoon of coffee and $sugarCount spoon of sugar for $name")
    } else if (coffeeCount == 1 && sugarCount != 1) {
        println("Making Coffee with $coffeeCount spoon of coffee and $sugarCount spoons of sugar for $name")
    } else if (coffeeCount != 1 && sugarCount == 1) {
        println("Making Coffee with $coffeeCount portions of coffee and $sugarCount portion of sugar for $name")
    } else {
        println("Making Coffee with $coffeeCount portions of coffee and $sugarCount portions of sugar for $name")
    }
}
fun add(num1:Int,num2:Int):Int{
    return num1+num2;
}