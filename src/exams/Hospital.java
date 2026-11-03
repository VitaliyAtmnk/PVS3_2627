package exams;

import fileworks.DataExport;
import fileworks.DataImport;
import oop.inheritance.CardiacSurgeon;
import oop.inheritance.Doctor;
import oop.inheritance.Surgeon;

import java.util.ArrayList;
import java.util.List;

// Načtěte ze souboru hospitalData informace o doktorech
// do souboru hospital.txt vypiste nasledujici informace o vsech doktorech:

// 1. Doktora s nejvetsim vydelkem
// 2. Doktora s nejmensjim vydelkem
// 3. Prumerny plat v nemocnici
// 4. Pocet realizovanych operací srdce
// 5. Pocet udelenych penalizaci nemocnici
//     - Nemocnice je penalizovana za kazdy zakrok doktora, na ktery nema kvalifikaci

// Bonus:
//   Vypiste 5 nejlepe placenych doktoru v nemocnici
//   Procentualni zastoupeni zamestnancu. (příklad: 50% Doktoři, 35% Chirurgové, 15% Kardiochirurgové)
//   Kdo způsobil největší penalizaci nemocnici

public class Hospital {
    private static int penalties = 0;
    private static int cardiacSurgeryCount = 0;

    static void validateJob(Doctor d, String jobType) {
        switch (jobType) {
            case "C": {
                if (d instanceof CardiacSurgeon c) {
                    c.cardiacSurgery();
                    cardiacSurgeryCount++;
                } else {
                    penalties++;
                }
                break;
            }
            case "S": {
                if (d instanceof Surgeon s) {
                    s.surgery();
                } else {
                    penalties++;
                }
                break;
            }
            default: {
                d.diagnose();
            }
        }
        // C -> cardiacSurgery
        // S -> surgery
        // D -> diagnose
    }

    static Doctor bestDoctor(List<Doctor> docs) {
        Doctor best = docs.getFirst();

        for (Doctor doc : docs) {
            if (best.getSalary() < doc.getSalary()) {
                best = doc;
            }
        }

        return best;
    }

    static Doctor worstDoctor(List<Doctor> docs) {
        Doctor worst = docs.getFirst();

        for (Doctor doc : docs) {
            if (worst.getSalary() > doc.getSalary()) {
                worst = doc;
            }
        }

        return worst;
    }

    static double avgSalary(List<Doctor> docs) {
        double salarySum = 0.0;

        for (Doctor doc : docs) {
            salarySum += doc.getSalary();
        }

        return salarySum / docs.size();
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hospitalData.txt");
        DataExport de = new DataExport("data/salaries.txt");

        List<Doctor> docs = new ArrayList<>();

        // TODO: napsat test
        while (di.hasNext()) {
            String line = di.readLine().strip();
            String[] parts = line.split(";");

            String name = parts[0];
            String docType = parts[1];

            if (docType.equals("CardiacSurgeon")) {
                docs.add(new CardiacSurgeon(name));
            } else if (docType.equals("Surgeon")) {
                docs.add(new Surgeon(name));
            } else {
                docs.add(new Doctor(name));
            }

            for (int i = 2; i < parts.length; i++) {
                String jobType = parts[i];
                validateJob(docs.getLast(), jobType);
            }
        }

        de.writeLine("Doctor with best salary: " + bestDoctor(docs));
        de.writeLine("Doctor with worst salary: " + worstDoctor(docs));
        de.writeLine("Average salary: " + avgSalary(docs));
        de.writeLine("Number of cardiac surgeries: " + cardiacSurgeryCount);
        de.writeLine("Number of penalties issued: " + penalties);

        // nezapomenout na úklid
        di.finishImport();
        de.finishExport();
    }
}
