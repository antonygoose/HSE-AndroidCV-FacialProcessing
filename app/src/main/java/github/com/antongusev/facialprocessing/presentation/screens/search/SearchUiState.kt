package github.com.antongusev.facialprocessing.presentation.screens.search

import android.graphics.Bitmap
import github.com.antongusev.facialprocessing.interactors.models.FaceCluster
import github.com.antongusev.facialprocessing.interactors.models.FaceSearchAttribute
import github.com.antongusev.facialprocessing.interactors.models.MediaEntry

data class SearchUiState(
    val faceCluster: FaceCluster?,
    val searchAttributeTypes: List<FaceSearchAttribute.Type>,
    val images: List<MediaEntry>,
) {
    companion object {
        val EMPTY = SearchUiState(
            faceCluster = null,
            searchAttributeTypes = emptyList(),
            images = emptyList()
        )
    }
}
