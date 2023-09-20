package uz.gita.testcleanafb6.data.network.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.testcleanafb6.data.network.request.AuthRequest
import uz.gita.testcleanafb6.data.network.response.AuthResponse
import uz.gita.testcleanafb6.data.network.response.MessageResponse

interface AuthApi {
    @POST("/register")
    suspend fun register(@Body authRequest: AuthRequest): Response<AuthResponse>
    @POST("/unregister")
    suspend fun unRegister(@Body unAuthRequest: AuthRequest):Response<AuthResponse>
    @POST("/login")
    suspend fun login(@Body loginRequest: AuthRequest):Response<AuthResponse>
    @POST("/logout")
    suspend fun logOut(@Body authRequest: AuthRequest):Response<MessageResponse>
}