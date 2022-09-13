package codegym.service.impl;

import codegym.model.EmailBox;
import codegym.repository.IEmailBoxSettingRepository;
import codegym.service.IEmailBoxSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailBoxSettingService implements IEmailBoxSettingService {

    @Autowired
    private IEmailBoxSettingRepository iEmailBoxSettingRepository ;

    @Override
    public List<String> languageList() {
        return iEmailBoxSettingRepository.languageList();
    }

    @Override
    public List<Integer> pageSizeList() {
        return iEmailBoxSettingRepository.pageSizeList();
    }

    @Override
    public void updateEmail(EmailBox emailBox) {
        this.iEmailBoxSettingRepository.updateEmail(emailBox);
    }
}
