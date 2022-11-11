fun main() {
    angka()
    println("------------------------")
    perbandinganArrays()
}

fun angka(){
    val num = listOf(1,4,3,5)
    var hasilNum = 0

    num.forEach { nums ->
        hasilNum = hasilNum + nums
    }
    println("Total Tambah : $hasilNum")
}

fun perbandinganArrays () {

    val angka1 = listOf(1,2,3,4,5)
    val angka2 = listOf(1,3,4,6,7)

    var result = true
    result = angka1.size == angka2.size
    if( result){
        for(i in angka1.indices){
            for (j in angka2.indices)
                if(angka1[i] == angka2[j]){
                    println("Sama : ${angka1[i]} dan ${angka2[j]}")
                    continue
                } else{
                    println("Beda : ${angka1[i]} dan ${angka2[j]}")
                }
        }
    }

}