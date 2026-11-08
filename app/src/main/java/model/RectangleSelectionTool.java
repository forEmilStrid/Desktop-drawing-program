package model;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class RectangleSelectionTool extends SelectionTool {

  private int startX;
  private int startY;

  public RectangleSelectionTool(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel) {
    super(canvas, changeManager, canvasPanel);
  }

  @Override
  public void onMouseBeginDragg(int x, int y, int lastX, int lastY) {
    startX = x;
    startY = y;
  }

  @Override
  public void onMouseDragged(int x, int y, int lastX, int lastY) {
    changeManager.redraw();
    Drawing.drawSelectionBorder(canvas, startX, startY, x, y);
  }

  @Override
  public void onMouseReleased(int x, int y, int lastX, int lastY) {
    float recX = Math.min(startX, x);
    float recY = Math.min(startY, y);
    float dx = (float) Math.abs(startX - x);
    float dy = (float) Math.abs(startY - y);
    Rectangle2D sel = new Rectangle2D.Float(recX, recY, dx, dy);
    if (!sel.isEmpty()) {
      changeManager.addNewChange(new SelectionCommand(sel));
    }
  }

}
