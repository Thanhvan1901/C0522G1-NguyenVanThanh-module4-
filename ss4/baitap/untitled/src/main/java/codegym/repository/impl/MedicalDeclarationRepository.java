package codegym.repository.impl;

import codegym.model.MedicalDeclaration;
import codegym.repository.IMedicalDeclarationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {
    private static List<String> years = new LinkedList<>();
    private static List<String> months = new LinkedList<>();
    private static List<String> days = new LinkedList<>();
    private static List<String> genders = new LinkedList<>();
    private static List<String> nationalities = new LinkedList<>();
    private static List<String> transports = new LinkedList<>();
    private static Map<Integer, MedicalDeclaration> medicalDeclarationMap = new HashMap<>();

    static {
        for (int i = 2022; i >= 1900; i--) {
            years.add(String.valueOf(i));
        }

        for (int i = 1; i < 13; i++) {
            months.add(String.valueOf(i));
        }

        for (int i = 1; i < 32; i++) {
            days.add(String.valueOf(i));
        }

        genders.add("Nam");
        genders.add("Nữ");
        genders.add("khác");

        nationalities.add("Việt Nam");
        nationalities.add("Trung Quốc");
        nationalities.add("Mỹ");
        nationalities.add("Hàn Quốc");
        nationalities.add("Nhật Bản");
        nationalities.add("Lào");
        nationalities.add("Thái Lan");
        nationalities.add("Khác");

        transports.add("Máy bay");
        transports.add("Tàu thuyền");
        transports.add("Ô tô");
        transports.add("Xe máy");
        transports.add("Khác(Ghi rõ)");
    }

    @Override
    public List<String> getDays() {
        return days;
    }
    @Override
    public List<String> getMonths() {
        return months;
    }

    @Override
    public List<String> getYears() {
        return years;
    }

    @Override
    public List<String> getGender() {
        return genders;
    }

    @Override
    public List<String> getNationalities() {
        return nationalities;
    }

    @Override
    public List<String> getTransports() {
        return transports;
    }

    @Override
    public void add(MedicalDeclaration medicalDeclaration) {
        int id = medicalDeclarationMap.size() + 1;
        medicalDeclaration.setId(id);
        medicalDeclarationMap.put(id, medicalDeclaration);
    }

    @Override
    public List<MedicalDeclaration> listOfMedicalDeclaration() {
        return new ArrayList<>(medicalDeclarationMap.values());
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        medicalDeclarationMap.put(id, medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findById(int id) {
        return medicalDeclarationMap.get(id);
    }
}
