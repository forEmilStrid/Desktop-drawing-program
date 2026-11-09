package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.formdev.flatlaf.FlatDarkLaf; // or FlatLightLaf

import de.lars.colorpicker.ColorPicker;
import model.ChangeManager;
import model.PenTool;
import model.Tool;
import model.ToolController;
import model.ToolFactory;

public class Window {

  public static void main() {
    FlatDarkLaf.setup();

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Window(700, 700);
      }
    });
  }

  public Window(int width, int height) {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());


    JMenuBar menuBar = new MenuBar();

    BufferedImage canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    ChangeManager changeManager = new ChangeManager(canvasImage, 10, 10);
    JPanel canvas = new CanvasPanel(canvasImage, changeManager);
    ToolController toolController = new ToolController(new PenTool(canvasImage, changeManager, canvas), canvas);
    ToolFactory toolFactory = new ToolFactory(canvasImage, changeManager, canvas, toolController);
    JColorChooser colorPicker = new JColorChooser(Color.BLACK);
    JSlider thicknesSlider = new ThicknessSlider(5, 100, 50);


    canvas.addMouseListener(toolController);
    canvas.addMouseMotionListener(toolController);
    canvas.addMouseWheelListener(toolController);


    ToolSettingsPanel rightColumn = new ToolSettingsPanel(thicknesSlider, toolController, colorPicker);
    ToolPanel leftColumn = new ToolPanel(toolFactory, colorPicker, thicknesSlider, toolController);

    frame.setContentPane(panel);
    frame.setJMenuBar(menuBar);
    panel.add(rightColumn, BorderLayout.EAST);
    panel.add(canvas, BorderLayout.CENTER);
    panel.add(leftColumn, BorderLayout.WEST);

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }
}
