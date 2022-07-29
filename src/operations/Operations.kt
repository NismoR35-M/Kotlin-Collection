

package operations

data class Product(
    val id: Int,
    val name: String,
    val price: Double
)

class Receipt(
    val id: Int,
    val seller: Worker,
    val products: List<Product>,
    val isPaid: Boolean = false
)

class Store(
    val receipts: List<Receipt>,
    val workers:List<Worker>
)

data class Worker(
    val id: Int,
    val name: String
)

fun beer() = Product(id = 2, name = "Beer, light, 0.5l", price = 7.5)
fun coffee() = Product(id = 3, name = "Ground coffee 1kg", price = 5.0)
fun bread() = Product(id = 1, name = "Gluten-free bread, 1kg", price = 5.0)

fun main() {
    val firstWorker = Worker(id = 1, name = "Filip")
    val secondWorker = Worker(id = 2, name = "Chris")

    val store = Store(
        receipts = listOf(
            Receipt(
                id = 1,
                seller = firstWorker,
                products = listOf(bread(), bread(), bread(), coffee(), beer()),
                isPaid = true
            ),

            Receipt(
                id = 2,
                seller = secondWorker,
                products = listOf(coffee(), coffee(), beer(), beer(), beer(), beer(), beer()),
                isPaid = false
            ),

            Receipt(
                id = 3,
                seller = secondWorker,
                products = listOf(beer(), beer(), bread()),
                isPaid = false
            )
        ),

        workers = listOf(firstWorker, secondWorker)
    )
}