package com.example.eduardo_jiron.tretris;

public class Cuadro
{
    private int x;
    private int y;

    public Cuadro(int pX, int pY)
    {
        x = pX;
        y = pY;
    }

    public void moverAbajo()
    {
        y++;
    }

    public void moverArriba()
    {
        y--;
    }

    public void moverDerecha()
    {
        x++;
    }

    public void moverIzquierda()
    {
        x--;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
