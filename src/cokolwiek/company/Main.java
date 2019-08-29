package cokolwiek.company;

import java.util.Scanner;

public class Main {

    static String[] zadania = new String[100];
    static String[] projekty = new String[100];
    static String[] changeLog = new String[100];

    static int licznikZadan = 0;
    static int licznikProjektow = 0;
    static int licznikChangeLogow = 0;

    public static void displayMenu() {
        System.out.println("1 - Stworz nowe zadanie");
        System.out.println("2 - Skasuj zadanie");
        System.out.println("3 - Stworz nowy projekt");
        System.out.println("4 - Skasuj projekt");
        System.out.println("5 - Pokaz wszystkie zadanie");
        System.out.println("6 - Pokaz wszystkie projekty");
        System.out.println("7 - Pokaz logi");
        System.out.println("0 - Wyjscie");
    }

    public static void dodajZadanie(String zadanie) {
        boolean jestMiejsceNaNoweZadanie = licznikZadan < zadania.length;
        if (jestMiejsceNaNoweZadanie) {
            zadania[licznikZadan] = zadanie;
            licznikZadan++;
            addLog("Dodano nowe zadanie: " + zadanie);
        } else {
            addLog("Nie udalo sie dodac nowego zadanie: " + zadanie);
        }
    }

    public static void usunZadanie(int indexZadan) {
        boolean isZadanieIstnieje = indexZadan < licznikZadan;
        if (isZadanieIstnieje) {
            for (int i = indexZadan; i < licznikZadan - 1; i++) {
                zadania[i] = zadania[i + 1];
            }
            licznikZadan--;
        } else {
            addLog("Nie udalo sie usunac zadania: " + zadania[indexZadan]);
        }
    }

    public static void pokazZadania() {
        System.out.println("Lista zadan: ");
        for (int i = 0; i < licznikZadan; i++) {
            System.out.println(zadania[i]);
        }
        addLog("Wyswietlono liste zadan");
    }

    public static void dodajProjekt(String projekt) {
        boolean jestMiejsceNaNowyProjekt = licznikProjektow < projekty.length;
        if (jestMiejsceNaNowyProjekt) {
            projekty[licznikProjektow] = projekt;
            licznikProjektow++;
            addLog("Dodano nowy projekt: " + projekt);
        } else {
            addLog("Nie udalo sie dodac nowego projektu: " + projekt);
        }
    }

    public static void usunProjekt(int indexProjekt) {
        boolean isProjektIstnieje = indexProjekt < licznikProjektow;
        if (isProjektIstnieje) {
            addLog("Usunieto projekt " + projekty[indexProjekt]);
            for (int i = indexProjekt; i < licznikProjektow - 1; i++) {
                projekty[i] = projekty[i + 1];
            }
            licznikProjektow--;
        } else {
            addLog("Nie udalo sie usunac projektu: " + projekty[indexProjekt]);
        }
    }

    public static void pokazProjekty() {
        System.out.println("Lista projektow: ");
        for (int i = 0; i < licznikProjektow; i++) {
            System.out.println(projekty[i]);
        }
        addLog("Wyswietlono liste projektow.");
    }

    public static void addLog(String log) {
        boolean jestMiejsceNaNowyLog = licznikChangeLogow < changeLog.length;
        if (jestMiejsceNaNowyLog) {
            changeLog[licznikChangeLogow] = log;
            licznikChangeLogow++;
        }
    }

    public static void pokazChangeLog() {
        System.out.println("Change log: ");
        for (int i = 0; i < licznikChangeLogow; i++) {
            System.out.println(changeLog[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radix;
        boolean isApplicationRun = true;
        while (isApplicationRun) {
            displayMenu();
            System.out.println("Wpisz numer zeby wybrac opcje: ");
            radix = scanner.nextInt();

            switch (radix) {
                case 1:
                    System.out.println("Podaj nazwe zadania do dodania: ");
                    String zadanie = scanner.next();
                    dodajZadanie(zadanie);
                    break;
                case 2:
                    System.out.println("Podaj index zadania do usuniecia: ");
                    int index = scanner.nextInt();
                    usunZadanie(index);
                    break;
                case 3:
                    System.out.println("Podaj nazwe projektu do dodania: ");
                    String projekt = scanner.next();
                    dodajProjekt(projekt);
                    break;
                case 4:
                    System.out.println("Podaj index projektu do usuniecia: ");
                    int indexProjekt = scanner.nextInt();
                    usunProjekt(indexProjekt);
                    break;
                case 5:
                    pokazZadania();
                    break;
                case 6:
                    pokazProjekty();
                    break;
                case 7:
                    pokazChangeLog();
                    break;
                case 0:
                    isApplicationRun = false;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji.");
                    break;
            }
        }


    }
}
