package vn.poly.mob305.slide1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.poly.mob305.slide1.R;

public class DemoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // goi cac cau lenh tai day !!!!!!
        EditText edt = view.findViewById(R.id.edtNumber);
        view.findViewById(R.id.btnEnter).setOnClickListener(v ->{
            Demo2Fragment demo2 =
                    (Demo2Fragment) getActivity().
                            getSupportFragmentManager()
                            .findFragmentById(R.id.demo2);
            demo2.setText(edt.getText().toString());
        });
    }
}
