package vn.poly.mob305.slide1.adapter;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.poly.mob305.slide1.R;
import vn.poly.mob305.slide1.dao.NhanVienDAO;
import vn.poly.mob305.slide1.model.NhanVien;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.NhanVienVH> {

    private ArrayList<NhanVien> nhanVienArrayList;

    public NhanVienAdapter(ArrayList<NhanVien> nhanVienArrayList){
      this.nhanVienArrayList = nhanVienArrayList;
    }

    public void setNhanVienArrayList(ArrayList<NhanVien> nhanVienArrayList){
        this.nhanVienArrayList = nhanVienArrayList;
    }

    @NonNull
    @Override
    public NhanVienVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_nv,parent,false);
        return new NhanVienVH(view);
        // khởi tạo NhanVienVH - nạp vào RecyclerView
    }

    @Override
    public void onBindViewHolder(@NonNull NhanVienVH holder, int position) {
        // phân phối, gán giá trị vào view - row - row_nv
        NhanVien nhanVien = nhanVienArrayList.get(position);
        holder.tvName.setText(nhanVien.getHoten());
        holder.tvName.setOnClickListener(v ->{
            AlertDialog.Builder alertDialog =
                    new AlertDialog.Builder(holder.itemView.getContext());
            alertDialog.setTitle("Are you sure ???");
            alertDialog.setPositiveButton("Delete", (dialog, which) -> {
                String username = nhanVien.getTendangnhap();
                NhanVienDAO dao = new NhanVienDAO(holder.itemView.getContext());
                dao.xoaNV(username);

                nhanVienArrayList.remove(position);
                notifyItemRemoved(position);// !!!!!!!
            });
            alertDialog.setNegativeButton("Cancel", (dialog, which) -> {

            });
            alertDialog.show();
        });
        holder.tvID.setText(nhanVien.getTendangnhap());
    }

    @Override
    public int getItemCount() {
        // đĩnh nghĩa số lượng sẽ hiển thị trên RV
        return nhanVienArrayList.size();
    }

    class NhanVienVH extends RecyclerView.ViewHolder {
        // anh xa findviewbyID các thành phần có trên 1 hàng của recyclerView
        public final TextView tvID,tvName;
        public NhanVienVH(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvMaNV);
            tvName = itemView.findViewById(R.id.tvMaNV);
        } // inner class
    }
}
