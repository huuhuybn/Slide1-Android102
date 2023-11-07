package vn.poly.mob305.slide1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // class  dùng để tạo bảng, tạo csdl cho ứng dụng
    // mỗi 1 ứng dụng chỉ nên có DUY NHẤT 1 class DBHelper
    // Phương thức khởi tạo : khởi tạo tên file của db, version của db,
    // cấp quyền truy cập db thông qua biến context
    public DBHelper(Context context){
        super(context,"ql.db",null,1);
        // context : cấp quyền truy cập
        // ql.db : tên file chứa dữ liệu
        // version : 1
        // factory : chưa sử dụng thì để là null

    }
    @Override
    public void onCreate(SQLiteDatabase db) { // Phương thức dùng để khởi tạo bảng có trong dự án
        // có thể tạo 1 hoặc nhiều bảng tại đây,
        // phương thức này chỉ được gọi vào 1 lần duy nhất lúc cài app lần đầu tiên trên thiết bị
        String nhanVienSQL = "CREATE TABLE NhanVien (tendangnhap TEXT PRIMARY KEY,matkhau TEXT,hoten TEXT)";
        // thực thi câu lệnh
        db.execSQL(nhanVienSQL);
        // Khởi tạo bảng sản phẩm


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
