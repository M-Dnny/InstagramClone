package com.example.instagramclone.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Default
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramclone.R

const val userName: String = "Phone number, email or username"
const val passwordText: String = "Password"


@Composable
fun LoginPage() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())

    )
    {
        InstagramTextLogo(normalText = "Instagram", subScriptText = "Clone")
        Spacer(modifier = Modifier.height(50.dp))
        UserNameTextField()
        Spacer(modifier = Modifier.height(15.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(15.dp))
        LogInButton()
        Spacer(modifier = Modifier.height(15.dp))
        ForgetPassword()
        Spacer(modifier = Modifier.height(15.dp))
        Or()
        Spacer(modifier = Modifier.height(15.dp))
        FaceBookLogin()
        Spacer(modifier = Modifier.height(25.dp))
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Divider()
        SignUp()
    }
}

@Composable
fun InstagramTextLogo(
    normalText: String,
    subScriptText: String,
    normalFontSize: TextUnit = MaterialTheme.typography.h3.fontSize,
    subscriptFontSize: TextUnit = MaterialTheme.typography.h5.fontSize,
    subTextFontWeight: FontWeight = FontWeight.Normal,
    subScript: BaselineShift = BaselineShift.Subscript,
    textLogoFont: FontFamily = FontFamily(Font(R.font.blue_vinyl_regular_ps_ot))
) {
    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = normalFontSize,
                fontFamily = textLogoFont
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = subscriptFontSize,
                fontWeight = subTextFontWeight,
                baselineShift = subScript,
                fontFamily = textLogoFont
            )
        ) {
            append(subScriptText)
        }
    })
}

@Composable
fun UserNameTextField(
    textFieldBorderColors: Color = colorResource(id = R.color.instaTextFieldBorder)
) {
    var state by remember { mutableStateOf("") }

    OutlinedTextField(
        value = state,
        placeholder = { Text(text = userName) },
        maxLines = 1,
        onValueChange = {
            state = it
        },
        shape = RoundedCornerShape(10),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorResource(id = R.color.instaTextField),
            focusedBorderColor = textFieldBorderColors,
            cursorColor = textFieldBorderColors
        ),
        modifier = Modifier
            .width(355.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        )

    )
}

@Composable
fun PasswordTextField(
    textFieldBorderColors: Color = colorResource(id = R.color.instaTextFieldBorder)
) {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        placeholder = { Text(text = passwordText) },
        maxLines = 1,
        modifier = Modifier
            .width(355.dp),

        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        trailingIcon = {
            val passwordImage = if (passwordVisibility)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = passwordImage, null)
            }
        },
        shape = RoundedCornerShape(10),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorResource(id = R.color.instaTextField),
            focusedBorderColor = textFieldBorderColors,
            cursorColor = textFieldBorderColors
        ),

        )
}

@Composable
fun LogInButton(
    LoginText: String = "Log In"
) {
    Button(
        onClick = {
        },
        modifier = Modifier
            .width(355.dp)
            .height(50.dp),
        shape = RoundedCornerShape(10),
        elevation = elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),
        colors = buttonColors(
            backgroundColor = colorResource(id = R.color.loginBtn),
            disabledBackgroundColor = colorResource(id = R.color.disable_loginBtn)
        ),
    ) {
        Text(
            text = LoginText,
            style = TextStyle(color = Color.White),
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ForgetPassword() {
    Row(
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) { }
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        colorResource(id = R.color.instaTextFieldBorder),
                        fontSize = 12.sp
                    )
                ) {
                    append("Forgot your login details? ")
                }
                withStyle(
                    style = SpanStyle(
                        colorResource(id = R.color.forgetText),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp

                    )
                ) { append("Get help logging in.") }
            },
        )
    }
}

@Composable
fun Or() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Divider(modifier = Modifier.width(150.dp))
        Text(
            text = "  OR  ",
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = colorResource(id = R.color.instaTextFieldBorder)
        )
        Divider(modifier = Modifier.width(150.dp))
    }


}

@Composable
fun FaceBookLogin() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) { }
    ) {
        Icon(
            imageVector = Default.Facebook,
            contentDescription = null,
            tint = colorResource(id = R.color.loginBtn),
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = "Log in with Facebook",
            color = colorResource(id = R.color.loginBtn),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SignUp() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) { }
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        colorResource(id = R.color.instaTextFieldBorder),
                        fontSize = 13.sp
                    )
                ) {
                    append("Don't have an account? ")
                }
                withStyle(
                    style = SpanStyle(
                        colorResource(id = R.color.forgetText),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,

                        )
                ) { append("Sign up.") }
            },
            modifier = Modifier.padding(
                bottom = 15.dp,
                top = 15.dp,
                start = 100.dp,
                end = 100.dp
            )
        )
    }
}
