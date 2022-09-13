package codegym.repository;

import codegym.model.EmailBox;

import java.util.List;

public interface IEmailBoxSettingRepository {
    List<String> languageList () ;
    List<Integer> pageSizeList ();
    void updateEmail(EmailBox emailBox);
}
