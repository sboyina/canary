/*
 * CanaryFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.strategicbase.canary.ui;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.SwingWorker;

import com.strategicbase.canary.ProgressListener;
import com.strategicbase.mp3.Input;
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
		startBtn = new javax.swing.JButton();
		musicLibraryDirectoryLabel = new javax.swing.JLabel();
		directoryPathTextField = new javax.swing.JTextField();
		browseBtn = new javax.swing.JButton();
		stopBtn = new javax.swing.JButton();
		copyFolderNameAsAlbumTitle = new javax.swing.JCheckBox();
		copyFileNameAsSongTitle = new javax.swing.JCheckBox();
		eraseAlbumArtistTags = new javax.swing.JCheckBox();
		processPanel = new javax.swing.JPanel();
		consolePane = new javax.swing.JScrollPane();
		console = new javax.swing.JTextArea();
		progressBar = new javax.swing.JProgressBar();

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

		copyFolderNameAsAlbumTitle.setFont(new java.awt.Font("Calibri", 0, 12));
		copyFolderNameAsAlbumTitle.setSelected(true);
		copyFolderNameAsAlbumTitle.setText("Copy folder name as album title");
		copyFolderNameAsAlbumTitle
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						copyFolderNameAsAlbumTitleActionPerformed(evt);
					}
				});

		copyFileNameAsSongTitle.setFont(new java.awt.Font("Calibri", 0, 12));
		copyFileNameAsSongTitle.setSelected(true);
		copyFileNameAsSongTitle.setText("Copy file name as song title");
		copyFileNameAsSongTitle
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						copyFileNameAsSongTitleActionPerformed(evt);
					}
				});

		eraseAlbumArtistTags.setFont(new java.awt.Font("Calibri", 0, 12));
		eraseAlbumArtistTags.setText("Erase album artist tags");

		console.setBackground(new java.awt.Color(51, 51, 51));
		console.setColumns(20);
		console.setForeground(new java.awt.Color(255, 255, 255));
		console.setRows(5);
		consolePane.setViewportView(console);

		javax.swing.GroupLayout processPanelLayout = new javax.swing.GroupLayout(
				processPanel);
		processPanel.setLayout(processPanelLayout);
		processPanelLayout.setHorizontalGroup(processPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(consolePane,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 551,
						Short.MAX_VALUE)
				.addComponent(progressBar,
						javax.swing.GroupLayout.DEFAULT_SIZE, 551,
						Short.MAX_VALUE));
		processPanelLayout.setVerticalGroup(processPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						processPanelLayout
								.createSequentialGroup()
								.addComponent(progressBar,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										20,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20)
								.addComponent(consolePane,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										291,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

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
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														processSubfolderFlag,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														267,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														copyFileNameAsSongTitle))
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED))
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										startBtn,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										85,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(15,
																										15,
																										15)))
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						eraseAlbumArtistTags)
																				.addComponent(
																						copyFolderNameAsAlbumTitle)
																				.addComponent(
																						stopBtn,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						75,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
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
														processPanel,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
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
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						processSubfolderFlag)
																				.addComponent(
																						copyFolderNameAsAlbumTitle)))
												.addComponent(
														browseBtn,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														25,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														copyFileNameAsSongTitle)
												.addComponent(
														eraseAlbumArtistTags))
								.addGap(18, 18, 18)
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
														34, Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(processPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void copyFileNameAsSongTitleActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	private void copyFolderNameAsAlbumTitleActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

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
	private javax.swing.JCheckBox copyFileNameAsSongTitle;
	private javax.swing.JCheckBox copyFolderNameAsAlbumTitle;
	private javax.swing.JTextField directoryPathTextField;
	private javax.swing.JCheckBox eraseAlbumArtistTags;
	private javax.swing.JLabel musicLibraryDirectoryLabel;
	private javax.swing.JPanel processPanel;
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
			Input input = new Input(rootDir.getAbsolutePath());
			input.setProcessSubFolders(includeSubFolders);
			input.setCopyFileNameAsSongTitle(copyFileNameAsSongTitle
					.isSelected());
			input.setCopyFolderNameAsAlbumTitle(copyFolderNameAsAlbumTitle
					.isSelected());
			input.setEraseAtrist(eraseAlbumArtistTags.isSelected());
			canary.updateAlbumTitle(input, new ProgressListener() {
				@Override
				public void setProgress(int progressPercentage) {
					progressBar.setValue(progressPercentage);
					if (progressPercentage > 99) {
						startBtn.setEnabled(true);
						stopBtn.setEnabled(false);
					}
				}
			});
			return null;
		}
	}

}