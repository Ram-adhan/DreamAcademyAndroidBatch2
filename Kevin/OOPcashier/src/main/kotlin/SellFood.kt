class SellFood {
    fun jualMenu(){
        val mesin = MesinKasir()
        val struk = Receipt()
        val makanan = mesin.dataMakanan
        var exit = false
        for (indx in listMakan.indices){
            totalMakan[listMakan.get(indx)] = 0
        }
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
            val indexMakanan = listMakan.indexOf(makanan)
            if(indexMakanan >= 0) {
                if (makanan in totalMakan.keys){
                    totalMakan[makanan] = (totalMakan.getValue(makanan) ?: 0) + 1
                }else {
                    totalMakan[makanan] = 1
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
            struk.printBill()
            exit = false
            mesin.mainMenu()
        }

    }
}