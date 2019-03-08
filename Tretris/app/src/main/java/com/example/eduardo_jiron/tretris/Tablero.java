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

    public void moverAbajo()
    {
        if(validarMoverAbajo())
        {
            for(Cuadro cuadro : figuraActiva.getCuadros())
            {
                tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.VACIO;
                tablero[cuadro.getColumn()][cuadro.getRow() + 1] = TipoFigura.ACTUAL;
            }
            figuraActiva.moverFiguraAbajo();
        }
        else
        {
            for(Cuadro cuadro : figuraActiva.getCuadros())
            {
                tablero[cuadro.getColumn()][cuadro.getRow()] = figuraActiva.getTipoFigura();
            }
        }
    }

    /**
     * Crea la figura activa
     * @param tipoFigura Forma de la figura (T, I, L, J, S, Z, O)
     */
    public void setFiguraActiva(TipoFigura tipoFigura)
    {
        int column = ((tablero[0].length - 2) / 2) - 1;
        figuraActiva = new Figura(tipoFigura, column, 0);
    }

    /**
     * Valida si mover izquierda la figura se puede
     * @return Devuelve si está vacío la posición izquierda de la figura
     */
    private boolean validarMoverIzquierda()
    {
        for(Cuadro cuadro : figuraActiva.getCuadros())
        {
            int column = cuadro.getColumn() - 1;
            int row = cuadro.getRow();
            if(column >= tablero[0].length && row >= tablero.length && tablero[column][row] != TipoFigura.ACTUAL && tablero[column][row] != TipoFigura.VACIO)
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
            int column = cuadro.getColumn() + 1;
            int row = cuadro.getRow();
            if(column >= tablero[0].length && row >= tablero.length && tablero[column][row] != TipoFigura.ACTUAL && tablero[column][row] != TipoFigura.VACIO)
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
            int column = cuadro.getColumn();
            int row = cuadro.getRow() + 1;
            if(column >= tablero[0].length && row >= tablero.length && tablero[column][row] != TipoFigura.ACTUAL && tablero[column][row] != TipoFigura.VACIO)
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
