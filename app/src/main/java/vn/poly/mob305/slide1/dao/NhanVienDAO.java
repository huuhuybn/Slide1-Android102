package vn.poly.mob305.slide1.dao;

import android.content.Context;

import vn.poly.mob305.slide1.db.DBHelper;

public class NhanVienDAO {

    DBHelper dbHelper;

    public NhanVienDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public void dangKyNV(String taikhoan,String matkhau,String hoten){
        String insertNV1 = String.format("INSERT INTO NhanVien VALUES(%s,%s,%s)",taikhoan,matkhau,hoten);
        dbHelper.getWritableDatabase().execSQL(insertNV1);
        // thêm nhân viên vào csdl, tuy nhiên, câu lệnh này chỉ chạy đc 1 lần
        // vì khoá chính là cột đầu tiên, ko được phép có gía trị trùng nhau
    }

    public void dangNhapNV(){
    }

    public void suaNV(){
    }

    public void luuTruNV(){
        // tam vo hieu hoa tk nhan vien
    }





}
