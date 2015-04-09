package com.iteso.marco.sesion10.beans;

import java.util.ArrayList;

/**
 * Created by marco on 4/8/15.
 */
public class DatoResponse
{
    private ArrayList<Tree> dato;

    public DatoResponse()
    {
        setDato(new ArrayList<Tree>());
    }

    public ArrayList<Tree> getDato() {
        return dato;
    }

    public void setDato(ArrayList<Tree> dato) {
        this.dato = dato;
    }
}
