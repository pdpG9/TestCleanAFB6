package uz.gita.testcleanafb6.data.mock_data.category_items

data class Product(
    val active: Boolean,
    val active_in_menu: Boolean,
    val brand_id: String,
    val categories: List<String>,
    val currency: String,
    val description: Description,
    val discounts: Any,
    val from_time: String,
    val gallery: Any,
    val has_modifier: Boolean,
    val id: String,
    val iiko_id: String,
    val image: String,
    val jowi_id: String,
    val off_always: Boolean,
    val out_price: Int,
    val rate_id: String,
    val string: String,
    val title: Title,
    val to_time: String,
    val type: String
)