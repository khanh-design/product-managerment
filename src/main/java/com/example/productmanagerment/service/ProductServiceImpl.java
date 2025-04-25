package com.example.productmanagerment.service;

import com.example.productmanagerment.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService<Product> {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iphone", 2000, "hang chinh hang moi ra rat dep", "China"));
        products.put(2, new Product(2, "samsung", 3000, "sang trong quy phai", "Han Quoc"));
        products.put(3, new Product(3, "Oppo", 15000, "Nang tam cuoc song", "Nhat Ban"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findByName(String name) {
        for (Product product : products.values()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product delete(int id) {
        return products.remove(id);
    }

    @Override
    public void update(Product product, int id) {
        products.put(id, product);
    }
}
