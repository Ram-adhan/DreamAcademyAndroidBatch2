import java.util.*

class DatabaseMakanan {
    var listMenu = mutableListOf(
        Makanan("Ayam", 20000),
        Makanan("Wagyu", 300000),
        Makanan("Nasi Padang", 25000)
    )

    fun panggilMenu(): String{
        listMenu.forEach{makanan ->
            println("""
                ${makanan.nama.padEnd(18).capitalize()} Rp.${makanan.harga}
            """.trimIndent())
        }
        return ("")
    }

    fun nambahMenu(){
        var newMakanan: Makanan = Makanan()

        print("""
        **********************************
        Masukkan makanan: 
    """.trimIndent())
        val input: String? = readLine()?.toLowerCase()?.kapital()

        val existingMakanan: Makanan? = listMenu.find {makanan ->
            makanan.nama == input
        }

        if (existingMakanan != null) {
            println("""
                Makanan Sudah Ada
            """.trimIndent())
            println("Apakah ingin mengupdate harga? (y/n)")
            val input1 = readLine()?.lowercase()
            if (input1 == "y"){
                updateHarga(existingMakanan)
            }else{
                nambahMenu()
            }
            }else{
                newMakanan.nama = input ?: ""
                print("""
        **********************************
        Masukkan harga: 
    """.trimIndent())
                val read = Scanner(System.`in`)
                val harga = read.nextInt()
                newMakanan.harga = harga
                listMenu.add(newMakanan)
            }
        }

    fun updateHarga(makanan: Makanan){
        do {
            print("Masukkan harga terbaru: ")
            try {
                val price = readLine()?.toInt() ?: throw NumberFormatException()
                val indexHarga = listMenu.indexOf(makanan)
                listMenu.removeAt(indexHarga)
                makanan.harga = price
                listMenu.add(makanan)
                break
            } catch (e: NumberFormatException) {
                println("""
                            yang anda masukkan bukan angka
                            silahkan masukkan ulang
                        """.trimIndent())
            }
        } while (true)
    }
}