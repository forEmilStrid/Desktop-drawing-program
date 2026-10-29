package model;

public class ToolController {
  private Tool tool;

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public void performToolAction() {
    tool.performToolAction();
  }

  public DrawCommand endToolAction() {
    return tool.endToolAction();
  }
}
