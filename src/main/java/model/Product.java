package model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private final String name;
    private final ProductType productType;

    public Product(String name, ProductType productType) {
        this.name = name;
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(productType, product.productType);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productType);
    }

    public String getName() {
        return name;
    }

}
