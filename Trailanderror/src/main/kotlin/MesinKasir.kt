class MesinKasir {
    var dataMakanan = mutableListOf(
        Food(1, "steak", 10000),
        Food(2, "spaghetti", 20000),
        Food(3,"burger",15000)
    )
    var totalMakanan = mutableMapOf<Int, String>()

    fun run() {
        dataMakanan.onEachIndexed { index, (keys) ->
            totalMakanan[index + 1] = keys.toString()
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
        var makanan: Food = Food()
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
                print("Harga berhasil diupdate")
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
        if(inputNamaMakanan.lowercase().isNotBlank()){
        }
        return false
    }
    fun Penjualan():Boolean{

        val pesanan = mutableMapOf<String, Int>()
        println("============Tambah Makanan===============")
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
//        val indexHarga = dataMakanan.indexOf(food)
        println("============Tambah Makanan===============")
        println("${"Nama Makanan".padEnd(20)} | ${"Jumlah Pesanan".padEnd(20)} | ${"SubTotal".padEnd(20)}")
        pesanan.forEach { namaMakanan, count ->
            val harga = ( pesanan[namaMakanan]?: 0) * count
            total += harga
            println("${namaMakanan.kapital().padEnd(20)} | ${count.toString().padEnd(20)} | ${"Rp $harga".padEnd(20)}")
        }
        println("---------------------------------------")
        println("Total Pembelian: Rp $total".padStart(50))
        println("------------Terima Kasih---------------")
        return false
    }

}