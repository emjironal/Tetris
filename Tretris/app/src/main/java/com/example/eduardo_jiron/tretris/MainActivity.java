package com.example.eduardo_jiron.tretris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar gridTablero
        try
        {
            GridLayout gridTablero = findViewById(R.id.gridTablero);
            for(int row = 0; row < gridTablero.getRowCount(); row++)
            {
                for(int column = 0; column < gridTablero.getColumnCount(); column++)
                {
                    ImageView imageView = new ImageView(this);
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(90, 90));
                    imageView.setImageResource(R.drawable.gray_square);
                    int index = getChildIndex(column, row, gridTablero.getColumnCount());
                    gridTablero.addView(imageView, index);
                }
            }
        }
        catch(Exception e)
        {
            Log.e("error", e.getMessage());
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Transforma una posición de la matriz en la posición del hijo del GridLayout
     * @param column
     * @param row
     * @param cantColumnas
     * @return
     */
    private int getChildIndex(int column, int row, int cantColumnas)
    {
        return (cantColumnas * row) + column;
    }

    /**
     * ActionPerformance del botón abajo
     * @param view
     */
    public void btnAbajoClicked(View view)
    {

    }

    /**
     * ActionPerformance del botón derecha
     * @param view
     */
    public void btnDerechaClicked(View view)
    {

    }

    /**
     * ActionPerformance del botón izquierda
     * @param view
     */
    public void btnIzquierdaClicked(View view)
    {

    }
}
