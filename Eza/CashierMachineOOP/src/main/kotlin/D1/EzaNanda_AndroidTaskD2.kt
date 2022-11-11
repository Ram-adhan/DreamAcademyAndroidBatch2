/*
1. Function tanpa return, dengan 2 parameter Integer, lalu implementasi operator
matematika (penjumlahan, pengurangan, perkalian, pembagian, modulus) pada 2 parameter
tersebut, tiap operator akan di print hasilnya di console
 */


fun tambah (a : Int, b : Int ): Int = a + b
fun kurang (a : Int, b : Int ): Int = a - b
fun kali (a : Int, b : Int ): Int = a * b
fun bagi (a : Int, b : Int ): Int = a / b
fun modulus (a : Int, b : Int ): Int = a % b


//fun main() {
//    val hasil = tambah(20,2)
//    println("Hasil Tambah :$hasil")
//    val hasil1 = kurang(20,2)
//    println("Hasil Kurang :$hasil1")
//    val hasil2 = kali(20,2)
//    println("Hasil Kali :$hasil2")
//    val hasil3 = bagi(20,2)
//    println("Hasil Bagi :$hasil3")
//    val hasil4 = modulus(20,2)
//    println("Hasil Modulus :$hasil4")
//
//}

/*
2. Function dengan return String seperti berikut (tanpa tanda petik)
"Belajar Kotlin <K>
Dream Academy"
dengan ketentuan: Function membutuhkan 2 parameter, (Kotlin) merupakan parameter dari function,
(K) merupakan huruf pertama dari parameter (Kotlin), (Dream Academy) merupakan default parameter
 */

fun belajar(language : String , place: String = "Dream Academy"):String{
    return """Belajar $language <${language[0]}>
        |$place
    """.trimMargin()
}


fun main(){
    println(belajar("Kotlin"))
}