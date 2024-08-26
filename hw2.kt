fun main(){
    println("Enter a number")
    val a=readLine()!!.toInt()
    println("Enter another number")
    val b=readLine()!!.toInt()
    println("+ for Addition ")
    println("- for Subtraction ")
    println("* for Multiplication ")
    println("/ for Division ")
    println("% for Modulus")
    println("Enter Choice:")
    val choice = readLine()!!.toString()
    if( choice.length>1){
        println("Invalid input")
    }
    else{
        when(choice[0]){
            '+'-> println(a+b)
            '-'-> println(a-b)
            '*'-> println(a*b)
            '/'-> println(a/b)
            '%'-> println(a%b)
            else -> println("Invalid input")
        }
    }


}