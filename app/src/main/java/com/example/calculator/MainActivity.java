package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonAdd, buttonSubtract, buttonClean, buttonMultiply, buttonDivide, buttonPower;
    private TextView operation, result;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Кнопки
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonClean = (Button) findViewById(R.id.buttonClean);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonPower = (Button) findViewById(R.id.buttonPower);

        //Текстовые поля
        operation = (TextView) findViewById(R.id.operation);
        result = (TextView) findViewById(R.id.result);

        //Поля ввода
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        //Установка прослушивателей кликов
        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
        buttonPower.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        //Объявляем необходимые переменные
        float num1 = 0;
        float num2 = 0;
        float res = 0;

        //Заполняем переменные числами
        num1 = Float.parseFloat(number1.getText().toString());
        num2 = Float.parseFloat(number2.getText().toString());

        //Операции
        switch (view.getId()){
            case R.id.buttonAdd:
                operation.setText("+");
                res = num1 + num2;
                break;
            case R.id.buttonSubtract:
                operation.setText("-");
                res = num1 - num2;
                break;
            case R.id.buttonDivide:
                operation.setText("/");
                res = num1 / num2;
                break;
            case R.id.buttonMultiply:
                operation.setText("*");
                res = num1 * num2;
                break;
            case R.id.buttonClean:
                number1.setText("");
                number2.setText("");
                operation.setText("");
                result.setText("");
                break;
            case R.id.buttonPower:
                operation.setText("^");
                res = (float) Math.pow(num1, num2);
                break;
        }
        result.setText(res + "");
    }
}