package model;

import java.awt.Color;
import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;

public abstract class Tool {
  private ToolAction start, during;
  private ToolCommand end;
  private List<int[]> currChange;

  public Tool(ToolAction start, ToolAction during, ToolCommand end) {
    this.start = start;
    this.during = during;
    this.end = end;
    currChange = new ArrayList<>();
  }

  public void startToolAction(BufferedImage canvas, int x, int y) {
    start.performToolAction(canvas, x, y);
  }

  public void performToolAction(BufferedImage canvas, int x, int y, int lastX, int lastY) {
    during.performToolAction(canvas, x, y);
  }

  public Command endToolAction() {
    Command cmd = end.getCommand(currChange);
    currChange = new ArrayList<>();
    return cmd;
  }
}
