package domain;

public class Page {

    private int currentPage;
    private int currentLine;
    private int lineEachPage;
    private int totalPage;
    private int totalLine;

    public Page(){

    }

    public Page(int currentPage, int currentLine, int lineEachPage, int totalPage, int totalLine) {
        this.currentPage = currentPage;
        this.currentLine = currentLine;
        this.lineEachPage = lineEachPage;
        this.totalPage = totalPage;
        this.totalLine = totalLine;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", currentLine=" + currentLine +
                ", lineEachPage=" + lineEachPage +
                ", totalPage=" + totalPage +
                ", totalLine=" + totalLine +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(int currentLine) {
        this.currentLine = currentLine;
    }

    public int getLineEachPage() {
        return lineEachPage;
    }

    public void setLineEachPage(int lineEachPage) {
        this.lineEachPage = lineEachPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(int totalLine) {
        this.totalLine = totalLine;
    }
}
