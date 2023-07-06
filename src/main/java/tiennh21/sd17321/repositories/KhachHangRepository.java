package tiennh21.sd17321.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tiennh21.sd17321.entities.KhachHang;

import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {

}
