package tiennh21.sd17321.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.request.DongSPVM;
import tiennh21.sd17321.request.NsxVM;

import java.util.UUID;
@Entity(name = "DongSP")
@Table(name = "DongSP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DongSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID Id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    public void loadFromVM(DongSPVM vm){
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
    }
}
