package com.sample.catdetails.view.catdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sample.catdetails.CatItem
import com.sample.catdetails.view.common.AppTopBar
import com.sample.catdetails.view.common.CommonImage

@Composable
fun DetailsOfCat(catItem: CatItem, onBackClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AppTopBar(
            isBackButtonRequired = true,
            text = catItem.name,
            onBackClicked = {
                onBackClicked()
            })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            val imageModifier = Modifier
                .padding(start = 0.dp, top = 10.dp, end = 0.dp, bottom = 0.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(8.dp))

            CommonImage(
                url = catItem.image?.url,
                contentDescription = catItem.name + " Details",
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))
            CustomText("Origin:", MaterialTheme.typography.titleSmall)
            CustomText(catItem.origin, MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(12.dp))
            CustomText("Temperament:", MaterialTheme.typography.titleSmall)
            CustomText(catItem.temperament, MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(12.dp))
            CustomText("Life Span:", MaterialTheme.typography.titleSmall)
            CustomText(catItem.lifeSpan, MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(12.dp))
            CustomText("Description:", MaterialTheme.typography.titleSmall)
            CustomText(catItem.description, MaterialTheme.typography.bodyMedium)
        }
    }
}


@Composable
fun CustomText(text: String, style: TextStyle) {
    Text(
        text = text,
        style = style
    )
}