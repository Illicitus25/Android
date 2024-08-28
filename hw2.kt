/* Homework: 1)Calculator using when
                2)Using loop add even and odd numbers of an array
                3)implement all operators
                */
fun main() {
    println("Enter 1 for Sum of Even Odd")
    println("Enter 2 for Calculator")
    println("Enter 3 for Operators")
    println("Enter your choice")
    val n = readLine()!!.toInt()
    when (n) {
        1 -> {
            println("Enter a number")
            val a = readLine()!!.toInt()

            println("Enter another number")
            val b = readLine()!!.toInt()

            println("+ for Addition ")
            println("- for Subtraction ")
            println("* for Multiplication ")
            println("/ for Division ")
            println("% for Modulus")
            println("Enter Choice:")
            val choice = readLine()!!.toString()

            if (choice.length > 1) {
                println("Invalid input")
            } else {
                when (choice[0]) {
                    '+' -> println(a + b)
                    '-' -> println(a - b)
                    '*' -> println(a * b)
                    '/' -> println(a / b)
                    '%' -> println(a % b)
                    else -> println("Invalid input")
                }
            }
        }
        2 ->{
            var sumeven: Int=0
            var sumodd: Int=0
            val arr: Array<Int> =arrayOf(1,2,3,4,5,6,7,8,9,10)
            for(i in 0..arr.size-1){
                if(arr[i]%2==0){
                    sumeven=sumeven+arr[i]
                }
                else if(arr[i]%2!=0){
                    sumodd=sumodd+arr[i]
                }
            }
            println(arr.contentToString())
            println("Sum of even elements in array: $sumeven")
            println("Sum of odd elements in array: $sumodd")
        }
        3 ->{
            //Arithmetic Operators
            var x=5
            var y=10
            var res: Int=0
            res= x+y
            res=x-y
            res=x*y
            res=x/y
            res=x%y
            x++
            y--

            //Assignment Operators
            x=y
            x+=y
            x-=y
            x*=y
            x/=y
            x%=y
            //Comparison Operators
            if(x==y)
                print("x==y")
            if(x!=y)
                print("x!=y")
            if(x>y)
                print("x>y")
            if(x<y)
                print("x<y")
            if(x<=y)
                print("x<=y")
            if(x>=y)
                print("x>=y")
            //Logical Operators
            if(true && true)
                print("&&")
            if(true || false)
                print("||")
            if(!true){
                print("!")
            }
            //Bitwise Operators
            print(x.shr(1))
            print(x.shl(1))
            print(x.ushr(1))
            print(x.inv())
            print(x and y)
            print(x or y)
            print(x xor y)
            //Elvis Operator
            val name: String? = "Alice"
            val displayName = name ?: "Unknown"

            println(displayName)
        }
        else -> {
            println("Invalid input")
        }
    }
}