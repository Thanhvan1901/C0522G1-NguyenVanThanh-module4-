package codegym.service;

import codegym.model.EmailBox;

import java.util.List;

public interface IEmailBoxSettingService {
    List<String> languageList () ;
    List<Integer> pageSizeList();
    void updateEmail(EmailBox emailBox);
}
