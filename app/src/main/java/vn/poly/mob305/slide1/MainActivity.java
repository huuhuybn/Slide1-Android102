package vn.poly.mob305.slide1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import vn.poly.mob305.slide1.adapter.NhanVienAdapter;
import vn.poly.mob305.slide1.dao.NhanVienDAO;
import vn.poly.mob305.slide1.db.DBHelper;
import vn.poly.mob305.slide1.model.NhanVien;

public class MainActivity extends AppCompatActivity {

    //DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // khởi tạo class DBHelper để sử dụng
        // có thể khởi tạo class DBHelper ở bất kì đâu trên ứng dụng Android
        // miễn là chúng ta có tham số Context để truyền vào !!!!
//        dbHelper = new DBHelper(MainActivity.this);
        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        EditText edtFullname = findViewById(R.id.edtFullname);
        Button btnInsert = findViewById(R.id.btnInsert);

        // bắt sự kiện bấm vào nút btnInsert được gắn với nút trên giao diện ở file activity_main.xml
        btnInsert.setOnClickListener(view -> {
            // view là tham số đại diện cho BUTTON !!!
            // lấy giá trị trên ô nhập liệu edittext
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            String fullname = edtFullname.getText().toString();

            AlertDialog.Builder builder =
                    new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(getString(R.string.main_title));
            //builder.setMessage(getString(R.string.main_message));

            String fruits[] = {"Apple","Pine","Coconut"};

            /*builder.setItems(fruits, (dialog, which) -> {
                Toast.makeText(this, fruits[which],
                        Toast.LENGTH_SHORT).show();
            });*/

           /* builder.setMultiChoiceItems(fruits, null,
                    (dialog, which, isChecked) -> {
                        Toast.makeText(this,
                                fruits[which] + " : " + isChecked, Toast.LENGTH_SHORT).show();
            });

            builder.setPositiveButton("Thoát", (dialog, which) -> {
                dialog.dismiss();
            });
            builder.setNegativeButton("Thêm", (dialog,which) ->{
                NhanVienDAO nhanVienDAO = new NhanVienDAO(MainActivity.this);
                nhanVienDAO.dangKyNV(username,password,fullname);
            });*/

            View dialogCustom = LayoutInflater.from(this)
                    .inflate(R.layout.dialog_custom,null);
            builder.setView(dialogCustom);

            // dialogCustom
            EditText edtInfo = dialogCustom.findViewById(R.id.edtInfo);
            CheckBox cbSave = dialogCustom.findViewById(R.id.cbSave);

            builder.setNeutralButton("TEST", (dialog, v) ->{
                Toast.makeText(this, edtInfo.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            });

            builder.setCancelable(false);

            builder.show();





        });

        findViewById(R.id.btnUpdate).setOnClickListener(v ->{
            // lấy giá trị trên ô nhập liệu edittext
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            String fullname = edtFullname.getText().toString();
            if (username.trim().equals("")){
                edtUsername.setError("Vui long nhap Username...");
                return;
            }
            NhanVienDAO nhanVienDAO = new NhanVienDAO(MainActivity.this);
            nhanVienDAO.suaNV(username,password,fullname);
        });

        findViewById(R.id.btnDelete).setOnClickListener(v ->{

            String username = edtUsername.getText()
                    .toString();
             if (username.trim().equals("")){
                edtUsername.setError("Vui long nhap Username...");
                return;
            }
            NhanVienDAO nhanVienDAO =
                    new NhanVienDAO
                            (MainActivity.this);
            nhanVienDAO.xoaNV(username);
        });


        findViewById(R.id.btnDanhSach).setOnClickListener(v ->{
            NhanVienDAO nhanVienDAO =
                    new NhanVienDAO
                            (MainActivity.this);
            ArrayList<NhanVien> nhanVienArrayList =

                    nhanVienDAO.danhSachNhanVien();
            Toast.makeText(this, "SO LUONG : " +
                            nhanVienArrayList.size(),
                    Toast.LENGTH_SHORT).show();

            // hien thi danh sach nhan vien len ListView hoac


            // 1. ListView trên xml giao diện
            // 2. Adapter - qui định giao diện cho 1 hàng trên listView
                         // - qui định cách phân phối dữ liệu vào ListView
                // notifyDataSetChanged();
            // BaseAdapter, ArrayAdapter .....

            //// RecyclerView
            // 1.RecyclerView trên xml giao diện
            // 2.Adapter
            // 3.ViewHolder - ViewHolder hoạt động như cơ chế Cache giúp
            // cuộn mượt hơn !!!!
            // 4.Hỗ trợ hiển thị dạng ngang, dọc hoặc lưới thông qua
            // LayoutManager
            // 5. Hỗ trợ nhiều hơn các câu lệnh liên quan tới chức năng
            // notifyDataSetChanged();
            // 6. ko hỗ trợ pt OnItemClickListener ??????
            RecyclerView rvListNV =
                    findViewById(R.id.rvListNhanVien);
            NhanVienAdapter vienAdapter = new NhanVienAdapter(nhanVienArrayList);
            rvListNV.setAdapter(vienAdapter);
            // hien thi theo hang doc!!!!
            LinearLayoutManager ln = new LinearLayoutManager(MainActivity.this
                    ,RecyclerView.HORIZONTAL,false);

            GridLayoutManager gm = new GridLayoutManager(
                    MainActivity.this,
                    3,
                    RecyclerView.VERTICAL,false);
            rvListNV.setLayoutManager(gm);



        });



    }
}