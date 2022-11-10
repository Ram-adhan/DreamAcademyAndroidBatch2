class Mesin {
    var menuTersedia = mutableListOf(
        Makanan(1, "nAsi gOreng", 1000, 0),
        Makanan(2, "bAKMi bASAH", 1500, 0),
        Makanan(3, "teMpe", 2000, 0)
    )

    fun String.kapitalisasi (): String{
        return split(" ")
            .map {
                val pertama = it[0].uppercase()
                pertama +it.substring(1)
            }.joinToString(" ")
    }

    fun run() {
        lihat_Menu()
    }

    fun halaman_Utama() {
        println(
            """
        =====Selamat Datang Di Warung SukaMaju======
        1. Lihat Menu
        2. Tambah Makanan.kt
        3. Penjualan
        4. Keluar
    """.trimIndent()
        )
        do {
            print("Silahkan memilih menu [ 1 - 4 ] :")
            var input_menu = readLine()!!.toInt()
            when (input_menu) {
                1 -> lihat_Menu()
//            2 -> tambah_Makanan()
//            3 -> penjualan()
//            4 -> keluar()
            }
        } while (input_menu > 4)
    }

    fun lihat_Menu() {
        println("${"Menu".padEnd(20)} | ${"Harga"}")
        println("====================================================")
        for (i in 0..menuTersedia.size - 1) {
            println("${menuTersedia[i].nama.lowercase().kapitalisasi().padEnd(20)} | ${menuTersedia[i].harga}")
        }
    }

    fun tambah_Makanan (){
        var nilaiSementaraMakanan: Makanan = Makanan()
        var makananTambahan = mutableListOf<Makanan>()
        var berubah = 0
        do {
            println("Masukan nama makanan :")
            var namaTambahMakanan = readLine()!!.toString().lowercase()
//          pengecekan untuk nama makanan yang sama
            for (i in 0..menuTersedia.size - 1) {
                if (namaTambahMakanan.equals(menuTersedia[i].nama.lowercase()) ){
                    println("Makanan.kt sudah ada. Apakah anda ingin memperbarui makanan yang sudah ada?")
                    println("1. Iya  2. Tidak")
                    var persetujuan_Update_Makanan = readLine()!!.toInt()
                    if (persetujuan_Update_Makanan == 1){
                        println("Masukan harga")
                        var harga1 = readLine()!!.toInt()
                        menuTersedia[i].harga = harga1
//                                halaman_Utama()
                    }else if (persetujuan_Update_Makanan == 2)  println("Pergi ke halaman utama")
//                        halaman_Utama()
                }
            }
            println("Masukan harga")
            var harga2 = readLine()!!.toInt()
            nilaiSementaraMakanan.nama = namaTambahMakanan
            nilaiSementaraMakanan.harga = harga2
            menuTersedia.add(nilaiSementaraMakanan)
            println("Apakah anda ingin menambah menu lagi ? [ 1 - 2 ]: ")
            println("1. Iya  2. Tidak")
            var pil_Tambah_Makan = readLine()!!.toInt()
        }while (pil_Tambah_Makan == 1)
//        halaman_Utama()
//        var harga1 = readLine()!!.toInt()
//        nilaiSementaraMakanan.harga = harga1
//        menuTersedia[2].harga = harga1
//        for (i in 0..menuTersedia.size - 1)
//            println("${menuTersedia[i].nama.lowercase().kapitalisasi().padEnd(20)} | ${menuTersedia[i].harga}")
//                var namaTambahMakanan = readLine()!!.toString().lowercase()
//                nilaiSementaraMakanan.nama = namaTambahMakanan
//                menuTersedia.add(nilaiSementaraMakanan)
//        for (i in 0..menuTersedia.size - 1)
//            println("${menuTersedia[i].nama.lowercase().kapitalisasi()} | ${menuTersedia[i].harga}")
    }
}