package com.example.shoppingcart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {
    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "https://th.bing.com/th/id/OIP.zGlB_ASIxPcmjSFdDdKWXgHaGK?w=243&h=203&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPad Air", 799, true, "https://th.bing.com/th/id/OIP.0VYC1y9tUSuW9DhV39d4YgHaJh?w=142&h=183&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPad Pro", 999, true, "https://th.bing.com/th/id/OIP.lpyUxlj2z1VJTzmx2Y4gKQHaHa?w=211&h=211&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11", 699, false, "https://th.bing.com/th/id/OIP.3xm0Ku_owtwyGINIBdbShgHaHp?w=189&h=196&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11 Pro", 999, true, "https://th.bing.com/th/id/OIP.DVyik16FfwZuhFopBqQQtAHaE8?w=254&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11 Pro Max", 1099, true, "https://th.bing.com/th/id/OIP.V13Sd0F80mUnM_hLV8_qIQHaD4?w=321&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone SE", 399, true, "https://th.bing.com/th/id/OIP.V6KStq1KrdLsmy5vju0kQgHaIw?w=172&h=204&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        productList.add(new Product(UUID.randomUUID().toString(), "MacBook Air", 999, true, "https://th.bing.com/th/id/OIP.7qR3rCB_iKCCPzUUmHwx8gHaE7?w=291&h=194&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        productList.add(new Product(UUID.randomUUID().toString(), "MacBook Pro 13", 1299, true, "https://th.bing.com/th/id/OIP.F7SUUyTm_n3MPZAfhWBlywHaFj?w=235&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        productList.add(new Product(UUID.randomUUID().toString(), "MacBook Pro 16", 2399, true, "https://th.bing.com/th/id/OIP.POQQf7QMSspZQLv31nSDtQHaE8?w=266&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        mutableProductList.setValue(productList);
    }
}