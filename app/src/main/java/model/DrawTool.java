package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public abstract class DrawTool extends CanvasTool {
  private Path2D currChange = new Path2D.Float();
  protected BasicStroke brush;
  protected Color color;

  public DrawTool(Canvas canvas, ChangeManager changeManager, JPanel canvasPanel) {
    super(canvas, changeManager, canvasPanel);
  }

  
  @Override
  public void onMouseBeginDragg(int x, int y, int lastX, int lastY) {
    currChange.moveTo(lastX, lastY);
  }

  @Override
  public void onMouseDragged(int x, int y, int lastX, int lastY) {
    canvas.drawLine(lastX, lastY, x, y, color, brush);
    currChange.moveTo(lastX, lastY);
    currChange.lineTo(x, y);
  }

  @Override
  public void onMouseReleased(int x, int y, int lastX, int lastY) {
    if (!PathUtils.isEmpty(currChange)) {
      currChange.moveTo(lastX, lastY);
      currChange.lineTo(x, y);
      changeManager.addNewChange(new DrawCommand(currChange, color, new BasicStroke(
        brush.getLineWidth(), 
        brush.getEndCap(), 
        brush.getLineJoin(), 
        brush.getMiterLimit(), 
        brush.getDashArray(),
        brush.getDashPhase()
      )));
      currChange = new Path2D.Float();
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

