package test

object ObjectTest {
    val NAME = "ls"
    fun getAge() = 10
    @JvmField
    val address = "beijing"
    const val city = "beijing"
    @JvmStatic
    fun getStreet() = "12"
    val time = System.currentTimeMillis()

    const val time1 = "123"
}