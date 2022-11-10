import java.util.NoSuchElementException

class Receipt {
    var dataMakanan = DatabaseMakanan().listMenu
    var pesananMakanan = mutableMapOf<String, Int>()

    fun jualMenu(){
        var exit = false
        while(exit != true){
            println("""
        **********************************
        ----- PENGEN MAKAN APA KAU?? -----
        **********************************
    """.trimIndent())

            print("""
        Makanan yang dipilih: 
    """.trimIndent())

            val makanan: String = readLine()?.lowercase()?.kapital() ?: ""
            val indexMakanan = dataMakanan.indexOfFirst { it.nama == makanan }
            if(indexMakanan >= 0) {
                if (makanan in pesananMakanan.keys){
                    pesananMakanan[makanan] = (pesananMakanan.getValue(makanan) ?: 0) + 1
                }else {
                    pesananMakanan[makanan] = 1
                }
            } else{
                println("Makanan tidak ada")
            }

            println("Ingin tambah lagi? (Y/N)")
            exit = readLine()?.let{
                it.kapital() == "N"
            } ?: true
        }
        while (exit == true){
            printBill()
            exit = false
            MesinKasir().mainMenu()
        }

    }

    fun printBill(){
        var subTotal = 0
        var total = 0
        fun panggilPesan(): String{
            for (makanan in pesananMakanan.keys){
                val dataMakanan = dataMakanan.find { it.nama == makanan }
                subTotal = (dataMakanan?.harga ?: 0) * try{
                    pesananMakanan.getValue(makanan)
                } catch(e: NoSuchElementException){
                    0
                }
                total += subTotal

                if(pesananMakanan.getValue(makanan) > 0){
                    println("""
                    ${makanan.kapital().padEnd(20)} ${pesananMakanan.getValue(makanan).toString().padEnd(9)} Rp.$subTotal
                """.trimIndent())
                }
            }
            return " "
        }

        println("""
            *****************************************
            ----------- INGPO MAKANAN KAU -----------
            *****************************************
            Nama Makanan    |   Total   |     Harga

        """.trimIndent())

        println("""
            ${panggilPesan()}
        """.trimIndent())

        println("""
            -----------------------------------------
            Total Harga: Rp.$total
        """.trimIndent())
    }
}