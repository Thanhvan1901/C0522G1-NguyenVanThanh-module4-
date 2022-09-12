package translate.service.impl;

import org.springframework.stereotype.Service;
import translate.model.Translate;
import translate.service.ITranslateService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TranslateService implements ITranslateService {
    private static List<Translate> translateList ;
    static {
        translateList = new ArrayList<>();
        translateList.add(new Translate("Hello", "Xin Chào"));
        translateList.add(new Translate("Birthday", "Sinh Nhật"));
        translateList.add(new Translate("Address", "Địa Chỉ"));
        translateList.add(new Translate("Computer", "Máy Tính"));
        translateList.add(new Translate("Car", "Ô tô"));
    }
    @Override
    public List<Translate> findByWord(String english, String vietNam) {
        List<Translate> words = new ArrayList<>();
        if (english.equals("vie")) {
            for (Translate translate : translateList) {
                if (translate.getVietNam().toLowerCase().contains(english)) {
                    words.add(translate);
                }
            }
        }
        return words;
    }
}
