package model;

import java.awt.image.BufferedImage;

public class EmptyCommand implements Command {

  @Override
  public void execute(BufferedImage canvas) {}

  @Override
  public void undo(BufferedImage canvas) {}

  @Override
  public boolean shouldStack() {
    return false;
  }
}
