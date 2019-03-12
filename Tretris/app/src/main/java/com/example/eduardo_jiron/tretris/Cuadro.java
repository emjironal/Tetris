package com.example.eduardo_jiron.tretris;

public class Cuadro
{
    /**
     * Posición en column del cuadro
     */
    public int column;

    /**
     * Posición en row del cuadro
     */
    public int row;

    /**
     * Constructor de la clase Cuadro
     * @param pColumn Posición en column del cuadro
     * @param pRow Posición en row del cuadro
     */
    public Cuadro(int pRow, int pColumn)
    {
        column = pColumn;
        row = pRow;
    }

    /**
     * Cambia la columna con la fila y la fila con la columna
     */
    public void trasponer()
    {
        int temp = column;
        column = row;
        row = temp;
    }

    /**
     * Refleja la columna del cuadro
     * @param cantColumns Cantidad de columnas de la matriz donde está el cuadro
     */
    public void mirrorColumn(int cantColumns)
    {
        column *= -1;
        column += cantColumns - 1;
    }

    /**
     * Método que cambia la posición del cuadro hacia abajo
     */
    public void moverAbajo()
    {
        row++;
    }

    /**
     * Método que cambia la posición del cuadro hacia la derecha
     */
    public void moverDerecha()
    {
        column++;
    }

    /**
     * Método que cambia la posición del cuadro hacia la izquierda
     */
    public void moverIzquierda()
    {
        column--;
    }

    /**
     * Getter de column
     * @return Devuelve la posición column del cuadro
     */
    public int getColumn()
    {
        return column;
    }

    /**
     * Getter de row
     * @return Devuelve la posición row del cuadro
     */
    public int getRow()
    {
        return row;
    }
}
