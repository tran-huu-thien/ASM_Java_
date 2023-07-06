package tiennh21.sd17321.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.request.KhachHangVM;

import java.util.UUID;

@Entity(name = "KhachHang")
@Table(name = "KhachHang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KhachHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Ma")
    private String Ma;
    @Column(name = "Ten")
    private String Ten;
    @Column(name = "TenDem")
    private String TenDem;

    @Column(name = "Ho")
    private String Ho;
    @Column(name = "NgaySinh")
    private String NgaySinh;
    @Column(name = "Sdt")

    private String Sdt;
    @Column(name = "DiaChi")

    private String DiaChi;

    @Column(name = "ThanhPho")
    private String ThanhPho;
    @Column(name = "QuocGia")

    private String QuocGia;
    @Column(name = "MatKhau")

    private String MatKhau;
    public void loadFromVM(KhachHangVM vm) {
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
