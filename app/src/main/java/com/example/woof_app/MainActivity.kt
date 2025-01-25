package com.example.woof_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.woof_app.R

@Composable
fun PetProfileApp() {
    Scaffold {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(petProfiles) { profile ->
                PetProfileCard(profile)
            }
        }
    }
}


@Composable
fun PetProfileCard(profile: PetProfile) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = profile.imageResource),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = profile.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "${profile.age} years old",
                    color = Color.Gray
                )
            }
            IconButton(
                onClick = { /* toggle expand/collapse */ }
            ) {
                Icon(
                    imageVector = if (profile.isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = null
                )
            }
        }
        if (profile.isExpanded) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(profile.about)
            }
        }
    }
}

data class PetProfile(
    val name: String,
    val age: Int,
    val about: String,
    val imageResource: Int,
    var isExpanded: Boolean = false
)

private val Icons.Filled.ExpandMore: ImageVector
    get() {TODO("Not yet implemented")}
private val Icons.Filled.ExpandLess: ImageVector
    get() {
        TODO("Not yet implemented")
    }
val petProfiles = listOf(
    PetProfile(
        name = "Koda",
        age = 2,
        about = "Eating treats on the terrace",
        imageResource = R.drawable.koda
    ),
    PetProfile(
        name = "Lola",
        age = 16,
        about = "Barking at Daddy",
        imageResource = R.drawable.lola
    ),
    PetProfile(
        name = "Frankie",
        age = 2,
        about = "Unknown",
        imageResource = R.drawable.frankie
    ),
    PetProfile(
        name = "Nox",
        age = 8,
        about = "Unknown",
        imageResource = R.drawable.nox
    ),
    PetProfile(
        name = "Faye",
        age = 8,
        about = "Unknown",
        imageResource = R.drawable.faye
    ),
    PetProfile(
        name = "Bella",
        age = 14,
        about = "Unknown",
        imageResource = R.drawable.bella
    )
)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PetProfilePreview() {
    PetProfileApp()
}