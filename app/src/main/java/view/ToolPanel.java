package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;

import model.Tool;
import model.ToolController;
import model.ToolFactory;

public class ToolPanel extends JPanel {

  private JPanel toolPicker = new ToolPicker();

  public ToolPanel(ToolFactory toolFactory, JColorChooser colorPicker, JSlider thicknesSlider, ToolController toolController) {
    super(new BorderLayout());
    add(toolPicker, BorderLayout.NORTH);

    Tool pen = toolFactory.createTool("pen", thicknesSlider.getValue() / 10, Color.BLACK);
    Tool eraser = toolFactory.createTool("eraser", thicknesSlider.getValue() / 10);
    Tool recSelector = toolFactory.createTool("recSelector");
    Icon penIcon = ViewUtils.iconFromPath("pen.png");
    Icon eraserIcon = ViewUtils.iconFromPath("sud.png");
    Icon recSelectIcon = ViewUtils.iconFromPath("sel.png");
    
    var penButton = new ToolButton(() -> {
      toolController.setTool(pen);
      toolController.setColor(colorPicker.getColor());
      thicknesSlider.setValue((int) toolController.getThickness() * 10);
      toolController.printTool();
    });
    penButton.setIcon(penIcon);
    var eraserButton = new ToolButton(() -> {
      toolController.setTool(eraser);
      thicknesSlider.setValue((int) toolController.getThickness() * 10);
      toolController.printTool();
    });
    eraserButton.setIcon(eraserIcon);
    var recSelectionButton = new ToolButton(() -> {
      toolController.setTool(recSelector);
    });
    recSelectionButton.setIcon(recSelectIcon);

    addBtn(penButton);
    addBtn(eraserButton);
    addBtn(recSelectionButton);
  }

  public void addBtn(JButton btn) {
    toolPicker.add(btn);
  }
}
