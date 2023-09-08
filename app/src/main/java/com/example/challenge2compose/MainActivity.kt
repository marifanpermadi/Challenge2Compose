package com.example.challenge2compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2compose.ui.FoodHorizontal
import com.example.challenge2compose.ui.FoodVertical
import com.example.challenge2compose.ui.theme.Challenge2ComposeTheme
import com.example.challenge2compose.ui.theme.LightMagenta

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column( modifier = Modifier.fillMaxSize()) {
                Challenge2ComposeTheme {
                    Texting()
                    Banner()
                    HorizontalImageList()
                    RecommendedFoodSection()
                }
            }
        }
    }
}



//@Preview(showBackground = true)
@OptIn(ExperimentalTextApi::class)
@Composable
fun Texting() {
    val gradientColor = listOf(LightMagenta, Color.Blue, Color.Magenta)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(10.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                ) {
            Text(
                text = "Hello Binarian,",
                style = TextStyle(
                    Brush.linearGradient(gradientColor)
                ),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_cart),
                    contentDescription = null,
                    tint = Color.Magenta
                )
                Icon(
                    painterResource(id = R.drawable.ic_account),
                    contentDescription = null,
                    tint = Color.Magenta
                )
            }

        }
        Text(
            text = "Feeling hungry?",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 12.dp)
        )


    }
}

@Preview(showBackground = true)
@Composable
fun Banner() {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = LightMagenta
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp)

    ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.burger),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                )

                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Discount 30%",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text (
                        text = "Order now and get your dream food!"
                    )
                }

            }
    }
}

@Composable
fun ImageWithDescriptionItem(imageWithDescription: FoodHorizontal) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageWithDescription.imageResource),
            contentDescription = null, // Provide a meaningful content description
            modifier = Modifier
                .size(60.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = imageWithDescription.description,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Composable
fun HorizontalImageList() {
    val imagesWithDescriptions = listOf(
        FoodHorizontal(R.drawable.burger, "Burger"),
        FoodHorizontal(R.drawable.mie, "Mie"),
        FoodHorizontal(R.drawable.salad, "Salad"),
        FoodHorizontal(R.drawable.pizza, "Pizza"),
        FoodHorizontal(R.drawable.satay, "Satay"),
        FoodHorizontal(R.drawable.jus, "Jus")
    )

    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imagesWithDescriptions) { imageWithDescription ->
            ImageWithDescriptionItem(imageWithDescription)
        }
    }
}

@Composable
fun FoodItemCard(foodItem: FoodVertical) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(140.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = LightMagenta),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = foodItem.imageResource),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Text(
                text = foodItem.name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "$${foodItem.price}",
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun RecommendedFoodSection() {
    val recommendedFood = listOf(
        FoodVertical("Pizza", "9.88", R.drawable.pizza),
        FoodVertical("Burger", "8.88", R.drawable.burger),
        FoodVertical("Mie", "7.88", R.drawable.mie),
        FoodVertical("Jus", "6.88", R.drawable.jus),
        FoodVertical("Satay", "5.88", R.drawable.satay),
        FoodVertical("Salad", "4.88", R.drawable.salad),
        FoodVertical("Soto", "3.88", R.drawable.soto),
        FoodVertical("Salad", "2.88", R.drawable.bakso),

    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Recommended food:",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(recommendedFood) { foodItem ->
                FoodItemCard(foodItem)
            }
        }
    }
}