package tiennh21.sd17321.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.entities.KhachHang;
import tiennh21.sd17321.entities.NhanVien;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KhachHangVM {
    @NotBlank(message = "không được để trống mã")
    private String Ma;
    @NotBlank(message = "không được để trống tên")
    private String Ten;
    @NotBlank(message = "không được để trống tên đệm")
    private String TenDem;
    @NotBlank(message = "không được để trống họ")
    private String Ho;
    @NotNull(message = "không được để trống ngày sinh")
    private String NgaySinh;
    @NotBlank(message = "không được để trống số điện thoại")
    private String Sdt;
    @NotBlank(message = "không được để trống địa chỉ")
    private String DiaChi;
    @NotBlank(message = "không được để trống thành phố")
    private String ThanhPho;
    @NotBlank(message = "không được để trống quốc gia")
    private String QuocGia;
    @NotBlank(message = "không được để trống mật khẩu")
    private String MatKhau;

    public void loadFromEntity(KhachHang vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
        this.setDiaChi(vm.getDiaChi());
        this.setHo(vm.getHo());
        this.setMatKhau(vm.getMatKhau());
        this.setSdt(vm.getSdt());
        this.setTenDem(vm.getTenDem());
        this.setQuocGia(vm.getQuocGia());
        this.setThanhPho(vm.getThanhPho());
        this.setNgaySinh(vm.getNgaySinh());

    }
}
