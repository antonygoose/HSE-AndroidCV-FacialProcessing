package github.com.antongusev.facialprocessing.interactors.models

import android.graphics.Bitmap

data class FaceCluster(
    val clusterId: Int,
    val sampleFace: Bitmap,
)
