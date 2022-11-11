class Fungsi {
    fun String.kapitalisasi (): String{
        return split(" ")
            .map {
                val pertama = it[0].uppercase()
                pertama + it.substring(1)
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
        println("${"Menu".padEnd(30)} | ${"Harga"}")
        println("====================================================")
        menu.forEach { makanan ->
            println("${makanan.nama.lowercase().kapitalisasi().padEnd(30)} | ${makanan.harga}")
        }
    }

    fun tambah_Makanan (menu: MutableList<Makanan>){
        val nilaiSementaraMakanan: Makanan = Makanan()
        var skip = false
        println("Masukan nama makanan :")
        val namaTambahMakanan = readLine().toString().lowercase()
//          pengecekan untuk nama makanan yang sama
        menu.forEach { makanan ->
            if (makanan.nama.lowercase().equals(namaTambahMakanan) ) {
                println("Makanan sudah ada. Apakah anda ingin memperbarui makanan yang sudah ada?")
                println("1. Iya  2. Tidak")
                val persetujuan_Update_Makanan = readLine()!!.toInt()
                if (persetujuan_Update_Makanan == 1) {
                    println("Masukan harga")
                    val harga = readLine()!!.toInt()
                    makanan.harga = harga
                    skip = true
                }
            }
        }

        if (skip == false) {
            println("Masukan harga")
            val harga = readLine()!!.toInt()
            nilaiSementaraMakanan.nama = namaTambahMakanan
            nilaiSementaraMakanan.harga = harga
            menu.add(nilaiSementaraMakanan)
        }
    }

    fun penjualan (menu: List<Makanan>) {
        val menuJual: List<Makanan> = menu
        var totalPesanan = 0
        // sinkronisasi, memberi nomor, dan reset pada menu yang akan dijual
        for (i in 0..menuJual.size - 1)  {
            menuJual[i].nomor = i + 1
            menuJual[i].jumlah = 0
        }
        do {
            println("${"No.".padEnd(4)} | ${"Menu".padEnd(30)} | ${"Harga"}")
            menuJual.forEach { makanan ->
                println("${makanan.nomor.toString().padEnd(4)} | ${makanan.nama.lowercase().kapitalisasi().padEnd(30)} | ${makanan.harga}")
            }
            println("Pilih nomor menu yang ingin dipesan [ 1 - ${menuJual.size}]")
            val pilihNo_makanan = readLine()!!.toInt()
            for (i in 0..menuJual.size - 1) {
                // pertama kali user input makanan
                if (pilihNo_makanan == menuJual[i].nomor) {
                    menuJual[i].jumlah =  menuJual[i].jumlah + 1
                    pesananUser = pesananUser + 1
                }
            }
            println("Apakah anda ingin menambah pesanan ?")
            println("1. Ya\t\t 2. Tidak\t[1 - 2]")
            val nambahpesanan = readLine()!!.toInt()
        }while (nambahpesanan == 1)
//                              STRUK PENJUALAN
        println("${"Menu".padEnd(30)} | ${"Harga".padEnd(10)} | ${"Jumlah".padEnd(10)} | ${"Sub Total"}")
        for (i in 0..menuJual.size - 1) {
            if (menuJual[i].jumlah >= 1) {
                val subtotal = menuJual[i].jumlah * menuJual[i].harga
                totalPesanan += subtotal
                println("${menuJual[i].nama.lowercase().kapitalisasi().padEnd(30)} | ${menuJual[i].harga.toString().padEnd(10)} | ${menuJual[i].jumlah.toString().padEnd(10)} | ${subtotal}")
            }
        }
        println("====================================================")
        println("${"Jumlah belanja".padEnd(40)} : ${totalPesanan}")
    }
    fun keluar (){
        println("Terima kasih atas kunjungannya")
    }

}
