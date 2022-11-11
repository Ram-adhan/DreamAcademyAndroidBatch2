package D8

import D8.kapitalis
import java.lang.NumberFormatException
import javax.swing.text.StyledEditorKit.BoldAction

class MesinKasir {

    val dataMakanan = mutableListOf(
        Food(1, 0,"ayam goreng", 10000),
        Food(2, 0,"spaghetti", 20000),
//        Food(3, 0,"mie goreng", 20000),
    )

    fun mainRslt() {
        var exit = false
        do {
            println(
                """    ***** MEWAH MURAH *****
        1. Lihat Makanan
        2. Tambah Makanan
        3. Penjualan
        4. Price Update
        5. Keluar
    ####################### 
""".trimIndent()
            )
            print("ketik kode menu yang diinginkan (1-4): ")
            val command = readLine()
            exit = when (command?.lowercase()) {
                "1" -> tampilkanMenu()
                "2" -> tambahkanMenu()
                "3" -> penjualan(dataMakanan)
                "4" -> false
                "5" -> {
                    logout()
                    println("Terimakasih")
                    true
                }
                else -> {
                    println("Menu tidak ditemukan, keluar dari program")
                    true
                }
            }
        } while (!exit)

    }

    fun tampilkanMenu(): Boolean{
        println("------------Daftar Menu---------------")
        println("${"No.".padEnd(4)} | ${"Nama Makanan".padEnd(20)} | ${"Harga".padEnd(20)}")

        dataMakanan.forEach { makanan ->
            println("${makanan.id.toString().padEnd(4)} | ${makanan.name.kapitalis().padEnd(20)} | ${"Rp ${makanan.price}".padEnd(20)}")
        }
        println("------------**********---------------")
        return false

    }

    fun tambahkanMenu():Boolean{

        println("------------Tambah Makanan---------------")
        print("Masukkan nama makanan: ")

        val namaMakanan = readLine() ?: ""
        print("Masukkan harga makanan: ")
        val hargaMakanan = readLine()!!
        val makanan = Food()

        if (namaMakanan.lowercase().isNotBlank()) {

            makanan.name = namaMakanan
            makanan.price = hargaMakanan.toInt()
        }

        dataMakanan.add(makanan)

        return false

    }

    fun priceUpdate(makanan : Food): Boolean{

        println("1 for update New Price")
        val updateHarga = readLine()!!.toInt()
        if (updateHarga == 1){
            val price= readLine()!!.toInt()?:throw NumberFormatException()
            val priceIndex = dataMakanan.indexOf(makanan)
            dataMakanan.removeAt(priceIndex)
            makanan.price = price
            dataMakanan.add(makanan)
        }else{
            tampilkanMenu()
        }
        return false
    }

    fun penjualan(menu : List<Food>): Boolean {
        tampilkanMenu()

        var userOrders = 0
        var totalOrders = 0

        val itemMenu :List<Food> = menu

        for(i in 0..itemMenu.size - 1){
            itemMenu[i].id = i + 1
            itemMenu[i].jumlah = 0
        }

        do {
            println("${"No.".padEnd(4)} | ${"Menu.".padEnd(20)} | ${"Harga."}")
            itemMenu.forEach { dataMakanan ->
                println("${dataMakanan.id.toString().padEnd(4)} | ${dataMakanan.name.kapitalis().padEnd(20)} | ${"Rp ${dataMakanan.price}".padEnd(20)}")
            }
            println("Pilih No Makanan =")
            val noItem = readLine()!!.toInt()
            for (i in 0..itemMenu.size - 1) {
                if ((noItem == itemMenu[i].id) && (userOrders == 0)) {
                    itemMenu[i].jumlah = itemMenu[i].jumlah + 1
                    userOrders = userOrders + 1
                } else if ((noItem == itemMenu[i].id) && (userOrders >= 1)) {
                    for (j in 0..itemMenu.size - 1) {
                        if (noItem == itemMenu[j].price) {
                            itemMenu[j].jumlah = itemMenu[j].jumlah + 1
                            break
                        }
                    }
                }
            }
            println("Ingin pesan lagi ?")
            println("1. Ya  2.Tidak")
            val moreOrders = readLine()!!.toInt()
        } while (moreOrders == 1)
        println("${"Menu".padEnd(30)} | ${"jumlah".padEnd(10)}")
        for (i in  0..itemMenu.size - 1){
            if (itemMenu[i].price >= 1){
                val total = itemMenu[i].jumlah * itemMenu[i].price
                totalOrders += total
                println("${itemMenu[i].name.lowercase().kapitalis().padEnd(30)} |${itemMenu[i].jumlah} ")
            }
        }
        println("")
        println("${"Total = ".padEnd(10)} ${totalOrders}")
        return false

    }

    fun logout(){
        println("""
         ----- TERIMAKASIH -------
       -- Silakan Datang Kembali --
    """.trimIndent())
    }

}