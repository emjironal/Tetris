package com.example.eduardo_jiron.tretris;

public class Tablero
{
    /**
     * Tablero virtual disponible para moverse
     */
    private TipoFigura[][] tablero;
    /**
     * Figura que se encuentra cayendo
     */
    private Figura figuraActiva;

    /**
     * Constructor de la clase Tablero
     * @param rows cantidad de filas disponibles para moverse
     * @param columns cantidad de columnas disponibles para moverse
     */
    public Tablero(int rows, int columns)
    {
        tablero = new TipoFigura[rows][columns];
        vaciarTablero();
    }

    public void rotarFiguraActual()
    {
        for(Cuadro cuadro : figuraActiva.getCuadros())
        {
            tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.VACIO;
        }
        figuraActiva.rotarFigura();
        for(Cuadro cuadro : figuraActiva.getCuadros())
        {
            tablero[cuadro.getColumn()][cuadro.getRow()] = TipoFigura.ACTUAL;
        }
    }

    /**
     * Devuelve el tipo de figura de la figura actual
     * @return Devuelve TipoFigura de figuraActual
     */
    public TipoFigura getTipoFiguraActual()
    {
        return figuraActiva.getTipoFigura();
    }

    /**
     * Obtiene el tablero
     * @return Devuelve el tablero
     */
    public TipoFigura[][] getTablero()
    {
        return tablero;
    }

    /**
     * Mueve la figura hacia la izquierda en el tablero si no se puede no la mueve
     */
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

    /**
     * Mueve la figura actual hacia la derecha en el tablero si no se puede no la mueve
     */
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

    /**
     * Mueve la figura activa hacia abajo en el tablero si no se puede la fija en el tablero y crea una nueva
     */
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

    /**
     * Crea una figura de manera aleatoria
     */
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

    /**
     * Limpia el tablero, pone la matriz virtual en TipoFigura.VACIO
     */
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
