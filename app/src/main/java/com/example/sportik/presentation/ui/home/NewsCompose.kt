package com.example.sportik.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.sportik.R
import com.example.sportik.domain.model.News

@Composable
fun ItemNewsCard(news: News/*, onItemClicked: (dog: News) -> Unit*/) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(136.5.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(16.dp)),
        //.clickable(onClick = { onItemClicked(news) }),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Box(
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .padding(16.dp)
        ) {
            ConstraintLayout {
                val (image, title, data, icon, num) = createRefs()
                //GLIDE
                //val image: Painter = rememberAsyncImagePainter(news.socialImage)
                Image(
                    modifier = Modifier
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                        }
                        .size(80.dp, 80.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    //painter = image,
                    painter = painterResource(id = R.drawable.sports_logo),
                    contentDescription = "img",
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = news.title,
                    modifier = Modifier
                        .padding(12.dp, 0.dp, 0.dp, 0.dp)
                        .height(80.dp)
                        .width(260.dp)
                        .constrainAs(title) {
                            top.linkTo(parent.top)
                            start.linkTo(image.end)
                        },
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    style = typography.bodyMedium,
                    textAlign = (TextAlign.Start)
                )


                Icon(
                    modifier = Modifier
                        .constrainAs(icon) {
                            top.linkTo(image.bottom)
                            start.linkTo(image.start)
                        }
                        .padding(0.dp, 7.dp),
                    painter = painterResource(R.drawable.icon_comment),
                    contentDescription = "CommentIcon",
                    tint = Color.Unspecified
                )

                Text(
                    text = news.postedTime,
                    modifier = Modifier
                        .height(16.dp)
                        .constrainAs(data) {
                            top.linkTo(icon.top)
                            bottom.linkTo(icon.bottom)
                            end.linkTo(parent.end)
                        },
                    color = Color.Gray,
                    style = typography.bodySmall,
                    maxLines = 1
                )

                Text(
                    text = news.postedTime,
                    modifier = Modifier
                        .padding(6.dp, 0.dp)
                        .constrainAs(num) {
                            top.linkTo(icon.top)
                            bottom.linkTo(icon.bottom)
                            start.linkTo(icon.end)
                        },
                    color = Color.Gray,
                    style = typography.titleSmall,
                    maxLines = 1
                )
                /*if (news.isFavourite) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    FavouriteTag()
                }
            }*/
            }
        }
    }
}

@Preview
@Composable
fun NewsList() {
    LazyColumn {
        val list: List<News> = listOf(
            News(
                313131,
                "Test Title One Test Title One Test Title One Test Title OneTest Title OneTest Title OneTest Title One Test Title One Test Title One",
                "3",
                "lol",
                "31"
            ),
            News(313131, "Test Title Two", "3", "lol", "31"),
            News(313131, "Test Title Three", "3", "lol", "31"),
            News(313131, "Test Title One", "3", "lol", "31"),
            News(313131, "Test Title Two", "3", "lol", "31"),
            News(313131, "Test Title Three", "3", "lol", "31"),
            News(313131, "Test Title One", "3", "lol", "31"),
            News(313131, "Test Title Two", "3", "lol", "31"),
            News(313131, "Test Title Three", "3", "lol", "31"),
        )
        items(list) {
            ItemNewsCard(it)
        }
    }
}