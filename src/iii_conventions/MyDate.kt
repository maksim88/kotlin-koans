package iii_conventions

import java.util.*
import kotlin.NoSuchElementException

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year != other.year) return year - other.year
        if (month != other.month) return month - other.month
        else return dayOfMonth - other.dayOfMonth
    }
}

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(interval: TimeInterval): MyDate = addTimeIntervals(interval, 1)

operator fun TimeInterval.times(number: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, number)

operator fun MyDate.plus(interval: RepeatedTimeInterval): MyDate = addTimeIntervals(interval.ti, interval.n)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = MyDateIterator(this)

    override fun contains(value: MyDate): Boolean {
        //return value in start..endInclusive // N26: why does the IDE tell me I can refactor that?
        return start <= value && endInclusive >= value
    }
}

class MyDateIterator(private val range: DateRange) : Iterator<MyDate> {
    var currentDate = range.start
    override fun hasNext(): Boolean {
        return currentDate <= range.endInclusive
    }

    override fun next(): MyDate {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val result = currentDate
        currentDate = currentDate.addTimeIntervals(TimeInterval.DAY, 1)
        return result
    }
}
