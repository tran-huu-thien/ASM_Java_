package tiennh21.sd17321.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.request.NsxVM;

import java.util.UUID;

@Entity(name = "NSX")
@Table(name = "NSX")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Nsx {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID Id;
    @Column(name = "Ma")
    private String Ma;
    @Column(name = "Ten")
    private String Ten;

    public void loadFromVM(NsxVM vm){
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
    }
}
