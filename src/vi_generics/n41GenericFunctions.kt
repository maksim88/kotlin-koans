package vi_generics

import util.TODO
import java.util.*
import kotlin.collections.ArrayList
import kotlin.jvm.internal.Intrinsics

fun task41(): Nothing = TODO(
    """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    //task41()
    val list = intArrayOf(1,2,3).toCollection(ArrayList())
    val set = setOf(1,2,3).toCollection(ArrayList())
    //listOf<String>("123", "234").toCollection()
    return partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
   // task41()
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}

fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(first: C,
                                                             second: C,
                                                             predicate: (T) -> Boolean):
        Pair<C, C> {
    for (element in this) {
        if (predicate(element)) {
            first.add(element)
        } else {
            second.add(element)
        }
    }
    return Pair(first, second)
}

fun String.bla()  = first()

