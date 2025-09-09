import java.util.Scanner;

public class StudyPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] titles = new String[20];
        int[] durations = new int[20];
        int count = 0;
        int[][] schedule = new int[7][3];
        String[] days = {"Senin","Selasa","Rabu","Kamis","Jumat","Sabtu","Minggu"};
        boolean running = true;

        while (running) {
            System.out.println("=== Study Planner ===");
            System.out.println("1. Tambah sesi belajar");
            System.out.println("2. Tampilkan semua sesi");
            System.out.println("3. Atur jadwal mingguan");
            System.out.println("4. Tampilkan jadwal mingguan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    if (count >= 20) {
                        System.out.println("Kapasitas penuh!");
                    } else {
                        System.out.print("Judul sesi: ");
                        titles[count] = sc.nextLine();
                        System.out.print("Durasi (menit): ");
                        durations[count] = Integer.parseInt(sc.nextLine());
                        count++;
                        System.out.println("Sesi berhasil ditambahkan.");
                    }
                    break;
                case "2":
                    if (count == 0) System.out.println("Belum ada sesi.");
                    else {
                        int nomor = 1;
                        for (String title : titles) {
                            if (nomor > count) break;
                            System.out.printf("%d. %s (%d min)\n", nomor, title, durations[nomor-1]);
                            nomor++;
                        }
                    }
                    break;
                case "3":
                    if (count == 0) System.out.println("Belum ada sesi.");
                    else {
                        System.out.print("Masukkan hari (1-7): ");
                        int day = Integer.parseInt(sc.nextLine()) - 1;
                        System.out.print("Masukkan slot (1-3): ");
                        int slot = Integer.parseInt(sc.nextLine()) - 1;
                        int nomor = 1;
                        for (String title : titles) {
                            if (nomor > count) break;
                            System.out.printf("%d. %s\n", nomor, title);
                            nomor++;
                        }
                        System.out.print("Pilih nomor sesi: ");
                        int idx = Integer.parseInt(sc.nextLine()) - 1;
                        if (day >= 0 && day < 7 && slot >= 0 && slot < 3 && idx >= 0 && idx < count) {
                            schedule[day][slot] = idx + 1;
                            System.out.println("Sesi berhasil ditambahkan ke jadwal.");
                        } else System.out.println("Input tidak valid.");
                    }
                    break;
                case "4":
                    for (int d = 0; d < 7; d++) {
                        System.out.println(days[d] + ":");
                        for (int s = 0; s < 3; s++) {
                            int val = schedule[d][s];
                            if (val == 0) System.out.printf("  Slot %d: -\n", s+1);
                            else {
                                int idx = val - 1;
                                System.out.printf("  Slot %d: %s (%d min)\n", s+1, titles[idx], durations[idx]);
                            }
                        }
                    }
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        }

        sc.close();
        System.out.println("Program selesai. Terima kasih!");
    }
}