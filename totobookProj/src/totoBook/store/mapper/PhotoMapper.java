package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Photo;

/**
 * @author
 * @version 1.0
 */
public interface PhotoMapper {
	void insertPhotos(List<Photo> photos);
	void deletePhotos(String PrintId);
}
