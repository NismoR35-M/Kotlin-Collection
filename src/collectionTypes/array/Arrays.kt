package collectionTypes.array

fun main() {
  val arrayOfNumbers = arrayOf(2, 3, 5, 6, 10)
  //iterate using forEach
  arrayOfNumbers.forEach { number -> println(number) }

  //or use for loop
  for (number in arrayOfNumbers){
    println(number)
  }

  //Accessing an array element
  val firstValue = arrayOfNumbers[0]
  println(firstValue)

  //to change value of first element
  arrayOfNumbers[0] = 38
  val newFirstElement = arrayOfNumbers[0]
  println(newFirstElement)

  //array syntax
  val someOtherArray = Array(5) {""}
  println(someOtherArray)

  //TODO : Check 'varags' feature.
}