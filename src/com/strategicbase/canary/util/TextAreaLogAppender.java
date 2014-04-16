/**
 * 
 */
package com.strategicbase.canary.util;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import javax.swing.JTextArea;

/**
 * @author srinivasab
 * 
 */
public class TextAreaLogAppender extends Handler {

	private JTextArea textArea;

	public TextAreaLogAppender() {
	}

	public void setTextArea(final JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void publish(LogRecord record) {
		if (textArea != null) {
			textArea.append(record.getMessage());
			textArea.append("\n");
		}
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws SecurityException {
		// TODO Auto-generated method stub

	}
}
