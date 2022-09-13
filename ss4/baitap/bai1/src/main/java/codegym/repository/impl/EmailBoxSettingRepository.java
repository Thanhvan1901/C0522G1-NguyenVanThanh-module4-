package codegym.repository.impl;

import codegym.model.EmailBox;
import codegym.repository.IEmailBoxSettingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailBoxSettingRepository implements IEmailBoxSettingRepository {
    private static List<String> languagelist = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();
    private static EmailBox emailBox ;
    static {
        languagelist.add("English");
        languagelist.add("Vietnamese");
        languagelist.add("Japanese");
        languagelist.add("Chinese");

        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }
    @Override
    public List<String> languageList() {
        return languagelist;
    }

    @Override
    public List<Integer> pageSizeList() {
        return pageSizeList;
    }

    @Override
    public void updateEmail(EmailBox emailBox) {
        this.emailBox = emailBox ;
    }
}
