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

import java.text.DecimalFormat;
import java.time.LocalDate;

public class BenhNhanTaiNha extends BenhNhan{
    private double tienDichVu;

    public BenhNhanTaiNha(String maBenhNhan, String hoTen, LocalDate ngayPhatBenh, String soDienThoai, TinhTrang tinhTrang, double tienDichVu) {
        super(maBenhNhan, hoTen, ngayPhatBenh, soDienThoai, tinhTrang);
        this.setTienDichVu(tienDichVu);
    }

    public double getTienDichVu() {
        return tienDichVu;
    }

    public void setTienDichVu(double tienDichVu) {
        if(tienDichVu < 0)
            throw new IllegalArgumentException("Tien Dich Vu >= 0");
        this.tienDichVu = tienDichVu;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00 VND");
        return super.toString() + String.format("%-20s", df.format(tienDichVu));
    }

    public double tienChiTra(){
        return tienDichVu;
    }

}
