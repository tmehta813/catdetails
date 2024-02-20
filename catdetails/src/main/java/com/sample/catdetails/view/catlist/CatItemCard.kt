package com.sample.catdetails.view.catlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sample.catdetails.CatItem
import com.sample.catdetails.view.common.CommonImage

@Composable
fun CatItemCard(catItem: CatItem, onItemClick: (CatItem) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(catItem) }
            .fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            val imageModifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .graphicsLayer {
                    // Apply center crop
                    clip = true
                }
            CommonImage(
                url = catItem.image?.url,
                contentDescription = catItem.name,
                contentScale = ContentScale.Crop,
                modifier = imageModifier
            )
        }
        Text(
            text = catItem.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}