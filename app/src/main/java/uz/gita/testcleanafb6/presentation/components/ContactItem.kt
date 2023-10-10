package uz.gita.testcleanafb6.presentation.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import uz.gita.testcleanafb6.R
import uz.gita.testcleanafb6.data.network.response.AddContactData
import uz.gita.testcleanafb6.domain.models.ContactParam
import uz.gita.testcleanafb6.domain.models.CrudContactParam

@Composable
fun ContactItem(
    data: ContactParam,
    onClickSettings: (ContactParam) -> Unit,
    onClickEdit: (ContactParam) -> Unit
) {

    Box(modifier = Modifier
        .clickable { onClickEdit(data) }
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
        .padding(top = 12.dp)
    ) {

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user), contentDescription = "profile", modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clip(shape = CircleShape),
                    tint = Color(0xffBDBDBD)
                )
                Spacer(modifier = Modifier.size(12.dp))

                Column(
                    modifier = Modifier
                        .weight(0.7f, true)
                ) {

                    Text(
                        text = data.data.name,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.size(4.dp))

                    Text(text = data.data.phone)

                }

                Column(modifier = Modifier.weight(0.3f)) {

                }

                IconButton(
                    onClick = {
                        onClickSettings(data)
                    },
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_settings),
                            contentDescription = "Settings",
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp),
                            tint = Color(0xffBDBDBD)
                        )
                    },
                )
            }

            Spacer(modifier = Modifier.size(12.dp))
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.Cyan))
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ContactItemPreview() {
    ContactItem(data = ContactParam(false, CrudContactParam(1, "","")), onClickSettings = { ContactParam(false, CrudContactParam(1, "","")) }, onClickEdit = { ContactParam(false, CrudContactParam(1, "","")) })
}