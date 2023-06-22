import java.util.Scanner;

public class FinalProjek {
    Siswa[] siswa = new Siswa[100];
    int siswaCount = 0;

    public class Siswa {
        String name;
        double tugas;
        double ulangan;
        double uts;
        double uas;
        double finalScore;

        public Siswa(String name, double tugas, double ulangan, double uts, double uas) {
            this.name = name;
            this.tugas = tugas;
            this.ulangan = ulangan;
            this.uts = uts;
            this.uas = uas;
            this.finalScore = calculateFinalScore();
        }

        public double calculateFinalScore() {
            return (tugas + ulangan + uts + uas) / 4;
        }

    }

    public void addSiswa(Siswa siswa) {
        if (siswaCount < 100) {
            this.siswa[siswaCount] = siswa;
            siswaCount++;
        } else {
            System.out.println("Batas maksimum siswa telah tercapai.");
        }
    }

    public void showSiswa() {
        if (siswaCount > 0) {
            System.out.println("Nomor\t\tNama\t\tNilai Akhir ");
            System.out.println("-------------------------------------------------");
            for (int i = 0; i < siswaCount; i++) {
                System.out.println((i + 1) + "\t\t" + siswa[i].name + "\t\t" + siswa[i].finalScore);
                System.out.println("-------------------------------------------------");
            }
        } else {
            System.out.println("Belum ada siswa yang terdaftar.");
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < siswaCount - 1; i++) {
            for (int j = 0; j < siswaCount - i - 1; j++) {
                if (siswa[j].finalScore < siswa[j + 1].finalScore) {
                    Siswa temp = siswa[j];
                    siswa[j] = siswa[j + 1];
                    siswa[j + 1] = temp;
                }
            }
        }
    }

    public int linearSearch(String searchName) {
        for (int i = 0; i < siswaCount; i++) {
            if (siswa[i].name.equalsIgnoreCase(searchName)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FinalProjek finalProjek = new FinalProjek();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Pilihan:");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Tampilkan Siswa");
            System.out.println("3. Urutkan Siswa berdasarkan Nilai Akhir");
            System.out.println("4. Cari Siswa berdasarkan Nama");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membaca newline character setelah membaca integer

            switch (choice) {
                case 1:
                    System.out.print("Masukkan jumlah siswa: ");
                    int jumlahSiswa = scanner.nextInt();
                    scanner.nextLine(); // Membaca newline character setelah membaca integer
                    for (int i = 0; i < jumlahSiswa; i++) {
                        System.out.println("Siswa ke-" + (i + 1));
                        System.out.print("Masukkan nama siswa: ");
                        String name = scanner.nextLine();
                        System.out.print("Masukkan nilai tugas: ");
                        double tugas = scanner.nextDouble();
                        System.out.print("Masukkan nilai ulangan: ");
                        double ulangan = scanner.nextDouble();
                        System.out.print("Masukkan nilai UTS: ");
                        double uts = scanner.nextDouble();
                        System.out.print("Masukkan nilai UAS: ");
                        double uas = scanner.nextDouble();
                        scanner.nextLine(); // Membaca newline character setelah membaca double
                        FinalProjek.Siswa newSiswa = finalProjek.new Siswa(name, tugas, ulangan, uts, uas);
                        finalProjek.addSiswa(newSiswa);
                    }
                    System.out.println("Siswa berhasil ditambahkan.");
                    break;
                case 2:
                    finalProjek.showSiswa();
                    break;
                case 3:
                    finalProjek.bubbleSort();
                    System.out.println("Siswa telah diurutkan berdasarkan nilai akhir.");
                    finalProjek.showSiswa();
                    break;
                case 4:
                    System.out.print("Masukkan nama siswa yang akan dicari: ");
                    String searchName = scanner.nextLine();
                    int result = finalProjek.linearSearch(searchName);
                    if (result != -1) {
                        System.out.println("Data ditemukan:");
                        System.out.println("Nama: " + finalProjek.siswa[result].name);
                        System.out.println("Nilai Akhir: " + finalProjek.siswa[result].finalScore);
                    } else {
                        System.out.println("Siswa dengan nama " + searchName + " tidak ditemukan.");
                    }
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }
}
