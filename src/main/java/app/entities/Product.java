package app.entities;

public class Product {
    private String name;
    private int code;
    private int price;

    public Product(String name, int code, int price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code=" + code + ", price(per unit or weight)="+ price+'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (this.name != null ? !this.name.equals(product.name) : product.name != null) return false;
        if(this.code != product.code) return false;
        return this.price != product.price;
    }
}
