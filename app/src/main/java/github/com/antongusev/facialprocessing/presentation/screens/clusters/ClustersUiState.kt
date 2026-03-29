package github.com.antongusev.facialprocessing.presentation.screens.clusters

import github.com.antongusev.facialprocessing.interactors.models.FaceCluster

data class ClustersUiState(
    val clusters: List<FaceCluster>
) {
    companion object {
        val EMPTY = ClustersUiState(
            clusters = emptyList()
        )
    }
}
