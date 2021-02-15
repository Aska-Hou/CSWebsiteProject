package domain;

public class Tutor {
    private int tutor_id;
    private String name;
    private String grade;
    private String photo;
    private String experience;

    public Tutor(){

    }

    public Tutor(int tutor_id, String name, String grade, String photo, String experience) {
        this.tutor_id = tutor_id;
        this.name = name;
        this.grade = grade;
        this.photo = photo;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tutor_id=" + tutor_id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", photo='" + photo + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}

