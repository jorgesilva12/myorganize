package dta.myorganize.init;

import dta.myorganize.enums.QuotaName;
import dta.myorganize.model.Quota;
import dta.myorganize.service.QuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StartQuota {
    @Autowired
    private QuotaService quotaService;
    public void startQuota(){

    List<QuotaName> quotaNames = Arrays.asList(QuotaName.values());
        for(int i = 0; i < quotaNames.size(); i++){
            Optional<Quota> quotaOptional = quotaService.findByQuotaName(quotaNames.get(i));
            if (quotaOptional.isEmpty()){
                Quota quota = new Quota();
                quota.setQuotaName(quotaNames.get(i));
                quotaService.create(quota);
            }
        }

    }
}
