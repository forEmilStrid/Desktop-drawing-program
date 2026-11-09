package model;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;

public class ToolController extends MouseAdapter {
  private Tool tool;
  private int lastX;
  private int lastY;
  private JPanel panel;
  private boolean mouseDown = false;

  public ToolController(Tool startingTool, JPanel panel) {
    this.panel = panel;
    tool = startingTool;
  }

  public void printTool() {
    System.out.println(tool.toString());
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public void setColor(Color color) {
    ((HasColor) tool).setColor(color);
  }

  public void setThickness(float thickness) {
    ((HasThickness) tool).setThickness(thickness);
  }

  public Color getColor() {
    return ((HasColor) tool).getColor();
  }

  public float getThickness() {
    return ((HasThickness) tool).getThickness();
  }

  private void update(int x, int y) {
    lastX = x;
    lastY = y;
    panel.repaint();
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseClicked(x, y, lastX, lastY);
    update(x, y);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMousePress(x, y, lastX, lastY);
    update(x, y);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    if (!mouseDown) {
      tool.onMouseBeginDragg(x, y, lastX, lastY);
      mouseDown = true;
    }
    else {
      tool.onMouseDragged(x, y, lastX, lastY);
    }
    update(x, y);
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseEntered(x, y, lastX, lastY);
    update(x, y);
  }

  @Override
  public void mouseExited(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseExited(x, y, lastX, lastY);
    update(x, y);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseMoved(x, y, lastX, lastY);
    update(x, y);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseReleased(x, y, lastX, lastY);
    mouseDown = false;
    update(x, y);
  }

  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseWheelMoved(x, y, lastX, lastY);
    update(x, y);
  }
}
