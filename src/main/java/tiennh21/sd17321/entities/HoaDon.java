package tiennh21.sd17321.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "HoaDon")
@Table(name = "HoaDon")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDon {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID Id;
    @Column(name = "Ma")
    private String Ma;

}
