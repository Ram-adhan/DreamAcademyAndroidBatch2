
val foods = mutableMapOf<String, Int>("ayam goreng" to 12000, "spaghetti" to 15000, "steak" to 40000)
val foodCodes = mutableMapOf<Int, String>()

fun main() {
    var exit = false
    foods.onEachIndexed { index, (keys) ->
        foodCodes[index + 1] = keys
    }
    do {
        println(
            """    ***** MEWAH MURAH *****
        1. Lihat Makanan
        2. Tambah Makanan
        3. Penjualan
        4. Keluar
    ####################### 
""".trimIndent()
        )
        print("ketik kode menu yang diinginkan (1-4): ")
        val command = readLine()
        exit = when(command?.lowercase()) {
            "1" -> showMenu()
            "2" -> addFood()
            "3" -> sellFood()
            "4" -> {
                println("Terimakasih")
                true
            }
            else -> {
                println("Menu tidak ditemukan, keluar dari program")
                true
            }
        }
    } while (!exit)
}

fun showMenu(): Boolean {
    println("------------Daftar Menu---------------")
    println("${"No.".padEnd(4)} | ${"Nama Makanan".padEnd(20)} | ${"Harga".padEnd(20)}")
    val codes = foodCodes.toList() // -> Pair(key, index)
    foods.onEachIndexed { index, (namaMakanan, harga) ->
        println("${codes[index].first.toString().padEnd(4)} | ${namaMakanan.kapitalisasi().padEnd(20)} | ${"Rp $harga".padEnd(20)}")
    }
    println("------------**********---------------")
    return false
}

fun addFood(): Boolean {
    println("------------Tambah Makanan---------------")
    print("""
        Silahkan tambahkan menu baru
        Masukkan nama makanan: 
    """.trimIndent())
    val namaMakanan = readLine() ?: ""
    if (namaMakanan.lowercase() in foods.keys) {
        print("Makanan sudah ada dalam menu, apakah ingin update harga?(Y/N) ")
        val answer = readLine() ?: ""
        if (answer.lowercase() == "y") {
            inputHarga(namaMakanan)
            print("Harga berhasil diupdate")
        } else {
            print("Baiklah")
        }
    } else {
        inputHarga(namaMakanan)
        foodCodes[foodCodes.keys.last() + 1] = namaMakanan
        print("Makanan berhasil ditambahkan")
    }
    println(", kembali ke menu")
    return false
}

fun inputHarga(namaMakanan: String) {
    do {
        print("Masukkan harga terbaru: ")
        try {
            val price = readLine()?.toInt() ?: throw NumberFormatException()
            foods[namaMakanan] = price
            break
        } catch (e: NumberFormatException) {
            println("""
                            yang anda masukkan bukan angka
                            silahkan masukkan ulang
                        """.trimIndent())
        }
    } while (true)
}

fun sellFood(): Boolean {
    val pesanan = mutableMapOf<String, Int>() //nama makanan dan jumlah pesanan
    println("------------Penjualan---------------")
    showMenu()
    do {
        print("Masukkan kode makanan: (numeric)")
        val code = try {
            readLine()?.toInt() ?: -1
        } catch (e: NumberFormatException) {
            -1
        }

        if (code in foodCodes.keys) {
            foodCodes[code]?.let {foodName ->
                pesanan[foodName] = try {
                    pesanan.getValue(foodName) + 1
                } catch (e: NoSuchElementException) {
                    1
                }
                println("${foodName.kapitalisasi()}, ditambahkan ke keranjang")
            }
        } else {
            println("Kode makanan tidak ditemukan")
        }
        println("Ingin menambahkan makanan lagi? (Y/N")
        val answer = readLine()?.lowercase()
        if (answer != "y")
            break
    } while (true)

    var total = 0
    println("-----------Struk Pembelian--------------")
    println("${"Nama Makanan".padEnd(20)} | ${"Jumlah Pesanan".padEnd(20)} | ${"SubTotal".padEnd(20)}")
    pesanan.forEach { namaMakanan, count ->
        val harga = (foods[namaMakanan] ?: 0) * count
        total += harga
        println("${namaMakanan.kapitalisasi().padEnd(20)} | ${count.toString().padEnd(20)} | ${"Rp $harga".padEnd(20)}")
    }
    println("---------------------------------------")
    println("Total Pembelian: Rp $total".padStart(50))
    println("------------Terima Kasih---------------")

    return false
}

fun String.kapitalisasi(): String {
    return split(" ")
        .map {
            val first = it[0].uppercase()
            first + it.substring(1)
        }
        .joinToString(" ")
}