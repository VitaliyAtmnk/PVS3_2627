package exams;

import fileworks.DataExport;
import fileworks.DataImport;

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

    static void validateJob(Doctor d, String jobType) {
        // TODO: implementujte logiku validace práce:
        // Doktor může dělat práci typu `jobType` jen pokud je kvalifikovan
        // C -> cardiacSurgery
        // S -> surgery
        // D -> diagnose
    }
    public static class Doctor {

        final static int BASE_SALARY = 50_000;
        public int numberOfPenalizations;
        public String name;
        public int salary;

        public Doctor(String name) {
            this.name = name;
            salary = BASE_SALARY;
        }

        public void diagnose() {
            System.out.println("Figuring out what's wrong with you...");
            salary += 10_000;
        }

    }
    public static class CardiacSurgeon extends Surgeon {

        final static int CS_BONUS = 35_000;
        public CardiacSurgeon(String name) {
            super(name);
            salary += CS_BONUS;
        }

        public void cardiacSurgery() {
            System.out.println("Cut my heart into pieces...");
            salary += 30_000;
        }
    }

    public static class Surgeon extends Doctor {
        final static int SURGEON_BONUS = 25_000;

        public Surgeon(String name) {
            super(name);
            salary += SURGEON_BONUS;
        }

        public void surgery() {
            System.out.println("Cutting you open...");
            salary += 20_000;
        }
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hospitalData.txt");
        DataExport de = new DataExport("data/hospital.txt");

        List<Doctor> doctors = new ArrayList<>();
        List<Surgeon> surgeons = new ArrayList<>();
        List<CardiacSurgeon> cardiacSurgeons = new ArrayList<>();

        while (di.hasNext()) {

            String line = di.readLine();
            String[] tokens = line.split(";");

            switch (tokens[1]) {

                case "Doctor" : {
                    Doctor doctor = new Doctor(tokens[0]);
                    doctors.add(doctor);
                    for (int i = 2; i < tokens.length; i++) {
                        switch (tokens[i]) {
                            case "D" : {
                                doctor.diagnose();
                                break;
                            }
                            default : {
                                doctor.numberOfPenalizations++;
                                break;
                            }
                        }
                    }
                }
                case "Surgeon" : {
                    Surgeon surgeon = new Surgeon(tokens[0]);
                    surgeons.add(surgeon);
                    for (int i = 2; i < tokens.length; i++) {
                        switch (tokens[i]) {
                            case "D" : {
                                surgeon.diagnose();
                                break;
                            }
                            case  "S" : {
                                surgeon.surgery();
                                break;
                            }
                            default : {
                                surgeon.numberOfPenalizations++;
                                break;
                            }
                        }
                    }
                }
                case "CardiacSurgeon" : {
                    CardiacSurgeon cardiacSurgeon = new CardiacSurgeon(tokens[0]);
                    cardiacSurgeons.add(cardiacSurgeon);

                    for (int i = 2; i < tokens.length; i++) {

                        switch (tokens[i]) {

                            case "D" :  {
                                cardiacSurgeon.diagnose();
                                break;
                            }
                            case "S" : {
                                cardiacSurgeon.surgery();
                                break;
                            }
                            case "C" : {
                                cardiacSurgeon.cardiacSurgery();
                                break;
                            }
                        }
                    }
                }
            }
        }

        List<Doctor> allDoctors = new ArrayList<>(cardiacSurgeons);

        Doctor highestPaidDoctor = allDoctors.getFirst();
        Doctor lowestPaidDoctor = allDoctors.getFirst();

        int celkovyPlat = 0;

        for (Doctor doctor : allDoctors) {

            if (doctor.salary > highestPaidDoctor.salary) {

                highestPaidDoctor = doctor;
            }

            if (doctor.salary < lowestPaidDoctor.salary) {

                lowestPaidDoctor = doctor;
            }

            celkovyPlat += doctor.salary;
        }

        int prumernyPlat = celkovyPlat/allDoctors.size();

        de.writeLine(highestPaidDoctor.toString());
        de.writeLine(lowestPaidDoctor.toString());
        de.writeLine("Průměrný plat v nemocnici: " );

        di.finishImport();
        de.finishExport();
    }
}
