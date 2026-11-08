package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import model.*;


public class CanvasPanel extends JPanel {

  private BufferedImage canvas;
  private ChangeManager changeManager;

  public CanvasPanel(BufferedImage canvas, ChangeManager changeManager) {
    this.canvas = canvas;
    this.changeManager = changeManager;

    setFocusable(true);
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(canvas.getWidth(), canvas.getHeight()));
    var g = canvas.createGraphics();
    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    g.dispose();

    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent arg0) {
        if (arg0.isControlDown()) {
          System.out.println("ctrl");
          switch (arg0.getKeyCode()) {
            case KeyEvent.VK_Z: 
              changeManager.undo();
              repaint();
              System.out.println(changeManager);
              break;
            case KeyEvent.VK_Y: 
              changeManager.redo();
              repaint();
              System.out.println(changeManager);
              break;
          }
        }
      }
    });

    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        requestFocusInWindow();
        repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
        requestFocusInWindow();
        repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        requestFocusInWindow();
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(canvas, 0, 0, this);
  }

}
