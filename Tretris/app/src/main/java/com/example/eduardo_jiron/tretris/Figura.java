package com.example.eduardo_jiron.tretris;

import java.util.ArrayList;

public class Figura
{
    /**
     * Lista de los cuadros que pertenece a la figura
     */
    private ArrayList<Cuadro> cuadros;
    private TipoFigura tipoFigura;
    private String orientacion = "normal";

    /**
     * Constructor de la clase Figura
     * @param idFigura Tipo de figura que se desea crear en el tetris
     * @param y columna en la que se ubica el inicio de la figura
     * @param x fila en la que se ubica el inicio de la figura
     */
    public Figura(TipoFigura idFigura, int y, int x)
    {
        cuadros = new ArrayList<>();
        switch (idFigura)
        {
            case T:
                crearFiguraT(x, y);
                tipoFigura = TipoFigura.T;
                break;
            case J:
                crearFiguraJ(x, y);
                tipoFigura = TipoFigura.J;
                break;
            case L:
                crearFiguraL(x, y);
                tipoFigura = TipoFigura.L;
                break;
            case S:
                crearFiguraS(x, y);
                tipoFigura = TipoFigura.S;
                break;
            case Z:
                crearFiguraZ(x, y);
                tipoFigura = TipoFigura.Z;
                break;
            case O:
                crearFiguraO(x, y);
                tipoFigura = TipoFigura.O;
                break;
            case I:
                tipoFigura = TipoFigura.I;
                crearFiguraI(x, y);
                break;
        }
    }

    /**
     * Rota la figura L
     */
    private void rotarFiguraL()
    {
        if(orientacion.equals("normal"))
        {
            orientacion = "izquierda";
            cuadros.get(0).row += 2; cuadros.get(0).column += 0;
            cuadros.get(1).row += 1; cuadros.get(1).column += 1;
            cuadros.get(2).row += 0; cuadros.get(2).column += 2;
            cuadros.get(3).row -= 1; cuadros.get(3).column += 1;
        }
        else if(orientacion.equals("izquierda"))
        {
            orientacion = "alreves";
            cuadros.get(0).row += 0; cuadros.get(0).column += 1;
            cuadros.get(1).row -= 1; cuadros.get(1).column += 0;
            cuadros.get(2).row -= 2; cuadros.get(2).column -= 1;
            cuadros.get(3).row -= 1; cuadros.get(3).column -= 2;
        }
        else if(orientacion.equals("alreves"))
        {
            orientacion = "derecha";
            cuadros.get(0).row -= 1; cuadros.get(0).column += 1;
            cuadros.get(1).row += 0; cuadros.get(1).column += 0;
            cuadros.get(2).row += 1; cuadros.get(2).column -= 1;
            cuadros.get(3).row += 2; cuadros.get(3).column += 0;
        }
        else
        {
            orientacion = "normal";
            cuadros.get(0).row -= 1; cuadros.get(0).column -= 2;
            cuadros.get(1).row += 0; cuadros.get(1).column -= 1;
            cuadros.get(2).row += 1; cuadros.get(2).column += 0;
            cuadros.get(3).row += 0; cuadros.get(3).column += 1;
        }
    }

    /**
     * Rota la figura J
     */
    private void rotarFiguraJ()
    {
        if(orientacion.equals("normal"))
        {
            orientacion = "izquierda";
            cuadros.get(0).row += 1; cuadros.get(0).column -= 1;
            cuadros.get(1).row += 0; cuadros.get(1).column += 0;
            cuadros.get(2).row -= 1; cuadros.get(2).column += 1;
            cuadros.get(3).row += 0; cuadros.get(3).column += 2;
        }
        else if(orientacion.equals("izquierda"))
        {
            orientacion = "alreves";
            cuadros.get(0).row += 1; cuadros.get(0).column += 0;
            cuadros.get(1).row += 0; cuadros.get(1).column -= 1;
            cuadros.get(2).row -= 1; cuadros.get(2).column -= 2;
            cuadros.get(3).row -= 2; cuadros.get(3).column -= 1;
        }
        else if(orientacion.equals("alreves"))
        {
            orientacion = "derecha";
            cuadros.get(0).row += 0; cuadros.get(0).column += 2;
            cuadros.get(1).row += 1; cuadros.get(1).column += 1;
            cuadros.get(2).row += 2; cuadros.get(2).column += 0;
            cuadros.get(3).row += 1; cuadros.get(3).column -= 1;
        }
        else
        {
            orientacion = "normal";
            cuadros.get(0).row -= 2; cuadros.get(0).column -= 1;
            cuadros.get(1).row -= 1; cuadros.get(1).column += 0;
            cuadros.get(2).row += 0; cuadros.get(2).column += 1;
            cuadros.get(3).row += 1; cuadros.get(3).column += 0;
        }
    }

