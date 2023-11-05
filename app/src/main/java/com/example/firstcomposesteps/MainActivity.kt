package com.example.firstcomposesteps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstcomposesteps.ui.theme.FirstComposeStepsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeStepsTheme {
                val viewModel = viewModel<MainViewModel>()
                val changeColorLambda = remember<(Color) -> Unit> {
                    {
                        viewModel.changeColor(it)
                    }
                }

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                )
                {
                    RgbSelector(
                        color = viewModel.color,
                        onColorClick = changeColorLambda
                    )
                }
            }
        }
    }
}
