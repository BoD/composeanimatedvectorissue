package com.example.composeanimatedvectorissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeanimatedvectorissue.ui.theme.ComposeAnimatedVectorIssueTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationGraphicsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimatedVectorIssueTheme {
                    var atEnd by remember { mutableStateOf(false) }
                    val animatedImageVector = AnimatedImageVector.animatedVectorResource(R.drawable.avd_bookmark)
                    FloatingActionButton(
                        onClick = {
                            atEnd = !atEnd
                        }
                    ) {
                        Image(
                            painter = rememberAnimatedVectorPainter(animatedImageVector, atEnd),
                            contentDescription = null
                        )
                    }
            }
        }
    }
}
