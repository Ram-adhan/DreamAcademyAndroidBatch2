package D8

import Food

class MesinKasir {

    val dataMakanan = mutableListOf(
        Food(1, "ayam goreng", 10000),
        Food(2, "spaghetti", 20000),
    )

    fun mainRslt() {
        var exit = false
        do {
            println(
                """    ***** MEWAH MURAH *****
        1. Lihat Makanan.kt
        2. Tambah Makanan.kt
        3. Penjualan
        4. Keluar
    ####################### 
""".trimIndent()
            )
            print("ketik kode menu yang diinginkan (1-4): ")
            val command = readLine()
            exit = when (command?.lowercase()) {
                "1" -> tampilkanMenu()
                "2" -> tambahkanMenu()
                "3" -> false
                "4" -> {
                    logout()
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

    fun tampilkanMenu(): Boolean{
        println("------------Daftar Menu---------------")
        println("${"No.".padEnd(4)} | ${"Nama Makanan.kt".padEnd(20)} | ${"Harga".padEnd(20)}")

        dataMakanan.forEach { makanan ->
            println("${makanan.id.toString().padEnd(4)} | ${makanan.name.kapitalis().padEnd(20)} | ${"Rp ${makanan.price}".padEnd(20)}")
        }
        println("------------**********---------------")
        return false

    }

    fun tambahkanMenu():Boolean{
        println("------------Tambah Makanan.kt---------------")
        print("Masukkan nama makanan: ")

        val namaMakanan = readLine() ?: ""
        print("Masukkan harga makanan: ")
        val hargaMakanan = readLine()!!
        val makanan = Food()

        if (namaMakanan.lowercase().isNotBlank()) {

            makanan.name = namaMakanan
            makanan.price = hargaMakanan.toInt()
        }
//        println(makanan)
        dataMakanan.add(makanan)

        return false

    }

//    fun penjualan(): Boolean{
//        tampilkanMenu()
//        println("------------Masukkan Nama Makanan.kt---------------")
//        val findMakanan = readLine() ?: ""
//
//        when {
//            findMakanan.lowercase() in dataMakanan -> {
//
//                for (i in 0..dataMakanan.size-1){
//                    println(dataMakanan[i])
//
//
//                }
//
//            }
//        }
//        return false
//    }

    fun logout(){
        println("""
         ----- TERIMAKASIH -------
       -- Silakan Datang Kembali --
    """.trimIndent())
    }

}