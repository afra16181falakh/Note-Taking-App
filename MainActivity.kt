package com.example.notetakingapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.notetakingapp.ui.theme.NoteTakingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTakingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val notes = remember {
        mutableStateListOf<NoteModel>(
            NoteModel("Title","Content"),
            NoteModel("Workshop","Hello World")
        )
    }
var isAddnoteModel = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
               title = {
                   Text("NoteVault")
               }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isAddnoteModel.value =true

                },
            ){
                Text("Add")
            }
        }

    ){
        innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(notes.toList()) {
                it ->
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Column {
                        Text(it.title, fontSize = 5.em)
                        Text(it.content)
                    }
                }
            }
        }

    }

if(isAddnoteModel.value){
    AddNoteModel(
    onAddnote = {title, content ->
        notes.add(
            NoteModel(title, content)
        )
        },
        onCancel={
            isAddnoteModel.value=false
        }
    )}}



