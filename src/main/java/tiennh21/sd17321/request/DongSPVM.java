package tiennh21.sd17321.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.entities.DongSP;
import tiennh21.sd17321.entities.Nsx;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DongSPVM {
    @NotBlank(message = "Không được để trống")
    private String Ma;
    @NotBlank(message = "Không được để trống")
    private String Ten;

    public void loadFromEntity(DongSP dsp){
        this.setMa(dsp.getMa());
        this.setTen(dsp.getTen());
    }
}
