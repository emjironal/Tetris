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

    public TipoFigura[][] getTablero()
    {
        return tablero;
    }

    public void moverIzquierda()
    {
        if(validarMoverIzquierda())
        {
            for(Cuadro cuadro : figuraActiva.getCuadros())
            {
                tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.VACIO;
            }
            figuraActiva.moverFiguraIzquierda();
            for(Cuadro cuadro : figuraActiva.getCuadros())
            {
                tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.ACTUAL;
            }
        }
    }

    public void moverDerecha()
    {
        if(validarMoverDerecha())
        {
            for(Cuadro cuadro : figuraActiva.getCuadros())
            {
                tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.VACIO;
            }
            figuraActiva.moverFiguraDerecha();
            for(Cuadro cuadro : figuraActiva.getCuadros())
            {
                tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.ACTUAL;
            }
        }
    }

    public void moverAbajo()
    {
        if(validarMoverAbajo())
        {
            for(Cuadro cuadro : figuraActiva.getCuadros())
            {
                tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.VACIO;
            }
            figuraActiva.moverFiguraAbajo();
            for(Cuadro cuadro : figuraActiva.getCuadros())
            {
                tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.ACTUAL;
            }
        }
        else
        {
            for(Cuadro cuadro : figuraActiva.getCuadros())
            {
                tablero[cuadro.getColumn()][cuadro.getRow()] = figuraActiva.getTipoFigura();
            }
            crearFigura();
        }
    }

    public void crearFigura()
    {
        int figura = (int)(Math.random() * 7);
        switch (figura)
        {
            case 0:
                setFiguraActiva(TipoFigura.T);
                break;
            case 1:
                setFiguraActiva(TipoFigura.J);
                break;
            case 2:
                setFiguraActiva(TipoFigura.L);
                break;
            case 3:
                setFiguraActiva(TipoFigura.S);
                break;
            case 4:
                setFiguraActiva(TipoFigura.Z);
                break;
            case 5:
                setFiguraActiva(TipoFigura.I);
                break;
            case 6:
                setFiguraActiva(TipoFigura.O);
                break;
            default:
                setFiguraActiva(TipoFigura.O);
                break;
        }
    }

    /**
     * Crea la figura activa
     * @param tipoFigura Forma de la figura (T, I, L, J, S, Z, O)
     */
    private void setFiguraActiva(TipoFigura tipoFigura)
    {
        int column = ((tablero[0].length - 2) / 2) - 1;
        figuraActiva = new Figura(tipoFigura, column, 0);
        for(Cuadro cuadro : figuraActiva.getCuadros())
        {
            tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.ACTUAL;
        }
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
            if(column < 0 || (tablero[column][row] != TipoFigura.ACTUAL && tablero[column][row] != TipoFigura.VACIO))
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
            if(column >= tablero[0].length || (tablero[column][row] != TipoFigura.ACTUAL && tablero[column][row] != TipoFigura.VACIO))
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
            if(row >= tablero.length || (tablero[column][row] != TipoFigura.ACTUAL && tablero[column][row] != TipoFigura.VACIO))
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
