package model;

import java.util.Map;

public interface ToolCommand {
  DrawCommand getCommand(Map<Integer, String> pixels);
}
