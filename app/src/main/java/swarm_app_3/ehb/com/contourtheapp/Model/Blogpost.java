package swarm_app_3.ehb.com.contourtheapp.Model;

/**
 * Created by Bram Schrooyen on 20/12/2016.
 */

public class Blogpost {

    private int blogpostId, userId;
    private String title, content, place, dateBlog;
    private String photo;

    public int getBlogpostId() {
        return blogpostId;
    }

    public void setBlogpostId(int blogpostId) {
        this.blogpostId = blogpostId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(String dateBlog) {
        this.dateBlog = dateBlog;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Blogpost() {
    }

    public Blogpost(int blogpostId, String title, String content, String place, String dateBlog, String photo, int userId) {
        this.blogpostId = blogpostId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.place = place;
        this.dateBlog = dateBlog;
        this.photo = photo;
    }

}
