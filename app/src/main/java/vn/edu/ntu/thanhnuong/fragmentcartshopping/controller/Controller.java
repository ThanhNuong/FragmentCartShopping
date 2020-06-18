package vn.edu.ntu.thanhnuong.fragmentcartshopping.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.thanhnuong.fragmentcartshopping.model.Product;

public class Controller  extends Application implements IController {
    List<Product> listMH = new ArrayList<>();
    List<Product> shoppingCart = new ArrayList<>();

    public Controller(){
        listMH.add(new Product("Khoai lang tím", 25000, "khoai lang Đà Lạt thơm ngon"));
        listMH.add(new Product("Khoai tây", 25000, "khoai tây Ninh Hòa giàu dinh dưỡng"));
        listMH.add(new Product("Khoai sọ", 25000, "khoai sọ thơm ngon"));
        listMH.add(new Product("Cà Chua", 25000, "khoai chua Đà Lạt"));
    }

    @Override
    public List<Product> getAllList() {
        return listMH;
    }

    @Override
    public List<Product> getListShoppingCart() {
        return shoppingCart;
    }

    @Override
    public boolean addToCart(Product p) {
        if(shoppingCart.contains(p))
            return false;
        shoppingCart.add(p);
        return true;
    }

    @Override
    public void addToListProduct(Product product) {
        listMH.add(product);
    }

    @Override
    public void clearCart() {
        shoppingCart.clear();
    }
}
