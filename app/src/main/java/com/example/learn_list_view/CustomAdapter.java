package com.example.learn_list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<SinhVien> {
    private Context mContext;
    private int mResource;
    List<SinhVien> sinhVienList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<SinhVien> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
        this.sinhVienList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.items_list_sv,parent,false);

            // anh xa
            viewHolder.textViewTen = convertView.findViewById(R.id.tv_ten);
            viewHolder.textViewDiaChi = convertView.findViewById(R.id.tv_diachi);
            viewHolder.textViewSDT = convertView.findViewById(R.id.tv_sodt);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SinhVien sinhVien = sinhVienList.get(position);
        //gan gia tri
        viewHolder.textViewTen.setText(String.valueOf(sinhVien.getmTen()));
        viewHolder.textViewDiaChi.setText(String.valueOf(sinhVien.getmDiaChi()));
        viewHolder.textViewSDT.setText(String.valueOf(sinhVien.getmSDT()));

        return convertView;
    }

    public class ViewHolder {
        TextView textViewTen, textViewDiaChi, textViewSDT;
    }
}
