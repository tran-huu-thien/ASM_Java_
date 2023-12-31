package tiennh21.sd17321.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import tiennh21.sd17321.entities.CuaHang;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuaHangVM {
    @NotBlank(message = "Không được để trống")
    private String Ma;

    @NotBlank(message = "Không được để trống")
    private String Ten;

    @NotBlank
    private String DiaChi;

    @NotBlank
    private String ThanhPho;

    @NotBlank
    private String QuocGia;

    public void loadFromEntity(CuaHang ch)
    {
        this.setMa( ch.getMa() );
        this.setTen( ch.getTen() );
        this.setThanhPho( ch.getThanhPho() );
        this.setQuocGia( ch.getQuocGia() );
        this.setDiaChi( ch.getDiaChi() );
    }
}
