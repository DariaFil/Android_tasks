package main.kotlin

fun main() {
    var id: Any? by StorageDelegate()
    id = 20
    println(id!!)

    id = 3.14
    println(id!!)

    id = "Hello Kotlin!"
    println(id!!)
}