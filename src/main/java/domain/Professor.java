package domain;

public class Professor {
    private int prof_id;
    private String name;
    private String photo;
    private String courses;
    private String background;
    private String publication;
    private String area;
    private String introduction;

    public Professor() {

    }

    public Professor(int prof_id, String name, String photo, String courses, String background, String publication, String area, String introduction) {
        this.prof_id = prof_id;
        this.name = name;
        this.photo = photo;
        this.courses = courses;
        this.background = background;
        this.publication = publication;
        this.area = area;
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "prof_id=" + prof_id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", courses='" + courses + '\'' +
                ", background='" + background + '\'' +
                ", publication='" + publication + '\'' +
                ", area='" + area + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public int getProf_id() {
        return prof_id;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}