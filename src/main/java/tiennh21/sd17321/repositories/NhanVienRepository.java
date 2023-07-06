package tiennh21.sd17321.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tiennh21.sd17321.entities.NhanVien;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query("Select o from NhanVien o where o.Ma = ?1 and o.MatKhau=?2")
    NhanVien findByManPassword(String name, String password);
}
