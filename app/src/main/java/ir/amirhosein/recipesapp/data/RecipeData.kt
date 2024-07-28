package ir.amirhosein.recipesapp.data

import ir.amirhosein.recipesapp.R

val baseIngredientsList = listOf(
    mapOf(
        "Lamb" to Pair(150, R.drawable.lamb),
        "Rice" to Pair(100, R.drawable.rice),
        "Onion" to Pair(300, R.drawable.onion),
        "Salt" to Pair(12, R.drawable.salt),
        "Pepper" to Pair(5, R.drawable.pepper),
        "Spices" to Pair(10, R.drawable.spices)
    ),
    mapOf(
        "Lamb" to Pair(500, R.drawable.lamb),
        "Onion" to Pair(250, R.drawable.onion),
        "Oil" to Pair(250, R.drawable.oil),
        "Vegetables" to Pair(200, R.drawable.vegetables),
        "Spices" to Pair(10, R.drawable.spices)
    )
    // Add other recipes' base ingredient amounts and images here
)

val recipeInstructionsList = listOf(
    """
    Step 1: You will need ten 1-inch metal skewers.
    Step 2: For best results the meat should be fresh (not previously frozen) and at room temperature.
    Step 3: Finely chop the onion pieces in a food processor until very juicy. Place a fine metal mesh over a bowl and strain the processed onion by pressing it with a spatula. Discard the juice.
    Step 4: Add the ground beef and lamb, minced garlic, salt, spices and egg to the bowl. Knead all of the ingredients for several minutes until the mixture is paste like and sticks together without falling apart.
    Step 5: ....
    """.trimIndent(),
    """
    Step 1: Lorem ipsum dolor sit amet, consectetur adipiscing elit,
    Step 2: Lorem ipsum dolor sit amet, consectetur adipiscing elit,
    Step 3: Lorem ipsum dolor sit amet, consectetur adipiscing elit,
    Step 4: Lorem ipsum dolor sit amet, consectetur adipiscing elit,
    Step 5: Lorem ipsum dolor sit amet, consectetur adipiscing elit,
    Step 6: Lorem ipsum dolor sit amet, consectetur adipiscing elit,
    """.trimIndent()
    // Add other recipes' instructions here
)