package com.example.antiquemall.data.model

/**
 * Created by Oguz Sahin on 9/9/2021.
 */
data class UserInfo(
    val type: UserTypes,
    val name: String,
    val mail: String? = null,
    val imageUri: String? = null
)


enum class UserTypes {
    SIGNED, GUEST
}
