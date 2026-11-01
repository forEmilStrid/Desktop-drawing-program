package model;

import java.awt.image.BufferedImage;
import java.util.List;

public class DrawCommand implements Command {
  private List<int[]> data;

  public DrawCommand(List<int[]> data) {
    this.data = data;
  }

  @Override
  public void execute(BufferedImage canvas) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'execute'");
  }

  @Override
  public void undo(BufferedImage canvas) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'undo'");
  }

}
