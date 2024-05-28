package ua.com.alevel;

public class Word {
    private String word;
    private int rating;
    private Long count;
    private Long percantage;

    public Word(String text, Long count, Long percantage) {
        this.word = text;
        this.count = count;
        this.percantage = percantage;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPercantage() {
        return percantage;
    }

    public void setPercantage(Long percantage) {
        this.percantage = percantage;
    }
}
