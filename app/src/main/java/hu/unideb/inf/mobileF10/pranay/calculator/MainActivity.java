package hu.unideb.inf.mobileF10.pranay.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;    //don't initialize before setting the activity main(Which is in onCreate method)


    @Override
    protected void onCreate(Bundle savedInstanceState) {    //called after constructor
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.resultTextView);     //All xmls are found in "R" folder.
    }

    public void handleClick(View view) {    //view is superclass of all android components. (E.G. buttons, Textview...)
        Button btn = (Button)view;          //So you can type caste View into any component of android.
        switch(btn.getText().toString()){
            case "CE": result.setText("0"); break;
            case "=": result.setText(calculateResult()); break;
            default: result.append(btn.getText());
        }
    }

    private String calculateResult() {
        int op1, op2;
        char operator;
        String resultString = result.getText().toString();
        op1 = Integer.parseInt(resultString.split("[+\\-/*]")[0]); //if you want to use many delimiters, put them in [].
                                                                        //you can set [1-9] to use all numbers between 1 to 9
                                                                        //so to mask "-" minus, use "//" double backslash
        op2 = Integer.parseInt(resultString.split("[+\\-/*]")[1]);
        int operatorPosition = resultString.split("[+\\-/*]")[0].length();
        operator = resultString.charAt(operatorPosition);

        switch (operator){
            case '+': return ""+(op1+op2);
            case '-': return ""+(op1-op2);
            case '*': return ""+(op1*op2);
            case '/': return ""+(op1/op2);
        }
        return "";
    }
}