package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class PenTool implements Tool {
  private BufferedImage canvas;
  private ChangeManager changeManager;
  private JPanel canvasPanel;
  private List<Point> currChange = new ArrayList<>();
  private Stroke brush = new BasicStroke(5.0f);

  public PenTool(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel) {
    this.canvas = canvas;
    this.changeManager = changeManager;
    this.canvasPanel = canvasPanel;
  }

  @Override
  public void onMouseDragged(int x, int y, int lastX, int lastY, Color color) {
    Graphics2D graphics = canvas.createGraphics();
    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

    graphics.setColor(color);
    graphics.drawLine(lastX, lastY, x, y);
    graphics.dispose();
    canvasPanel.repaint();

  }

  @Override
  public void onMouseReleased(int x, int y, int lastX, int lastY, Color color) {
    
  }

  @Override
  public void onMouseEntered(int x, int y, int lastX, int lastY, Color color) {
    canvasPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
  }

  @Override
  public void onMouseExited(int x, int y, int lastX, int lastY, Color color) {
    canvasPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }

  @Override
  public String toString() {
    return "Pen";
  }
}
