package com.example.eduardo_jiron.tretris;

import java.util.ArrayList;

public class Figura
{
    /**
     * Lista de los cuadros que pertenece a la figura
     */
    private ArrayList<Cuadro> cuadros;

    /**
     * Constructor de la clase Figura
     * @param idFigura Tipo de figura que se desea crear en el tetris
     */
    public Figura(TipoFigura idFigura)
    {
        cuadros = new ArrayList<>();
        switch (idFigura)
        {
            case T:
                crearFiguraT();
                break;
            case J:
                crearFiguraJ();
                break;
            case L:
                crearFiguraL();
                break;
            case S:
                crearFiguraS();
                break;
            case Z:
                crearFiguraZ();
                break;
            case O:
                crearFiguraO();
                break;
            case I:
                crearFiguraI();
                break;
        }
    }

    /**
     * Mueve la figura hacia la izquierda
     */
    public void moverFiguraIzquierda()
    {
        for(Cuadro cuadro : cuadros)
        {
            cuadro.moverIzquierda();
        }
    }

    /**
     * Mueve la figura hacia la derecha
     */
    public void moverFiguraDerecha()
    {
        for(Cuadro cuadro : cuadros)
        {
            cuadro.moverDerecha();
        }
    }

    /**
     * Mueve la figura hacia abajo
     */
    public void moverFiguraAbajo()
    {
        for(Cuadro cuadro : cuadros)
        {
            cuadro.moverAbajo();
        }
    }

    /**
     * Crear la figura T
     */
    private void crearFiguraT()
    {
        /*
        ooo
         o
         */
        cuadros.add(new Cuadro(0, 0));
        cuadros.add(new Cuadro(0, 1));
        cuadros.add(new Cuadro(0, 2));
        cuadros.add(new Cuadro(1, 1));
    }

    /**
     * Crear la figura J
     */
    private void crearFiguraJ()
    {
        /*
         o
         o
        oo
         */
        cuadros.add(new Cuadro(0, 1));
        cuadros.add(new Cuadro(1, 1));
        cuadros.add(new Cuadro(2, 1));
        cuadros.add(new Cuadro(2, 0));
    }

    /**
     * Crear la figura L
     */
    private void crearFiguraL()
    {
        /*
        o
        o
        oo
         */
        cuadros.add(new Cuadro(0, 0));
        cuadros.add(new Cuadro(1, 0));
        cuadros.add(new Cuadro(2, 0));
        cuadros.add(new Cuadro(2, 1));
    }

    /**
     * Crear la figura S
     */
    private void crearFiguraS()
    {
        /*
         oo
        oo
         */
        cuadros.add(new Cuadro(1, 0));
        cuadros.add(new Cuadro(1, 1));
        cuadros.add(new Cuadro(0, 1));
        cuadros.add(new Cuadro(0, 2));
    }

    /**
     * Crear la figura Z
     */
    private void crearFiguraZ()
    {
        /*
        oo
         oo
         */
        cuadros.add(new Cuadro(0, 0));
        cuadros.add(new Cuadro(0, 1));
        cuadros.add(new Cuadro(1, 1));
        cuadros.add(new Cuadro(1, 2));
    }

    /**
     * Crear la figura O
     */
    private void crearFiguraO()
    {
        /*
        oo
        oo
         */
        cuadros.add(new Cuadro(0, 0));
        cuadros.add(new Cuadro(0, 1));
        cuadros.add(new Cuadro(1, 0));
        cuadros.add(new Cuadro(1, 1));
    }

    /**
     * Crear la figura I
     */
    private void crearFiguraI()
    {
        /*
        oooo
         */
        cuadros.add(new Cuadro(0, 0));
        cuadros.add(new Cuadro(0, 1));
        cuadros.add(new Cuadro(0, 2));
        cuadros.add(new Cuadro(0, 3));
    }
}
