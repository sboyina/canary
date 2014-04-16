/*
 * CanaryFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.strategicbase.canary.ui;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.SwingWorker;

import com.strategicbase.canary.ProgressListener;
import com.strategicbase.mp3.MP3TagSweeper;

/**
 * 
 * @author __USER__
 */
public class CanaryFrame extends javax.swing.JFrame {

	private static final Logger LOGGER = Logger.getLogger(CanaryFrame.class
			.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFileChooser fileChooser = new JFileChooser();

	/** Creates new form CanaryFrame */
	public CanaryFrame() {
		initComponents();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		processSubfolderFlag = new javax.swing.JCheckBox();
		progressBar = new javax.swing.JProgressBar();
		startBtn = new javax.swing.JButton();
		consolePane = new javax.swing.JScrollPane();
		console = new javax.swing.JTextArea();
		musicLibraryDirectoryLabel = new javax.swing.JLabel();
		directoryPathTextField = new javax.swing.JTextField();
		browseBtn = new javax.swing.JButton();
		stopBtn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("canary");
		setAlwaysOnTop(true);
		setBackground(new java.awt.Color(204, 204, 204));
		setResizable(false);

		processSubfolderFlag.setFont(new java.awt.Font("Calibri", 0, 12));
		processSubfolderFlag.setSelected(true);
		processSubfolderFlag.setText("Process sub folders recursively");
		processSubfolderFlag
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						processSubfolderFlagActionPerformed(evt);
					}
				});

		startBtn.setFont(new java.awt.Font("Calibri", 1, 14));
		startBtn.setText("Start");
		startBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startBtnActionPerformed(evt);
			}
		});

		consolePane
				.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		console.setBackground(new java.awt.Color(51, 51, 51));
		console.setColumns(20);
		console.setForeground(new java.awt.Color(255, 255, 255));
		console.setRows(5);
		consolePane.setViewportView(console);

		musicLibraryDirectoryLabel.setFont(new java.awt.Font("Calibri", 1, 12));
		musicLibraryDirectoryLabel.setText("Music Library Directory");
		musicLibraryDirectoryLabel.setFocusable(false);

		directoryPathTextField.setFont(new java.awt.Font("Calibri", 1, 12));
		directoryPathTextField.setToolTipText("Select folder to scan");

		browseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/sun/java/swing/plaf/windows/icons/Directory.gif"))); // NOI18N
		browseBtn.setMargin(new java.awt.Insets(5, 5, 5, 5));
		browseBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				browseBtnActionPerformed(evt);
			}
		});

		stopBtn.setFont(new java.awt.Font("Calibri", 1, 14));
		stopBtn.setText("Stop");
		stopBtn.setEnabled(false);
		stopBtn.setIconTextGap(5);
		stopBtn.setMargin(new java.awt.Insets(2, 4, 2, 4));
		stopBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopBtnActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														consolePane,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														551, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		musicLibraryDirectoryLabel,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		195,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		directoryPathTextField,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		293,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(8, 8, 8)
																.addComponent(
																		browseBtn))
												.addComponent(
														processSubfolderFlag,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														267,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		startBtn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		85,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		stopBtn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		85,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														progressBar,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														551, Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						musicLibraryDirectoryLabel,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						27,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						directoryPathTextField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						23,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(14, 14,
																		14)
																.addComponent(
																		processSubfolderFlag)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						startBtn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						32,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						stopBtn,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						31,
																						Short.MAX_VALUE))
																.addGap(18, 18,
																		18))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		browseBtn,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		25,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
								.addComponent(progressBar,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										20,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(consolePane,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										274, Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.task != null) {
			if (this.task.cancel(true)) {
				this.startBtn.setEnabled(true);
				this.stopBtn.setEnabled(false);
			}
		}
	}

	private void processSubfolderFlagActionPerformed(
			java.awt.event.ActionEvent evt) {

	}

	private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {
		File file = new File(this.directoryPathTextField.getText());
		if (!file.exists()) {
			LOGGER.log(Level.SEVERE, "Selected folder doesn't exist.");

		} else if (!file.isDirectory()) {
			LOGGER.log(Level.SEVERE,
					"Entered path doesn't refer to a directory.");
		} else {
			this.console.setText("");
			this.progressBar.setValue(0);
			this.task = new CanaryTask(file);
			this.task.execute();
			this.startBtn.setEnabled(false);
			this.stopBtn.setEnabled(true);
		}
	}

	private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String selectedDir = fileChooser.getSelectedFile()
					.getAbsolutePath();
			directoryPathTextField.setText(selectedDir);
		}
	}

	public javax.swing.JTextArea getConsolePane() {
		return console;
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton browseBtn;
	private javax.swing.JTextArea console;
	private javax.swing.JScrollPane consolePane;
	private javax.swing.JTextField directoryPathTextField;
	private javax.swing.JLabel musicLibraryDirectoryLabel;
	private javax.swing.JCheckBox processSubfolderFlag;
	private javax.swing.JProgressBar progressBar;
	private javax.swing.JButton startBtn;
	private javax.swing.JButton stopBtn;
	// End of variables declaration//GEN-END:variables

	private CanaryTask task;

	private class CanaryTask extends SwingWorker<Void, Void> {

		private File rootDir = null;

		CanaryTask(File rootDir) {
			this.rootDir = rootDir;
		}

		@Override
		protected Void doInBackground() throws Exception {
			MP3TagSweeper canary = new MP3TagSweeper();
			boolean includeSubFolders = processSubfolderFlag.isSelected();
			canary.updateAlbumTitle(rootDir.getAbsolutePath(),
					includeSubFolders, new ProgressListener() {
						@Override
						public void setProgress(int progressPercentage) {
							progressBar.setValue(progressPercentage);
							if (progressPercentage > 99) {
								startBtn.setEnabled(true);
							}
						}
					});
			return null;
		}
	}

}