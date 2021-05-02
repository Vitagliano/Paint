/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author bielv
 */
public class Retangulo extends Forma {

    @Override
    public void desenhar(Graphics g2d) {

        g2d = (Graphics2D) g2d.create();

        int xdi = xi <= xf ? xi : xf;
        int ydi = yi <= yf ? yi : yf;
        int xdf = xi <= xf ? xf : xi;
        int ydf = yi <= yf ? yf : yi;

        if (corPreenchimento != null) {
            g2d.setColor(corPreenchimento);
            g2d.fillRect(xdi, ydi, xdf - xdi, ydf - ydi);
        }

        if (corContorno != null) {
            g2d.setColor(corContorno);
            g2d.drawRect(xdi, ydi, xdf - xdi, ydf - ydi);
        }
    }

}
