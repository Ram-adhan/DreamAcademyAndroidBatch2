class Fungsi {
    fun String.kapitalisasi (): String{
        return split(" ")
            .map {
                val pertama = it[0].uppercase()
                pertama +it.substring(1)
            }.joinToString(" ")
    }



    fun halaman_Utama() {
        println(
            """
        =====Selamat Datang Di Warung SukaMaju======
        1. Lihat Menu
        2. Tambah Makanan
        3. Penjualan
        4. Keluar
    """.trimIndent()
        )
    }

    fun lihat_Menu(menu: List<Makanan>) {
        println("${"Menu".padEnd(20)} | ${"Harga"}")
        println("====================================================")
        for (i in 0..menu.size - 1) {
            println("${menu[i].nama.lowercase().kapitalisasi().padEnd(20)} | ${menu[i].harga}")
        }
    }





    fun tambah_Makanan (menu: mu){
        var nilaiSementaraMakanan: Makanan = Makanan()
        println("Masukan nama makanan :")
        var namaTambahMakanan = readLine()!!.toString().lowercase()
//          pengecekan untuk nama makanan yang sama
        for (i in 0..menu.size - 1) {
            if (namaTambahMakanan.equals(menu[i].nama.lowercase()) ){
                println("Makanan sudah ada. Apakah anda ingin memperbarui makanan yang sudah ada?")
                println("1. Iya  2. Tidak")
                var persetujuan_Update_Makanan = readLine()!!.toInt()
                if (persetujuan_Update_Makanan == 1){
                    println("Masukan harga")
                    var harga1 = readLine()!!.toInt()
                    menu[i].harga = harga1
                    halaman_Utama()
                }else if (persetujuan_Update_Makanan == 2)
                    halaman_Utama()
            }
        }
        println("Masukan harga")
        var harga2 = readLine()!!.toInt()
        nilaiSementaraMakanan.nama = namaTambahMakanan
        nilaiSementaraMakanan.harga = harga2
        menu
    }

}
