package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import model.ChangeManager;

public class Window {

  public static void main() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Window(700, 700, new Color(49, 6, 47));
      }
    });
  }

  public Window(int width, int height, Color bgColor) {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());

    JPanel rightColumn = new RightColumn(bgColor);
    JPanel leftColumn = new LeftColumn(bgColor);

    JMenuBar menuBar = new MenuBar();

    BufferedImage canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    ChangeManager changeManager = new ChangeManager(canvasImage, 10, 10);
    JPanel canvas = new CanvasPanel(canvasImage, changeManager);
    



    frame.setContentPane(panel);
    frame.setJMenuBar(menuBar);
    panel.add(rightColumn, BorderLayout.EAST);
    panel.add(canvas, BorderLayout.CENTER);
    panel.add(leftColumn, BorderLayout.WEST);

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }
}
