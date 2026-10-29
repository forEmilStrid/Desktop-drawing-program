package model;

import java.util.HashMap;
import java.util.Map;

public abstract class Tool {
  private ToolAction toolAction;
  private ToolCommand toolCommand;
  private Map<Integer, String> currChange;

  public Tool(ToolAction toolAction, ToolCommand toolCommand) {
    this.toolAction = toolAction;
    this.toolCommand = toolCommand;
    currChange = new HashMap<>();
  }

  public void performToolAction() {
    toolAction.performToolAction();
  }

  public DrawCommand endToolAction() {
    DrawCommand cmd = toolCommand.getCommand(currChange);
    currChange = new HashMap<>();
    return cmd;
  }
}
