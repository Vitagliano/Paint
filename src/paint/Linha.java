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
public class Linha extends Forma {

    @Override
    public void desenhar(Graphics g2d) {

        g2d = (Graphics2D) g2d.create();
        if (corContorno != null) {
            g2d.setColor(corContorno);
            g2d.drawLine(xi, yi, xf, yf);
        }
    }

}
