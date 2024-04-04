package sk.first.servlet;

import java.sql.Date;

public class Blogs {
    private Long id;
    private AuthUsers user;
    private String title;
    private String shortContent;
    private String content;
    private Date post_date;

    public Blogs(Long id, AuthUsers user, String title, String shortContent, String content, Date post_date) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
        this.post_date = post_date;
    }

    public Blogs() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AuthUsers getUser() {
        return user;
    }

    public void setUser(AuthUsers user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }
}
