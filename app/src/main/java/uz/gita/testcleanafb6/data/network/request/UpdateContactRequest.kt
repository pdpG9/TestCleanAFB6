package uz.gita.testcleanafb6.data.network.request

data class UpdateContactRequest(
    val id: Int,
    val name: String,
    val phone: String
)