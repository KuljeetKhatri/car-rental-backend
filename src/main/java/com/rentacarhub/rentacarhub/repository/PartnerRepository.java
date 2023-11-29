package com.rentacarhub.rentacarhub.repository;

import com.rentacarhub.rentacarhub.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner,Long> {
    public Partner getPartnersByEmail(String email);
}
