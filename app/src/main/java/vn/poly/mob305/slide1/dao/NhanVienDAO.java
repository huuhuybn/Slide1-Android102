package vn.poly.mob305.slide1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import vn.poly.mob305.slide1.db.DBHelper;
import vn.poly.mob305.slide1.model.NhanVien;

public class NhanVienDAO {

    DBHelper dbHelper;
    Context context;

    public NhanVienDAO(Context context){
        dbHelper = new DBHelper(context);
        this.context = context;
    }

    public void dangKyNV(String taikhoan,String matkhau,String hoten){
/*        try{
            String insertNV1 = String.format("INSERT INTO NhanVien VALUES('%s','%s','%s')",taikhoan,matkhau,hoten);
            dbHelper.getWritableDatabase().execSQL(insertNV1);
        }catch (Exception e){
            Log.e("ABC","" + e.getMessage());
        }*/
        // thêm nhân viên vào csdl, tuy nhiên, câu lệnh này chỉ chạy đc 1 lần
        // vì khoá chính là cột đầu tiên, ko được phép có gía trị trùng nhau
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues nhanVien = new ContentValues();
        //(tendangnhap TEXT PRIMARY KEY,matkhau TEXT,hoten TEXT)";
        // khởi tạo giá trị với cột tương ứng trong bản Nhân Viên
        nhanVien.put("tendangnhap",taikhoan);
        nhanVien.put("matkhau",matkhau);
        nhanVien.put("hoten",hoten);
        // db la bien dc tao o dong 27
        // nhanVien la bien dc tao o dong 28
        long ketqua = db.insert("NhanVien",null,nhanVien);
        if (ketqua>0){
            // thong bao thanh cong
            Toast.makeText(context, "Them Nhan Vien Thanh Cong!!!", Toast.LENGTH_SHORT).show();
        }else {
            // thong bao fail !!!!
            Toast.makeText(context, "Them Nhan Vien KHONG Thanh Cong!!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void suaNV(String taikhoan,String matkhau,String hoten){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues nhanVien = new ContentValues();
        //(tendangnhap TEXT PRIMARY KEY,matkhau TEXT,hoten TEXT)";
        // khởi tạo giá trị với cột tương ứng trong bản Nhân Viên
        nhanVien.put("tendangnhap",taikhoan);
        nhanVien.put("matkhau",matkhau);
        nhanVien.put("hoten",hoten);
        // db la bien dc tao o dong 27
        // nhanVien la bien dc tao o dong 28
        long ketqua = db.update("NhanVien",nhanVien,"tendangnhap = ?",new String[]{taikhoan});
        if (ketqua>0){
            // thong bao thanh cong
            Toast.makeText(context, "SUA Nhan Vien Thanh Cong!!!", Toast.LENGTH_SHORT).show();
        }else {
            // thong bao fail !!!!
            Toast.makeText(context, "SUA Nhan Vien KHONG Thanh Cong!!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void xoaNV(String taikhoan){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long ketqua = db.delete("NhanVien","tendangnhap = ?",new String[]{taikhoan});
        if (ketqua>0){
            // thong bao thanh cong
            Toast.makeText(context, "XOA Nhan Vien Thanh Cong!!!", Toast.LENGTH_SHORT).show();
        }else {
            // thong bao fail !!!!
            Toast.makeText(context, "XOA Nhan Vien KHONG Thanh Cong!!!", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<NhanVien> danhSachNhanVien(){
        ArrayList<NhanVien> nhanVienArrayList = new ArrayList<>();
        // viet cau lenh truy van
        String truyvan = "SELECT * FROM NhanVien";
        // null tức là lấy toàn bộ giá trị các cột
        Cursor ketqua = dbHelper.getWritableDatabase().rawQuery(truyvan,null);
        if (ketqua.getCount() > 0){
            ketqua.moveToFirst(); // cho chương trình di chuyển đến vị trí đầu tiên
            while (ketqua.moveToNext()){ // kiểm tra điều kiện di chuyển đến vị trí tiếp theo
                NhanVien nv = new NhanVien();
                // giá trị đc tính theo thứ tự khi khai báo bảng
                nv.setTendangnhap(ketqua.getString(0)); // lấy giá trị theo vị trí đầu tiên 0
                nv.setMatkhau(ketqua.getString(1));
                nv.setHoten(ketqua.getString(2));
                nhanVienArrayList.add(nv); // sau khi lấy được giá trị thì bỏ vào mảng nhân viên
            }
            // ket thuc vong while
            ketqua.close();
        }
        return nhanVienArrayList;
    }


    public void dangNhapNV(){
    }

    public void suaNV(){
    }

    public void luuTruNV(){
        // tam vo hieu hoa tk nhan vien
    }





}
