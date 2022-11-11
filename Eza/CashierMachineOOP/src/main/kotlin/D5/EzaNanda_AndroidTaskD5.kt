fun main() {

    inputCek()
}


fun inputCek() {
    println("Input Value: ")
    val input: String? = readLine()
    val arrayOfInput: List<Any>? = input?.split(" ")
    val num = listOf("1","2","3","4","5","6","7","8","9","0")
    val str = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
    println("Hasil Array: $arrayOfInput")



    if (arrayOfInput != null) {
        for(i in arrayOfInput.indices ){
            if (arrayOfInput[i] in str){
                println("${arrayOfInput[i]} -> huruf")
            } else if (arrayOfInput[i] in num){
                println("${arrayOfInput[i]} -> Angka")
            } else {
                println("${arrayOfInput[i]} -> Lainnya")
            }
        }
    }
}
