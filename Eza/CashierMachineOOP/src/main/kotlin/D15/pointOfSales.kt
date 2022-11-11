
class MesinKasir {
    var dataMakanan = mutableListOf(
        Food(1, "steak", 10000),
        Food(2, "spaghetti", 20000),
        Food(3,"burger",15000)
    )
    var totalMakanan = mutableMapOf<Int, Int>()
    var makanan: Food = Food()

    fun run() {
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
            val input = readLine()
            exit = when (input?.lowercase()) {
                "1" -> showMenu()
                "2" -> TambahMenu()
                "3" -> Penjualan()
                "4" -> {
                    println("\"============BYE BYE===============\"")
                    true
                }
                else -> {
                    println("Menu tidak ditemukan, keluar dari program")
                    true
                }
            }
        } while (!exit)
    }

    //contoh untuk access property object
    fun showMenu(): Boolean {
        println("------------Daftar Menu---------------")
        println("${"No.".padEnd(4)} | ${"Nama Makanan".padEnd(20)} | ${"Harga".padEnd(20)}")

        dataMakanan.forEach { makanan ->
            println("${makanan.id.toString().padEnd(4)} | ${makanan.name.kapital().padEnd(20)} | ${"Rp ${makanan.price}".padEnd(20)}")
        }
        println("------------**********---------------")
        return false
    }


    fun TambahMenu(): Boolean {
        println("============Tambah Makanan===============")
        print("Silahkan masukan nama makanan: ")

        val inputNamaMakanan = readLine()?.lowercase() ?: ""
        val existingMakanan = dataMakanan.find {
            it.name == inputNamaMakanan
        }
        fun updateHarga(food: Food){
            do {
                print("Masukan harga terbaru: ")
                try {
                    val price = readLine()?.toInt() ?: throw NumberFormatException()
                    val indexHarga = dataMakanan.indexOf(food)
                    dataMakanan.removeAt(indexHarga)
                    food.price = price
                    dataMakanan.add(food)
                } catch (e: NumberFormatException){
                    print("""
                        Yang anda masukan bukan angka
                        Silahkan masukan ulang
                    """.trimIndent())
                }
            } while (false)
        }
        if (existingMakanan != null) {
            println("Makanan Sudah Ada, Apakah inging memperbarui menu?(Y/N)")
            val answer = readLine() ?: ""
            if (answer.lowercase() == "y") {
                updateHarga(existingMakanan)
                println("Harga berhasil diupdate")
            } else {
                print("Baiklah")
            }
        } else {
            makanan.id = dataMakanan.count()+1
            makanan.name = inputNamaMakanan
            print("Silahkan masukan harga: ")
            val inputPrice = readLine()!!.toInt()
            makanan.price = inputPrice
            dataMakanan.add(makanan)
        }
        return false
    }

    fun Penjualan(): Boolean {
        showMenu()
        var exit = false
        while(exit != true){
            println("============Tambah Makanan===============")
            print("Masukan nomer makanan: ")
            val makanan = readLine()?.toInt()?: ""
            val indexMakanan = dataMakanan.indexOfFirst { it.id == makanan }
            if(indexMakanan >= 0) {
                if (makanan in totalMakanan.keys){
                    totalMakanan[makanan as Int] = (totalMakanan.getValue(makanan) ?: 0) + 1
                }else {
                    totalMakanan[makanan as Int] = 1
                }
            } else{
                println("Makanan tidak ada")
            }

            print("Inging Menambahkan makanan lagi? (Y/N) ")
            exit = readLine()?.let{
                it.kapital() == "N"
            } ?: true
        }
        while (exit == true){
            struk()
            exit = false
        }
        return true

    }

    fun struk(){
        var harga = 0
        var total = 0
        fun panggilPesan(): String{
            for (makanan in totalMakanan.keys){
                val dataMakanan = dataMakanan.find { it.id == makanan }
                harga = (dataMakanan?.price ?: 0) * try{
                    totalMakanan.getValue(makanan)
                } catch(e: NoSuchElementException){
                    0
                }
                total += harga

                if(totalMakanan.getValue(makanan) > 0){
                    if (dataMakanan != null) {
                        println("""
                                    ${dataMakanan.name.kapital().padEnd(22)} ${totalMakanan.getValue(makanan).toString().padEnd(20)} Rp.$harga
                                """.trimIndent())
                    }
                }
            }
            return " "
        }

        println("""
            "============Struk Makanan==============="
            ${"Nama Makanan".padEnd(20)} | ${"Jumlah Pesanan".padEnd(20)} | ${"SubTotal".padEnd(20)}
        """.trimIndent())

        println("""
            ${panggilPesan()}
        """.trimIndent())

        println("---------------------------------------")
        println("Total Pembelian: Rp $total".padStart(30))
        println("------------Terima Kasih---------------")
        totalMakanan.clear()
        run()

    }

}