class jalanProgram {
    var menuTersedia = mutableListOf(
        Makanan(1, "nAsi gOreng", 1000, 0),
        Makanan(2, "bAKMi bASAH", 1500, 0),
        Makanan(3, "teMpe", 2000, 0)
    )
    var fungsi = Fungsi()

    fun run() {
        do {
            fungsi.halaman_Utama()
            print("Silahkan memilih menu [ 1 - 4 ] :")
            var input_menu = readLine()!!.toInt()
            when (input_menu) {
                1 -> fungsi.lihat_Menu(menuTersedia)
                2 -> {
                    do {
                        fungsi.tambah_Makanan(menuTersedia)
                        println("Apakah anda ingin menambah menu ?")
                        println("1. Iya  2. Tidak")
                        var opsiMenu = readLine()!!.toInt()
                    } while (opsiMenu == 1)
                }
                3 -> fungsi.penjualan(menuTersedia)
                4 -> fungsi.keluar()
            }
        }while(input_menu != 4)

    }
}



