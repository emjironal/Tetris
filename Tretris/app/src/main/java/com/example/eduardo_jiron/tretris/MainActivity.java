package com.example.eduardo_jiron.tretris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar gridTablero
        GridLayout gridTablero = findViewById(R.id.gridTablero);
        gridTablero.removeAllViews();
        for(int row = 0; row < gridTablero.getRowCount(); row++)
        {
            for(int column = 0; column < gridTablero.getColumnCount(); column++)
            {
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(10,10));
                imageView.setImageResource(R.drawable.gray_square);
                gridTablero.addView(imageView, column, row);
            }
        }
    }
}
