package oop.inheritance;

public class Hospital {

    public static void main(String[] args) {
        Doctor doctor = new Doctor("Jeff");
        System.out.println(doctor.name);
        System.out.println(doctor.salary);
        doctor.diagnose();
        System.out.println(doctor.salary);
        System.out.println();

        Surgeon s = new Surgeon("Pepa");
        System.out.println(s.name);
        System.out.println(s.salary);

        System.out.println();
        s.diagnose();
        s.surgery();

        CardiacSurgeon cs = new CardiacSurgeon("Max");

    }
}
