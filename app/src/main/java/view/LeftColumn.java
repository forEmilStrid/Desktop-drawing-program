package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class LeftColumn extends JPanel {
  public LeftColumn(Color bgColor) {
    super(new BorderLayout());
    setBackground(bgColor);
    ToolPicker toolPicker = new ToolPicker();
    toolPicker.setBackground(bgColor);
    add(toolPicker, BorderLayout.NORTH);
  }
}
