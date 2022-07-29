package collectionTypes.set

import com.sun.corba.se.spi.orbutil.threadpool.Work

/*
Set is a collection of elements where each of the elements is unique and there
are no duplicates.Useful when you need to filter out duplicates.
Sets are more advanced version of lists with internal filtering of data.
*/

data class Worker(
    val id: Int,
    val name: String
)

fun main() {
    val workers = mutableSetOf(
        Worker(id = 5, name = "Philip"),
        Worker(id = 6, name = "Watson"),
        Worker(id = 7, name = "Vossen"),
        Worker(id = 5, name = "Philip") //duplicate.
    )
    //set uses hashCode() internally to filter out duplicates.
    println(workers) //[Worker(id=5, name=Philip), Worker(id=6, name=Watson), Worker(id=7, name=Vossen)]
    val removedWorker = Worker(id = 5, name = "Philip")
    workers.remove(removedWorker)
    println(workers)
}