fun main(){
    val letter: Char = 'A'
    print("$letter")
    println('\n')
    println('\$')
    println('\\')
    var ch: Char;
    ch='C'
    ch=ch+2
    println(ch)
    val ch2: String
    ch2="""This is going
to be 
a multi line 
string"""
    println(ch2)
    val bool: Boolean=true
    println(bool)
    println(!bool)
val numbers= arrayOf(1,2,3,4,5)
    println(numbers[0])
    println("$numbers[1]")
    println(numbers.contentToString())
    for(i in numbers){
        println(i)
    }
    val arr: Array<String> = arrayOf("cpp","java","python")
    println(arr[0])
    println(arr.contentToString())
    println(arr.size)
    for(i in arr){
        println(i)
    }
    println(arr.isEmpty())
    println(arr.first())
    println(arr.last())
    println(arr.indexOf("java"))
    val arr1=arrayOf(1,2,2,3,3,3,4,4,5)
    println(arr1.lastIndexOf(4))
    //Homework : Find array functions
    //2D Matrix
    val matrix: Array<Array<Int>> = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))
    for(i in matrix){
        println(i.contentToString())
    }
}