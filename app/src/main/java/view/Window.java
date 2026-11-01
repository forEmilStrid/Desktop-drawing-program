package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import com.formdev.flatlaf.FlatDarkLaf; // or FlatLightLaf


import model.ChangeManager;
import model.PenTool;
import model.ToolController;
import model.ToolFactory;

public class Window {

  public static void main() {
    FlatDarkLaf.setup();

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Window(700, 700);
      }
    });
  }

  public Window(int width, int height) {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());


    JMenuBar menuBar = new MenuBar();

    BufferedImage canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    ChangeManager changeManager = new ChangeManager(canvasImage, 10, 10);
    JPanel canvas = new CanvasPanel(canvasImage, changeManager);
    ToolController toolController = new ToolController(new PenTool(canvasImage, changeManager), Color.BLACK, canvas);
    ToolFactory toolFactory = new ToolFactory(canvasImage, changeManager);

    canvas.addMouseListener(toolController);
    canvas.addMouseMotionListener(toolController);
    canvas.addMouseWheelListener(toolController);

    JPanel rightColumn = new RightColumn();
    JPanel leftColumn = new LeftColumn(toolController, toolFactory);

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
