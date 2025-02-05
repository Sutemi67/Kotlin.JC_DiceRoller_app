package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme
import kotlin.math.floor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp(){
    DiceWithButtonsAndImage()
}
@Composable
fun DiceWithButtonsAndImage(){

    var result by remember { mutableIntStateOf(1) }
    val textVariable  = when (result){
        3 -> "Ы"
        else -> " "
    }
    val imageResource = when (result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Box(
        modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
    ){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            text = textVariable,
            fontSize = 50.sp,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(id = imageResource), contentDescription = result.toString())
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { result = floor(Math.random() * 6).toInt() }) {
            Text(stringResource(R.string.roll))
        }
    }
    }
}