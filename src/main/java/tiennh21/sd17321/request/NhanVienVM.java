package tiennh21.sd17321.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.entities.NhanVien;

import java.sql.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class NhanVienVM {

    @NotBlank(message = "không được để trống mã")
    private String Ma;

    @NotBlank(message = "không được để trống tên")

    private String Ten;

    @NotBlank(message = "không được để trống tên đệm")
    private String TenDem;

    @NotBlank(message = "không được để trống họ")
    private String Ho;

    @NotBlank(message = "không được để trống giới tính")
    private String GioiTinh;

    @NotNull(message = "không được để trống ngày sinh")
    private Date NgaySinh;

    @NotBlank(message = "không được để trống địa chỉ")
    private String DiaChi;

    @NotBlank(message = "không được để trống số điện thoại")
    private String Sdt;

    @NotBlank(message = "không được để trống mật khẩu")
    private String MatKhau;


    private UUID CH;


    private UUID CV;

    @NotNull(message = "không được để trống trạng thái")
    private Integer TrangThai;

    public void loadFromEntity(NhanVien vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
        this.setDiaChi(vm.getDiaChi());
        this.setGioiTinh(vm.getGioiTinh());
        this.setHo(vm.getHo());
        this.setMatKhau(vm.getMatKhau());
        this.setNgaySinh(vm.getNgaySinh());
        this.setCH(vm.getCH().getId());
        this.setCV(vm.getCV().getId());
        this.setSdt(vm.getSdt());
        this.setTrangThai(vm.getTrangThai());
        this.setTenDem(vm.getTenDem());

    }
}
