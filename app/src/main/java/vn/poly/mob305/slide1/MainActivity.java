package vn.poly.mob305.slide1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.poly.mob305.slide1.db.DBHelper;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // khởi tạo class DBHelper để sử dụng
        // có thể khởi tạo class DBHelper ở bất kì đâu trên ứng dụng Android
        // miễn là chúng ta có tham số Context để truyền vào !!!!
        dbHelper = new DBHelper(MainActivity.this);
    }
}