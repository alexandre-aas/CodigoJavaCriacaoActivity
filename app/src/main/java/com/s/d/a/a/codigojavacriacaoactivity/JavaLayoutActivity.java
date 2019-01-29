package com.s.d.a.a.codigojavacriacaoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android .widget.RelativeLayout;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class JavaLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //NÃO será usado o layout XML
        //setContentView(R.layout.activity_java_layout);

        //O Botão é instanciado 1º p/ poder ser incluido no layout
        Button btnPressionar = new Button(this);

        RelativeLayout layoutAct = new RelativeLayout(this);

        //Define a cor de fundo do layout
        layoutAct.setBackgroundColor(Color.BLUE);

        //define texto e cor de fundo do botão
        btnPressionar.setText("Pressione");
        btnPressionar.setBackgroundColor(Color.YELLOW);

        EditText edtNome = new EditText(this);

        //Usando IDs View. Foi criado préviamente o arquivo de resource id.xml
        btnPressionar.setId(R.id.btnPressionarId);
        edtNome.setId(R.id.edtNomeId);

        //Definir Altura(height) e largura(width) do botão (widget) p/ armazenar o conteúdo
        RelativeLayout.LayoutParams parametrosBtnPressionar = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //Centralizar botão dentro do layout
        parametrosBtnPressionar.addRule(RelativeLayout.CENTER_HORIZONTAL);
        parametrosBtnPressionar.addRule(RelativeLayout.CENTER_VERTICAL);

        //Definir Altura(height) e largura(width) do EditText (widget)  p/ armazenar o conteúdo
        RelativeLayout.LayoutParams parametrosEdtNome = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //Posiciona o edtNome acima do botão que está centralizado
        parametrosEdtNome.addRule(RelativeLayout.ABOVE, btnPressionar.getId());
        parametrosEdtNome.addRule(RelativeLayout.CENTER_HORIZONTAL);
        parametrosEdtNome.setMargins(0, 0, 0, 80);


        //Atenção p/ não vincular uma View + de uma vez no código p/ não gerar a exceção:
        //The specified child already has a parent. You must call removeView() on the child's parent first.
        layoutAct.addView(btnPressionar, parametrosBtnPressionar);
        layoutAct.addView(edtNome, parametrosEdtNome);

        //Uma outra forma de informar ao layout o widget\parametros
        //btnPressionar.setLayoutParams(parametrosBtnPressionar);

        //Converter dp em px
        Resources r = getResources();
        int pixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());

        edtNome.setWidth(pixels);

        setContentView(layoutAct);
    }
}
