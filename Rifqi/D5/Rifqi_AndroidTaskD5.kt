package task

fun main (args: Array<String>) {
    someMethod ("Angka", "Huruf","Lainnya")
}

private fun someMethod (angka : String, huruf: String, lainnya : String) {

    loop@ for (a in angka ){
        println ("1 -> " + angka)
        println ("0 -> " + angka)
        println ("8 -> " + angka)
        break@loop
    }

    loop@ for (h in huruf ){
        println ("a -> " + huruf)
        println ("s -> " + huruf)
        break@loop
    }

    loop@ for (l in lainnya ){
        println ("bc -> " + lainnya)
        println ("d3 -> " + lainnya)
        println ("22 -> " + lainnya)
        break@loop
    }


}
