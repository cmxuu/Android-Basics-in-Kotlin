/**
* Program to order different types of noodle soup
*  1. class and list
*  2. different ways to declare
*/

/* Order */
class Order(val orderNumber: Int) {
    val itemList: MutableList<Item> = mutableListOf()
    var total = 0
    
    fun addItem(newItem: Item): Order {
        itemList.add(newItem)
        return this
    }
    
    fun addAll(newIem: List<Item>): Order{
        itemList.addAll(newIem)
        return this
    }
    
    fun print(){
        println("Order #${orderNumber}")
        for (item in itemList) {
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: ${total}")
    }
}

/* Item */
open class Item(val name: String, val price: Int)
class Noodles(): Item("Noodles", 10) {
    override fun toString(): String {
        return name
    }
}
class Vegetables(vararg val toppings: String): Item("Vegetables", 5) {
    override fun toString(): String {
        if (toppings.isEmpty()){
        	return "$name Chef's Choice"  
        } else {
            return name + " " + toppings.joinToString()
        }
    }
}

/* Main */
fun main() {
    val ordersList = mutableListOf<Order>()

    // Add an item to an order
    val order1 = Order(1)
    order1.addItem(Noodles())
    ordersList.add(order1)

    // Add multiple items individually
    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    ordersList.add(order2)

    // Add a list of items at one time
    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
    ordersList.add(order3)
    
    // Use builder pattern -> By .add return this
    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
	ordersList.add(order4)
    
    // Create and add order directly
    ordersList.add(
    	Order(5)
    		.addItem(Noodles())
    		.addItem(Vegetables())
    		.addItem(Vegetables("Spinach")))
    
    for (order in ordersList) {
        order.print()
        println()
    }
    	
}