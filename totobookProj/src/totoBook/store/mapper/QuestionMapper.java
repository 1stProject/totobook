package totoBook.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import totoBook.domain.Book;
import totoBook.domain.Post;

/**
 * @author
 * @version 1.0
 */

public interface QuestionMapper {
//,@Param("memberId") String memberId,@Param("fileName") String filename,@Param("contentType") String contentType
	void insertQuestion(Post post);
	List<Post>	selectAllQuestion();
	Post selectQuestionById(String questionId);
	void updateQuestion(Post post);
	void deleteQuestion(String questionId);
	
}
