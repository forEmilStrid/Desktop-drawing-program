package view;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Tool;
import model.ToolController;
import model.ToolFactory;

public class ToolPicker extends JPanel {

  public ToolPicker() {
    setLayout(new GridLayout(0,1));
    setBorder(BorderFactory.createTitledBorder("Tools"));
  }
}
