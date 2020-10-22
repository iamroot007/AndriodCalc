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
    String Exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Answer=(EditText)findViewById(R.id.edt1);
        Exp="";
    }
    public void handleinput(View view) {
             Button b = (Button)view;
             Answer.setText(Answer.getText()+""+b.getText()+"");
    }
    public void handleoperand(View view){
            Button b = (Button)view;
            if (Answer.getText().toString()==""){
            if (Exp.endsWith("+")||Exp.endsWith("-")||Exp.endsWith("/")||Exp.endsWith("*")){
              Exp = Exp.substring(0, Exp.length() - 1) + b.getText()+"";
            }}
            else{
                Exp=Exp+Answer.getText()+b.getText()+"";
            }
            Answer.setText("");
    }
    public void handlesubmit(View view){
        Exp = Exp + Answer.getText()+"";
        double ans=EvaluateString.eval(Exp);
        Answer.setText(ans+"");
        Exp=ans+"";
    }
    public void clearall(View view){
          Exp="";
          Answer.setText("");
    }

}
