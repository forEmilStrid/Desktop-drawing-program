package model;

import java.awt.Color;
import java.util.List;
import java.util.Map;

public interface ToolCommand {
  Command getCommand(List<int[]> pixels);
}
