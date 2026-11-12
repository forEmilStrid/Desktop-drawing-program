package model;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class RectangleSelectionTool extends SelectionTool {

  public RectangleSelectionTool(Canvas canvas, ChangeManager changeManager, JPanel canvasPanel, ToolController toolController) {
    super(canvas, changeManager, canvasPanel, toolController);
  }

  @Override
  protected void drawSelectionShape(int x, int y) {
    canvas.drawSelectionBorder(startX, startY, x, y);
  }

  @Override
  protected Shape getShape(float recX, float recY, float dx, float dy) {
    return new Rectangle(startX, startY, startY, startX);
  }
}
