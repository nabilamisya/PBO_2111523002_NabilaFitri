package Tugas2;

public class Asdos extends Mahasiswa{
    private int jamNgasdos;

    Asdos(String nama, int sks, int jamNgasdos) {
        super(nama, sks);
        jamSibuk = jamSibuk + jamNgasdos;
    }

    int getJamSibuk() {
        return jamSibuk;
    }
    
    @Override
    void kirim() {
        System.out.println(getnama() + " adalah seorang asdos dengan jam sibuk " + getJamSibuk());
    }
}
