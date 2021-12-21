package model.expense;

public class Expense {
    private int userId;
    private String category;
    private Float price;
    private String currency;
    private String date;
    private String Description;

    public Expense(){

    }

    public Expense(int userId, String category, Float price, String currency, String date, String description) {
        this.userId = userId;
        this.category = category;
        this.price = price;
        this.currency = currency;
        this.date = date;
        this.Description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
