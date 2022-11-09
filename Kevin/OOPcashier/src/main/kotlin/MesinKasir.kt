class MesinKasir {
    val show = ShowMenu()
    val add = AddFood()
    val sell = SellFood()

    val dataMakanan = mutableListOf(
        Makanan("Ayam", 20000),
        Makanan("Wagyu", 300000),
        Makanan("Nasi Padang", 25000)
    )

    fun mainMenu(){
        println("""
        **********************************
        ------------ MAIN MENU -----------
        **********************************
        1. Tampilkan Menu
        2. Tambahkan Menu
        3. Penjualan Makanan
        4. Keluar Program
        **********************************
        ------- Pilih Angka (1-4) --------
        **********************************
    """.trimIndent())

        print("""
        Masukkan angka: 
    """.trimIndent())
        val userIn: Int = Integer.valueOf(readLine())
        when (userIn){
            1 -> tampilMenu()
            2 -> tambahMenu()
            3 -> sell.jualMenu()
            4 -> keluarProgram()
        }
    }

    fun tampilMenu(){

        println("""
        **********************************
        ---------- MENU MAKANAN ----------
        **********************************
        Nama Makanan    |     Harga  
        
    """.trimIndent())
        println("""
        ${show.panggilMenu()}
    """.trimIndent())
        println("""
        **********************************
        ----------------------------------
        **********************************
    """.trimIndent())

        println("""
        
    """.trimIndent())

        mainMenu()
    }

    fun tambahMenu(){

        add.nambahMenu()

        println("""
        **********************************
           MAKANAN BERHASIL DITAMBAHKAN
        **********************************
        
        0. Main Menu
        1. Tampilkan Menu
        2. Tambah makanan lagi
        3. Penjualan makanan
        
        ----------------------------------
        Masukkan angka: 
    """.trimIndent())
        val userIn: Int = Integer.valueOf(readLine())
        when (userIn){
            0 -> mainMenu()
            1 -> tampilMenu()
            2 -> add.nambahMenu()
            3 -> sell.jualMenu()
        }
    }

    fun keluarProgram(){
        println("""
       ***********************************
       ----- BELI DOANG MAKAN KAGAK ------
    """.trimIndent())
    }

}