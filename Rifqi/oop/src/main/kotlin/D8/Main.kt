package D8

import java.util.*
import MesinKasir
fun main(){
    MesinKasir().mainRslt()

}

fun String.kapitalis(): String {
    return split(" ")
        .map {
            val first = it[0].uppercase()
            first + it.substring(1)
        }
        .joinToString(" ")
}