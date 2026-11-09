package view;

import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class ThicknessSlider extends JSlider {
  public ThicknessSlider(int min, int max, int value) {
    super(min, max, value);

    Hashtable<Integer, JLabel> thicknessTexts = new Hashtable<>();
    thicknessTexts.put(5, new JLabel("0.5"));
    thicknessTexts.put(24, new JLabel("2.4"));
    thicknessTexts.put(43, new JLabel("4.3"));
    thicknessTexts.put(62, new JLabel("6.2"));
    thicknessTexts.put(81, new JLabel("8.1"));
    thicknessTexts.put(100, new JLabel("10.0"));

    setLabelTable(thicknessTexts);
    setPaintLabels(true);
  
    setMajorTickSpacing(19);
    setMinorTickSpacing(1);
    setPaintLabels(true);
    setPaintTicks(true);

    setBorder(BorderFactory.createTitledBorder("Thickness"));
  }
}
