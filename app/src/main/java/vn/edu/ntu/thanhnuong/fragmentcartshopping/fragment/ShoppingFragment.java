package vn.edu.ntu.thanhnuong.fragmentcartshopping.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.thanhnuong.fragmentcartshopping.R;
import vn.edu.ntu.thanhnuong.fragmentcartshopping.controller.IController;
import vn.edu.ntu.thanhnuong.fragmentcartshopping.model.Product;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment implements View.OnClickListener{


    NavController navcontroller;
    IController controller;

    TextView txtShoppingCart;
    Button btnSubmit, btnCancel;

    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        navcontroller = NavHostFragment.findNavController(this);
        ((MainActivity)getActivity()).navcontroller = navcontroller;
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping, container, false);

    }
    public void onViewCreated (@NonNull View view, Bundle savedInstanceState) {
        //setHasOptionsMenu(true);

        super.onViewCreated(view, savedInstanceState);
        //NavHostFragment.findNavController(ShoppingFragment.this).navigate(R.id.action_shoppingFragment_to_confirmFragment);

        addView(view);


        view.findViewById(R.id.fabShopping).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        navcontroller.navigateUp();
            }
        });


    }

    private void addView(View view){
        txtShoppingCart = (TextView) view.findViewById(R.id.txtShoppingCart);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        controller = (IController) getActivity().getApplication();
        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        showShoppingCart();
    }



    private void showShoppingCart(){

        List<Product> shoppingCart = controller.getListShoppingCart();
        StringBuilder builder = new StringBuilder(); //
        for (Product p:shoppingCart){ //c2
            builder.append(p.getName()).append("\t\t\t").append(p.getPrice()).append("\n");
        }
        if (builder.toString().length() > 0)
            txtShoppingCart.setText(builder.toString());
        else
            txtShoppingCart.setText("Không có mặt hàng nào!");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btnCancel: cancel();
                break;
            case  R.id.btnSubmit: submit();
                break;
        }
    }


    private  void cancel(){
        txtShoppingCart.setText("Không có mặt hàng nào");
        controller.clearCart();
    }

    private  void submit(){
        navcontroller.navigate(R.id.action_shoppingFragment_to_confirmFragment);
    }
}
