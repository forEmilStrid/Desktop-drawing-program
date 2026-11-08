package model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public abstract class SelectionTool extends CanvasTool {

  private ToolController toolController;

  protected int startX;
  protected int startY;
  
  public SelectionTool(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel, ToolController toolController) {
    super(canvas, changeManager, canvasPanel);
    this.toolController = toolController;
  }

  @Override
  public void onMouseReleased(int x, int y, int lastX, int lastY) {
    changeManager.redraw();

    float recX = Math.min(startX, x);
    float recY = Math.min(startY, y);
    float dx = (float) Math.abs(startX - x);
    float dy = (float) Math.abs(startY - y);
    Shape sel = getShape(recX, recY, dx, dy);

    toolController.setTool(new Selection(canvas, changeManager, sel));
    //Drawing.drawShape(canvas, sel, Color.WHITE);


    if (!sel.getBounds().isEmpty()) {
      changeManager.addNewChange(new SelectionCommand(sel));
    }
  }

  @Override
  public void onMouseBeginDragg(int x, int y, int lastX, int lastY) {
    startX = x;
    startY = y;
  }

  @Override
  public void onMouseDragged(int x, int y, int lastX, int lastY) {
    changeManager.redraw();
    drawSelectionShape(x, y);
  }

  @Override
  public void onMouseClicked(int x, int y, int lastX, int lastY) {
    changeManager.redraw();
  }

  @Override
  public void onMouseEntered(int x, int y, int lastX, int lastY) {
    canvasPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
  }

  @Override
  public void onMouseExited(int x, int y, int lastX, int lastY) {
    canvasPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }

  protected abstract void drawSelectionShape(int x, int y);
  protected abstract Shape getShape(float recX, float recY, float dx, float dy);
}
