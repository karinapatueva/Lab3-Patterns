class Girl private constructor(val age: Int,
                                        val name: String = "unset",
                                        val desires: String = "unset") {
    companion object {
        fun newGirl(vararg desires : String) : Girl {
            return Girl(17, desires = desires.joinToString(", "))
        }
        fun newGirl(name : String) : Girl {
            return Girl(17, name = name)
        }
    }
}

fun main() {
    val anna = Girl.newGirl("Anna")
    val lisa = Girl.newGirl("chocolate", "coffee")

    println(anna.name)
    println(anna.desires)
    println(lisa.name)
    println(lisa.desires)
}