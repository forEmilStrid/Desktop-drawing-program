package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ToolController;

public class ToolSettingsPanel extends JPanel {

  private JSlider thicknesSlider;
  private ToolController toolController;
  private JColorChooser colorPicker;

  public ToolSettingsPanel(JSlider thicknesSlider, ToolController toolController, JColorChooser colorPicker) {
    this.thicknesSlider = thicknesSlider;
    this.toolController = toolController;
    this.colorPicker = colorPicker;

    super(new GridLayout(0, 1));
    add(colorPicker);
    add(new JSeparator());
    add(thicknesSlider);

    colorPicker.setBorder(BorderFactory.createTitledBorder("Color"));
    
    thicknesSlider.addChangeListener(new ChangeListener() {

      @Override
      public void stateChanged(ChangeEvent e) {
        toolController.setThickness((float) thicknesSlider.getValue() / 10);
      }
      
    });

    colorPicker.getSelectionModel().addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        toolController.setColor(colorPicker.getColor());
      }
    });

    colorPicker.setPreviewPanel(new JPanel());

    correctColorPanelMenuItems();

  }

  private void correctColorPanelMenuItems() {
    AbstractColorChooserPanel[] items = colorPicker.getChooserPanels();
    colorPicker.removeChooserPanel(items[0]);
    colorPicker.removeChooserPanel(items[2]);
    colorPicker.removeChooserPanel(items[3]);
    colorPicker.removeChooserPanel(items[4]);

  }

}
