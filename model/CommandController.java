package model;

import java.util.Stack;

public class CommandController {
  private Stack<Command> commandStack = new Stack<>();
  
  public void add(Command command) {
    commandStack.add(command);
  }

  
}
