package oose.dea.domain;

public class Item {
    private String sku;
    private String category;
    private String title;

    public Item(){}

    public Item(String sku, String category, String title) {
        this.sku = sku;
        this.category = category;
        this.title = title;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "sku='" + sku + '\'' +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}