package model;

import java.awt.Color;

public interface Tool {
  default void onMousePress(int x, int y, int lastX, int lastY, Color color) {};
  default void onMouseReleased(int x, int y, int lastX, int lastY, Color color) {};
  default void onMouseClicked(int x, int y, int lastX, int lastY, Color color) {};
  default void onMouseEntered(int x, int y, int lastX, int lastY, Color color) {};
  default void onMouseExited(int x, int y, int lastX, int lastY, Color color) {};
  default void onMouseDragged(int x, int y, int lastX, int lastY, Color color) {};
  default void onMouseMoved(int x, int y, int lastX, int lastY, Color color) {};
  default void onMouseWheelMoved(int x, int y, int lastX, int lastY, Color color) {};
}
