package tiennh21.sd17321.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.entities.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietSPVM {
    private UUID Id;

    private UUID SP;

    private UUID Nsx;

    private UUID MS;

    private UUID DSP;


    @NotNull(message = "không được để trống năm bảo hành")
    private Integer NamBH;
    @NotBlank(message = "không được để trống mô tả")
    private String MoTa;
    @NotNull(message = "không được để trống số lượng tồn")
    private Integer SoLuongTon;
    @NotNull(message = "không được để trống giá nhập")
    private Integer GiaNhap;
    @NotNull(message = "không được để trống giá bán")
    private Integer GiaBan;
    public void loadFromEntity(ChiTietSP vm) {
        this.setNamBH(vm.getNamBH());
        this.setMoTa(vm.getMoTa());
        this.setSoLuongTon(vm.getSoLuongTon());
        this.setGiaBan(vm.getGiaBan());
        this.setGiaNhap(vm.getGiaNhap());
        this.setDSP(vm.getDSP().getId());
        this.setMS(vm.getMS().getId());
        this.setNsx(vm.getNsx().getId());
        this.setSP(vm.getSP().getId());
    }
}
