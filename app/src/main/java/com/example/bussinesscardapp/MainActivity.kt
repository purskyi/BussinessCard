package com.example.bussinesscardapp

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscardapp.ui.theme.BussinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardAppTheme {
                SetStatusBarColor(color = MaterialTheme.colorScheme.background)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BussinessCard()
                }
            }
        }
    }
}

@Composable
fun BussinessCard( modifier: Modifier = Modifier) {
    var name = "Andrii Purskyi"
    var qualification = "Android Developer Extraordinaire"
    var number = "+380938721749"
    var mail = "purskyipro@gmail.com\n"
    var colorCanvas = Color(242, 243, 244  )
    var colorText = Color(28, 40, 51 )
    Box (modifier = Modifier
        .fillMaxSize()
        .background(colorCanvas),
        contentAlignment  = Alignment.Center){

            Column ( horizontalAlignment = Alignment.CenterHorizontally){

                Text(
                    text =name,
                    style = TextStyle(
                        fontFamily = FontFamily.Cursive,
                        fontSize = 40.sp),
                   color = colorText,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier

                )
                Text(
                    text =qualification,
                    style = TextStyle(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 20.sp),
                    color = colorText,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier

                )
            }



            Column ( horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier .padding(top = 500.dp)
                ){
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Image(
                        painter = painterResource(R.drawable.r),
                        contentDescription = null,
                        modifier = Modifier
                            .size(15.dp)
                           )
                    Text(
                        text =number,
                        color = colorText,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(start = 10.dp)
                    )
                }
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Image(
                        painter = painterResource(R.drawable.mail_icon_11549825367za0blj7xnt),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                    )

                    Text(
                        text =mail,
                        color = colorText,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(start = 10.dp, top = 15.dp)
                    )
                }

            }


Column (modifier = Modifier.padding(top = 750.dp)){
    Image(
        painter = painterResource(R.drawable.android_logo),
        contentDescription = null,
        modifier = Modifier
            .size(50.dp)

    )
}


    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BussinessCardAppTheme {
        BussinessCard()
    }
}



@Composable
fun SetStatusBarColor(color: Color)
{
    val view = LocalView.current

    if (!view.isInEditMode)
    {
        LaunchedEffect(key1 = true)
        {
            val window = (view.context as Activity).window
            window.statusBarColor = color.toArgb()
        }
    }
}




