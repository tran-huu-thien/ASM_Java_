package tiennh21.sd17321.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiennh21.sd17321.entities.ChiTietSP;
import tiennh21.sd17321.repositories.ChiTietSPRepository;

import java.util.Optional;
import java.util.UUID;
@Service
public class CTSPService {
    @Autowired
    private ChiTietSPRepository repository;

    public ChiTietSP findById(String pk) {
        Optional<ChiTietSP> l = repository.findById(UUID.fromString(pk));
        if (l.isPresent()) {
            return l.get();
        } else {
            return null;
        }
    }
}
