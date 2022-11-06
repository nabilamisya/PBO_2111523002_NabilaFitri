package Tugas2;

public class Mahasiswa extends Elemen {
    private int sks;
    protected int jamSibuk;

    Mahasiswa(String nama, int sks) {
        super(nama);
        jamSibuk = sks*3;
    }

    @Override
    void kirim() {
        System.out.println(getnama() + " adalah seorang mahasiswa dengan jam sibuk " + getJamSibuk());
    }

    int getJamSibuk(){
        return jamSibuk;
    }
}
