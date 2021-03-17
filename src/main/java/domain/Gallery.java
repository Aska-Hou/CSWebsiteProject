package domain;

public class Gallery {

    private int gallery_id;
    private String title;
    private String content;
    private String photo;

    public Gallery(){

    }

    public Gallery(int gallery_id, String title, String content, String photo) {
        this.gallery_id = gallery_id;
        this.title = title;
        this.content = content;
        this.photo = photo;
    }

    public int getGallery_id() {
        return gallery_id;
    }

    public void setGallery_id(int gallery_id) {
        this.gallery_id = gallery_id;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
