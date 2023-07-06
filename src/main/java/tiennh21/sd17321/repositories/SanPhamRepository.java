package tiennh21.sd17321.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tiennh21.sd17321.entities.SanPham;

import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
}
