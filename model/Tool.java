package model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public abstract class Tool {
  private ToolAction start, during;
  private ToolCommand end;
  private Map<int[], Color> currChange;

  public Tool(ToolAction start, ToolAction during, ToolCommand end) {
    this.start = start;
    this.during = during;
    this.end = end;
    currChange = new HashMap<>();
  }

  public void startToolAction(Canvas canvas, int x, int y) {
    start.performToolAction(canvas, x, y);
  }

  public void performToolAction(Canvas canvas, int x, int y) {
    during.performToolAction(canvas, x, y);
  }

  public Command endToolAction() {
    Command cmd = end.getCommand(currChange);
    currChange = new HashMap<>();
    return cmd;
  }
}
