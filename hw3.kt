/*  Homework
Find factorial of a number using recursion
 Find the sum of n numbers using recursion
 Fine out the sum of all even numbers in a given range of 1 to n using recursion and function calling
 create a class create two objects with different values of parameters
*/
fun fact(a: Int): Int{
    if(a == 1)
        return 1
    return a*fact(a-1)
}
fun sum(a: Int): Int{
    if(a == 1)
        return 1
    return a+sum(a-1)
}
fun sumEven(a: Int): Int{
    if(a<2){
        return 0
    }
    if(a%2==0){
        return a+sumEven(a-2)
    }
    return sumEven(a-1)
}
fun main(){
    println("Enter 1 for factorial")
    println("Enter 2 for Sum of numbers")
    println("Enter 3 for Sum in range")
    println("Enter Choice")
    var choice= readLine()!!.toInt()
    when(choice){
        1->{
            println("Enter a number ")
            var n= readLine()!!.toInt()
            println("Factorial of $n is ${fact(n)}")
        }
        2->{
            println("Enter a number ")
            var n= readLine()!!.toInt()
            println("Sum of $n is ${sum(n)}")
        }
        3->{
            println("Enter a number ")
            var n= readLine()!!.toInt()
            println("Sum of even numbers from 1 to $n is ${sumEven(n)}")
        }
        else->{
            println("Invalid input")
        }
    }
}
