class UncertainAnimal {
    var makeSound = fun() {
        println("Meow!")
    }
}

fun main() {
    val someAnimal = UncertainAnimal()

    someAnimal.makeSound()
    someAnimal.makeSound = fun() {
        println("Woof!")
    }
    someAnimal.makeSound()
}
