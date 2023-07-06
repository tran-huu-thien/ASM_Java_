package tiennh21.sd17321.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tiennh21.sd17321.entities.ChiTietSP;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {
    @Query("SELECT l FROM ChiTietSP l WHERE l.SP.Ten" +
            " like ?1")
    List<ChiTietSP> findByNameLike(String name);
    @Query("SELECT l FROM ChiTietSP l WHERE l.Id = ?1")
    ChiTietSP findByID(UUID id);
}
