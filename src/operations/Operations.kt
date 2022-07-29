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

    /*Get all products sold*/
    val receipts = store.receipts //Fetch the receipts
    val productsList = receipts.map { it.products } // List<List<Product>>
    println(productsList)
    /*You can improve this further by using 'flatmap'*/
    val allProducts = receipts.flatMap { it.products }
    /*flatmap transform elements and flattens them to a single list*/
    println(allProducts)
    /*Prices of products or their sum*/
    val allProductEarnings = receipts.flatMap { it.products }
        .map { it.price }
        .sumByDouble { it }
    println(allProductEarnings)

    //TODO : Filtering and Grouping Data
    /* filtering by condition */
    val paidReceipts = receipts.filter { it.isPaid }
    println(paidReceipts)

    //grouping values by condition
    val paidUnpaid = receipts.partition { it.isPaid }
    val (paid, unpaid) = paidUnpaid
    println(paid)
    println(unpaid)

    val groupedByWorker = receipts.groupBy { it.seller } // Map<Worker, List<Receipt>>
    println(groupedByWorker)

    //TODO : Validating data
    val areThereNoReceipts = receipts.isEmpty()
    val areAllPaid = receipts.all { it.isPaid }
    val nonePaid = receipts.none { it.isPaid }
    val isAtleastOnePaid = receipts.any { it.isPaid }

    //TODO : Looking up data
    val receiptByIndex = receipts[0] // receipt.get(0)
    val firstPaidReceipt = receipts.first { it.isPaid } //it can crash if there is none
    val firstPaidReceiptOrNull = receipts.firstOrNull { it.isPaid } //either is paid or null
    val lastByPredicate = receipts.last { !it.isPaid } //last which is not paid
}