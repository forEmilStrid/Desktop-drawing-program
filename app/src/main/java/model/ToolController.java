package model;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;

public class ToolController extends MouseAdapter {
  private Tool tool;
  private Color color;
  private int lastX;
  private int lastY;
  private JPanel panel;

  public ToolController(Tool startingTool, Color startingColor, JPanel panel) {
    this.panel = panel;
    tool = startingTool;
    color = startingColor;
  }

  public void printTool() {
    System.out.println(tool.toString());
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public void setColor(Color color) {
    this.color = color;
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
    tool.onMouseClicked(x, y, lastX, lastY, color);
    update(x, y);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMousePress(x, y, lastX, lastY, color);
    update(x, y);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseDragged(x, y, lastX, lastY, color);
    update(x, y);
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseEntered(x, y, lastX, lastY, color);
    update(x, y);
  }

  @Override
  public void mouseExited(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseExited(x, y, lastX, lastY, color);
    update(x, y);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseMoved(x, y, lastX, lastY, color);
    update(x, y);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseReleased(x, y, lastX, lastY, color);
    update(x, y);
  }

  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    int x = e.getX();
    int y = e.getY();
    tool.onMouseWheelMoved(x, y, lastX, lastY, color);
    update(x, y);
  }
}
