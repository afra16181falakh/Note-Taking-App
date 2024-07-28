package com.example.notetakingapp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.window.Dialog

@Composable
fun AddNoteModel(
    onAddnote : (title: String, content : String) -> Unit,
    onCancel :()-> Unit
)
{
    var title by remember {
        mutableStateOf("")}
    var content by remember {
        mutableStateOf("")
    }
    Dialog(
        onDismissRequest ={


        }
    ) {
        Surface(
            modifier = Modifier.padding(2.dp),
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 4.dp
        ){
            Column (
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
            ){
                    Text(
                        "add a new post",
                        fontSize = 5.em
                    )
                    OutlinedTextField(value = title,
                        onValueChange ={title = it},
                        label = { Text("Title")})
                    OutlinedTextField(value = content ,
                        onValueChange ={content = it},
                        label = {Text("Content")},
                        minLines = 4
                        )
                Button(onClick = {
                    onAddnote(title, content)
                    onCancel()

                },
                    modifier = Modifier.fillMaxWidth(),
                ){
                    Text("ADD")
                }
            }
        }
    }
}
