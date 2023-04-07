package com.example.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.profilecardlayout.ui.theme.ProfileCardLayoutTheme
import com.example.profilecardlayout.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardLayoutTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(userProfiles: List<UserProfile> = userProfileList) {

    Scaffold(
        topBar = {
            TopBar()
        }
    ) { contentPadding ->

        Box(modifier = Modifier.padding(contentPadding)) {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray
            ) {
                LazyColumn {

                    items(userProfiles) { userProfile ->

                        ProfileCard(userProfile)
                    }

                }
            }
        }
    }

}

@Composable
fun TopBar() {

    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home", Modifier.padding(
                    start = 16.dp
                )
            )
        },
        title = { Text(text = "Home") },

        )
}

@Composable
fun ProfileCard(userProfile: UserProfile) {

    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        shape = CutCornerShape(topEnd = 24.dp),
        elevation = 8.dp,
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.pictureUrl, userProfile.status)
            ProfileContent(userProfile.name, userProfile.status, Alignment.Start)
        }

    }

}

@Composable
fun ProfilePicture(userProfileUrl: String, onlineStatus: Boolean, imageDp: Dp = 72.dp) {

    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (onlineStatus) MaterialTheme.colors.lightGreen else Color.Red
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp,
    ) {

        AsyncImage(
            model = userProfileUrl,
            contentDescription = "User Profile Picture",
            modifier = Modifier.size(imageDp),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun ProfileContent(
    userName: String,
    onlineStatus: Boolean,
    horizontalAlignment: Alignment.Horizontal
) {

    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = horizontalAlignment
    ) {

        CompositionLocalProvider(
            if (onlineStatus) LocalContentAlpha provides (1f)
            else LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = userName,
                style = MaterialTheme.typography.h5
            )
        }

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = if (onlineStatus) "Active now" else "Offline",
                style = MaterialTheme.typography.body2
            )
        }
    }

}

@Composable
fun UserProfileDetailsScreen(userProfile: UserProfile = userProfileList[0]) {

    Scaffold(
        topBar = {
            TopBar()
        }
    ) { contentPadding ->

        Box(modifier = Modifier.padding(contentPadding)) {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.LightGray
            ) {
                ProfileDetailsCard(userProfile)
            }
        }
    }

}

@Composable
fun ProfileDetailsCard(userProfile: UserProfile) {

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        shape = CutCornerShape(topEnd = 24.dp),
        elevation = 8.dp,
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfilePicture(userProfile.pictureUrl, userProfile.status, 180.dp)
            ProfileContent(userProfile.name, userProfile.status, Alignment.CenterHorizontally)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun UserProfileDetailsPreview() {

    ProfileCardLayoutTheme {
        UserProfileDetailsScreen()
    }

}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {

    ProfileCardLayoutTheme {
        MainScreen()
    }

}