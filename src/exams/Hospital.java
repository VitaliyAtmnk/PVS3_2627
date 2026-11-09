package exams;

import fileworks.DataExport;
import fileworks.DataImport;
import oop.inheritance.Doctor;
import oop.inheritance.Surgeon;
import oop.inheritance.CardiacSurgeon;

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

    public static int pocetOperaciSrdce = 0;
    public static int pocetPenalizaci = 0;

    static void validateJob(Doctor d, String jobType) {
        // TODO: implementujte logiku validace práce:
        // Doktor může dělat práci typu `jobType` jen pokud je kvalifikovan
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

        de.writeLine(doktorSNejvetsimVydelkem.toString());
        de.writeLine(doktorSNejmensimVydelkem.toString());
        de.writeLine("Průměrný plat v nemocnici: " + prumernyPlat);
        de.writeLine("Počet operací srdce: " + pocetOperaciSrdce);
        de.writeLine("Počet udělených penalizací: " + pocetPenalizaci);
        de.writeLine("Doktor s největším počtem penalizací: " + nejvicePenalizaci + " " + nejvicePenalizaci.pocetNekvalifikovanychPraci);

        di.finishImport();
        de.finishExport();
    }
}