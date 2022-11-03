var makanan = mutableListOf<String>("Steak", "Spaghetti", "Burger")
var harga = mutableListOf<Int>(50000,20000,15000)
var num = mutableListOf<String>("1","2","3")
var total = 0
var amount = 0

fun main() {
    Menu()
    print("Input Menu: ")
    val input: Int? = readLine()!!.toInt()

    if (input != null) {
            when (input){
                1 -> LihatMenu()
                2 -> TambahMenu()
                3 -> Penjualan()
                4 -> Keluar()
            }
    }
}


fun Menu() {
    println("""
        ***** MEWAH MURAH *****
            1. Lihat Menu
            2. Tambah Menu
            3. Penjualan
            4. Keluar
        #######################
    """.trimIndent())

    }

fun LihatMenu(){

    for (i in makanan.indices) {
        println(
            """
       ${num[i]}. ${makanan[i].padEnd(10)}   Rp.${harga[i]}
    """.trimIndent())
    }
    print("Balik ke Menu(Y/N) : ")
    val jikaInput: String? = readLine()
    if (jikaInput == "Y"){
        Menu()
    } else if (jikaInput == "y"){
        Menu()
    } else {
        Keluar()
    }

    print("Input Menu: ")
    val input: Int? = readLine()!!.toInt()

    if (input != null) {
        when (input){
            1 -> LihatMenu()
            2 -> TambahMenu()
            3 -> Penjualan()
            4 -> Keluar()
        }
    }

//    ${num[i]}. ${makanan[i]}  Rp.${harga[i]}

}
fun capitalize(str: String): String {
    return str.trim().split("\\s+".toRegex())
        .map { it.capitalize() }.joinToString(" ")

}

fun TambahMenu(){
    print("Masukan Nomer Makanan: ")
    val inputNum: String? = readLine()
    print("Nama Makanan         : ")
    val inputMenu: String? = readLine()?.toLowerCase()
    print("Masukan Harga        : ")
    val inputHarga = readLine()!!.toInt()



    if (inputMenu != null) {

        if (inputNum != null) {
            num.add(inputNum)
        }
        makanan.add(capitalize(inputMenu))
        harga.add(inputHarga)
    }
    Menu()
    print("Input Menu: ")
    val input: Int? = readLine()!!.toInt()

    if (input != null) {
        when (input){
            1 -> LihatMenu()
            2 -> TambahMenu()
            3 -> Penjualan()
            4 -> Keluar()
        }
    }
}

fun Penjualan(){
    for (i in makanan.indices) {
    println("${num[i]}. ${makanan[i].padEnd(10)}   Rp.${harga[i]}") }
    print("Masukan Nomer Makanan : ")
    val input: String? = readLine()
    val reqMakan : List<String>? = input?.split(",")

        if (reqMakan != null) {
            for (i in reqMakan.indices) {
                when (reqMakan[i]) {
                    in num -> harga.get(num.indexOf(reqMakan[i]))
                    else -> "Nomer tidak ada"
                }
                total += harga.get(num.indexOf(reqMakan[i]))
                amount += num.get(num.indexOf(reqMakan[i])).count()
            }
            print("Y/N: ")
            val inputReq: String? = readLine()
            var req = inputReq

            if(req == "Y") {
                Penjualan()

            } else if(req == "y"){
                Penjualan()
            }
            else {
                strukBill()
            }

    }

}
//var reqMak = TambahMenu()

fun strukBill(){
//    var strukMakan = reqMak.distinct()
    fun struk (): String {
        for (i in makanan.indices) {

            println("""
                ${makanan[i].padEnd(10)}| $amount  | Rp.${harga[i]}
            """.trimIndent())
        }
        return(" ")
    }

    println("""
                ==========================================================
                Nama Makanan              | Jumlah        | Harga
                ==========================================================
    """.trimIndent())

    println("""
        ${struk()}
    """.trimIndent())

    println("""
                ==========================================================
                Total Harga : $total
    """.trimIndent())


}

fun Keluar(){
    println("""
        *****BYE*****
    """.trimIndent())
}

