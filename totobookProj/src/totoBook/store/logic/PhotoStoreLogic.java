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
				mapper.insertPhoto(photo);
			}
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deletePhotos(String printId) {
		SqlSession session = factory.openSession();
		try {
			PhotoMapper mapper = session.getMapper(PhotoMapper.class);
			mapper.deletePhotos(printId);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Photo> selectPhotosByPrintId(String printId) {
		SqlSession session = factory.openSession();
		List<Photo> photos = null;
		try{
			PhotoMapper mapper = session.getMapper(PhotoMapper.class);
			photos = mapper.selectPhotosByPrintId(printId);
		} finally {
			session.close();	
		}
		return photos;
	}

	@Override
	public Photo selectPhotoByPhotoId(String photoId) {
		SqlSession session = factory.openSession();
		Photo photo = null;
		try{
			PhotoMapper mapper = session.getMapper(PhotoMapper.class);
			photo = mapper.selectPhotoByPhotoId(photoId);
		} finally {
			session.close();	
		}
		return photo;
	}
	
}
