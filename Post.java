package model;

import java.sql.Timestamp;
import java.util.List;

public class Post {
    private int postId;
    private int userId;
    private String title;
    private String content;
    private Timestamp createdAt;
    private List<Comment> comments;

    public int getPostId() { return postId;}
    public void setPostId(int postId) {this.postId = postId;}

    public int getUserId() {return userId;}
    public void setUserId(int userId) {this.userId = userId;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}

    public Timestamp getCreatedAt() {return createdAt;}
    public void setCreatedAt(Timestamp createdAt) {this.createdAt = createdAt;}

    public List<Comment> getComments() {return comments;}
    public void setComments(List<Comment> comments) {this.comments = comments;}
}