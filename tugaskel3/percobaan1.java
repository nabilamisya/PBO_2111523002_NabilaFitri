import java.util.HashMap;

class percobaan1 {
    public static void main(String[] args) {
        HashMap<Integer, String> days = new HashMap<>();

        days.put(1, "Minggu");
        days.put(2, "Senin");
        days.put(3, "Selasa");
        days.put(4, "Rabu");
        days.put(5, "Kamis");
        days.put(6, "Jumat");
        days.put(7, "Sabtu");

        System.out.println("Isi objek days: " + days);
    }
}