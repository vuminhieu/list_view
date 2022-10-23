package com.example.learn_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextTen, editTextDiaChi, editTextSDT;
    Button buttonThem, buttonSua, buttonXoa;
    ArrayList<SinhVien> arrayList;
    CustomAdapter customAdapter;
    private int vitri;

    ListView listViewSinhVien;

    private void mapping() {
        editTextTen = (EditText) findViewById(R.id.edt_ten);
        editTextDiaChi = (EditText) findViewById(R.id.edt_diachi);
        editTextSDT = (EditText) findViewById(R.id.edt_sdt);
        buttonSua = (Button) findViewById(R.id.btn_sua);
        buttonThem = (Button) findViewById(R.id.btn_them);
        buttonXoa = (Button) findViewById(R.id.btn_xoa);
        listViewSinhVien = (ListView) findViewById(R.id.lv_sinh_vien);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        arrayList = new ArrayList<>();
        SinhVien sinhVien = new SinhVien("Vũ Minh Hiếu" , "Thái Bình" , "09944355555");
        SinhVien sinhVien1 = new SinhVien("Phùng Băng Giang" , "Hà Nội" , "747474744");
        arrayList.add(sinhVien);
        arrayList.add(sinhVien1);
        customAdapter = new CustomAdapter(this, R.layout.items_list_sv,arrayList);
        listViewSinhVien.setAdapter(customAdapter);

        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = editTextTen.getText().toString();
                String diachi = editTextDiaChi.getText().toString();
                String sdt = editTextSDT.getText().toString();
                if (TextUtils.isEmpty(ten) || TextUtils.isEmpty(diachi) || TextUtils.isEmpty(sdt)) {
                    Toast.makeText(MainActivity.this, "Vui Lòng Nhập đầy đủ", Toast.LENGTH_SHORT).show();
                }
                arrayList.add(new SinhVien(ten,diachi,sdt));
                customAdapter.notifyDataSetChanged();
                editTextDiaChi.setText("");
                editTextSDT.setText("");
                editTextTen.setText("");
            }
        });

        listViewSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                editTextTen.setText(arrayList.get(position).getmTen());
                editTextDiaChi.setText(arrayList.get(position).getmDiaChi());
                editTextSDT.setText(arrayList.get(position).getmSDT());
            }
        });

        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(vitri);
                customAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        buttonSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.get(vitri).setmTen(editTextTen.getText().toString());
                arrayList.get(vitri).setmDiaChi(editTextDiaChi.getText().toString());
                arrayList.get(vitri).setmSDT(editTextSDT.getText().toString());
                customAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
            }
        });

    }

}