import java.util.*

class AddFood {
    fun nambahMenu(){
        val mesin = MesinKasir()
        var makanan: Makanan = Makanan()
        val listNamaMakanan = mesin.dataMakanan

        print("""
        **********************************
        Masukkan makanan: 
    """.trimIndent())
        val input: String? = readLine()?.toLowerCase()
        if (input != null) {
//            if(input.kapital().isNotBlank()){
//                makanan.nama = input
//                listNamaMakanan.add(makanan)
//            }
            if (input.kapital() in listMakan){
                println("""
                Makanan Sudah Ada
            """.trimIndent())
                println("Apakah ingin mengupdate harga? (y/n)")
                val input1 = readLine()?.lowercase()
                if (input1 == "y"){
                    updateHarga(input.kapital())
                }else{
                    nambahMenu()
                }
            } else{
                listMakan.add(input.kapital())
                print("""
        **********************************
        Masukkan harga: 
    """.trimIndent())
                val read = Scanner(System.`in`)
                val harga = read.nextInt()
                listHarga.add(harga)
            }
        }
    }

    fun updateHarga(namaMakanan: String){
        do {
            print("Masukkan harga terbaru: ")
            try {
                val price = readLine()?.toInt() ?: throw NumberFormatException()
                val indexMakanan = listMakan.indexOf(namaMakanan)
                listHarga[indexMakanan] = price
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