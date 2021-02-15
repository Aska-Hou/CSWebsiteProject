package domain;

import java.sql.Date;

public class Prize {

    private int prize_id;
    private String name;
    private String winner;
    private Date date;
    private int news_id;
    private String description;
    private String photo;

    public Prize(){

    }

    @Override
    public String toString() {
        return "Prize{" +
                "prize_id=" + prize_id +
                ", name='" + name + '\'' +
                ", winner='" + winner + '\'' +
                ", date=" + date +
                ", news_id=" + news_id +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getPrize_id() {
        return prize_id;
    }

    public void setPrize_id(int prize_id) {
        this.prize_id = prize_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
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

    public Prize(int prize_id, String name, String winner, Date date, int news_id, String description, String photo) {
        this.prize_id = prize_id;
        this.name = name;
        this.winner = winner;
        this.date = date;
        this.news_id = news_id;
        this.description = description;
        this.photo = photo;
    }
}
