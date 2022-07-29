
package collectionTypes.map

fun main() {
    val httpHeaders = mutableMapOf(
        "Authorization" to "api-key",
        "contentType" to "application/json",
        "userLocale" to "Norway"
    )
    //Change values by its keys
    httpHeaders["Authorization"] = "anotherThing"
    println(httpHeaders["Authorization"]) //anotherThing
    println(httpHeaders)

    //TODO : Iterating through Maps in kotlin is a bit special
    httpHeaders.forEach{key, value -> println("value for key $key is $value")}
}