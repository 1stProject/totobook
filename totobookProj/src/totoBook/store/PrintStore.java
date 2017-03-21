package totoBook.store;

import java.util.List;

import totoBook.domain.Print;

/**
 * @author
 * @version 1.0
 */
public interface PrintStore {
	void insertPrint(Print print);
	void deletePrint(String printId);
	List<Print> selectPrintsByUserId(String memberId);
}
