class ShowMenu {
    val mesin = MesinKasir()
    val isiMenu = mesin.dataMakanan
    fun panggilMenu(): String{
        for(indx in isiMenu.indices){
            println("""
                ${listMakan[indx].padEnd(18).capitalize()} Rp.${listHarga[indx]}
            """.trimIndent())
        }
        return ("")
    }
}