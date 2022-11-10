/*
import kotlin.system.exitProcess

var makanan = mutableMapOf<String, Int>("steak" to 50000, "spaghetti" to 20000, "burger" to 15000)
var totalMakanan = mutableMapOf<Int, String>()


fun pointOfSales() {
    makanan.onEachIndexed { index, (keys) ->
        totalMakanan[index + 1] = keys
    }
    var exit = false
    do {
        println("""
        ***** MEWAH MURAH *****
            1. Lihat Menu
            2. Tambah Menu
            3. Penjualan
            4. Keluar
        #######################
    """.trimIndent())
        print("Input Menu(1-4): ")
        val input: Int? = readLine()!!.toInt()

        if (input != null) {
            when (input){
                1 -> LihatMenu()
                2 -> TambahMenu()
                3 -> Penjualan()
                4 -> Keluar()
            }
        }
    } while (!exit)


}

fun LihatMenu() :Boolean{
    println("======================================")
    println("============Daftar Menu===============")
    println("\"${"No.".padEnd(4)} | ${"Nama Makanan".padEnd(20)} | ${"Harga".padEnd(20)}\"")
    val code = totalMakanan.toList()
    makanan.onEachIndexed { index, (namaMakanan, harga) ->
        println("${code[index].first.toString().padEnd(4)} | ${namaMakanan.kapital().padEnd(20)} | ${"Rp $harga".padEnd(20)}")
    }
    println("======================================")
    return false
}

fun String.kapital(): String {
    return split(" ")
        .map {
            val first = it[0].uppercase()
            first + it.substring(1)
        }
        .joinToString(" ")
}

fun TambahMenu():Boolean{

    println("============Tambah Makanan===============")
    print("Silahkan masukan nama makanan: ")
    val inputMakanan = readLine()?: ""
    if(inputMakanan.lowercase() in makanan.keys) {
        print("Makanan sudah ada dimenu apakah ingin diperbarui harga (Y/N):")
        val jawab = readLine()?: ""
        if (jawab.lowercase() == "y"){
            inputHarga(inputMakanan)
            println("Harga berhasil diperbarui")
        } else {
            println("Baiklah")
        }
    } else {
        inputHarga(inputMakanan)
        totalMakanan[totalMakanan.keys.last()+1] = inputMakanan
        println("Makanan berhasil ditambahkan")
    }
    println(",Kembali ke menu")
    return false
}

fun inputHarga(inputMakanan: String) {
    do {
        print("Masukan Harga:")
        try {
            val price = readLine()?.toInt() ?: throw NumberFormatException()
            makanan[inputMakanan] = price
            break
        } catch (e:NumberFormatException){
            println("""
                Input salah, yang anda masukan harus angka
            """.trimIndent())
        }
    } while (true)
}


fun Penjualan():Boolean{

    val pesanan = mutableMapOf<String, Int>()
    println("============Tambah Makanan===============")
    LihatMenu()
    do {
        print("Masukan nomer makanan: ")
        val codes = try {
            readLine()?.toInt() ?: - 1
        } catch (e: NumberFormatException){
            -1
        }
        if (codes in totalMakanan.keys) {
            totalMakanan[codes]?.let { foodName ->
                pesanan[foodName] = try {
                    pesanan.getValue(foodName) + 1
                } catch (e: NoSuchElementException) {
                    1
                }
                println("${foodName.kapital()}, ditambahkan ke keranjang")
            }
        } else {
            println("Code Makanan Salah")
        }
        println("Inging Menambahkan makanan lagi? (Y/N)")
        val answer = readLine()?.lowercase()
        if (answer != "y")
            break
    } while (true)

    var total = 0

    println("============Tambah Makanan===============")
    println("${"Nama Makanan".padEnd(20)} | ${"Jumlah Pesanan".padEnd(20)} | ${"SubTotal".padEnd(20)}")
    pesanan.forEach { namaMakanan, count ->
        val harga = (makanan[namaMakanan] ?: 0) * count
        total += harga
        println("${namaMakanan.kapital().padEnd(20)} | ${count.toString().padEnd(20)} | ${"Rp $harga".padEnd(20)}")
    }
    println("---------------------------------------")
    println("Total Pembelian: Rp $total".padStart(50))
    println("------------Terima Kasih---------------")

    return false
}

fun Keluar(){
    println("""
        *****BYE*****
    """.trimIndent())
}*/
