package view;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.ToolController;
import model.ToolFactory;

public class ToolPicker extends JPanel {

  public ToolPicker(ToolController toolController, ToolFactory toolFactory) {

    setLayout(new GridLayout(0,1));

    var penButton = new ToolButton(() -> {
      toolController.setTool(toolFactory.createTool("pen"));
      toolController.printTool();
    });
    penButton.setText("PEN");
    var eraserButton = new ToolButton(() -> {
      toolController.setTool(toolFactory.createTool("eraser"));
      toolController.printTool();
    });
    eraserButton.setText("ERASER");



    add(penButton);
    add(eraserButton);
  }
}
