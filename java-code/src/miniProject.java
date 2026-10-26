import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
        private Nilai[] daftarNilai;

        public void setNama(String nama){ this.nama = nama; }
        public void setNim(String nim){ this.nim = nim; }
        public void setKelas(String kelas){ this.kelas = kelas; }
        public void setDaftarNilai(Nilai[] daftarNilai){ this.daftarNilai = daftarNilai; }

        public String getNama(){ return nama; }
        public String getNim(){ return nim; }
        public String getKelas(){ return kelas; }
        public Nilai[] getDaftarNilai(){ return daftarNilai; }
        public double getRataRataNilai(){ 
            if (daftarNilai == null || daftarNilai.length == 0){
                return 0;
            }
            double total = 0;
            for (Nilai x : daftarNilai){
                total += x.getAngka();
            }
            return total / daftarNilai.length;
        }

    }

    static Mahasiswa[] dataMahasiswa = new Mahasiswa[0];
    static final Map<String, Double> rataRataPerKelas = new TreeMap<>();

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
        if (dataMahasiswa.length == 0) return 0;

        double total = 0;
        for (Mahasiswa m : dataMahasiswa) {
            total += m.getRataRataNilai();
        }
        return total / dataMahasiswa.length;
    }

    public static void hitungRataRataPerKelas() {
        rataRataPerKelas.clear();

        Map<String, Double> totalKelas = new TreeMap<>();
        Map<String, Integer> jumlahMahasiswaKelas = new TreeMap<>();

        for (Mahasiswa m : dataMahasiswa) {
            Nilai[] daftarNilai = m.getDaftarNilai();
            if (daftarNilai == null || daftarNilai.length == 0) {
                continue;
            }

            totalKelas.merge(m.getKelas(), m.getRataRataNilai(), Double::sum);
            jumlahMahasiswaKelas.merge(m.getKelas(), 1, Integer::sum);
        }

        for (String kelas : totalKelas.keySet()) {
            int jumlahMahasiswa = jumlahMahasiswaKelas.get(kelas);
            if (jumlahMahasiswa > 0) {
                rataRataPerKelas.put(kelas, totalKelas.get(kelas) / jumlahMahasiswa);
            }
        }
    }

    public static double rataRataKelas() {
        if (rataRataPerKelas.isEmpty()) return 0;

        double total = 0;
        for (double rata : rataRataPerKelas.values()) {
            total += rata;
        }
        return total / rataRataPerKelas.size();
    }

    public static Mahasiswa cariNim(Scanner input, String prompt) {
        while (true){
            System.out.print(prompt);
            String kataKunci = input.nextLine().trim();

            if (kataKunci.equals("0")) {
                return null;
            }
            if (!kataKunci.matches("\\d+")){
                System.out.println("Format NIM tidak valid! NIM harus berupa angka.");
                continue;
            }

            Mahasiswa[] kandidat = new Mahasiswa[dataMahasiswa.length];
            int jumlahKandidat = 0;

            for (Mahasiswa m : dataMahasiswa) {
                if (m.getNim().contains(kataKunci)) {
                    kandidat[jumlahKandidat] = m;
                    jumlahKandidat++;
                }
            }

            if (jumlahKandidat == 0) {
                System.out.println("Tidak ada NIM yang cocok dengan \"" + kataKunci + "\".");
                continue;
            }

            if (jumlahKandidat == 1) {
                return kandidat[0];
            }

            System.out.println("\nDitemukan " + jumlahKandidat + " mahasiswa:");
            for (int i = 0; i < jumlahKandidat; i++) {
                Mahasiswa m = kandidat[i];
                System.out.printf("%d. %s | %s | %s%n",
                    i + 1, m.getNim(), m.getNama(), m.getKelas());
            }

            int pilih = (int) bacaAngka(input, "Pilih nomor (0 untuk batal): ", 0, jumlahKandidat);
            if (pilih == 0) {
                return null;
            }
            return kandidat[pilih - 1];
        }
    }

    public static float nilaiTertinggi() {
        return 1;
    }

    public static String predikat() {
        return "1";
    }

    public static boolean tampilanWarning(){
        if (dataMahasiswa.length == 0){
            System.out.println("Belum ada data. Tolong masukkan data terlebih dahulu.");
            return true;
        }
        return false;
    }

    public static void statistik(Scanner input) {
        boolean inStatistik = true;
        while (inStatistik) {
            System.out.println("\nMENU STATISTIK");
            System.out.println("1. Total Mahasiswa\n2. Rata-Rata Keseluruhan Mahasiswa\n3. Rata-Rata Keseluruhan Kelas\n4. Nilai Tertinggi\n5. Predikat\n6. Semua\n7. Keluar");
            int pilihan = (int) bacaAngka(input, "Pilihan: ", 1, 7);
            switch (pilihan) {
                case 1 -> {
                    if (tampilanWarning()) break;
                    System.out.printf("Total Mahasiswa: %d\n", dataMahasiswa.length);
                }
                case 2 -> {
                    if (tampilanWarning()) break;
                    System.out.printf("Rata-rata Nilai Keseluruhan Manusia: %.1f%n", rataRataMahasiswa());
                }
                case 3 -> {
                    if (tampilanWarning()) break;
                    System.out.println("\nRata-rata per Kelas:");
                    for (Map.Entry<String, Double> entry : rataRataPerKelas.entrySet()) {
                        System.out.printf("Kelas %-6s : %.2f%n", entry.getKey(), entry.getValue());
                    }
                    System.out.printf("Rata-rata Nilai Keseluruhan Kelas: %.2f%n", rataRataKelas());
                }
                case 4 -> {
                    if (tampilanWarning()) break;
                }
                case 5 -> {
                    if (tampilanWarning()) break;
                }
                case 6 -> {
                    if (tampilanWarning()) break;
                }
                case 7 -> {
                    inStatistik = false;
                }
            }
        }
    }

    public static void tampilanData(Scanner input) {
        boolean inTampilan = true;
        while (inTampilan) {
            System.out.println("\nMENU TAMPILAN DATA");
            System.out.println("1. Data Individu Mahasiswa\n2. Daftar Mahasiswa\n3. Keluar");
            int pilihan = (int) bacaAngka(input, "Pilihan: ", 1, 3);
            switch (pilihan) {
                case 1 -> {
                    if (tampilanWarning()) break;

                    Mahasiswa m = cariNim(input, "Masukkan NIM Mahasiswa yang ingin ditampilkan (0 untuk batal): ");
                    if (m == null) {
                        System.out.println("Pencarian dibatalkan.");
                        break;
                    }

                    System.out.println("\nDATA MAHASISWA");
                    System.out.println("NIM   : " + m.getNim());
                    System.out.println("Nama  : " + m.getNama());
                    System.out.println("Kelas : " + m.getKelas());

                    System.out.println("Nilai:");
                    Nilai[] daftarNilai = m.getDaftarNilai();
                    if (daftarNilai != null) {
                        for (Nilai n : daftarNilai) {
                            System.out.printf("  %-20s : %.2f%n", n.getNama(), n.getAngka());
                        }
                    }

                    System.out.printf("Rata-rata mahasiswa : %.2f%n", m.getRataRataNilai());

                    Double rataKelas = rataRataPerKelas.get(m.getKelas());
                    if (rataKelas != null) {
                        System.out.printf("Rata-rata kelas %s : %.2f%n", m.getKelas(), rataKelas);
                    }
                }
                case 2 -> {
                    if (tampilanWarning()) break;
                    System.out.printf("%-12s %-20s %-8s%n", "NIM", "NAMA", "KELAS");
                    for (Mahasiswa m : dataMahasiswa) {
                        System.out.printf("%-12s %-20s %-8s%n", m.getNim(), m.getNama(), m.getKelas());
                    }
                }
                case 3 -> {
                    inTampilan = false;
                }
            }
        }
    }

    public static void inputData(Scanner input){
        int n = (int) bacaAngka(input, "Silakan input jumlah mahasiswa (3-20): ", 3, 20);
        Mahasiswa[] m = new Mahasiswa[n];
        for (int i = 0; i < m.length; i++) {
            m[i] = new Mahasiswa();
            System.out.println("\nData mahasiswa ke-" + (i + 1));
            String nimValid;
            while (true) {
                nimValid = bacaNim(input, "NIM: ");
                boolean sudahAda = false;
                for (int k = 0; k < i; k++) {
                    if (m[k].getNim().equals(nimValid)) {
                        sudahAda = true;
                        break;
                    }
                }
                if (!sudahAda) break;
                System.out.println("NIM sudah terdaftar. Masukkan NIM lain.");
            }
            m[i].setNim(nimValid);
            System.out.print("Nama: ");
            m[i].setNama(input.nextLine().trim());
            System.out.print("Kelas: ");
            m[i].setKelas(input.nextLine().trim().toUpperCase());

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
        hitungRataRataPerKelas();
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
                case 2 -> tampilanData(input);
                case 3 -> statistik(input);
                case 4 -> {
                    System.out.println("Terima Kasih Telah Menggunakan Program Ini!");
                    inProgram = false;
                }
            }
        }
    }
}
