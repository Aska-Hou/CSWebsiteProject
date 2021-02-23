package domain;


public class Publication {
    private int publication_id;
    private String title;
    private String author;
    private String date;
    private String area;
    private String abstractContent;
    private String website;

    public Publication(){

    }

    public Publication(int publication_id, String title, String author, String date, String area, String abstractContent, String website) {
        this.publication_id = publication_id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.area = area;
        this.abstractContent = abstractContent;
        this.website = website;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "publication_id=" + publication_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", area='" + area + '\'' +
                ", abstractContent='" + abstractContent + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    public int getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(int publication_id) {
        this.publication_id = publication_id;
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
