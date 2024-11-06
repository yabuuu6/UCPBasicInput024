package com.example.ucp1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview (showBackground = true)
@Composable
fun biodata (modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var noTelepon by remember { mutableStateOf("") }
    var selectedjk by remember { mutableStateOf("") }

    val listjk = listOf("Laki - Laki", "Perempuan")


    var svnama by remember { mutableStateOf("") }
    var svnoTelepon by remember { mutableStateOf("") }
    var svselectedjk by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            placeholder = {
                Row {
                    Text("Isi Nama Anda")
                }
            }
        )
        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = noTelepon,
            onValueChange = { noTelepon = it },
            label = { Text("No Telepon") },
            placeholder = { Text("isi No Telepon anda") }
        )
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listjk.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedjk == item,
                        onClick = { selectedjk = item }
                    )
                    Text(text = item)
                }
            }
        }
        Button(
            onClick = {
                svnama
                svnoTelepon
                svselectedjk
            },
            modifier = Modifier.padding(top = 16.dp)
                .fillMaxSize()
        ) { Text(text = "Submit") }

        Column(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp)),
                //.background(Color(0E91F3)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Biodata",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Column(
                modifier = Modifier.run {
                    fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        //.background(Color(0E91F3 ))
                        .padding(8.dp)
                }
            ) {
                Detail(judul = "Nama", isinya = svnama)
                Detail(judul = "No Telepon", isinya = svnoTelepon)
                Detail(judul = "Jenis Kelamin", isinya = svselectedjk)
            }


        }
    }
}

@Composable
fun Detail(judul: String, isinya: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = judul,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f),
            color = Color.Black
        )
        Text(
            text = ":",
            modifier = Modifier.weight(0.1f),

            )
        Text(
            text = isinya,
            modifier = Modifier.weight(2f),

            )
    }
}