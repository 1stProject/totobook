package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Photo;

/**
 * @author
 * @version 1.0
 */
public interface PhotoMapper {
	void insertPhoto(Photo photo);
	void deletePhotos(String printId);
	List<Photo> selectPhotosByPrintId(String printId);
	Photo selectPhotoByPhotoId(String photoId);
}
