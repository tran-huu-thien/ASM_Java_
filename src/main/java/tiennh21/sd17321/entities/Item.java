package tiennh21.sd17321.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@Data
public class Item {

    private UUID idCtsp;

    private String tenSanPham;
    private String tenMau;

    private Integer soLuong;

    private Integer giaBan;

    public Item(UUID idCtsp, String tenSanPham, String tenMau, Integer soLuong, Integer giaBan) {
        this.idCtsp = idCtsp;
        this.tenSanPham = tenSanPham;
        this.tenMau = tenMau;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idCtsp=" + idCtsp +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", tenMau='" + tenMau + '\'' +
                ", soLuong=" + soLuong +
                ", giaBan=" + giaBan +
                '}';
    }
}
