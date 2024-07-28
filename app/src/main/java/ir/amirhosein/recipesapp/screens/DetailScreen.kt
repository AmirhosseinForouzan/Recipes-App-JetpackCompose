package ir.amirhosein.recipesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.amirhosein.recipesapp.data.baseIngredientsList
import ir.amirhosein.recipesapp.data.recipeInstructionsList

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    photos: Array<Int>,
    names: Array<String>,
    itemIndex: Int?
) {
    var numOfPeople by rememberSaveable { mutableIntStateOf(1) }

    fun calculateIngredients(): Map<String, Pair<Int, Int>> {
        val baseIngredients = baseIngredientsList.getOrElse(itemIndex ?: 0) { emptyMap() }
        return baseIngredients.mapValues { (_, value) ->
            Pair(value.first * numOfPeople, value.second)
        }
    }

    val calculatedIngredients = calculateIngredients()
    val recipeInstructions = recipeInstructionsList.getOrElse(itemIndex ?: 0) { "No instructions available." }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                Box(modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = photos[itemIndex!!]),
                        contentDescription = names[itemIndex],
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                    )
                }
            }
            item {
                Text(text = names[itemIndex!!], fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { if (numOfPeople > 1) numOfPeople-- },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE91E63),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "-", fontSize = 24.sp)
                    }

                    Text(
                        text = "$numOfPeople",
                        fontSize = 24.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                    Button(
                        onClick = { numOfPeople++ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4CAF50),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "+", fontSize = 24.sp)
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Ingredients for $numOfPeople people:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            item {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(calculatedIngredients.toList()) { (ingredient, value) ->
                        val (amount, imageRes) = value
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = imageRes),
                                contentDescription = ingredient,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(4.dp))
                            )
                            Text(
                                text = ingredient,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "$amount ${if (ingredient == "Milk") "ml" else "g"}",
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Recipe Instructions:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            item {
                Text(
                    text = recipeInstructions,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

