package totoBook.store;

import java.util.List;

import totoBook.domain.Photo;

public interface PhotoStore {
	void insertPhotos(List<Photo> photos);
	void deletePhotos(String PrintId);
}
