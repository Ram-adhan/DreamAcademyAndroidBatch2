package D15

class Food (val name: String, var price: Int) {

    constructor(name: String): this(name,0){

    }

    /*var price: Int = 0
        set(value) {
            println("Harga Lama: $field")
            field = value
            println("Harga Baru: $price")
            //logic lain
        }
        get() {
            println("Harga Sekarang: $field")
            return field
        }*/

/*    fun updatePrice(price:Int) {
        this.price = price
    }*/

/*    override fun toString(): String {
        return "nama makanan: ${this.name}, harga:$price"
    }*/
}