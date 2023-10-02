package uz.gita.testcleanafb6.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.testcleanafb6.R
import uz.gita.testcleanafb6.domain.models.ContactParam

@Composable
fun ContactItem(
    data: ContactParam,
    onClickSettings: (ContactParam) -> Unit,
    onClickEdit: (ContactParam) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { onClickEdit(data) }
            .padding(8.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_user), contentDescription = "profile", modifier = Modifier.width(40.dp).height(40.dp).clip(shape = CircleShape))
        Spacer(modifier = Modifier.size(12.dp))

        Column(
            modifier = Modifier
                .weight(0.7f, true)
        ) {

            Text(
                text = data.name,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(text = data.phone)

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
                        .height(24.dp)
                )
            },
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ContactItemPreview(){
    ContactItem(data = ContactParam(1, "", ""), onClickSettings = {ContactParam(1, "", "")}, onClickEdit = {ContactParam(1, "", "")})
}