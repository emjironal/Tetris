package com.example.eduardo_jiron.tretris;

public class Tablero
{
    private TipoFigura[][] tablero;
    private Figura figuraActiva;

    public Tablero(int rows, int columns)
    {
        tablero = new TipoFigura[rows][columns];
        vaciarTablero();
    }

    /**
     * Crea la figura activa
     * @param tipoFigura Forma de la figura (T, I, L, J, S, Z, O)
     */
    public void setFiguraActiva(TipoFigura tipoFigura)
    {
        figuraActiva = new Figura(tipoFigura, tablero[0].length, 0);
    }

    /**
     * Valida si mover izquierda la figura se puede
     * @return Devuelve si está vacío la posición izquierda de la figura
     */
    private boolean validarMoverIzquierda()
    {
        for(Cuadro cuadro : figuraActiva.getCuadros())
        {
            int x = cuadro.getX();
            int y = cuadro.getY() - 1;
            if(x >= tablero.length && y >= tablero[0].length && tablero[x][y] != TipoFigura.ACTUAL && tablero[x][y] != TipoFigura.VACIO)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida si mover derecha la figura se puede
     * @return Devuelve si está vacío la posición derecha de la figura
     */
    private boolean validarMoverDerecha()
    {
        for(Cuadro cuadro : figuraActiva.getCuadros())
        {
            int x = cuadro.getX();
            int y = cuadro.getY() + 1;
            if(x >= tablero.length && y >= tablero[0].length && tablero[x][y] != TipoFigura.ACTUAL && tablero[x][y] != TipoFigura.VACIO)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida si mover abajo la figura se puede
     * @return Devuelve si está vacío la posición abajo de la figura
     */
    private boolean validarMoverAbajo()
    {
        for(Cuadro cuadro : figuraActiva.getCuadros())
        {
            int x = cuadro.getX() + 1;
            int y = cuadro.getY();
            if(x >= tablero.length && y >= tablero[0].length && tablero[x][y] != TipoFigura.ACTUAL && tablero[x][y] != TipoFigura.VACIO)
            {
                return false;
            }
        }
        return true;
    }

    private void vaciarTablero()
    {
        for(int row = 0; row < tablero.length; row++)
        {
            for(int column = 0; column < tablero[0].length; column++)
            {
                tablero[row][column] = TipoFigura.VACIO;
            }
        }
    }
}
