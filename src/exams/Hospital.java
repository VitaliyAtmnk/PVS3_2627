package exams;

import fileworks.DataExport;
import fileworks.DataImport;
import oop.inheritance.CardiacSurgeon;
import oop.inheritance.Doctor;
import oop.inheritance.Surgeon;

import java.util.ArrayList;
import java.util.List;

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

    public static int pocetOperaciSrdce = 0;
    public static int pocetPenalizaci = 0;

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

        if (d instanceof CardiacSurgeon) {

            switch (jobType) {

                case "D" : {
                    d.diagnose();
                    break;
                }
                case "S" : {
                    ((CardiacSurgeon) d).surgery();
                    break;
                }
                case "C" : {
                    ((CardiacSurgeon) d).cardiacSurgery();
                    pocetOperaciSrdce++;
                    break;
                }
            }
        }

        else if (d instanceof Surgeon) {

            switch (jobType) {

                case "D" : {
                    d.diagnose();
                    break;
                }
                case "S" : {
                    ((Surgeon) d).surgery();break;

                }
                case "C" : {
                    d.pocetNekvalifikovanychPraci++;
                    pocetPenalizaci++;
                    break;
                }
            }
        }

        else if (d instanceof Doctor) {

            switch (jobType) {

                case "D" : {
                    d.diagnose();
                    break;
                }
                case "S" : {
                    d.pocetNekvalifikovanychPraci++;
                    pocetPenalizaci++;
                    break;
                }
                case "C" : {
                    d.pocetNekvalifikovanychPraci++;
                    pocetPenalizaci++;
                    break;
                }
            }
        }

        else {

            switch (jobType) {

                case "D" : {
                    d.pocetNekvalifikovanychPraci++;
                    break;
                }
                case "S" : {
                    d.pocetNekvalifikovanychPraci++;
                    break;
                }
                case "C" : {
                    d.pocetNekvalifikovanychPraci++;
                    break;
                }
            }
        }
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
        DataExport de = new DataExport("data/hospital.txt");

        List<Doctor> doctors = new ArrayList<>();

        while (di.hasNext()) {

            String line = di.readLine();
            String[] tokens = line.split(";");

            Doctor doctor = new Doctor(tokens[0]);

            doctors.add(doctor);

            for (int i = 2; i < tokens.length; i++) {

                validateJob(doctor, tokens[i]);
            }

//            switch (tokens[1]) {
//
//                case "Doctor": {
//                    Doctor doctor = new Doctor(tokens[0]);
//                    doctors.add(doctor);
//                    for (int i = 2; i < tokens.length; i++) {
//
//                        switch (tokens[i]) {
//
//                            case "D": {
//                                doctor.diagnose();
//                                break;
//                            }
//                            default: {
//                                doctor.pocetNekvalifikovanychPraci++;
//                                pocetPenalizaci++;
//                                break;
//                            }
//                        }
//                    }
//                }
//                break;
//
//                case "Surgeon": {
//                    Surgeon surgeon = new Surgeon(tokens[0]);
//                    surgeons.add(surgeon);
//
//                    for (int i = 2; i < tokens.length; i++) {
//
//                        switch (tokens[i]) {
//
//                            case "D": {
//                                surgeon.diagnose();
//                                break;
//                            }
//                            case "S": {
//                                surgeon.surgery();
//                                break;
//                            }
//                            default: {
//                                surgeon.pocetNekvalifikovanychPraci++;
//                                pocetPenalizaci++;
//                                break;
//                            }
//                        }
//                    }
//                }
//                break;
//
//                case "CardiacSurgeon": {
//                    CardiacSurgeon cardiacSurgeon = new CardiacSurgeon(tokens[0]);
//                    cardiacSurgeons.add(cardiacSurgeon);
//
//                    for (int i = 2; i < tokens.length; i++) {
//
//                        switch (tokens[i]) {
//
//                            case "D": {
//                                cardiacSurgeon.diagnose();
//                                break;
//                            }
//                            case "S": {
//                                cardiacSurgeon.surgery();
//                                break;
//                            }
//                            case "C": {
//                                cardiacSurgeon.cardiacSurgery();
//                                pocetOperaciSrdce++;
//                                break;
//                            }
//                        }
//                    }
//                }
//                break;
//            }
        }

        Doctor doktorSNejvetsimVydelkem = doctors.getFirst();
        Doctor doktorSNejmensimVydelkem = doctors.getFirst();
        Doctor nejvicePenalizaci = doctors.getFirst();

        int celkovyPlat = 0;

        for (Doctor doctor : doctors) {

            if (doctor.salary > doktorSNejvetsimVydelkem.salary) {

                doktorSNejvetsimVydelkem = doctor;
            }

            if (doctor.salary < doktorSNejmensimVydelkem.salary) {

                doktorSNejmensimVydelkem = doctor;
            }

            if (doctor.pocetNekvalifikovanychPraci > nejvicePenalizaci.pocetNekvalifikovanychPraci) {

                nejvicePenalizaci = doctor;
            }

            celkovyPlat += doctor.salary;
        }

        int prumernyPlat = celkovyPlat / doctors.size();

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

        di.finishImport();
        de.finishExport();
    }
}