package com.business.cmpproject.presentation.features.ticket

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.business.cmpproject.data.model.response.TicketData
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape

// Compose Material (CMP standard)
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface

// Runtime & State
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.business.cmpproject.presentation.theme.CreamBackground
import com.business.cmpproject.presentation.theme.CreamSurface
import com.business.cmpproject.presentation.theme.GreenPrimary
import com.business.cmpproject.presentation.theme.GreenSecondary
import com.business.cmpproject.presentation.theme.LightTextPrimary
import com.business.cmpproject.presentation.theme.LightTextSecondary

@Composable
fun TicketHistoryContent(item: TicketData, isDark: Boolean,
                         onTicketClick: (Int) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp),
        // Material 3 mein colors aise define hote hain
        colors = CardDefaults.cardColors(
            containerColor = CreamSurface,

        ),
        onClick ={
            item.id?.let { onTicketClick(it) }
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ID: #${item.ticketId ?: "N/A"}",
                    style = TextStyle(
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = LightTextPrimary
                    )
                )

                Surface(
                    color = if (item.status == "Open") Color(0xFFFFEBEE) else Color(0xFFE8F5E9),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = item.status ?: "Unknown",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        style = TextStyle(
                            color = if (item.status == "Open") Color.Red else GreenPrimary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.category ?: "General Support",
                style = TextStyle(color = GreenSecondary, fontWeight = FontWeight.Medium)
            )

            HorizontalDivider( // Divider ki jagah HorizontalDivider (M3)
                modifier = Modifier.padding(vertical = 8.dp),
                color = CreamBackground,
                thickness = 1.dp
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = LightTextSecondary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = item.companyName ?: "No Company",
                    style = TextStyle(color = LightTextSecondary, fontSize = 14.sp)
                )
            }
        }

}
}