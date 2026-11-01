package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import model.ToolController;
import model.ToolFactory;

public class LeftColumn extends JPanel {
  public LeftColumn(ToolController toolController, ToolFactory toolFactory) {
    super(new BorderLayout());
    ToolPicker toolPicker = new ToolPicker(toolController, toolFactory);
    add(toolPicker, BorderLayout.NORTH);
  }
}
