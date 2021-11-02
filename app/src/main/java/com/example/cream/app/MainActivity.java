package com.example.cream.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnClear = (Button)findViewById(R.id.btn1);
        btnClear.setOnClickListener(new clearResult());
        Button btn1 = (Button)findViewById(R.id.btn5);
        btn1.setOnClickListener(new inputNumber());
        Button btn2 = (Button)findViewById(R.id.btn6);
        btn2.setOnClickListener(new inputNumber());
        Button btn3 = (Button)findViewById(R.id.btn7);
        btn3.setOnClickListener(new inputNumber());
        Button btn4 = (Button)findViewById(R.id.btn9);
        btn4.setOnClickListener(new inputNumber());
        Button btn5 = (Button)findViewById(R.id.btn10);
        btn5.setOnClickListener(new inputNumber());
        Button btn6 = (Button)findViewById(R.id.btn11);
        btn6.setOnClickListener(new inputNumber());
        Button btn7 = (Button)findViewById(R.id.btn13);
        btn7.setOnClickListener(new inputNumber());
        Button btn8 = (Button)findViewById(R.id.btn14);
        btn8.setOnClickListener(new inputNumber());
        Button btn9 = (Button)findViewById(R.id.btn15);
        btn9.setOnClickListener(new inputNumber());
        Button btn0 = (Button)findViewById(R.id.btn17);
        btn0.setOnClickListener(new inputNumber());
        Button btnRemainder = (Button)findViewById(R.id.btn3);
        btnRemainder.setOnClickListener(new inputSecond());
        Button btnDivision = (Button)findViewById(R.id.btn4);
        btnDivision.setOnClickListener(new inputSecond());
        Button btnMultiply = (Button)findViewById(R.id.btn8);
        btnMultiply.setOnClickListener(new inputSecond());
        Button btnMinus = (Button)findViewById(R.id.btn12);
        btnMinus.setOnClickListener(new inputSecond());
        Button btnPlus = (Button)findViewById(R.id.btn16);
        btnPlus.setOnClickListener(new inputSecond());
        Button btnPoint = (Button)findViewById(R.id.btn18);
        btnPoint.setOnClickListener(new inputNumber());
        Button btnResult = (Button)findViewById(R.id.btn19);
        btnResult.setOnClickListener(new inputSecond());
        Button btnChange = (Button)findViewById(R.id.btn2);
        btnChange.setOnClickListener(new change());
        Button btnSqrt = (Button)findViewById(R.id.sqrt);
        btnSqrt.setOnClickListener(new sqrtResult());
    }
    class clearResult implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            TextView result = (TextView)findViewById(R.id.result);
            TextView sign = (TextView)findViewById(R.id.sign);
            TextView second = (TextView)findViewById(R.id.second);
            TextView save = (TextView)findViewById(R.id.save);
            result.setText("");
            sign.setText("");
            second.setText("");
            save.setText("");
            //result.getText().toString();
        }
    }
    class sqrtResult implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            TextView result = (TextView)findViewById(R.id.result);
            TextView sign = (TextView)findViewById(R.id.sign);
            TextView second = (TextView)findViewById(R.id.second);
            TextView save = (TextView)findViewById(R.id.save);

            String str = result.getText().toString();
            if(str==""){
                Toast ts = Toast.makeText(getBaseContext(),"未输入数,无法计算开平方",Toast.LENGTH_LONG);
                ts.show();
                return;
            }else if(str.indexOf(".")!=str.lastIndexOf(".")||str.indexOf(".")==0){
                    Toast ts = Toast.makeText(getBaseContext(),"第一个数格式不合规",Toast.LENGTH_LONG);
                    ts.show();
                    return;
            }else if (Float.parseFloat(str)<0){
                Toast ts = Toast.makeText(getBaseContext(),"负数不可开平方",Toast.LENGTH_LONG);
                ts.show();
                return;
            }else{
                String end = String.format("%.4f", Math.sqrt(Float.parseFloat(str)));
                result.setText("");
                sign.setText("");
                second.setText("");
                save.setText(end);
            }

        }
    }
    class change implements View.OnClickListener{
        @Override
        public void onClick(View view){
            TextView active = (TextView)findViewById(R.id.second);
            if(active.getText().toString()==""){
                active = (TextView)findViewById(R.id.result);
            }
            if(active.getText().toString()!=""){
                active.setText(Float.parseFloat(active.getText().toString())*(-1)+"");
            }else{
                Toast ts = Toast.makeText(getBaseContext(),"未输入数,无法切换正负",Toast.LENGTH_LONG);
                ts.show();
            }
        }
    }
    class inputNumber implements View.OnClickListener{
        @Override
        public void onClick(View view){
            TextView first = (TextView)findViewById(R.id.result);
            TextView sign = (TextView)findViewById(R.id.sign);
            TextView result = (TextView)findViewById(R.id.second);
            if(sign.getText().toString()==""){
                result = first;
            }
            Button btn = (Button)findViewById(view.getId());
            String str = result.getText().toString() + btn.getText().toString();
            result.setText(str);
            TextView save = (TextView)findViewById(R.id.save);
            save.setText("");
        }
    }
    class inputSecond implements View.OnClickListener{
        @Override
        public void onClick(View view){
            TextView result = (TextView)findViewById(R.id.result);
            String first=result.getText().toString();
            if(first=="")
            {
                Toast ts = Toast.makeText(getBaseContext(),"未输入第一个数",Toast.LENGTH_LONG);
                ts.show();
            }else{
                if(first.indexOf(".")!=first.lastIndexOf(".")||first.indexOf(".")==0){
                    Toast ts = Toast.makeText(getBaseContext(),"第一个数不合规",Toast.LENGTH_LONG);
                    ts.show();
                }else{
                    TextView sign = (TextView)findViewById(R.id.sign);
                    TextView second = (TextView)findViewById(R.id.second);
                    String secondStr = second.getText().toString();
                    if(secondStr!=""){
                        if(secondStr.indexOf(".")!=secondStr.lastIndexOf(".")||secondStr.indexOf(".")==0){
                            Toast ts = Toast.makeText(getBaseContext(),"第二个数不合规",Toast.LENGTH_LONG);
                            ts.show();
                        }else{
                            float resultNum=0;
                            float a=Float.parseFloat(first);
                            float b=Float.parseFloat(secondStr);
                            String mySign=sign.getText().toString();
                            switch(mySign){
                                case "+" :resultNum=a+b;break;
                                case "-" :resultNum=a-b;break;
                                case "*" :resultNum=a*b;break;
                                case "/" :
                                    if(b==0){
                                        Toast ts = Toast.makeText(getBaseContext(),"被除数不可为0",Toast.LENGTH_LONG);
                                        ts.show();
                                        return;
                                    }
                                    resultNum=a/b;
                                    break;
                                case "%" :
                                    if(b==0){
                                        Toast ts = Toast.makeText(getBaseContext(),"被除数不可为0",Toast.LENGTH_LONG);
                                        ts.show();
                                        return;
                                    }
                                    resultNum=a%b;
                                    break;
                                default :break;
                            }
                            result.setText(resultNum+"");
                            second.setText("");
                        }
                    }
                    Button btn = (Button)findViewById(view.getId());
                    String newSign = btn.getText().toString();
                    if(newSign.equals("="))
                    {
                        TextView save = (TextView)findViewById(R.id.save);
                        save.setText(result.getText().toString());
                        result.setText("");
                        sign.setText("");
                    }else{
                        sign.setText(newSign);
                    }
                }
            }
        }
    }
}
