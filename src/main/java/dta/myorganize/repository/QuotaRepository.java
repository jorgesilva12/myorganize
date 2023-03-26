package dta.myorganize.repository;

import dta.myorganize.enums.QuotaName;
import dta.myorganize.model.Quota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuotaRepository extends JpaRepository<Quota, UUID> {
    Optional<Quota> findByQuotaName(QuotaName quotaName);
}
