package domain;

public class Index {

    private int index_id;
    private String img;
    private String news_id;

    public Index(){

    }

    public Index(int index_id, String img, String news_id) {
        this.index_id = index_id;
        this.img = img;
        this.news_id = news_id;
    }

    @Override
    public String toString() {
        return "Index{" +
                "index_id=" + index_id +
                ", img='" + img + '\'' +
                ", news_id='" + news_id + '\'' +
                '}';
    }

    public int getIndex_id() {
        return index_id;
    }

    public void setIndex_id(int index_id) {
        this.index_id = index_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }
}
