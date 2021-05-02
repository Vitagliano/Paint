/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author bielv
 */
public class PainelDesenho extends JPanel {

    private TipoDesenho tipo;

    private List<Forma> formas;
    private Forma formaTemp;

    private int xPress;
    private int yPress;

    private Color corContorno;
    private Color corPreenchimento;

    public PainelDesenho() {

        tipo = TipoDesenho.LINHA;
        formas = new ArrayList<>();
        corContorno = Color.BLACK;
        corPreenchimento = null;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xPress = e.getX();
                yPress = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                Forma novaForma = null;

                switch (tipo) {
                    case LINHA:
                        novaForma = new Linha();
                        break;

                    case RETANGULO:
                        novaForma = new Retangulo();
                        break;

                    case ELIPSE:
                        novaForma = new Elipse();
                        break;
                    

                }

                if (novaForma != null) {
                    novaForma.setXi(xPress);
                    novaForma.setYi(yPress);
                    novaForma.setXf(e.getX());
                    novaForma.setYf(e.getY());
                    novaForma.setCorContorno(corContorno);
                    novaForma.setCorPreenchimento(corPreenchimento);
                    formas.add(novaForma);

                    formaTemp = null;
                    repaint();

                }
            }

        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                switch (tipo) {
                    case LINHA:
                        formaTemp = new Linha();
                        break;

                    case RETANGULO:
                        formaTemp = new Retangulo();
                        break;

                    case ELIPSE:
                        formaTemp = new Elipse();
                        break;

                }

                formaTemp.setXi(xPress);
                formaTemp.setYi(yPress);
                formaTemp.setXf(e.getX());
                formaTemp.setYf(e.getY());
                formaTemp.setCorContorno(corContorno);
                formaTemp.setCorPreenchimento(corPreenchimento);

                repaint();
            }

        });

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        
        for (Forma forma : formas) {
            forma.desenhar(g2d);
        }

        if (formaTemp != null) {
            formaTemp.desenhar(g2d);
        }
    }

    public void setTipo(TipoDesenho tipo) {
        this.tipo = tipo;
    }

    public void setCorContorno(Color corContorno) {
        this.corContorno = corContorno;
    }

    public void setCorPreenchimento(Color corPreenchimento) {
        this.corPreenchimento = corPreenchimento;
    }

    public Color getCorContorno() {
        return corContorno;
    }

    public Color getCorPreenchimento() {
        return corPreenchimento;
    }

}
