package kodlamaio.hrms.business.adapters;

import mernisServiceAdapter.UWBKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter {
    private UWBKPSPublicSoap client;

    public MernisServiceAdapter() {
        this.client = new UWBKPSPublicSoap();
    }

    public boolean verifyUser(String identityNumber, String name, String surName, int dateOfBirth) throws Exception {
        var result = client.TCKimlikNoDogrula(Long.parseLong(identityNumber), name, surName, dateOfBirth);

        return result;
    }
}
