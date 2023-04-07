package com.example.profilecardlayout

data class UserProfile(
    val name: String,
    val status: Boolean,
    val drawableId: Int
)

val userProfileList = listOf(
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
    UserProfile(name = "Jeff Alpha", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Sara Beta", status = false, drawableId = R.drawable.profile_picture2),
)
