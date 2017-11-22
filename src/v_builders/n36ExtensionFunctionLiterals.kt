package v_builders

import util.TODO
import util.doc36

fun todoTask36(): Nothing = TODO(
    """
        Task 36.
        Read about extension function literals.
        You can declare `isEven` and `isOdd` as values, that can be called as extension functions.
        Complete the declarations below.
    """,
    documentation = doc36()
)

fun task36(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this % 2 == 0 }
    val isOdd: Int.() -> Boolean = { this % 2 == 1 }

    fun Int.isEven2(): Boolean = this % 2 == 0
    fun Int.isOdd2(): Boolean = this % 2 == 1

    var b = 23.isEven2()
    var c = 23.isOdd2()

    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}



