package totoBook.service;

import java.util.List;

import totoBook.domain.Photo;
import totoBook.domain.Print;

/**
 * @author
 * @version 1.0
 */

public interface PrintService {
	void registerPrint(Print print);
	void removePrint(String printId);
	void removePhotos(String printId);
	List<Photo> findPhotosByPrintId(String printId);
	List<Print> findPrintsByMemberId(String memberId);
	Print findPrintByPrintId(String printId);
	Photo findPhotoByPhotoId(String photoId);
}
