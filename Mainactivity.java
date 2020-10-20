package com.nitin.app1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.nitin.app1.EvaluateString;
public class MainActivity extends AppCompatActivity {
    Button  buttonC;
    EditText Answer;
    String Exp,TempText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Answer=(EditText)findViewById(R.id.edt1);
        Exp="";
        TempText="";
    }
    public void handleinput(View view) {
             Button b = (Button)view;
             TempText=TempText+b.getText()+"";
             Answer.setText(TempText);
    }
    public void handleoperand(View view){
            Button b = (Button)view;
            if (TempText==""||Answer.getText().toString()==""){
            if (Exp.endsWith("+")||Exp.endsWith("-")||Exp.endsWith("/")||Exp.endsWith("*")){
              Exp = Exp.substring(0, Exp.length() - 1) + b.getText()+"";
            }}
            else{
             if (Answer.getText()+""==TempText) {
               Exp = Exp + TempText+b.getText()+"";
              }
             else {
                Exp=Exp+Answer.getText()+b.getText()+"";
            }}
            TempText="";
            Answer.setText("0");
    }
        public void handlesubmit(View view){
         if (TempText==null) {
                Exp = Exp + TempText;
            }
         else
            {
                Exp=Exp+Answer.getText()+"";
            }
         double ans=EvaluateString.eval(Exp);
         Answer.setText(ans+"");
         Exp=ans+"";
        }
        public void clearall(View view){
          Exp="";
          TempText="";
          Answer.setText("0");
        }

}
