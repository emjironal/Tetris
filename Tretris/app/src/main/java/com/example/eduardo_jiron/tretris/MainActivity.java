package com.example.eduardo_jiron.tretris;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    /**
     * Tablero virtual
     */
    private Tablero tablero;
    /**
     * Puntos que lleva el jugador
     */
    private int puntos = 0;
    /**
     * Hace que las fichas se muevan solas
     */
    private Runnable runnable;
    /**
     * Controla el runnable
     */
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar gridTablero
        try
        {
            GridLayout gridTablero = findViewById(R.id.gridTablero);
            tablero = new Tablero(gridTablero.getRowCount() - 2, gridTablero.getColumnCount() - 2);
            for(int row = 0; row < gridTablero.getRowCount(); row++)
            {
                for(int column = 0; column < gridTablero.getColumnCount(); column++)
                {
                    ImageView imageView = new ImageView(this);
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(45, 45)); //Tamaño de la imagen
                    if(row == (gridTablero.getRowCount() - 1) || row == 0 || column == (gridTablero.getColumnCount() - 1) || column == 0)
                    {
                        imageView.setImageResource(R.drawable.gray_square);
                    }
                    else
                    {
                        imageView.setImageResource(R.drawable.black_square);
                    }
                    int index = getChildIndex(column, row, gridTablero.getColumnCount());
                    gridTablero.addView(imageView, index);
                }
            }
            tablero.crearFigura();
            recargarTablero();
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run()
                {
                    tablero.moverAbajo();
                    recargarTablero();
                    handler.postDelayed(this, 1000);
                }
            };
            runnable.run();
        }
        catch(Exception e)
        {
            Log.e("error", e.getMessage());
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Pinta un cuadro en el tablero
     * @param imageView ImageView del cuadro en el GUI
     * @param tipoFigura TipoFigura del cuadro a pintar
     */
    private void pintarCuadro(ImageView imageView, TipoFigura tipoFigura)
    {
        switch (tipoFigura)
        {
            case I:
                imageView.setImageResource(R.drawable.cyan_square);
                break;
            case O:
                imageView.setImageResource(R.drawable.yellow_square);
                break;
            case Z:
                imageView.setImageResource(R.drawable.green_square);
                break;
            case S:
                imageView.setImageResource(R.drawable.red_square);
                break;
            case L:
                imageView.setImageResource(R.drawable.orange_square);
                break;
            case J:
                imageView.setImageResource(R.drawable.blue_square);
                break;
            case T:
                imageView.setImageResource(R.drawable.magenta_square);
                break;
        }
    }

    /**
     * Refresca el tablero, recarga los colores en las posiciones correctas
     */
    private void recargarTablero()
    {
        TipoFigura[][] temporalTablero = tablero.getTablero();
        GridLayout gridTablero = findViewById(R.id.gridTablero);
        ImageView imageView;
        ArrayList<Integer> listOfFilledRows = new ArrayList<>();
        for(int row = 0; row < temporalTablero.length; row++)
        {
            boolean isRowFilled = true;
            for(int column = 0; column < temporalTablero[row].length; column++)
            {
                imageView = (ImageView)gridTablero.getChildAt(getChildIndex(column + 1, row + 1, gridTablero.getColumnCount()));
                if(temporalTablero[column][row] != TipoFigura.VACIO)
                {
                    if(temporalTablero[column][row] == TipoFigura.ACTUAL)
                    {
                        pintarCuadro(imageView, tablero.getTipoFiguraActual());
                    }
                    else
                    {
                        pintarCuadro(imageView, temporalTablero[column][row]);
                    }
                }
                else
                {
                    imageView.setImageResource(R.drawable.black_square);
                    isRowFilled = false;
                }
            }
            if(isRowFilled)
            {
                listOfFilledRows.add(row);
            }
        }
        if(!listOfFilledRows.isEmpty())
        {
            try
            {
                destruirFilas(listOfFilledRows);
            }
            catch (Exception e)
            {
                Log.e("error", e.getMessage());
            }
        }
    }

    private void destruirFilas(ArrayList<Integer> listOfFilledRows)
    {
        for(int row : listOfFilledRows)
        {
            Log.e("error", "row: " + row);
            tablero.deleteRow(row);
        }
        recargarTablero();
    }

    /**
     * Transforma una posición de la matriz en la posición del hijo del GridLayout
     * @param column Número de columna
     * @param row Número de fila
     * @param cantColumnas Cantidad total de columnas
     * @return Retorna el index del hijo en el GridLayout
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
        tablero.moverAbajo();
        recargarTablero();
    }

    /**
     * ActionPerformance del botón derecha
     * @param view
     */
    public void btnDerechaClicked(View view)
    {
        tablero.moverDerecha();
        recargarTablero();
    }

    /**
     * ActionPerformance del botón izquierda
     * @param view
     */
    public void btnIzquierdaClicked(View view)
    {
        tablero.moverIzquierda();
        recargarTablero();
    }

    public void btnRotarClicked(View view)
    {
        tablero.rotarFiguraActual();
        recargarTablero();
    }
}
