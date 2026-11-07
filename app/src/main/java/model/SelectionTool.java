package model;

import java.awt.Cursor;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class SelectionTool extends CanvasTool {

  protected Shape selection;
  
  public SelectionTool(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel) {
    super(canvas, changeManager, canvasPanel);
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
