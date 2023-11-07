package vn.poly.mob305.slide1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

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

            NhanVienDAO nhanVienDAO = new NhanVienDAO(MainActivity.this);
            nhanVienDAO.dangKyNV(username,password,fullname);
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
            // RecyclerView


        });



    }
}