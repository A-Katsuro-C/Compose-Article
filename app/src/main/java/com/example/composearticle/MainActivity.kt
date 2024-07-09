package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Article(
                        title = stringResource(R.string.title),
                        body1 = stringResource(R.string.body1),
                        body2 = stringResource(R.string.body2),
                        image = painterResource(R.drawable.bg_compose_background)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(title: String, body1: String, body2: String, image: Painter, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp),
        )
        Text(
            text = body1,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
            ),
            textAlign = TextAlign.Justify,

        )
        Text(
            text = body2,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Compose Article",
    )
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        Article(
            title = stringResource(R.string.title),
            body1 = stringResource(R.string.body1),
            body2 = stringResource(R.string.body2),
            image = painterResource(R.drawable.bg_compose_background),
        )
    }
}