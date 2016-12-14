package integration.of.ecs;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
 
import javax.swing.*;
import java.awt.*;

/**...*/
public class JavaSwingSample {
public static void main(String[] args) {
Browser browser = new Browser();
BrowserView view = new BrowserView(browser);
 
JFrame frame = new JFrame();
frame.add(view, BorderLayout.CENTER);
frame.setSize(700, 500);
frame.setVisible(true);
 
browser.loadURL("http://localhost:8080/UploadPDF/");
}
}