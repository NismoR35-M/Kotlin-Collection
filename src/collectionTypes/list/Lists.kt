package collectionTypes.list

fun main() {
    val list = listOf(2, 3, 6, 9, 12)
    println(list) //prints out number bcoz all true collection overrides 'toString()'

    //TODO: You can change the size and contents of Kotlin collection which starts with 'Mutable'
    val anotherList = mutableListOf(1,2,3,4,5)
    anotherList[2] = 200
    println(anotherList[2]) //200
    anotherList.add(index = 3, element = 500) //dynamic size feature of a list
    println(anotherList[3]) //500
    anotherList.remove(5)
    println(anotherList) // [1, 2, 200, 500, 4]
    anotherList.removeAt(0)
    println(anotherList) // [2, 200, 500, 4]
}