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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.domain.Item

val favoriteList = listOf(
    Item("Short mantras", getImage("1001682")),
    Item("Stress and axiety", getImage("1557238")),
    Item("Overwhelmed", getImage("3560044")),
)

val favoriteList2 = listOf(
    Item("Nature meditations", getImage("3571551")),
    Item("Self-massage", getImage("1029604")),
    Item("Nightly wind down", getImage("924824")),
)

val bodyList = listOf(
    Item("Inversions", getImage("317157")),
    Item("Quick yoga", getImage("1812964")),
    Item("Stretching", getImage("4056723")),
    Item("Tabata", getImage("4662438")),
    Item("HIIT", getImage("999309")),
    Item("Pre-natal yoga", getImage("396133")),
)

val mindList = listOf(
    Item("Meditate", getImage("3822622")),
    Item("With kids", getImage("3094230")),
    Item("Aromatherapy", getImage("4498318")),
    Item("On the go", getImage("1241348")),
    Item("With pets", getImage("4056535")),
    Item("High stress", getImage("897817")),
)

private fun getImage(id: String) =
    "https://images.pexels.com/photos/$id/pexels-photo-$id.jpeg?cs=srgb&h=300&w=300"
