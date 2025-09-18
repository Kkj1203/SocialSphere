package dao;

import model.Post;
import java.util.List;

public interface PostDAO {
    boolean createPost(Post post);
    List<Post> getAllPosts();
}