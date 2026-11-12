package model;

import java.awt.image.BufferedImage;

public interface Command {
  void execute(Canvas canvas);

  public default boolean shouldStack() {
    return true;
  }
}
