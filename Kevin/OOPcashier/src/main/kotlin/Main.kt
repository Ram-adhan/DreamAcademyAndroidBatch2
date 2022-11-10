
fun main(){
    MesinKasir().mainMenu()
}

fun String.kapital(): String = trim().split(" ").map{it.capitalize()}.joinToString(" ")
