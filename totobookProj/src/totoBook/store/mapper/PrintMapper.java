package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Print;

/**
 * @author
 * @version 1.0
 */
public interface PrintMapper {
	String insertPrint(Print print);
	void deletePrint(String printId);
	List<Print> selectPrintsByMemberId(String memberId);
	Print selectPrintByPrintId(String printId);
}

