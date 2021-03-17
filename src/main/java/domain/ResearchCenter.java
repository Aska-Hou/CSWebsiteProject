package domain;

import java.util.List;

public class ResearchCenter {

    private int center_id;
    private String title;
    private String leader;
    private String description;
    private String photo;

    public ResearchCenter(){

    }

    public ResearchCenter(int center_id, String title, String leader, String description, String photo) {
        this.center_id = center_id;
        this.title = title;
        this.leader = leader;
        this.description = description;
        this.photo = photo;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
