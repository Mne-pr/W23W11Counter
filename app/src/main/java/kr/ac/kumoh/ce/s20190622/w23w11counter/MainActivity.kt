package kr.ac.kumoh.ce.s20190622.w23w11counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20190622.w23w11counter.ui.theme.W23W11CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Column (
                    Modifier.fillMaxSize().padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Clicker()
                    Counter()
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){ // 아무 리턴도 없는 파라미터인 content
    W23W11CounterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun Clicker(){
    // 값이 바뀔 때 재구성-recomposition이 일어나야 함 => 변수를 상태로 만들어야 함
    var (txtString, setTxtString) = remember { mutableStateOf(value="눌러보세요") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = txtString,
            fontSize = 70.sp,
        )
        Button(modifier = Modifier
            .fillMaxWidth(),
            onClick = {
                setTxtString("눌렸습니다")
            }) {
            // Text(text = "눌러봐")
            Text("눌러봐")
        }
    }
}

@Composable
fun Counter(){
    // 값이 바뀔 때 재구성-recomposition이 일어나야 함 => 변수를 상태로 만들어야 함
    var (c, setC) = rememberSaveable { mutableStateOf(value=0) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$c", fontSize = 70.sp,)

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            ) {
            Button(modifier = Modifier
                .height(50.dp)
                .weight(1f), onClick = { setC( c+1 )}) {
                Text("증가")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(modifier = Modifier
                .height(50.dp)
                .weight(1f), onClick = { setC( c-1 ) }) {
                Text("감소")
            }
        }

    }
}