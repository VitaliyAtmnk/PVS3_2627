package student.exams;

import fileworks.DataExport;
import fileworks.DataImport;
import java.util.ArrayList;

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
    public static int penalizace;
    public static int cardiacSurgeries;


    static void doJob(Doctor doctor, String[] jobs) {

        for (int i = 2; i < jobs.length; i++) {
            switch (jobs[i]){
                case "D":
                    if (doctor instanceof Doctor) {
                        doctor.diagnose();
                    } else {
                        penalizace++;
                    }
                    break;
                case "S":
                    if (doctor instanceof Surgeon) {
                        ((Surgeon) doctor).surgery();
                    } else {
                        penalizace++;
                    }
                    break;
                case "C":
                    if (doctor instanceof CardiacSurgeon) {
                        ((CardiacSurgeon) doctor).cardiacSurgery();
                        cardiacSurgeries++;
                    } else {
                        penalizace++;
                    }
                    break;
            }
        }

        // TODO: implementujte logiku validace práce:
        // Doktor může dělat práci typu `jobType` jen pokud je kvalifikovan
        // C -> cardiacSurgery
        // S -> surgery
        // D -> diagnose
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hospitalData.txt");
        DataExport de = new DataExport("data/hospital.txt");


        ArrayList<Doctor> doctors = new ArrayList<>();


        while (di.hasNext()){
            String line = di.readLine();
            String[] split = line.split(";");
            switch (split[1]){
                case "Doctor":
                    doctors.add(new Doctor(split[0]));
                    break;
                case "Surgeon":
                    doctors.add(new Surgeon(split[0]));
                    break;
                case "CardiacSurgeon":
                    doctors.add(new CardiacSurgeon(split[0]));
                    break;
            }
            Hospital.doJob(doctors.getLast(), split);

        }

        System.out.println(doctors);

        Doctor best = doctors.getFirst();
        Doctor worst  = doctors.getFirst();
        double prumer;
        int total = 0;
        for (Doctor bob : doctors) {
            if (bob.salary < worst.salary){
                worst = bob;
            }
            if (bob.salary > best.salary){
                best = bob;
            }
            total += bob.salary;
        }

        prumer = (double) (total) / (doctors.size());

        System.out.println(doctors.size());
        System.out.println(total);
        System.out.println(best);
        System.out.println(worst);
        System.out.println(prumer);
        System.out.println(cardiacSurgeries);
        System.out.println(penalizace);

        de.writeLine(best.toString());
        de.writeLine(worst.toString());
        de.writeLine(String.valueOf(prumer));
        de.writeLine(String.valueOf(cardiacSurgeries));
        de.writeLine(String.valueOf(penalizace));


        // TODO: napsat test

        // nezapomenout na úklid
        di.finishImport();
        de.finishExport();
    }
}
