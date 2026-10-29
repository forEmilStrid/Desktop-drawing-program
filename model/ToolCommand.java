package model;

import java.awt.Color;
import java.util.Map;

public interface ToolCommand {
  Command getCommand(Map<int[], Color> pixels);
}
