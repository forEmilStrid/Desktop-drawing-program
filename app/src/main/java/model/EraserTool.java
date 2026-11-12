package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class EraserTool extends DrawTool implements HasThickness {

  public EraserTool(Canvas canvas, ChangeManager changeManager, JPanel canvasPanel) {
    super(canvas, changeManager, canvasPanel);
    color = Color.WHITE;
    setThickness(5.0f);
  }

  @Override
  public void setThickness(float thickness) {
    brush = new BasicStroke(thickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
  }

  @Override
  public float getThickness() {
    return brush.getLineWidth();
  }

  @Override
  public String toString() {
    return "ERASER";
  }
}
