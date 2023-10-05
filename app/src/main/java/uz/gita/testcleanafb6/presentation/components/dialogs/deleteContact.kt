package uz.gita.testcleanafb6.presentation.components.dialogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import uz.gita.testcleanafb6.R
import uz.gita.testcleanafb6.ui.theme.TestCleanAFB6Theme

@Composable
fun InfoDialog(
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {

        Box(
            modifier = Modifier
                .height(210.dp)
        ) {
            Column(
                modifier = Modifier
            ) {
                Box(
                    modifier = Modifier
                        .height(210.dp)
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = RoundedCornerShape(25.dp, 25.dp, 25.dp, 25.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Image(painter = painterResource(id = R.drawable.delete1),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.Top))
                            Text(
                                text = "Delete Contact",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(start = 10.dp,end=10.dp),
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Image(painter = painterResource(id = R.drawable.xmark),
                                contentDescription = null,
                                modifier = Modifier
                                    .clickable(
                                        onClick = onDismiss
                                    )
                                    .size(30.dp)
                                    .align(Alignment.Top))
                        }

                        Spacer(modifier = Modifier.height(8.dp))


                        Text(
                            text = "Do you want delete this contact?",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 15.dp, end = 15.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                        Spacer(modifier = Modifier.height(24.dp))


                        OutlinedCard(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                            ),
                            border = BorderStroke(1.dp, Color(0xFFEB5757)),
                            modifier = Modifier
                                .width(120.dp)
                                .height(35.dp)
                                .align(Alignment.End)
                                .clickable(
                                    onClick = {
                                        onDismiss
                                    }
                                ),

                            ) {
                            Text(
                                text = "Delete",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color(0xFFEB5757))
                                    .padding(top = 6.dp),
                                color = Color(0xFFFFFFFF),
                                fontWeight = FontWeight.Bold
                            )
                        }
//                        Button(
//                            onClick = onDismiss,
//                            modifier = Modifier
//                                .width(100.dp)
//                                .align(Alignment.End)
//                                .clip(RoundedCornerShape(5.dp)),
//                            colors = Color(0xFFEB5757)
//                        ) {
//                            Text(
//                                text = "Delete",
//                                color = Color.White
//                            )
//                        }
//                        ElevatedButton(
//                            onClick = onDismiss,
//                            colors= ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .clip(RoundedCornerShape(5.dp))
//                        ) {
//                            Text(
//                                text = "Enable Location",
//                                color = Color.White
//                            )
//                        }


//                        Spacer(modifier = Modifier.width(8.dp))
//                        Image(painter = painterResource(id = R.drawable.delete1),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .size(30.dp)
//                                .align(Alignment.Start),)
                    }
                }
            }


//            HeaderImage(
//                modifier = Modifier
//                    .size(200.dp)
//                    .align(Alignment.TopCenter)
//                /*.border(
//                    border = BorderStroke(width = 5.dp, color = Color.White),
//                    shape = CircleShape
//                )*/
//            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun getDeleteContactDialog(){
    TestCleanAFB6Theme {
        InfoDialog( onDismiss = {

        })
    }
}