fun main() {
    var run = MesinKasir()
    run.run()


}


fun String.kapital(): String {
    return split(" ")
        .map {
            val first = it[0].uppercase()
            first + it.substring(1)
        }
        .joinToString(" ")
}