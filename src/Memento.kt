data class Memento(val state: String)

class Class(var state: String) {

    fun createMemento(): Memento {
        return Memento(state)
    }

    fun restore(memento: Memento) {
        state = memento.state
    }
}

class Saver {
    private val mementoList = ArrayList<Memento>()

    fun saveState(state: Memento) {
        mementoList.add(state)
    }

    fun restore(index: Int): Memento {
        return mementoList[index]
    }
}

fun main() {
    val clazz = Class("initial state")
    val saver = Saver()
    saver.saveState(clazz.createMemento())

    clazz.state = "State #1"
    clazz.state = "State #2"
    saver.saveState(clazz.createMemento())
    clazz.state = "State #3"
    println("Current State: " + clazz.state)

    clazz.state = saver.restore(1).state
    println("Current State: " + clazz.state)
}