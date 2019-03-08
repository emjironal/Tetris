package com.example.eduardo_jiron.tretris;

public class Cuadro
{
    /**
     * Posición en column del cuadro
     */
    private int column;

    /**
     * Posición en row del cuadro
     */
    private int row;

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
     * Método que cambia la posición del cuadro hacia abajo
     */
    public void moverAbajo()
    {
        row++;
    }

    /**
     * Método que cambia la posición del cuadro hacia arriba
     */
    public void moverArriba()
    {
        row--;
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
