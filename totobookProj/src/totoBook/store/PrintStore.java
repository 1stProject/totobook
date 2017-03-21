package totoBook.store;

import totoBook.domain.Print;

/**
 * @author
 * @version 1.0
 */
public interface PrintStore {
	void insertPrint(Print print);
	void deletePrint(Print print);
}
