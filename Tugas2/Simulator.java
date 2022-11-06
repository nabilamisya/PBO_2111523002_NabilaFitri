package Tugas2;

public class Simulator {
    public static void main(String[] args) {
        Asdos x = new Asdos("Fairuzikun", 24, 1);
        Dosen y = new Dosen("Raja OP Demanik", 5);
        Elemen z = new Asdos("Angle-chan", 21, 1);
        Mahasiswa s = new Mahasiswa("Firman", 20);
        Elemen j = new Mahasiswa("Nid to pass this sem", 23);
        Elemen k = (Dosen) Elemen ("Nivotko", 3);

        int jumlah = x.getJamSibuk() + y.getJamSibuk() + ((Asdos) z).getJamSibuk() 
                    + ((Mahasiswa) s).getJamSibuk() + ((Mahasiswa) j).getJamSibuk() + ((Dosen) k).getJamSibuk();
        
        x.kirim();
        y.kirim();
        z.kirim();
        s.kirim();
        j.kirim();
        k.kirim();

        System.out.println("Total jam sibuk elemen Fasilkom adalah " + jumlah); 
    }

    private static Dosen Elemen(String string, int i) {
        return null;
    }
}
