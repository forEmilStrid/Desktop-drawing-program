package model;

import java.awt.Color;

public interface Tool {
  default void onMousePress(int x, int y, int lastX, int lastY) {};
  default void onMouseReleased(int x, int y, int lastX, int lastY) {};
  default void onMouseClicked(int x, int y, int lastX, int lastY) {};
  default void onMouseEntered(int x, int y, int lastX, int lastY) {};
  default void onMouseExited(int x, int y, int lastX, int lastY) {};
  default void onMouseDragged(int x, int y, int lastX, int lastY) {};
  default void onMouseMoved(int x, int y, int lastX, int lastY) {};
  default void onMouseWheelMoved(int x, int y, int lastX, int lastY) {};

  default void setColor(Color c) {};
  default void setThickness(float thickness) {};
}
