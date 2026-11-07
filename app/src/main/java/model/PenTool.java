package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PenTool extends DrawTool {

  public PenTool(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel) {
    super(canvas, changeManager, canvasPanel);
    setThickness(5.0f);
    setColor(Color.BLACK);
  }

  @Override
  public void setColor(Color c) {
    color = c;
  }

  @Override
  public void setThickness(float thickness) {
    brush = new BasicStroke(thickness);
  }

  @Override
  public String toString() {
    return "Pen";
  }
}
