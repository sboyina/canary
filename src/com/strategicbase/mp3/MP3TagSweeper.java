/**
 * 
 */
package com.strategicbase.mp3;

import java.io.File;
import java.io.IOException;
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

import com.strategicbase.pecker.ProgressListener;

/**
 * @author srinivasab
 * 
 */
public class MP3TagSweeper {

	private static final Logger LOGGER = Logger.getLogger(Packer.class
			.getName());

	public MP3TagSweeper() {
	}

	public void updateAlbumTitle(String folderPath, boolean includeSubFolders,
			ProgressListener progressListener) {
		try {
			LOGGER.log(Level.INFO, "scanning for mp3 files ... ");
			List<File> mp3Files = new MP3FileScanner().scan(
					new File(folderPath), includeSubFolders);
			int total = mp3Files.size();
			LOGGER.log(Level.INFO, total + " file(s) found.");
			LOGGER.log(Level.INFO, "processing ");
			int noOfProcessed = 0;
			for (File file : mp3Files) {
				updateAlbumTitleWithJAudio(file);
				noOfProcessed++;
				progressListener.setProgress((noOfProcessed * 100) / total);
			}
			LOGGER.log(Level.INFO, "Successfully processed " + total
					+ " file(s).");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void updateAlbumTitleWithJAudio(File inputfile) throws Exception,
			IOException {
		LOGGER.log(Level.INFO, "    " + inputfile.getAbsolutePath());
		String albumTitle = inputfile.getParentFile().getName().toLowerCase();
		AudioFile audioFile = AudioFileIO.read(inputfile);
		Tag tag = audioFile.getTag();
		if (tag == null) {
			tag = new ID3v24Tag();
			audioFile.setTag(tag);
		}
		setTag(tag, FieldKey.TITLE, inputfile.getName());
		setTag(tag, FieldKey.ALBUM, albumTitle);
		setTag(tag, FieldKey.ARTIST, "");
		setTag(tag, FieldKey.ALBUM_ARTIST, "");
		audioFile.commit();
	}

	private void setTag(Tag tag, FieldKey key, String value)
			throws KeyNotFoundException, FieldDataInvalidException {
		List<TagField> fieldList = tag.getFields(key);
		if (fieldList != null && !fieldList.isEmpty()) {
			tag.setField(key, value);
		}
	}

	public static void main(String[] args) {
		MP3TagSweeper pecker = new MP3TagSweeper();
		pecker.updateAlbumTitle("L:\\test\\telugu", true,
				new ProgressListener() {

					@Override
					public void setProgress(int progressPercentage) {
						// TODO Auto-generated method stub
					}
				});
	}
}
