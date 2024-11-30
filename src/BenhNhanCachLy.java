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

public class BenhNhanCachLy extends BenhNhan {
    private int soNgayCachLy;

    public BenhNhanCachLy(String maBenhNhan, String hoTen, LocalDate ngayPhatBenh, String soDienThoai, TinhTrang tinhTrang, int soNgayCachLy) {
        super(maBenhNhan, hoTen, ngayPhatBenh, soDienThoai, tinhTrang);
        this.setSoNgayCachLy(soNgayCachLy);
    }

    public int getSoNgayCachLy() {
        return soNgayCachLy;
    }

    public void setSoNgayCachLy(int soNgayCachLy) {
        if(soNgayCachLy <= 0)
            throw new IllegalArgumentException("So Ngay Cach Ly Lon Hon 0");
        this.soNgayCachLy = soNgayCachLy;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10d", soNgayCachLy);
    }

    public double tienChiTra()
    {
        return soNgayCachLy * 100000f;
    }

}
