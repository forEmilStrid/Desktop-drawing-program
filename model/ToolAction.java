package model;

import java.awt.image.BufferedImage;

public interface ToolAction {
  void performToolAction(BufferedImage canvas, int x, int y);
}
