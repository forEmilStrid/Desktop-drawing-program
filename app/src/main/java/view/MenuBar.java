package view;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

  public MenuBar() {
    var file = new JMenu("File");
    var newFile = new JMenuItem("new");
    var openFile = new JMenuItem("open");
    file.add(newFile); 
    file.add(openFile);
    
    add(file);
  }
}
