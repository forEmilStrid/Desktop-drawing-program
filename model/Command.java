package model;

import java.awt.image.BufferedImage;

public interface Command {
  void execute(BufferedImage canvas);
  void undo(BufferedImage canvas);

  public default boolean shouldStack() {
    return true;
  }
}
