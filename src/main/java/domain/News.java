package domain;

import java.sql.Date;

public class News {
    private int news_id;
    private String title;
    private String content;
    private Date date;
    private String author;
    private String abstractContent;
    private String photo;

    public News(){

    }

    public News(int news_id){
        this.news_id = news_id;
    }

    public News(int news_id, String title, String content, Date date, String author, String abstractContent, String photo) {
        this.news_id = news_id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
        this.abstractContent = abstractContent;
        this.photo = photo;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", author='" + author + '\'' +
                ", abstractContent='" + abstractContent + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
