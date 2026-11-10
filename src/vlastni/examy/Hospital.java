package vlastni.examy;

import fileworks.DataExport;
import fileworks.DataImport;

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
    static int PocetPenalizaci = 0;
    static int PocetOperaciSrdce = 0;

    static void validateJob(Doctor d, String jobType) {

        switch (jobType){
            case "D":
                d.diagnose();
                break;
            case "S":
                if (d instanceof Surgeon){
                    ((Surgeon)d).surgery();

                }
                else {

                    PocetPenalizaci++;
                }
                break;
            case "C":
                if (d instanceof CardiacSurgeon){
                    ((CardiacSurgeon)d).cardiacSurgery();
                    PocetOperaciSrdce++;
                }
                else {

                    PocetPenalizaci++;
                }
                break;

        }
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hospitalData.txt");
        DataExport de = new DataExport("data/hospital.txt");
        int suma = 0;
        int pocetDoktoru = 0;
        int maxSalary = Integer.MIN_VALUE;
        String maxJmeno = "";
        int minSalary = Integer.MAX_VALUE;
        String minJmeno = "";
        while (di.hasNext()){
           Doctor doctor;
           String line = di.readLine();
           String[]params = line.split(";");
           switch (params[1]){

               case "Surgeon":
                   doctor = new Surgeon(params[0]);
                   break;
               case "CardiacSurgeon":
                   doctor = new CardiacSurgeon(params[0]);
                   break;
               default:
                   doctor = new Doctor(params[0]);
           }
            for (int i = 2; i < params.length ; i++) {
                validateJob(doctor,params[i]);
            }
            pocetDoktoru++;
            suma += doctor.salary;
            if (maxSalary < doctor.salary){
                maxSalary = doctor.salary;
                maxJmeno = doctor.name;
            }
            if (minSalary > doctor.salary){
                minSalary = doctor.salary;
                minJmeno = doctor.name;
            }
        }
        de.writeLine("Doktor s nejmenším výdělkem se jmenuje " + minJmeno + " a vydělal " + minSalary);
        de.writeLine("Doktor s největším výdělkem se jmenuje " + maxJmeno + " a vydělal " + maxSalary);
        de.writeLine("Počet penalizací: " + PocetPenalizaci);
        de.writeLine("Počet operací srdce: " + PocetOperaciSrdce);
        de.writeLine("Průměrný plat: " + (double)suma/pocetDoktoru);


        // nezapomenout na úklid
        di.finishImport();
        de.finishExport();
    }
}
