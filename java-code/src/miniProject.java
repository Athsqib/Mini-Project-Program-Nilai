
import java.util.Scanner;


public class miniProject {
    
    public class Mahasiswa{
        String nama;
        String Nim;
        int[] nilai;
    }

    public static double rataRataMahasiswa(){
        return 1;
    }

    public static double rataRataKelas(){
        return 1;
    }

    public static String cariNim(){
        return "1";
    }

    public static float nilaiTertinggi(){
        return 1;
    }

    public static String predikat(){
        return "1";
    }

    public static void tampilanData(){
        
    }

    public static void statistik(){
        
    }

    public static void main(String[] args) {
        boolean inProgram = true;
        while(inProgram){
            Scanner input = new Scanner(System.in);
            System.out.println("SISTEM MONITOR NILAI KELAS");
            System.out.println("1. Input Data\n2. Tampilan Data\n3. Statistik\n4. Keluar");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1 -> {
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> {
                    System.out.println("TERIMA KASIH SUDAH MENGGUNAKAN PROGRAM INI!");
                    inProgram = false;
                }
                default -> throw new AssertionError();
            }
        }
    }
}
