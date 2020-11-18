class DivZeroException: Exception("divided by zero")

fun divide(x: Int, y: Int): Int {
    tailrec fun div(x: Int, y: Int, quot: Int = 0): Int {
        return when {
            y == 0 -> throw DivZeroException()
            x < y -> quot
            else -> div(x - y, y, quot + 1)
        }
    }

    val sign: Lazy<Int> = lazy { if ((x < 0) || (y < 0)) -1 else 1 }
    return div(kotlin.math.abs(x), kotlin.math.abs(y)) * sign.value
}

// Main without error handling
val (x, y) = Pair(args[0].toInt(), args[1].toInt())
println("${x} / ${y} = ${divide(x, y)}")
