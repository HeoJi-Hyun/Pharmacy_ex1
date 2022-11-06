package com.example.pharmacy_ex1;

public class ListItem {
    private String Name1;
    private String price;

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    ListItem(String Name1, String price) {
        this.Name1 = Name1;
        this.price = price;
    }
}
