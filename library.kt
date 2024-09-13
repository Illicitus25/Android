package com.example.kotlinbasics

class Book(val title:String="Unknown",val author:String="Anonymous",val yearpublished:Int=2024) {

}
fun main(){
    val myBook=Book()
    print(myBook.title,myBook.author,myBook.yearpublished)
    val customBook=Book("Harry Potter","J.K.Rowling",2001)
    print(customBook.title,customBook.author,customBook.yearpublished)
}
fun print(title: String,author: String,yearpublished: Int){
    println("Title: ${title}\nAuthor: ${author}\nyear Published:${yearpublished}\n")
}