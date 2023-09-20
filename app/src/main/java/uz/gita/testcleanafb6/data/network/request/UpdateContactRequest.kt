package uz.gita.testcleanafb6.data.network.request

data class UpdateContactRequest(
    val id: String,
    val name: String,
    val phone: String
)