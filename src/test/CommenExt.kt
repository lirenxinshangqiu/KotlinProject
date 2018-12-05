package test

inline fun runtimeCal(method: () -> Unit) {
    val startTime = System.currentTimeMillis()
    method()
    println("执行时间：${System.currentTimeMillis() - startTime}")
}