package exams;

import fileworks.DataExport;
import fileworks.DataImport;
import oop.inheritance.Doctor;
import oop.inheritance.Surgeon;
import oop.inheritance.CardiacSurgeon;

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

    static int[] validateJob(Doctor d, String[] jobType) {
        // TODO: implementujte logiku validace práce:
        // Doktor může dělat práci typu `jobType` jen pokud je kvalifikovan
        // C -> cardiacSurgery
        // S -> surgery
        // D -> diagnose

        int returnNum[] = {0, 0};

        for (int i = 0; i < jobType.length; i++) {
            switch (jobType[i]) {
                case "C":
                    if(d instanceof CardiacSurgeon) {
                        ((CardiacSurgeon) d).cardiacSurgery();
                        returnNum[1]++;
                    } else {
                        returnNum[0]++;
                    }
                    break;
                case "S":
                    if(d instanceof Surgeon) {
                        ((Surgeon) d).surgery();
                    } else {
                        returnNum[0]++;
                    }
                    break;
                default:
                    d.diagnose();
            }
        }
        return returnNum;
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hospitalData.txt");
        DataExport de = new DataExport("data/hospital.txt");

        // TODO: napsat test

        int mostEarned = Integer.MIN_VALUE;
        String mostEarnedName = "";
        int leastEarned = Integer.MAX_VALUE;
        String leastEarnedName = "";
        int avgSalary = 0;
        int numOfHearthOperations = 0;
        int numOfPenalizations = 0;

        Doctor currentDoctor;
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<String> jobs = new ArrayList<>();

        while(di.hasNext()) {
            String line = di.readLine();
            String[] params = line.split(";");
            switch (params[1]) {
                case "Surgeon":
                    currentDoctor = new Surgeon(params[0]);
                    break;
                case "CardiacSurgeon":
                    currentDoctor = new CardiacSurgeon(params[0]);
                    break;
                default:
                    currentDoctor = new Doctor(params[0]);
                    break;
            }

            for (int i = 2; i < params.length; i++) {
                jobs.add(params[i]);
            }
            jobs.add(";");

            doctors.add(currentDoctor);
        }

        for (int i = 0; i < doctors.size(); i++) {
            String[] doctorJobs = jobs.get(i).split(";");
            int[] num;
            num = validateJob(doctors.get(i), doctorJobs);
            numOfPenalizations += num[0];
            numOfHearthOperations += num[1];
        }

        for (Doctor d : doctors) {
            if(d.salary > mostEarned) {
                mostEarned = d.salary;
                mostEarnedName = d.name;
            }
        }
        for (Doctor d : doctors) {
            if(d.salary < leastEarned) {
                leastEarned = d.salary;
                leastEarnedName = d.name;
            }
        }

        for (int i = 0; i < doctors.size(); i++) {
            avgSalary += doctors.get(i).salary;
        }
        avgSalary /= doctors.size();

        de.writeLine("Doctor with the most earnings is: " + mostEarnedName + " with " + mostEarned);
        de.writeLine("Doctor with the least earnings is: " + leastEarnedName + " with " + leastEarned);
        de.writeLine("Average salary in the hospital is: " + avgSalary);
        de.writeLine("The number of cardiac operations is: " + numOfHearthOperations);
        de.writeLine("The number of hopital penalizations is: " + numOfPenalizations);

        // nezapomenout na úklid
        di.finishImport();
        de.finishExport();
    }
}
