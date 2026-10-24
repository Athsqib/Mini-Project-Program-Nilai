import java.util.Scanner;

public class miniProject {

    public static class Nilai {
        private String namaMataKuliah;
        private double angka;

        public Nilai(String namaMataKuliah, double angka) {
            this.namaMataKuliah = namaMataKuliah;
            this.angka = angka;
        }

        public void setNamaMataKuliah(String nama){ this.namaMataKuliah = nama; }
        public void setAngka(double angka){ this.angka = angka; }

        public String getNama(){ return namaMataKuliah; }
        public double getAngka(){ return angka; }

    }

    public static class Mahasiswa {
        private String nama;
        private String nim;
        private String kelas;
        private Nilai[] daftarNilai ;

        public void setNama(String nama){ this.nama = nama; }
        public void setNim(String nim){ this.nim = nim; }
        public void setKelas(String kelas){ this.kelas = kelas; }
        public void setDaftarNilai(Nilai[] daftarNilai){ this.daftarNilai = daftarNilai; }

        public String getNama(){ return nama; }
        public String getNim(){ return nim; }
        public String getKelas(){ return kelas; }
        public Nilai[] getDaftarNilai(){ return daftarNilai; }

    }

    static Mahasiswa[] dataMahasiswa = new Mahasiswa[0];

    public static double bacaAngka(Scanner input, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String s = input.nextLine().trim();
            try {
                double value = Double.parseDouble(s);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Input harus antara "+(int)min+" dan "+(int)max+".");
            } catch(NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    public static String bacaNim(Scanner input, String prompt) {
        while(true){
            System.out.print(prompt);
            String nim = input.nextLine().trim();

            if (nim.length() == 10) {
                if (nim.matches("\\d+")) {
                    return nim;
                } else {
                    System.out.println("NIM harus berupa angka.");
                }
            } else {
                System.out.println("Format tidak valid! NIM harus terdiri dari tepat 10 digit.");
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

    public static void statistik(Scanner input) {
        boolean inStatistik = true;
        while (inStatistik) {
            System.out.println("\nMENU SATISTIK");
            System.out.println("1. Total Mahasiswa\n2. Rata-Rata Mahasiswa\n3. Rata-Rata Kelas\n4. Nilai Tertinggi\n5. Predikat\n6. Keluar");
            int pilihan = (int) bacaAngka(input, "Pilihan: ", 1, 5);
            switch (pilihan) {
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> {
                    inStatistik = false;
                }
            }
        }
    }

    public static void tampilanData(Scanner input) {
        boolean inTampilan = true;
        while (inTampilan) {
            System.out.println("\nMENU TAMPILAN DATA");
            System.out.println("1. Data Individu Mahasiswa\n2. Daftar Mahasiswa\n3. ");
        }
    }

    public static void inputData(Scanner input){
        int n = (int) bacaAngka(input, "Silakan input jumlah mahasiswa (3-20): ", 3, 20);
        Mahasiswa[] m = new Mahasiswa[n];
        for (int i = 0; i < m.length; i++) {
            m[i] = new Mahasiswa();
            System.out.println("\nData mahasiswa ke-" + (i + 1));
            String nimValid = bacaNim(input, "NIM: ");
            m[i].setNim(nimValid);
            System.out.print("Nama: ");
            m[i].setNama(input.nextLine().trim());
            System.out.print("Kelas: ");
            m[i].setKelas(input.nextLine().trim());

            int t = (int) bacaAngka(input, "Silakan masukkan jumlah nilai mata kuliah (3-5): ", 3, 5);
            Nilai[] kumpulanNilai = new Nilai[t];

            for (int j = 0; j < t; j++) {
                System.out.print("Nama Mata Kuliah ke-" + (j + 1) + ": ");
                String namaMatkul = input.nextLine().trim();

                double angkaInput = bacaAngka(input, "Nilai mata kuliah ke-"+ (j+1) +": ", 0, 100);

                kumpulanNilai[j] = new Nilai(namaMatkul, angkaInput);
            }

            m[i].setDaftarNilai(kumpulanNilai);
        }
        dataMahasiswa = m;
        System.out.println("\nData berhasil disimpan ("+ n +" mahasiswa).");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean inProgram = true;
        while (inProgram) {
            System.out.println("\nSISTEM MONITOR NILAI KELAS");
            System.out.println("1. Input Data\n2. Tampilan Data\n3. Statistik\n4. Keluar");
            int pilihan = (int) bacaAngka(input, "PIlihan: ", 1, 4);
            switch (pilihan) {
                case 1 -> inputData(input);
                case 2 -> {}
                case 3 -> statistik(input);
                case 4 -> {
                    System.out.println("Terima Kasih Telah Menggunakan Program Ini!");
                    inProgram = false;
                }
            }
        }
    }
}
