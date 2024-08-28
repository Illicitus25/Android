//Default Function
fun calc(){
    println("i am calc")
}
//Parameterized Function
fun sum(a: Int,b: Int): Int{
    val c= a+b
    return c
}
//recursion
var count=0
fun recursion(){
    count++
    if(count<=5){
        println("Meow")
        recursion()
    }
}
class car{
    var make: String=""
    var model: String=""
    var year: Int=0

    fun getInfo(): String {
        return "$make $model, year $year"
    }
}
fun main(){
    calc()
    var a=readLine()!!.toInt()
    var b=readLine()!!.toInt()
    val c=sum(a,b)
    println(c)
    recursion()
    var car= car()

    println(car.getInfo())
}
/*  Homework
Find factorial of a number using recursion
 Find the sum of n numbers using recursion
 Fine out the sum of all even numbers in a given range of 1 to n using recursion and function calling
 create a class create two objects with different values of parameters
*/