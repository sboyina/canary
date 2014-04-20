/**
 * 
 */
package com.strategicbase.mp3;

/**
 * @author srinivasab
 * 
 */
public class Input {

	private String libraryFolderPath;

	private boolean processSubFolders = true;

	private boolean copyFolderNameAsAlbumTitle;

	private boolean copyFileNameAsSongTitle;

	private boolean eraseAtrist;

	public Input(String libraryFolderPath) {
		this.libraryFolderPath = libraryFolderPath;
	}

	public String getLibraryFolderPath() {
		return libraryFolderPath;
	}

	public boolean isProcessSubFolders() {
		return processSubFolders;
	}

	public void setProcessSubFolders(boolean processSubFolders) {
		this.processSubFolders = processSubFolders;
	}

	public boolean isCopyFolderNameAsAlbumTitle() {
		return copyFolderNameAsAlbumTitle;
	}

	public void setCopyFolderNameAsAlbumTitle(boolean copyFolderNameAsAlbumTitle) {
		this.copyFolderNameAsAlbumTitle = copyFolderNameAsAlbumTitle;
	}

	public boolean isCopyFileNameAsSongTitle() {
		return copyFileNameAsSongTitle;
	}

	public void setCopyFileNameAsSongTitle(boolean copyFileNameAsSongTitle) {
		this.copyFileNameAsSongTitle = copyFileNameAsSongTitle;
	}

	public boolean isEraseAtrist() {
		return eraseAtrist;
	}

	public void setEraseAtrist(boolean eraseAtrist) {
		this.eraseAtrist = eraseAtrist;
	}

	public boolean isThereAnythingToProcess() {
		return this.copyFileNameAsSongTitle || this.copyFolderNameAsAlbumTitle
				|| this.eraseAtrist;
	}

}
