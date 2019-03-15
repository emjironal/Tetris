package com.example.eduardo_jiron.tretris;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
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
    private Integer speed = 1000;
    private boolean isPaused = false;

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
                    int width = gridTablero.getLayoutParams().width / gridTablero.getColumnCount();
                    int height = gridTablero.getLayoutParams().height / gridTablero.getRowCount();
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(width, height)); //Tamaño de la imagen
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
                    if(!isPaused)
                    {
                        btnAbajoClicked(null);
                        handler.postDelayed(this, speed);
                    }
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
        TipoFigura[][] temporalTablero = tablero.getTablero(); //tablero virtual
        GridLayout gridTablero = findViewById(R.id.gridTablero); //tablero grafico
        ImageView imageView; //imagen del tablero grafico
        TextView lbPpuntos = findViewById(R.id.lbCurrentPoints);
        lbPpuntos.setText("" + puntos);
        ArrayList<Integer> listOfFilledRows = new ArrayList<>(); //filas llenas
        boolean isRowFilled; //si la fila está llena
        for(int row = 0; row < temporalTablero.length; row++) //recorre las filas del tablero virtual
        {
            isRowFilled = true; //pone que la fila está llena
            for(int column = 0; column < temporalTablero[row].length; column++) //recorre las columnas de la fila del tablero virtual
            {
                imageView = (ImageView)gridTablero.getChildAt(getChildIndex(column + 1, row + 1, gridTablero.getColumnCount())); //Obtiene la posicion del tablero virtual en el grafico
                if(temporalTablero[row][column] != TipoFigura.VACIO) //si esa posicion diferente de vacía
                {
                    if(temporalTablero[row][column] == TipoFigura.ACTUAL) //si la posicion del tablero pertenece a la figura cayendo
                    {
                        pintarCuadro(imageView, tablero.getTipoFiguraActual()); //pinta el cuadro del tablero grafico
                        isRowFilled = false; //pone que la fila no está llena
                    }
                    else
                    {
                        pintarCuadro(imageView, temporalTablero[row][column]); //pinta el tablero grafico del color de la figura del tablero virtual
                        if(row < 2)
                        {
                            perder();
                            return;
                        }
                    }
                }
                else
                {
                    imageView.setImageResource(R.drawable.black_square); //pinta el tablero grafico como vacio
                    isRowFilled = false; //pone que la fila no está llena
                }
            }
            if(isRowFilled) //si la fila está llena
            {
                listOfFilledRows.add(row); //agrega el número de fila a la lista de filas llenas
            }
        }
        if(!listOfFilledRows.isEmpty()) //si la lista de filas vacías no está vacía
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

    public void perder()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                recreate();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        alertDialogBuilder.setMessage("¿Jugar de nuevo?");
        alertDialogBuilder.show();
    }

    private void destruirFilas(ArrayList<Integer> listOfFilledRows)
    {
        Double newSpeed = speed.doubleValue();
        for(int row : listOfFilledRows)
        {
            tablero.deleteRow(row);
            puntos += 10;
            newSpeed /= 1.1;
            speed = newSpeed.intValue();
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
        boolean isValid = tablero.moverAbajo();
        recargarTablero();
        if(!isValid)
        {
            tablero.crearFigura();
            recargarTablero();
        }
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
