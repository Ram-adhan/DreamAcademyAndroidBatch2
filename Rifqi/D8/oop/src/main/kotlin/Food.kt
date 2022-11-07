
class Food(val nama : String) {

    constructor(name: String, price : Int):this(name){
        this.price = price
    }
    var price : Int = 0
        set(value) {
            println("Harga lama : $field")
            field = value
            println("Harga baru : $field")
        }
        get() {
            println("Harga sekarang : $field")
            return field

        }

    fun updatePrice(price : Int ){
        this.price = price
    }

    override fun toString(): String{
        return "nama makanan: ${this.nama}, harga: $price"
    }

}