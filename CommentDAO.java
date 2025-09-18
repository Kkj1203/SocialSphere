package dao;

import model.Comment;
import java.util.List;

public interface CommentDAO {
    boolean addComment(Comment comment);
    List<Comment> getCommentsByPostId(int postId);
}
