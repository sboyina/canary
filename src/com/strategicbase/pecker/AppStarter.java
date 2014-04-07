/**
 * 
 */
package com.strategicbase.pecker;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.strategicbase.pecker.ui.PeckerFrame;
import com.strategicbase.pecker.util.TextAreaLogAppender;

/**
 * @author srinivasab
 * 
 */
public class AppStarter {

	private static final TextAreaLogAppender TEXT_AREA_LOG_APPENDER = new TextAreaLogAppender();

	static {
		Logger rootLogger = Logger.getLogger("");
		Handler[] handlers = rootLogger.getHandlers();
		for (Handler handler : handlers) {
			rootLogger.removeHandler(handler);
		}
		rootLogger.setLevel(Level.INFO);
		rootLogger.addHandler(TEXT_AREA_LOG_APPENDER);
	}

	public static void centreWindow(JFrame frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// Its fine to go with default;
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				PeckerFrame peckerFrame = new PeckerFrame();
				centreWindow(peckerFrame);
				peckerFrame.setVisible(true);
				ImageIcon imgIcon = new ImageIcon(
						Toolkit.getDefaultToolkit()
								.getImage(
										getClass()
												.getResource(
														"/com/strategicbase/pecker/ui/images/pecker.png")));
				peckerFrame.setIconImage(imgIcon.getImage());
				TEXT_AREA_LOG_APPENDER.setTextArea(peckerFrame.getConsolePane());
			}
		});
	}
}
