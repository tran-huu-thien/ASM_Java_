package tiennh21.sd17321.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.request.ChucVuVM;
import tiennh21.sd17321.request.NsxVM;

import java.util.UUID;

@Entity(name = "ChucVu")
@Table(name = "ChucVu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID Id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    public void loadFromVM(ChucVuVM vm){
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
    }
}
