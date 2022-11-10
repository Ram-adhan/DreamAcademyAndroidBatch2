class jalanProgram {
    var menuTersedia = mutableListOf(
        Makanan(1, "nAsi gOreng", 1000, 0),
        Makanan(2, "bAKMi bASAH", 1500, 0),
        Makanan(3, "teMpe", 2000, 0)
    )
    var fungsi = Fungsi()

    fun run() {
        fungsi.halaman_Utama()
        print("Silahkan memilih menu [ 1 - 4 ] :")
        var input_menu = readLine()!!.toInt()
        when (input_menu) {
            1 -> fungsi.lihat_Menu(menuTersedia)
            2 -> tambah_Makanan()
            3 -> penjualan()
            4 -> keluar()
        }
    }
}