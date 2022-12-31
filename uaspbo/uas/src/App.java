import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // membuat objek
            Scanner input = new Scanner (System.in);
            Barang connection = new Barang();  

            //koneksi ke database
            connection.connection();
            boolean lanjut = true;

            System.out.println();

            // pilihan pemesanan daftar barang
            while(lanjut){
                switch(Menu.menuBarang()){
                    case 1:
                    connection.tampilBarang();
                    break;
        
                    case 2:
                    connection.pesan();
                    break;

                    case 3: 
                    connection.ubahBarang();
                    break;

                    case 4:
                    connection.hapusBarang();
                    break;

                    default:
                    System.out.println("pilihan tidak ada");

                    break;
                }

                //program lanjut / tidak
                System.out.print("Apakah anda ingin pesan lagi ?  ");
                String pilihan =  input.next();
                lanjut = pilihan.equalsIgnoreCase("ya");
                if(!lanjut){
                    connection.tampilBarang();
                    connection.cariBarang();
                    System.out.println();
                    System.out.println("Pilih menu pembayaran");
                    Menu.pembayaran();
    
                    
                    System.out.println("TERIMA KASIH");
                }
             }
             input.close();

        } 
        catch (Exception e) {
            e.printStackTrace();
        }    
    }
}
