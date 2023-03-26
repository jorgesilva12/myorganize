package dta.myorganize.service;

import dta.myorganize.enums.QuotaName;
import dta.myorganize.model.Quota;
import dta.myorganize.repository.QuotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuotaService {
    @Autowired
    private QuotaRepository quotaRepository;

    public Optional<Quota> findByQuotaName(QuotaName quotaName) {return quotaRepository.findByQuotaName(quotaName); }
    public Quota create(Quota quota) {return quotaRepository.save(quota);}
}
