package com.cookandroid.project4_3;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRemainder;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);
        btnAdd = findViewById(R.id.BtnAdd);
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        btnRemainder = findViewById(R.id.BtnRemainder);
        textResult = findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnRemainder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String num1 = edit1.getText().toString();
        String num2 = edit2.getText().toString();
        double result = 0;

        try {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            switch (v.getId()) {
                case R.id.BtnAdd:
                    result = n1 + n2;
                    break;
                case R.id.BtnSub:
                    result = n1 - n2;
                    break;
                case R.id.BtnMul:
                    result = n1 * n2;
                    break;
                case R.id.BtnDiv:
                    if (n2 == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = n1 / n2;
                    break;
                case R.id.BtnRemainder:
                    if (n2 == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = n1 % n2;
                    break;
            }

            textResult.setText("계산 결과 : " + result);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
    }
}
