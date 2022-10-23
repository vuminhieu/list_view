package com.example.learn_list_view;

public class SinhVien {
    private String mTen;
    private String mDiaChi;
    private String mSDT;

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public String getmDiaChi() {
        return mDiaChi;
    }

    public void setmDiaChi(String mDiaChi) {
        this.mDiaChi = mDiaChi;
    }

    public String getmSDT() {
        return mSDT;
    }

    public void setmSDT(String mSDT) {
        this.mSDT = mSDT;
    }

    public SinhVien(String mTen, String mDiaChi, String mSDT) {
        this.mTen = mTen;
        this.mDiaChi = mDiaChi;
        this.mSDT = mSDT;
    }
}
