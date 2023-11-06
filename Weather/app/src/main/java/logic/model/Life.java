package logic.model;

public class Life {
    private String date;
    private String type;
    private String name;
    private String level;
    private String category;
    private String text;

    public Life(String date, String type, String name, String level, String category, String text) {
        this.date = date;
        this.type = type;
        this.name = name;
        this.level = level;
        this.category = category;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
