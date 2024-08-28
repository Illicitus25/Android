fun main(){
    // Shift Operator
    var n=5
    println(n.shr(1))
    println(n.shl(1))
    // Logical And
    var x=true
    var y=true
    if( x && y){
        println("true")
    }
    // Bitwise And
    val number1 = 12
    val number2 = 25
    val result: Int
    result = number1 and number2
    println(result)
    // Elvis Bhai
    var str: String?=null
    var str2: String?="May be declare nullabe string"
    var len1: Int= str?.length?:-1
    var len2: Int= str2?.length?:-1
    println("Length of str is ${len1}")
    println("length of str2 is ${len2}")
    // Switch Case
    var choice=2
    val r=when(choice){
        1->"hello"
        2->"hi"
        3->"vanakkam"
        4->"Namaste"
        else-> "No need"
    }
    println(r)
    //for Loop
    for(i in 1..5){
        print("$i ")
    }
    println()
    for(i in 6 until 10){
        print("$i ")
    }
    println()
    for (i in 0 ..10 step 2){
        print("$i ")
    }
    println()
    //While
    while(n<10){
        print("$n ")
        n++
    }
    println()
    //do while

    /* Homework: 1)Calculator using when
                 2)Using loop add even and odd numbers of an array
                 3)implement all operators
                 */
}