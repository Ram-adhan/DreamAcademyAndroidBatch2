import java.util.NoSuchElementException

class Receipt {
    val reqMakanan: String = ""
    var jumlah: Int = 0
    val makanan: Makanan = Makanan()

    fun printBill(){
        var subTotal = 0
        var total = 0
        fun panggilPesan(): String{
            for (makanan in totalMakan.keys){
                val indexMakanan = listMakan.indexOf(makanan)
                val harga = listHarga[indexMakanan]
                subTotal = harga * try{
                    totalMakan.getValue(makanan)
                } catch(e: NoSuchElementException){
                    0
                }
                total += subTotal

                if(totalMakan.getValue(makanan) > 0){
                    println("""
                    ${makanan.kapital().padEnd(20)} ${totalMakan.getValue(makanan).toString().padEnd(9)} Rp.$subTotal
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