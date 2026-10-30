package model;

import java.awt.image.BufferedImage;

public class ToolController {
  private Tool tool;

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public void startToolAction(BufferedImage canvas, int x, int y) {
    tool.startToolAction(canvas, x, y);
  }  

  public void performToolAction(BufferedImage canvas, int x, int y, int lastX, int lastY) {
    tool.performToolAction(canvas, x, y, lastX, lastY);
  }

  public Command endToolAction() {
    return (tool.endToolAction());
  }
}
