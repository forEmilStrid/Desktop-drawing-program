package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Window {

  public static void main() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Window();
      }
    });
  }

  public Window() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    ToolPicker toolPicker = new ToolPicker();
    CanvasWindow canvasWindow = new CanvasWindow();



    frame.setContentPane(panel);
    panel.setLayout(new BorderLayout());

    panel.add(toolPicker, SwingConstants.WEST);
    panel.add(canvasWindow, SwingConstants.CENTER);
  }
}
