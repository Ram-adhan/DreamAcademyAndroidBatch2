
var listMakan = mutableListOf("Ayam", "Wagyu", "Nasi Padang")
var listHarga = mutableListOf(30000, 500000, 50000)
var totalMakan = mutableMapOf<String, Int>()
val mesin = MesinKasir()

fun main(){
    mesin.mainMenu()
}

fun String.kapital(): String = trim().split(" ").map{it.capitalize()}.joinToString(" ")