    /**
     * Rota la figura
     */
    public void rotarFigura()
    {
        switch (tipoFigura)
        {
            case L:
                rotarFiguraL();
                break;
            case J:
                rotarFiguraJ();
                break;
        }
    }

    /**
     * Devuelve el tipo de figura
     * @return Devuelve tipoFigura
     */
    public TipoFigura getTipoFigura()
    {
        return tipoFigura;
    }

    /**
     * Devuelve el arreglo de cuadros
     * @return Devuelve el arreglo de cuadros
     */
    public ArrayList<Cuadro> getCuadros()
    {
        return cuadros;
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
    private void crearFiguraT(int x, int y)
    {
        /*
        ooo
         o
         */
        cuadros.add(new Cuadro(0 + x, 0 + y));
        cuadros.add(new Cuadro(0 + x, 1 + y));
        cuadros.add(new Cuadro(0 + x, 2 + y));
        cuadros.add(new Cuadro(1 + x, 1 + y));
    }

    /**
     * Crear la figura J
     */
    private void crearFiguraJ(int x, int y)
    {
        /*
         o
         o
        oo
         */
        cuadros.add(new Cuadro(0 + x, 1 + y));
        cuadros.add(new Cuadro(1 + x, 1 + y));
        cuadros.add(new Cuadro(2 + x, 1 + y));
        cuadros.add(new Cuadro(2 + x, 0 + y));
    }

    /**
     * Crear la figura L
     */
    private void crearFiguraL(int x, int y)
    {
        /*
        o
        o
        oo
         */
        cuadros.add(new Cuadro(0 + x, 0 + y));
        cuadros.add(new Cuadro(1 + x, 0 + y));
        cuadros.add(new Cuadro(2 + x, 0 + y));
        cuadros.add(new Cuadro(2 + x, 1 + y));
    }

    /**
     * Crear la figura S
     */
    private void crearFiguraS(int x, int y)
    {
        /*
         oo
        oo
         */
        cuadros.add(new Cuadro(1 + x, 0 + y));
        cuadros.add(new Cuadro(1 + x, 1 + y));
        cuadros.add(new Cuadro(0 + x, 1 + y));
        cuadros.add(new Cuadro(0 + x, 2 + y));
    }

    /**
     * Crear la figura Z
     */
    private void crearFiguraZ(int x, int y)
    {
        /*
        oo
         oo
         */
        cuadros.add(new Cuadro(0 + x, 0 + y));
        cuadros.add(new Cuadro(0 + x, 1 + y));
        cuadros.add(new Cuadro(1 + x, 1 + y));
        cuadros.add(new Cuadro(1 + x, 2 + y));
    }

    /**
     * Crear la figura O
     */
    private void crearFiguraO(int x, int y)
    {
        /*
        oo
        oo
         */
        cuadros.add(new Cuadro(0 + x, 0 + y));
        cuadros.add(new Cuadro(0 + x, 1 + y));
        cuadros.add(new Cuadro(1 + x, 0 + y));
        cuadros.add(new Cuadro(1 + x, 1 + y));
    }

    /**
     * Crear la figura I
     */
    private void crearFiguraI(int x, int y)
    {
        /*
        oooo
         */
        cuadros.add(new Cuadro(0 + x, 0 + y));
        cuadros.add(new Cuadro(0 + x, 1 + y));
        cuadros.add(new Cuadro(0 + x, 2 + y));
        cuadros.add(new Cuadro(0 + x, 3 + y));
    }
}
