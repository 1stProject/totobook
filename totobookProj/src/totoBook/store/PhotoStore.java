package totoBook.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Photo;
import totoBook.store.PhotoStore;
import totoBook.store.mapper.PhotoMapper;

/**
 * @author
 * @version 1.0
 */
public class PhotoStoreLogic implements PhotoStore {
	private SqlSessionFactory factory;
	
	public PhotoStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
			
	@Override
	public void insertPhotos(List<Photo> photos) {
		SqlSession session = factory.openSession();
		try {
			PhotoMapper mapper = session.getMapper(PhotoMapper.class);
			for(Photo photo : photos){
				String fileName = photo.getFileName() + "/" + photo.getContentType();
				photo.setFileName(fileName);
				mapper.insertPhoto(photo);
			}
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deletePhotos(String PrintId) {
		
	}

}
