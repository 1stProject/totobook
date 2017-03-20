package totoBook.store;

import totoBook.domain.Print;

public interface PrintStore {
	void insertPrint(Print print);
	void deletePrint(Print print);
}
