package ph.mart.todo.data

import ph.mart.todo.R

data class Fruit(
    val id: String,
    val name: String,
    val icon: Int
)

val fruits = listOf(
    Fruit("1", "Apple", R.drawable.baseline_add_reaction_24),
    Fruit("2", "Banana", R.drawable.baseline_alarm_24),
    Fruit("3", "Orange", R.drawable.baseline_animation_24),
)