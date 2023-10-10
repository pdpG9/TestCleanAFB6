package uz.gita.testcleanafb6.data.mock_data.branch

data class Geozone(
    val created_at: String,
    val id: String,
    val name: String,
    val points: List<Point>,
    val shipper_id: String,
    val updated_at: String
)