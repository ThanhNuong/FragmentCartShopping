package vn.edu.ntu.thanhnuong.fragmentcartshopping.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.thanhnuong.fragmentcartshopping.R;
import vn.edu.ntu.thanhnuong.fragmentcartshopping.controller.IController;
import vn.edu.ntu.thanhnuong.fragmentcartshopping.model.Product;

public class AddFragment extends Fragment {


    List<Product> list = new ArrayList<>();
    NavController navcontroller;
    FloatingActionButton fabBack;

    EditText edtName, edtPrice, edtDesc;
    Button btnSubmit;
    IController controller;
    int position=-1;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        fabBack = view.findViewById(R.id.fabAdd);
        return view;

    }
    public void onViewCreated (@NonNull View view, Bundle savedInstanceState) {
         //setHasOptionsMenu(true);

        //addEvent();
         super.onViewCreated(view, savedInstanceState);

         view.findViewById(R.id.fabBack).setOnClickListener(new View.OnClickListener() {
             @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(AddFragment.this)
                            .navigate(R.id.action_addFragment_to_listFragment);
                }
            });

        controller = ((MainActivity)getActivity()).controller;
        edtName = view.findViewById(R.id.edtName);
        edtPrice = view.findViewById(R.id.edtPrice);
        edtDesc = view.findViewById(R.id.edtDesc);
        btnSubmit = view.findViewById(R.id.btnSubmit);



//        list = controller.getAllList();
//
//        final Intent intent = getActivity().getIntent();

//        if(intent.getStringArrayExtra("position") != null){
//            position = Integer.parseInt(intent.getStringExtra("position"));
//            edtName.setText(list.get(position).getName());
//            edtPrice.setText(list.get(position).getPrice());
//            edtDesc.setText(list.get(position).getDesc());
//        }

       btnSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name = edtName.getText().toString();
               int price = edtPrice.getText().toString().matches("") ? 0 : Integer.parseInt(edtPrice.getText().toString());
               String desc = edtDesc.getText().toString();

               Product p = new Product(name, price, desc );

               controller.addToListProduct(p);

               Toast.makeText(getContext(),"Đã thêm mặt hàng" + name, Toast.LENGTH_SHORT).show();

               edtName.setText("");
               edtPrice.setText("");
               edtDesc.setText("");
           }
       });
    }

}
