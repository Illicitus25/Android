fun main(){
    println("Enter Total Cost")
    val cost= readLine()!!.toInt()
    println("Membership? true: false")
    val membership= readLine()!!.toBoolean()
    var discount:Double=0.0
    if(membership) {
        if (cost > 8000) {
            discount = 0.20
        } else if (cost > 6000) {
            discount = 0.15
        } else if (cost > 4000) {
            discount = 0.10
        } else if (cost > 2000) {
            discount = 0.05
        } else {
            discount = 0.0
        }
    }
    else{
        if(cost>2000) {
            discount = 0.05
        }
    }
    val finalCost=cost-(discount*cost)
    println("Cost: $cost")
    println("Discount: "+(discount*100)+"%")
    println("Discount Amount: "+(discount*cost))
    println("Price after discount: $finalCost")
}