package github.com.antongusev.facialprocessing.utils

fun <T> List<T>.sample(n: Int): List<T> {
    val shuffledList = shuffled()
    if (shuffledList.size < n) {
        return shuffledList
    }
    return shuffledList.subList(0, n)
}
