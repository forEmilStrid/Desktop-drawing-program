package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class PenTool implements Tool {
  private BufferedImage canvas;
  private ChangeManager changeManager;

  public PenTool(BufferedImage canvas, ChangeManager changeManager) {
    this.canvas = canvas;
    this.changeManager = changeManager;
  }


  @Override
  public void onMouseDragged(int x, int y, int lastX, int lastY, Color color) {
    Graphics2D graphics = canvas.createGraphics();
    graphics.setColor(color);
    graphics.drawLine(lastX, lastY, x, y);
    graphics.dispose();
  }

  @Override
  public String toString() {
    return "Pen";
  }
}
