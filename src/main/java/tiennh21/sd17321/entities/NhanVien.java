package tiennh21.sd17321.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.request.CuaHangVM;
import tiennh21.sd17321.request.NhanVienVM;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "NhanVien")
@Table(name = "NhanVien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID Id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    @Column(name = "TenDem")
    private String TenDem;

    @Column(name = "Ho")
    private String Ho;

    @Column(name = "GioiTinh")
    private String GioiTinh;

    @Column(name = "NgaySinh")
    private Date NgaySinh;
    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "Sdt")
    private String Sdt;

    @Column(name = "MatKhau")
    private String MatKhau;

    //    @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "IdCH", referencedColumnName = "Id")
//    private CuaHang IdCH;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH", referencedColumnName = "Id")
    private CuaHang CH;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV", referencedColumnName = "Id")
    private ChucVu CV;

    @Column(name = "TrangThai")
    private Integer TrangThai;

    public void loadFromVM(NhanVienVM vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
        this.setDiaChi(vm.getDiaChi());
        this.setGioiTinh(vm.getGioiTinh());
        this.setHo(vm.getHo());
        this.setMatKhau(vm.getMatKhau());
        this.setNgaySinh(vm.getNgaySinh());
        this.setSdt(vm.getSdt());
        this.setTrangThai(vm.getTrangThai());
        this.setTenDem(vm.getTenDem());

    }
}
