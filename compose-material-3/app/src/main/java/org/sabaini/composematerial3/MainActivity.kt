package org.sabaini.composematerial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sabaini.composematerial3.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "My Button")
                        }
                        androidx.compose.material3.Button(onClick = { /*TODO*/ }) {
                            Text(text = "My Button M3")
                        }


                        Card(
                            elevation = 3.dp, modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .padding(10.dp)
                        ) {
                            Text(text = "My Card")
                        }
                        androidx.compose.material3.Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .padding(10.dp)
                        ) {
                            androidx.compose.material3.Text(text = "My Card M3")
                        }


                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Checkbox")
                            Checkbox(checked = true, onCheckedChange = {})
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            androidx.compose.material3.Text(text = "Checkbox M3")
                            androidx.compose.material3.Checkbox(
                                checked = true,
                                onCheckedChange = {})
                        }


                        TextField(
                            value = "Text",
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth()
                        )
                        androidx.compose.material3.TextField(
                            value = "Text M3",
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth()
                        )


                        FloatingActionButton(onClick = { /*TODO*/ }) {
                            Text(text = "FAB")
                        }
                        androidx.compose.material3.FloatingActionButton(onClick = { /*TODO*/ }) {
                            androidx.compose.material3.Text(text = "FAB3")
                        }
                    }
                }
            }
        }
    }
}