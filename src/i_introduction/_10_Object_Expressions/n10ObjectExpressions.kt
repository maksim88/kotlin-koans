package i_introduction._10_Object_Expressions

import util.TODO
import util.doc10
import java.util.*
import kotlin.Comparator

fun todoTask10(): Nothing = TODO(
    """
        Task 10.
        Read about object expressions that play the same role in Kotlin as anonymous classes in Java.

        Add an object expression that provides a comparator to sort a list in a descending order using 'java.util.Collections' class.
        In Kotlin you use Kotlin library extensions instead of java.util.Collections,
        but this example is still a good demonstration of mixing Kotlin and Java code.
    """,
    documentation = doc10()
)


fun task103() : Comparator<Int> {
    val a = object: Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o2.compareTo(o1)
        }
    }
    return a
}

fun task104() : Comparator<Int> {
    val a = Comparator<Int> { o1, o2 -> o2.compareTo(o1) }
    return a
}

fun task105() : Comparator<Int> {
    return Comparator { o1, o2 -> o2.compareTo(o1) }
}

fun task106() : Comparator<Int> = Comparator { o1, o2 -> o2.compareTo(o1)}

fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, task106())
    return arrayList
}