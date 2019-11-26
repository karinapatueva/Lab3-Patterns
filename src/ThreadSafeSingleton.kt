class Singleton private constructor(var value: String) {

    companion object {
        @Volatile private var instance: Singleton? = null

        fun getInstance(value: String): Singleton? {
            var result = instance
            if (result == null)
            {
                synchronized (Singleton::class.java) {
                    result = instance
                    if (result == null)
                    {
                        result = Singleton(value)
                        instance = result
                    }
                }
            }
            return instance
        }
    }
}

class ThreadFoo: Runnable {
    override fun run() {

        val singleton = Singleton.getInstance("FOO")
        println(singleton!!.value)
    }
}

class ThreadBar: Runnable {
    override fun run() {

        val singleton = Singleton.getInstance("BAR")
        println(singleton!!.value)
    }
}

fun main(args: Array<String>) {
    println("Must be equal: " + "\n")

    val threadFoo = Thread(ThreadFoo())
    val threadBar = Thread(ThreadBar())
    threadFoo.start()
    threadBar.start()
}

