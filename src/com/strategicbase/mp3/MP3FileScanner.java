/**
 * 
 */
package com.strategicbase.mp3;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author srinivasab
 * 
 */
public class MP3FileScanner {

	private static final FileFilter DIRECTORY_FILTER = new FileFilter() {
		@Override
		public boolean accept(File file) {
			return file.isDirectory();
		}
	};

	private static final FileFilter MP3_FILTER = new FileFilter() {
		@Override
		public boolean accept(File file) {
			String fileName = file.getName().toLowerCase();
			return !file.isDirectory() && fileName.endsWith(".mp3");
		}
	};

	public MP3FileScanner() {
	}

	public List<File> scan(File directory, boolean scanSubDirectories) {
		List<File> mp3FileList = new LinkedList<File>();
		for (File mp3File : directory.listFiles(MP3_FILTER)) {
			mp3FileList.add(mp3File);
		}
		if (scanSubDirectories) {
			for (File childDir : directory.listFiles(DIRECTORY_FILTER)) {
				mp3FileList.addAll(scan(childDir, scanSubDirectories));
			}
		}
		return mp3FileList;
	}
}
