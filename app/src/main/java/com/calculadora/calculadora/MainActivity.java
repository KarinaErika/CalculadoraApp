package com.calculadora.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView campoTexto;
    float numeroA = 0;
    String operacao = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Operações");
        campoTexto = (TextView)findViewById(R.id.campoResultado);
        campoTexto.setText("0");
    }
    public  void clicaBotao(View view){
        switch (view.getId()){
            case R.id.btnSoma:
                calculaNumeros("+");
                break;
            case R.id.btnDivide:
                calculaNumeros("/");
                break;
            case R.id.btnMultiplica:
                calculaNumeros("*");
                break;
            case R.id.btnSubtrai:
                calculaNumeros("-");
                break;
            case R.id.btnClear:
                campoTexto.setText("0");
                numeroA = 0;
                operacao = "";
                break;
            case R.id.btnIgual:
                mostraResultado();
                break;
            default:
                String numb;
                numb = ((Button)view).getText().toString();
                getKeyboard(numb);
                break;
        }
    }
    public void calculaNumeros(String tiopoOperacao){
        numeroA = Float.parseFloat(campoTexto.getText().toString());
        operacao = tiopoOperacao;
        campoTexto.setText("0");
    }
    public  void getKeyboard(String str){
        String ScrCurrent = campoTexto.getText().toString();
        ScrCurrent += str;
        campoTexto.setText(ScrCurrent);
    }
    public  void mostraResultado(){
        float numeroB = Float.parseFloat(campoTexto.getText().toString());
        float result = 0;
        if(operacao.equals("+"))
            result = numeroB + numeroA;
        if(operacao.equals("-"))
            result = numeroA - numeroB;
        if(operacao.equals("*"))
            result = numeroB * numeroA;
        if(operacao.equals("/"))
            result = numeroA / numeroB;
        campoTexto.setText(String.valueOf(result)); //String.valueOf: converte String para float
    }
}
