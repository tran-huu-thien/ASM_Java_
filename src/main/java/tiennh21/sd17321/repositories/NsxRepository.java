package tiennh21.sd17321.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tiennh21.sd17321.entities.Nsx;

import java.util.UUID;

public interface NsxRepository extends JpaRepository<Nsx, UUID> {
}
