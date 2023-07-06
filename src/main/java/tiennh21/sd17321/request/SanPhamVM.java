package tiennh21.sd17321.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.entities.SanPham;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamVM {
    @NotBlank(message = "Không được để trống")
    private String Ma;
    @NotBlank(message = "Không được để trống")
    private String Ten;

    public void loadFromEntity(SanPham cv) {
        this.setMa(cv.getMa());
        this.setTen(cv.getTen());
    }
}
