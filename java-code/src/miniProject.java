import java.util.Scanner;

public class miniProject {

    public static class Mahasiswa {
        private String nama;
        private String nim;
        private String kelas;
        double[] nilai;

        public void setNama(String nama){ this.nama = nama; }

        public void setNim(String nim){
            if (nim.length() == 10){
                this.nim = nim;
            }
            else{
                System.out.println("Format NIM tidak valid");
            }
        }
        
        public void setKelas(String kelas){ this.kelas = kelas; }


    }

    public class Nilai {
        String nama;
        double nilai;
    }

    static Mahasiswa[] dataMahasiswa = new Mahasiswa[0];

    public static double bacaAngka(Scanner input, String prompt, double min, double max){
        while (true) {
            System.out.print(prompt);
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

    public static void inputData(Scanner input){
        int n = (int) bacaAngka(input, "Silakan input jumlah mahasiswa (3-20): ", 3, 20);
        Mahasiswa[] m = new Mahasiswa[n];
        for (int i = 0; i < m.length; i++) {
            m[i] = new Mahasiswa();
            System.out.println("\nData mahasiswa ke-" + (i + 1));
            System.out.print("NIM: ");
            m[i].nim = input.nextLine().trim();
            System.out.print("Nama: ");
            m[i].nama = input.nextLine().trim();
            System.out.print("Kelas: ");
            m[i].kelas = input.nextLine().trim();

            int t = (int) bacaAngka(input, "Silakan masukkan jumlah nilai mata kuliah (3-5): ", 3, 5);
            m[i].nilai = new double[t];
            for (int j = 0; j < t; j++){
                m[i].nilai[j] = bacaAngka(input, "Nilai mata kuliah ke-"+(j+1)+": ", 0, 100);
            }
        }
        dataMahasiswa = m;
        System.out.println("\nData berhasil disimpan ("+n+" mahasiswa).");
    }

    public static void main(String[] args) {
        boolean inProgram = true;
        while (inProgram) {
            Scanner input = new Scanner(System.in);
            System.out.println("\nSISTEM MONITOR NILAI KELAS");
            System.out.println("1. Input Data\n2. Tampilan Data\n3. Statistik\n4. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = Integer.parseInt(input.nextLine().trim());
            switch (pilihan) {
                case 1 -> inputData(input);
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
