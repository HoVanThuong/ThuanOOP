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

import java.util.*;
import java.util.stream.Collectors;

public class QuanLyBenhNhan {
    private List<BenhNhan> dsBN;

    public QuanLyBenhNhan() {
        this.dsBN =new ArrayList<BenhNhan>();
    }

    public int getIndex(String maBenhNhan){
        for(int i=0;i<dsBN.size();i++){
            if(dsBN.get(i).getMaBenhNhan().equalsIgnoreCase(maBenhNhan)){
                return i;
            }
        }
        return -1;
    }

    public boolean themBenhNhan(BenhNhan benhNhan){
        if(benhNhan == null || benhNhan.getMaBenhNhan().equals(""))
            return false;
        int index = getIndex(benhNhan.getMaBenhNhan());
        if(index != -1)
            return false;
        dsBN.add(benhNhan);
        return true;
    }

    public Map<String,Integer> thongKeSoCaBenh(){
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<dsBN.size();i++){
            if(dsBN.get(i).getTinhTrang().getTinhTrang().equalsIgnoreCase(TinhTrang.CONBENH.getTinhTrang())){
                String tinhTrang = dsBN.get(i).getTinhTrang().getTinhTrang();
                map.put(tinhTrang, map.getOrDefault(tinhTrang, 0)+1);
            }
        }
        return map;
    }

    public Collection<BenhNhan> getDSBNBenhNang(){
        int max = dsBN.stream()
                .filter(bn -> bn instanceof BenhNhanCachLy)
                .map(bn -> ((BenhNhanCachLy) bn).getSoNgayCachLy())
                .max((bn1, bn2) -> Integer.compare(bn1, bn2))
                .orElse(0);
        return dsBN.stream()
                .filter(bn -> bn instanceof BenhNhanCachLy)
                .filter(bn -> ((BenhNhanCachLy) bn).getSoNgayCachLy() == max)
                .collect(Collectors.toList());
    }

    public boolean capNhatBenhNhan(BenhNhan benhNhanMoi){
        if(benhNhanMoi == null || benhNhanMoi.getMaBenhNhan().equals(""))
            return false;
        int index = getIndex(benhNhanMoi.getMaBenhNhan());
        if(index == -1)
            return false;
        dsBN.set(index, benhNhanMoi);
       return true;
    }

    public int xoaBenhNhan(){
        int dem = 0;
        for(int i= dsBN.size() - 1; i >= 0; i--){
            if(dsBN.get(i).getTinhTrang().getTinhTrang().equalsIgnoreCase(TinhTrang.HETBENH.getTinhTrang())){
                dem++;
                dsBN.remove(i);
            }
        }
        return dem;
    }

}
