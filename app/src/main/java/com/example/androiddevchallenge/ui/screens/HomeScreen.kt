/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.bodyList
import com.example.androiddevchallenge.data.favoriteList
import com.example.androiddevchallenge.data.favoriteList2
import com.example.androiddevchallenge.data.mindList
import com.example.androiddevchallenge.domain.Item
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.primary,
                elevation = 8.dp
            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Spa,
                            contentDescription = "HOME",
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = {
                        Text(
                            "HOME", style = MaterialTheme.typography.caption
                        )
                    },
                    selected = true,
                    onClick = {}
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "PROFILE",
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = { Text("PROFILE", style = MaterialTheme.typography.caption) },
                    selected = false,
                    onClick = {}
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                backgroundColor = MaterialTheme.colors.primary,
            ) { Icon(Icons.Default.PlayArrow, contentDescription = "Play") }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
    ) {
        Surface(color = MaterialTheme.colors.background) {
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(top = 56.dp),
            ) {
                TextField(
                    value = "Search",
                    singleLine = true,
                    onValueChange = { },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                        .height(56.dp)
                        .clip(shapes.small),
                    textStyle = MaterialTheme.typography.body1,
                )
                Text(
                    text = "FAVORITE COLLECTIONS",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp)
                        .padding(start = 16.dp)
                )
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp),
                    contentPadding = PaddingValues(start = 16.dp),
                    content = {
                        items(favoriteList) {
                            FavoriteItem(it)
                        }
                    }
                )
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp),
                    contentPadding = PaddingValues(start = 16.dp),
                    content = {
                        items(favoriteList2) {
                            FavoriteItem(it)
                        }
                    }
                )
                Text(
                    text = "ALIGN YOUR BODY",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 48.dp)
                        .padding(start = 16.dp)
                )
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp),
                    contentPadding = PaddingValues(start = 16.dp),
                    content = {
                        items(bodyList) {
                            AlignItem(it)
                        }
                    }
                )
                Text(
                    text = "ALIGN YOUR MIND",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 48.dp)
                        .padding(start = 16.dp)
                )
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp),
                    contentPadding = PaddingValues(start = 16.dp),
                    content = {
                        items(mindList) {
                            AlignItem(it)
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun FavoriteItem(item: Item) {
    Row(
        modifier = Modifier
            .width(192.dp)
            .height(56.dp)
            .padding(end = 8.dp)
            .clip(shape = shapes.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            data = item.imageUrl,
            contentDescription = item.title,
            fadeIn = true,
            modifier = Modifier.size(56.dp),
            contentScale = ContentScale.Crop,
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                item.title,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Composable
private fun AlignItem(item: Item) {
    Column(
        modifier = Modifier.padding(end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            data = item.imageUrl,
            contentDescription = item.title,
            fadeIn = true,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        Text(
            item.title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(top = 24.dp)
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}
