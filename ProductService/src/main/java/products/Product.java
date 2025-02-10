package products;

public class Product {
    private String productNumber;
    private String name;
    private int numberInStock;

    public Product(){}

    public Product(String productNumber, String name, int numberInStock) {
        this.productNumber = productNumber;
        this.name = name;
        this.numberInStock = numberInStock;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productNumber + '\'' +
                ", name='" + name + '\'' +
                ", numberInStock=" + numberInStock +
                '}';
    }
}
