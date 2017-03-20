package totoBook.service;

import java.util.List;

import totoBook.domain.Photo;
import totoBook.domain.Print;

public interface PrintService {
	void registerPrint(Print print);
	void registerPhotos(List<Photo> photos);
	void removePrint(String printId);
	void removePhotos(List<Photo> photos);
}
