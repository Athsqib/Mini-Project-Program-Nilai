import java.util.Scanner;

public class miniProject {

    public static class Mahasiswa {
        String nama;
        String nim;
        String kelas;
        double[] nilai;
    }

    static Mahasiswa[] dataMahasiswa = new Mahasiswa[0];

    public static double bacaAngka(Scanner input, String prompt, double min, double max){
        while (true) {
            System.out.println(prompt);
            String s = input.nextLine().trim();
            try {
                double value = Double.parseDouble(s);
                if (value >= min && value <= max){
                    return value;
                }
                System.out.println("Input harus antara "+(int)min+" dan "+(int)max+".");
            } catch(NumberFormatException e){
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    public static double rataRataMahasiswa() {
        return 1;
    }

    public static double rataRataKelas() {
        return 1;
    }

    public static String cariNim() {
        return "1";
    }

    public static float nilaiTertinggi() {
        return 1;
    }

    public static String predikat() {
        return "1";
    }

    public static void tampilanData() {

    }

    public static void statistik() {

    }

    public static void main(String[] args) {
        boolean inProgram = true;
        while (inProgram) {
            Scanner input = new Scanner(System.in);
            System.out.println("SISTEM MONITOR NILAI KELAS");
            System.out.println("1. Input Data\n2. Tampilan Data\n3. Statistik\n4. Keluar");
            System.out.print("Pilihan : ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1 -> {
                    boolean masihInput = true;
                    while (masihInput) {
                        System.out.print("Silakan input jumlah mahasiswa (3-20): ");
                        int n = input.nextInt();
                        if (n < 3 || n > 20) {
                            System.out.println("Jumlah mahasiswa tidak valid.\n");
                            break;
                        }
                        Mahasiswa[] m = new Mahasiswa[n];

                        for (int i = 0; i < m.length; i++) {
                            m[i] = new Mahasiswa();
                            System.out.println("\nData mahasiswa ke-" + (i + 1));
                            System.out.println("NIM: ");
                            m[i].nim = input.nextLine();
                            System.out.println("Nama: ");
                            m[i].nama = input.nextLine();
                            System.out.println("Kelas: ");
                            m[i].kelas = input.nextLine();
                            System.out.println("Silakan input jumlah nilai mata kuliah (3-5): ");
                            int t = Integer.parseInt(input.nextLine());
                            boolean inputNilai = true;
                            while (inputNilai) {
                                if (t < 3 || t > 5) {
                                    System.out.println("Jumlah nilai mata kuliah tidak valid.");
                                    break;
                                }
                            }
                        }
                    }
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> {
                    System.out.println("Terima Kasih Telah Menggunakan Program Ini!");
                    inProgram = false;
                }
                default -> {
                    System.out.println("Pilihan tidak valid.");
                    break;
                }
            }
        }
    }
}
