package vn.edu.ntu.thanhnuong.fragmentcartshopping.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.thanhnuong.fragmentcartshopping.R;
import vn.edu.ntu.thanhnuong.fragmentcartshopping.controller.IController;
import vn.edu.ntu.thanhnuong.fragmentcartshopping.model.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmFragment extends Fragment {

    List<Product> list = new ArrayList<>();
    NavController navcontroller;
    FloatingActionButton fabConfirm;
    IController controller;
    TextView txtConfirm;

    public ConfirmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);
        fabConfirm = view.findViewById(R.id.fabConfirm);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navcontroller = NavHostFragment.findNavController(ConfirmFragment.this);
        ((MainActivity)getActivity()).navcontroller = navcontroller;

        fabConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        txtConfirm = view.findViewById(R.id.txtConfirm);
        controller = (IController) getActivity().getApplication();
        list = controller.getListShoppingCart();

        if (list.isEmpty()){
            txtConfirm.setText("Bạn chưa chọn mua mặt hàng nào!");
        }
        else {
            txtConfirm.setText("Cảm ơn bạn đã mua hàng");
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

}
