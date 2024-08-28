
fun greet(){
    val message: String = "Hello Kotlin"
    println(message)
}
class Person
{
    var name:String="John Doe"
    val age:Int=30
    fun displayInfo(){
        println("Name: $name, Age: $age")
    }
    fun calc(){
        val a=10
        val b=5
        println("a=$a, b=$b and sum of a and b is ${a+b}")
    }
}

fun main(){
    val person = Person()
    greet()
    person.name=" John who "
    person.displayInfo()
    person.calc()
    println("")
}
