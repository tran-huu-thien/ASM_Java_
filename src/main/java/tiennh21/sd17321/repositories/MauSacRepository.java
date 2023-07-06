package tiennh21.sd17321.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tiennh21.sd17321.entities.ChucVu;
import tiennh21.sd17321.entities.MauSac;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
}
