package Tugas2;

public class Dosen extends Elemen{
    private int jumlahHariKerja;
    private int jamSibuk;

    Dosen(String nama, int jumlahHariKerja) {
        super(nama);
        jamSibuk = jumlahHariKerja*8;
    }
    
    @Override
    void kirim() {
        System.out.println(getnama() + " adalah seorang dosen dengan jam sibuk " + getJamSibuk());
    }

    int getJamSibuk() {
        return jamSibuk;
    }
}
