package ph.mart.todo.data

import kotlinx.serialization.Serializable

object Screen {

    @Serializable
    data object FruitList

    @Serializable
    data class FruitDetails(val fruitId: String)
}