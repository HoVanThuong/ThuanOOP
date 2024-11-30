/*
 * @ Ho Van Thuong.java    1.0 30
 * Copyright (c) 2024 IUH. All rights reserved
 *
 */


/*
 * @description: IUHER
 * @author: Ho Van Thuong
 * @date: 30/11/2024
 * @version: 1.0
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BenhNhan {
    protected final String maBenhNhan;
    protected String hoTen;
    protected LocalDate ngayPhatBenh;
    protected String soDienThoai;
    protected TinhTrang tinhTrang;

    public BenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
        this.hoTen = "Khong Co Ten";
        this.ngayPhatBenh = LocalDate.now();
        this.soDienThoai = "Khong Co";
        this.tinhTrang = TinhTrang.CHUARO;
    }

    public BenhNhan(String maBenhNhan, String hoTen, LocalDate ngayPhatBenh, String soDienThoai, TinhTrang tinhTrang) {
        this.maBenhNhan = maBenhNhan;
        this.setHoTen(hoTen);
        this.setNgayPhatBenh(ngayPhatBenh);
        this.setSoDienThoai(soDienThoai);
        this.setTinhTrang(tinhTrang);
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if(hoTen == null || hoTen.equals(""))
            throw new IllegalArgumentException("Ho Ten Khong Hop Le");
        this.hoTen = hoTen;
    }

    public LocalDate getNgayPhatBenh() {
        return ngayPhatBenh;
    }

    public void setNgayPhatBenh(LocalDate ngayPhatBenh) {
        if(ngayPhatBenh.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Ngay Phat Benh Khong Hop Le");
        this.ngayPhatBenh = ngayPhatBenh;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher matcher = pattern.matcher(soDienThoai);
        if(!matcher.matches())
            throw new IllegalArgumentException("So dien Thoai Khong Hop Le");
        this.soDienThoai = soDienThoai;
    }

    public TinhTrang getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-20s %-20 %-10s %-20s",hoTen,dtf.format(ngayPhatBenh),soDienThoai,tinhTrang.getTinhTrang());
    }

    public abstract double tienChiTra();
}
