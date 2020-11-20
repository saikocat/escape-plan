/*
class Queue {
    Queue push(int value);
    Pair<Queue, int> pop();
};
Queue qq = new Queue()
eq1 = qq.push(234)
eq2 = eq1.push(567)
assert(eq2.pop().second == 567)
assert(eq2.pop().first.pop().second == 234)
assert(eq2.pop().first.pop().empty())
assert(eq1.pop().second == 234)
assert(eq1.pop().first.empty())
*/

// Kotlin list is immutable
class Queue(val incoming: List<Int>, val outgoing: List<Int>) {
    constructor(): this(emptyList(), emptyList())

    // Helper
    fun <T> List<T>.head(): T = first()

    // subList is a view and lazy
    fun <T> List<T>.tail(): List<T> =
        if (isEmpty()) throw IllegalStateException("fail to get tail of an empty list")
        else subList(1, count())

    fun isEmpty(): Boolean = incoming.isEmpty() && outgoing.isEmpty()

    fun push(value: Int): Queue = Queue(listOf(value) + incoming, outgoing)

    fun pop(): Pair<Queue, Int> = when {
        outgoing.isEmpty() && !incoming.isEmpty() -> {
            val rev = incoming // .asReversed()
            Pair(Queue(emptyList(), rev.tail()), rev.head())
        }
        !outgoing.isEmpty() -> Pair(Queue(incoming, outgoing.tail()), outgoing.head())
        else -> throw NoSuchElementException("dequeue on empty queue")
    }

    override fun toString(): String =
        "Queue{incoming:${incoming}; outgoing:${outgoing}}"
}

// Enable assertion in JVM
// $ kotlinc -J-ea -script 
val qq = Queue()
val eq1 = qq.push(234)
val eq2 = eq1.push(567)
println(qq)
println(eq1)
println(eq2)
println(eq2.pop())
assert(eq2.pop().second == 567)
assert(eq2.pop().first.pop().second == 234)
assert(eq2.pop().first.pop().first.isEmpty())
assert(eq1.pop().second == 234)
assert(eq1.pop().first.isEmpty())
