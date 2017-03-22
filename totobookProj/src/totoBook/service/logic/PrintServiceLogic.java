package totoBook.service.logic;

import java.util.List;

import totoBook.domain.Photo;
import totoBook.domain.Print;
import totoBook.service.PrintService;
import totoBook.store.PhotoStore;
import totoBook.store.PrintStore;
import totoBook.store.logic.PhotoStoreLogic;
import totoBook.store.logic.PrintStoreLogic;

/**
 * @author
 * @version 1.0
 */
public class PrintServiceLogic implements PrintService {
	PrintStore printStore = null;
	PhotoStore photoStore = null;
	public PrintServiceLogic() {
		printStore = new PrintStoreLogic();
		photoStore = new PhotoStoreLogic();
	}
	@Override
	public void registerPrint(Print print) {
		printStore.insertPrint(print);
	}

	@Override
	public void registerPhotos(List<Photo> photos) {
		photoStore.insertPhotos(photos);
	}

	@Override
	public void removePrint(String printId) {
		printStore.deletePrint(printId);
	}

	@Override
	public void removePhotos(String printId) {
		photoStore.deletePhotos(printId);
	}

	@Override
	public List<Print> findPrintsByMemberId(String memberId) {
		return printStore.selectPrintsByMemberId(memberId);
	}
	@Override
	public Print findPrintByPrintId(String printId) {
		return printStore.selectPrintByPrintId(printId);
	}
}
