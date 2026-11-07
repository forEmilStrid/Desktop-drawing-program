package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawTool implements Tool {
  private BufferedImage canvas;
  private ChangeManager changeManager;
  private JPanel canvasPanel;
  private List<Point> currChange = new ArrayList<>();
  protected BasicStroke brush;
  protected Color color;

  public DrawTool(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel) {
    this.canvas = canvas;
    this.changeManager = changeManager;
    this.canvasPanel = canvasPanel;
  }
  
  @Override
  public void onMouseDragged(int x, int y, int lastX, int lastY) {
    Graphics2D graphics = canvas.createGraphics();

    graphics.setColor(color);
    graphics.setStroke(brush);
    graphics.drawLine(lastX, lastY, x, y);
    graphics.dispose();
    canvasPanel.repaint();

    currChange.add(new Point(lastX, lastY));
  }

  @Override
  public void onMouseReleased(int x, int y, int lastX, int lastY) {
    if (!currChange.isEmpty()) {
      currChange.add(new Point(x, y));
      changeManager.addNewChange(new DrawCommand(new ArrayList<>(currChange), color, new BasicStroke(
        brush.getLineWidth(), 
        brush.getEndCap(), 
        brush.getLineJoin(), 
        brush.getMiterLimit(), 
        brush.getDashArray(),
        brush.getDashPhase()
      )));
      currChange = new ArrayList<>();
    }
  }

  @Override
  public void onMouseEntered(int x, int y, int lastX, int lastY) {
    canvasPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
  }

  @Override
  public void onMouseExited(int x, int y, int lastX, int lastY) {
    canvasPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
}

