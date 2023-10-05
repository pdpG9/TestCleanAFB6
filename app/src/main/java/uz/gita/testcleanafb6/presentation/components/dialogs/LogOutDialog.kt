@file:Suppress("UNUSED_EXPRESSION")

package uz.gita.testcleanafb6.presentation.components.dialogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import uz.gita.testcleanafb6.R
import uz.gita.testcleanafb6.ui.theme.TestCleanAFB6Theme

import java.time.format.TextStyle

@Composable
fun LogOutDialog(
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {

        Box(
            modifier = Modifier
                .height(190.dp)
        ) {
            Column(
                modifier = Modifier
            ) {
                Box(
                    modifier = Modifier
                        .height(190.dp)
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = RoundedCornerShape(25.dp, 25.dp, 25.dp, 25.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.height(16.dp))
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.logout_icon),
                                contentDescription = "icon",
                                modifier = Modifier
                                    .width(24.dp)
                                    .height(24.dp)
                            )
                            Text(
                                text = "Sign Out",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.weight(1f),
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                fontWeight = FontWeight.Bold
                            )
                            Image(
                                painter = painterResource(id = R.drawable.xmark),
                                contentDescription = "icon",
                                modifier = Modifier
                                    .width(24.dp)
                                    .height(24.dp)
                                    .clickable(
                                        onClick = onDismiss
                                    )
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))


                        Text(
                            text = "Do you want unregister or logout?",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                        Spacer(modifier = Modifier.height(24.dp))

                        Row {
                            OutlinedCard(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.surface,
                                ),
                                border = BorderStroke(1.dp, Color(0xFFEB5757)),
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(35.dp)
                                    .clickable(
                                        onClick = {
                                            onDismiss
                                        }
                                    ),

                                ) {
                                Text(
                                    text = "UnRegister",
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 6.dp),
                                    color = Color(0xFFEB5757),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            OutlinedCard(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.surface,
                                ),
                                border = BorderStroke(1.dp, Color(0xFFEB5757)),
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(35.dp)
                                    .clickable(
                                        onClick = {
                                            onDismiss
                                        }
                                    ),

                                ) {
                                Text(
                                    text = "LogOut",
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(color = Color(0xFFEB5757))
                                        .padding(top = 6.dp),
                                    color = Color(0xFFFFFFFF),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetLogOutDialog() {
    TestCleanAFB6Theme {
        LogOutDialog(onDismiss = {})
    }
}