/*
var makanan = mutableListOf<String>("Steak", "Spaghetti", "Burger")
var harga = mutableListOf<Int>(50000,20000,15000)
var num = mutableListOf<String>("1","2","3")
var totalMakanan = mutableMapOf<String, Int>()
var total = 0
var amount = 0

fun main() {
    Menu()
    mainMenu()

}

fun mainMenu(){
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
       ${num[i]}. ${makanan[i].padEnd(15)}   Rp.${harga[i]}
    """.trimIndent())
    }
    print("Balik ke Menu(Y/N) : ")
    val jikaInput: String? = readLine()
    if (jikaInput == "Y"){
        Menu()
    } else if (jikaInput == "y"){
        Menu()
        mainMenu()
    } else {
        Keluar()
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
    val inputMenu: String? = readLine()?.lowercase()
    print("Masukan Harga        : ")
    val inputHarga = readLine()!!.toInt()



    if (inputMenu != null) {
        if (inputNum in num){
            if (inputNum != null) {
                num.set(inputNum.toInt()-1,inputNum)
                makanan.set(inputNum.toInt()-1,capitalize(inputMenu))
                harga.set(inputNum.toInt()-1,inputHarga)
            }
        }
        else {
            if (inputNum != null) {
                num.add(inputNum)
            }
            makanan.add(capitalize(inputMenu))
            harga.add(inputHarga)
        }

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
    for (indx in makanan.indices){
        totalMakanan[num.get(indx)] = 0
    }
//    val makan : List<String>? = reqMakan
    println("Makanan | Jumlah Pesanan | Subtotal")
    for (makan in totalMakanan.keys){
        val indexMakan = num.indexOf(makan)
        val harga = harga[indexMakan]
        val jumlahPesanan = try {
            totalMakanan.getValue(makan)
        } catch (e: NoSuchElementException){
            0
        }
        val subTotal = harga * jumlahPesanan
        total += subTotal
        println("$reqMakan | $jumlahPesanan | $subTotal")
    }
    println("==================")
    println("Total $total")


//    if (reqMakan != null) {
//        for (i in reqMakan.indices) {
//            when (reqMakan[i]) {
//                in num -> harga.get(num.indexOf(reqMakan[i]))
//                else -> "Nomer tidak ada"
//            }
//            total += harga.get(num.indexOf(reqMakan[i]))
//            amount += num.get(num.indexOf(reqMakan[i])).count()
//        }
        print("Tambah Menu? Y/N: ")
        val inputReq: String? = readLine()
        if(inputReq == "Y") {
            Penjualan()

        } else if(inputReq == "y"){
            Penjualan()
        }
        else {
            strukBill()
        }

//    }


}


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

    print("Balik ke Menu(Y/N) : ")
    val jikaInput: String? = readLine()
    if (jikaInput == "Y"){
        Menu()
    } else if (jikaInput == "y"){
        Menu()
    } else {
        Keluar()
    }

}

fun Keluar(){
    println("""
        *****BYE*****
    """.trimIndent())
}*/
