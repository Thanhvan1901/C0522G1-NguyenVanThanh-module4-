package translate.service;

import translate.model.Translate;

import java.util.List;

public interface ITranslateService {
     List<Translate> findByWord(String keyword,String lang);
}
