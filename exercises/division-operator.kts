class DivZeroException: Exception("divided by zero")

fun divide(x: Int, y: Int): Int {
    tailrec fun div(x: Int, y: Int, quot: Int = 0): Int {
        return when {
            y == 0 -> throw DivZeroException()
            x < y -> quot
            else -> div(x - y, y, quot + 1)
        }
    }

    val neg: Lazy<Int> = lazy { if ((x < 0) || (y < 0)) -1 else 1 }
    return div(kotlin.math.abs(x), kotlin.math.abs(y)) * neg.value
}

// not handling overflow integer
fun divideBinarySearch(x: Long, y: Long): Long {
    // positive value only
    fun div(x: Long, y: Long): Long {
        if (y == 0L) throw DivZeroException()
        if (x < y) return 0

        var multiple = 1L
        var sum = y
        while ((sum + sum) <= x) {
            sum += sum
            multiple += multiple
        }

        // remainder => re-apply the search recursively
        return div(x - sum, y) + multiple
    }

    val neg: Lazy<Int> = lazy { if ((x < 0) || (y < 0)) -1 else 1 }
    return div(kotlin.math.abs(x), kotlin.math.abs(y)) * neg.value
}


// Main without error handling
// kotlinc -script division-operator.kts -- <x> <y>
// val (x, y) = Pair(args[0].toInt(), args[1].toInt())
// println("${x} / ${y} = ${divide(x, y)}")
