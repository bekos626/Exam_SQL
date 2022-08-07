public class News {
    private Integer id;
    private String header;
    private String text;

    public  News(Integer id) {
        this.id = id;
    }

    public News(String header, String text) {
        this.header = header;
        this.text = text;
    }

    public News(String header, String  text, Integer id) {
        this.header = header;
        this.text = text;
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
