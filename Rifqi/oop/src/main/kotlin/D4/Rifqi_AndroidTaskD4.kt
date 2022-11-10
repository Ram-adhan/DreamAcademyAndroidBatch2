package task

import java.util.Scanner

var no : Int = 0
var end : Int = 0
var angka: Int = 0
var sum: Float = 0f

fun main() {

    sumCounting()
    arrayComparasion()

}
fun sumCounting(){

    val scn = Scanner(System.`in`)
    print("Deret angka diinput(n):  ")
    end = scn.nextInt()
    sum = 0.0f
    no = 1
    for (no in no..end step 1){
        print("Input angka ke " + no + " : ")
        angka = scn.nextInt()
        sum = sum + angka
    }
    println(" Nilai jumlah : $sum")
}

fun arrayComparasion(){

    val first = arrayOf(1, 2, 3)
    val second = arrayOf(1, 2, 4)
    val result = first.contentEquals(second)

    when (result) {
        true -> println("is equal")
        else -> {
            println("not equal")
        }
    }

}