object NewSingleton {
    var value : String = "Just a value"
}

fun main() {
    val single = NewSingleton;
    val singleNew = NewSingleton;

    single.value = "New value"
    singleNew.value = "Completely new value"

    println(single.value);
}