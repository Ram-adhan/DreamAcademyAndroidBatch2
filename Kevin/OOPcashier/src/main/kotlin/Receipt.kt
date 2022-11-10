//import java.util.NoSuchElementException
//
//class Receipt {
//    val dataMakanan = DatabaseMakanan().listMenu
//    var pesananMakanan = mutableMapOf<String, Int>()
//    var jumlah: Int = 0
//    val makanan: Makanan = Makanan()
//
//    fun jualMenu(){
//        var exit = false
////        val orderedMakanan = readLine()?.lowercase()?.kapital() ?: ""
////        orderedMakanan.forEach{makanan ->
////            val jumlahMakanan = orderedMakanan.count()
////        }
////        for (indx in listMakan.indices){
////            totalMakan[listMakan.get(indx)] = 0
////        }
//        while(exit != true){
//            println("""
//        **********************************
//        ----- PENGEN MAKAN APA KAU?? -----
//        **********************************
//    """.trimIndent())
//
//            print("""
//        Makanan yang dipilih:
//    """.trimIndent())
//
//            val makanan: String = readLine()?.lowercase()?.kapital() ?: ""
//            val indexMakanan = dataMakanan.indexOf(makanan)
//            if(indexMakanan >= 0) {
//                if (makanan in pesananMakanan.keys){
//                    pesananMakanan[makanan] = (pesananMakanan.getValue(makanan) ?: 0) + 1
//                }else {
//                    pesananMakanan[makanan] = 1
//                }
//            } else{
//                println("Makanan tidak ada")
//            }
//
//            println("Ingin tambah lagi? (Y/N)")
//            exit = readLine()?.let{
//                it.kapital() == "N"
//            } ?: true
//        }
//        while (exit == true){
//            printBill()
//            exit = false
//            MesinKasir().mainMenu()
//        }
//
//    }
//
//    fun printBill(){
//        var subTotal = 0
//        var total = 0
//        fun panggilPesan(): String{
//            for (makanan in pesananMakanan.keys){
//                val indexMakanan = dataMakanan.nama.indexOf(makanan)
//                val harga = dataMakanan.harga.[indexMakanan]
//                subTotal = harga * try{
//                    pesananMakanan.getValue(makanan)
//                } catch(e: NoSuchElementException){
//                    0
//                }
//                total += subTotal
//
//                if(pesananMakanan.getValue(makanan) > 0){
//                    println("""
//                    ${makanan.kapital().padEnd(20)} ${pesananMakanan.getValue(makanan).toString().padEnd(9)} Rp.$subTotal
//                """.trimIndent())
//                }
//            }
//            return " "
//        }
//
//        println("""
//            *****************************************
//            ----------- INGPO MAKANAN KAU -----------
//            *****************************************
//            Nama Makanan    |   Total   |     Harga
//
//        """.trimIndent())
//
//        println("""
//            ${panggilPesan()}
//        """.trimIndent())
//
//        println("""
//            -----------------------------------------
//            Total Harga: Rp.$total
//        """.trimIndent())
//    }
//}