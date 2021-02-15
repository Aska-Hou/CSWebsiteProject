package domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Paper {
    private int paper_id;
    private String title;
    private String author;
    private String date;
    private String area;
    private String abstractContent;
    private String website;

    public Paper(){

    }

    @Override
    public String toString() {
        return "Paper{" +
                "paper_id=" + paper_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", area='" + area + '\'' +
                ", abstractContent='" + abstractContent + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    public Paper(int paper_id, String title, String author, String date, String area, String abstractContent, String website) {
        this.paper_id = paper_id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.area = area;
        this.abstractContent = abstractContent;
        this.website = website;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
