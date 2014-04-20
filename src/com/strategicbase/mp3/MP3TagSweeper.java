/**
 * 
 */
package com.strategicbase.mp3;

import java.io.File;
import java.util.List;
import java.util.jar.Pack200.Packer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.id3.ID3v24Tag;

import com.strategicbase.canary.ProgressListener;

/**
 * @author srinivasab
 * 
 */
public class MP3TagSweeper {

	private static final Logger LOGGER = Logger.getLogger(Packer.class
			.getName());

	public MP3TagSweeper() {
	}

	public void updateAlbumTitle(Input input, ProgressListener progressListener) {
		try {
			LOGGER.log(Level.INFO, "scanning for mp3 files ... ");
			List<File> mp3Files = new MP3FileScanner().scan(
					new File(input.getLibraryFolderPath()),
					input.isProcessSubFolders());
			int total = mp3Files.size();
			LOGGER.log(Level.INFO, total + " file(s) found.");
			LOGGER.log(Level.INFO, "processing ");
			int noOfProcessed = 0;
			for (File file : mp3Files) {
				updateAlbumTitleWithJAudio(file, input);
				noOfProcessed++;
				progressListener.setProgress((noOfProcessed * 100) / total);
			}
			LOGGER.log(Level.INFO, "Successfully processed " + total
					+ " file(s).");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					"Failed to process request due to  " + e.getMessage());
		}
	}

	private void updateAlbumTitleWithJAudio(File inputfile, Input input) {
		try {
			LOGGER.log(Level.INFO, "    " + inputfile.getAbsolutePath());
			if (!input.isThereAnythingToProcess()) {
				return;
			}
			String albumTitle = inputfile.getParentFile().getName()
					.toLowerCase();
			AudioFile audioFile = AudioFileIO.read(inputfile);
			Tag tag = getTag(audioFile);
			setTag(input.isCopyFileNameAsSongTitle(), tag, FieldKey.TITLE,
					inputfile.getName());
			setTag(input.isCopyFolderNameAsAlbumTitle(), tag, FieldKey.ALBUM,
					albumTitle);
			setTag(input.isEraseAtrist(), tag, FieldKey.ARTIST, "");
			setTag(input.isEraseAtrist(), tag, FieldKey.ALBUM_ARTIST, "");
			audioFile.commit();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,
					" Not able to process " + inputfile.getAbsolutePath()
							+ " due to:" + e.getMessage());
		}
	}

	private Tag getTag(AudioFile audioFile) {
		Tag tag = audioFile.getTag();
		if (tag == null) {
			tag = new ID3v24Tag();
			audioFile.setTag(tag);
		}
		return tag;
	}

	private void setTag(boolean doIt, Tag tag, FieldKey key, String value)
			throws KeyNotFoundException, FieldDataInvalidException {
		if (doIt) {
			List<TagField> fieldList = tag.getFields(key);
			if (fieldList != null && !fieldList.isEmpty()) {
				tag.setField(key, value);
			}
		}
	}
}
