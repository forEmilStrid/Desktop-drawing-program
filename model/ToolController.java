package model;

public class ToolController {
  private Tool tool;

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public void performToolAction(Canvas canvas, int x, int y) {
    tool.performToolAction(canvas, x, y);
  }

  public Command endToolAction() {
    return tool.endToolAction();
  }
}
