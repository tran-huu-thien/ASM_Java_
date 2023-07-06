package tiennh21.sd17321.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.request.ChiTietSPVM;

import java.util.UUID;

@Entity(name = "ChiTietSP")
@Table(name = "ChiTietSP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID Id;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham SP;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private Nsx Nsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac MS;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP DSP;



    @Column(name = "NamBH")
    private Integer NamBH;

    @Column(name = "MoTa")
    private String MoTa;

    @Column(name = "SoLuongTon")
    private Integer SoLuongTon;

    @Column(name = "GiaNhap")
    private Integer GiaNhap;

    @Column(name = "GiaBan")
    private Integer GiaBan;

    public void loadFromVM(ChiTietSPVM vm) {
        this.setNamBH(vm.getNamBH());
        this.setMoTa(vm.getMoTa());
        this.setSoLuongTon(vm.getSoLuongTon());
        this.setGiaBan(vm.getGiaBan());
        this.setGiaNhap(vm.getGiaNhap());


    }
}
