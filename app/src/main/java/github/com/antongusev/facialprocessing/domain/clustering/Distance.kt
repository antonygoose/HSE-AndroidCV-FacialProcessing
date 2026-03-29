package github.com.antongusev.facialprocessing.domain.clustering

interface Distance<V> {

    fun calculateDistance(one: V, another: V): Double

}
