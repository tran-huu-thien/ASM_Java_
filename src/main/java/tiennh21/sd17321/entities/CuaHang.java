package tiennh21.sd17321.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiennh21.sd17321.request.CuaHangVM;

import java.util.UUID;


    @Entity(name="CuaHang")
    @Table(name="CuaHang")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class CuaHang {
        @Id
        @Column(name="Id")
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID Id;

        @Column(name="Ma")
        private String Ma;

        @Column(name="Ten")
        private String Ten;

        @Column(name="DiaChi")
        private String DiaChi;

        @Column(name="ThanhPho")
        private String ThanhPho;

        @Column(name="QuocGia")
        private String QuocGia;
        public void loadFromVM(CuaHangVM vm)
        {
            this.setMa( vm.getMa() );
            this.setTen( vm.getTen() );
            this.setThanhPho( vm.getThanhPho() );
            this.setQuocGia( vm.getQuocGia() );
            this.setDiaChi( vm.getDiaChi() );
        }
    }

