package com.example.eduardo_jiron.tretris;

public class Cuadro
{
    /**
     * Posición en x del cuadro
     */
    private int x;

    /**
     * Posición en y del cuadro
     */
    private int y;

    /**
     * Constructor de la clase Cuadro
     * @param pX
     * @param pY
     */
    public Cuadro(int pX, int pY)
    {
        x = pX;
        y = pY;
    }

    /**
     * Método que cambia la posición del cuadro hacia abajo
     */
    public void moverAbajo()
    {
        y++;
    }

    /**
     * Método que cambia la posición del cuadro hacia arriba
     */
    public void moverArriba()
    {
        y--;
    }

    /**
     * Método que cambia la posición del cuadro hacia la derecha
     */
    public void moverDerecha()
    {
        x++;
    }

    /**
     * Método que cambia la posición del cuadro hacia la izquierda
     */
    public void moverIzquierda()
    {
        x--;
    }

    /**
     * Getter de x
     * @return
     */
    public int getX()
    {
        return x;
    }

    /**
     * Getter de y
     * @return
     */
    public int getY()
    {
        return y;
    }
}
