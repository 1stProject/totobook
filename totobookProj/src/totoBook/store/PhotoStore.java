package totoBook.store;

import java.util.List;

import totoBook.domain.Photo;

/**
 * @author
 * @version 1.0
 */
public interface PhotoStore {
	void insertPhotos(List<Photo> photos);
	void deletePhotos(String printId);
	List<Photo> selectPhotosByPrintId(String printId);
	Photo selectPhotoByPhotoId(String photoId);
}
