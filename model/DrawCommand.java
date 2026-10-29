package model;

import java.awt.Color;
import java.util.Map;

public class DrawCommand implements Command {
  private Map<int[], Color> data;

  public DrawCommand(Map<int[], Color> data) {
    this.data = data;
  }

  @Override
  public void execute(Canvas canvas) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'execute'");
  }

  @Override
  public void undo(Canvas canvas) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'undo'");
  }

}
