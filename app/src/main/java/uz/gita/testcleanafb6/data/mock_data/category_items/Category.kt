package uz.gita.testcleanafb6.data.mock_data.category_items

data class Category(
    val active: Boolean,
    val child_categories: Any,
    val description: Description,
    val id: String,
    val image: String,
    val order_no: String,
    val parent_id: String,
    val products: List<Product>,
    val slug: String,
    val title: TitleX
)