package view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.*;


public class CanvasPanel extends JPanel {

  BufferedImage canvas;
  int lastX;
  int lastY;
  ToolController toolController;


  public CanvasPanel(BufferedImage canvas) {
    this.canvas = canvas;
    toolController = new ToolController();

    setPreferredSize(new Dimension(canvas.getWidth(), canvas.getHeight()));

    MouseAdapter mouseListener = new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        toolController.startToolAction(canvas, x, y);

        lastX = x;
        lastY = y;
      }

      @Override
      public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        toolController.performToolAction(canvas, x, y, lastX, lastY);

        lastX = x;
        lastY = y;
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        toolController.endToolAction();
      }
    };
  }

}
