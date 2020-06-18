package vn.edu.ntu.thanhnuong.fragmentcartshopping.controller;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.thanhnuong.fragmentcartshopping.model.Product;

public interface IController {
    //mảng ds mặt hàng
    public List<Product> getAllList();

    //mảng ds các mặt hàng trong giỏ
    public List<Product> getListShoppingCart();

    //Kiểm tra mặt hàng có nằm trong giỏ hàng chưa
    public boolean addToCart(Product p);

    public  void addToListProduct(Product product);

    //Xóa giỏ hàng
    public void clearCart();
}
