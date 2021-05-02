/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author bielv
 */
public abstract class Forma {

    protected int xi;
    protected int yi;
    protected int xf;
    protected int yf;

    protected Color corContorno;
    protected Color corPreenchimento;

    public abstract void desenhar(Graphics g2d);

    public int getXi() {
        return xi;
    }

    public void setXi(int xi) {
        this.xi = xi;
    }

    public int getYi() {
        return yi;
    }

    public void setYi(int yi) {
        this.yi = yi;
    }

    public int getXf() {
        return xf;
    }

    public void setXf(int xf) {
        this.xf = xf;
    }

    public int getYf() {
        return yf;
    }

    public void setYf(int yf) {
        this.yf = yf;
    }

    public Color getCorContorno() {
        return corContorno;
    }

    public void setCorContorno(Color corContorno) {
        this.corContorno = corContorno;
    }

    public Color getCorPreenchimento() {
        return corPreenchimento;
    }

    public void setCorPreenchimento(Color corPreenchimento) {
        this.corPreenchimento = corPreenchimento;
    }
    
    
}
