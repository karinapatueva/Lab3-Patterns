class Account(private val config: Builder) {

    fun info(): String{
        return config.name + " " + config.nickname
    }

    fun isEmail(): Boolean {
        return config.nickname?.contains("@") ?: false
    }

    companion object Builder {
        private var name: String? = null
        private var nickname: String? = null

        fun name(value: String) = apply { name = value }
        fun nickname(value: String) = apply { nickname = value }

        fun build(): Account {
            return Account(this)
        }
    }
}

fun main() {
    val account = Account.Builder
        .name("Sasha")
        .nickname("sasha@tinkoff")
        .build()


    println(account.info())
    println(account.isEmail())
}
