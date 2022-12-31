import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Menu {
    static Scanner input = new Scanner(System.in);
    static Date date =  new Date();
    static Calendar calendar = Calendar.getInstance();

    String barang;
    int harga;

    public Menu(String barang, int harga){
        this.barang = barang;
        this.harga = harga;
    }
    
    // Method tampil menu
    public static int menuBarang(){

        // Menampilkan Tanggal
       String nameDay[] = {
        "Minggu","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"
       };
       String hari = nameDay[calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)];
       String tanggal = String.format("%tF", date);
       String time = String.format("%tT", date);
       String zona = String.format("%tZ", date);
       System.out.println();
       System.out.println(hari +","+ tanggal + " || "+ time +" "+ zona);
        
        // Membuat objek
        LinkedHashSet<Menu> buku=new LinkedHashSet<Menu>();  
        LinkedHashSet<Menu> atk=new LinkedHashSet<Menu>();  
        
        // Inisialisasi objek
        Menu bk1 = new Menu("Komet Minor",85000);  
        Menu bk2 = new Menu("00.00",77000);  
        Menu bk3 = new Menu("Bahasa Pemograman Java", 70000);
        Menu bk4 = new Menu("Bersikap Bodo Amat", 60000);
        Menu bk5 = new Menu("Rentang Kisah", 54000);
        Menu bk6 = new Menu("Resep Masak", 35000); 
        
        Menu tk1 = new Menu("Hi-Tech Pen",20000);  
        Menu tk2 = new Menu("Penghapus",10000);  
        Menu tk3 = new Menu("Pensil", 15000);
        Menu tk4 = new Menu("HVS 70 GSM", 30000);
        Menu tk5 = new Menu("Bookmark", 10000);
        Menu tk6 = new Menu("Refil Pen", 15000);

        // Menambah elemen ke LinkedHashset
        buku.add(bk1);  
        buku.add(bk2);  
        buku.add(bk3);  
        buku.add(bk4);  
        buku.add(bk5);  
        buku.add(bk6);      

        atk.add(tk1);  
        atk.add(tk2); 
        atk.add(tk3); 
        atk.add(tk4); 
        atk.add(tk5); 
        atk.add(tk6); 
        
       // Membuat tampilan daftar barang
        System.out.println("====================================================");
        System.out.println("              TOKO BUKU & ATK JAYAPURA              ");
        System.out.println("====================================================");
        System.out.println("           DISKON AKHIR TAHUN HINGGA 20%            ");
        System.out.println("   OPEN at Senin - Jum'at , jam 10.00 - 22.00 WIB   ");
        System.out.println("====================================================");

        //Menampilkan daftar barang
        System.out.println("                      DAFTAR BARANG                 "); 
        System.out.println("----------------------------------------------------");
        System.out.println("|        Buku              |        Harga          |");
        System.out.println(" ---------------------------------------------------");
        for(Menu b:buku){  
            System.out.printf("%-25s  |   %-9d\n",b.barang,b.harga);  
        }   
        System.out.println("");
        System.out.println("----------------------------------------------------");
        System.out.println("|         ATK              |        Harga          |");
        System.out.println(" ---------------------------------------------------");
        for(Menu b:atk){  
            System.out.printf("%-25s  |   %-9d\n",b.barang,b.harga);  
        } 
        
        System.out.println("");
        System.out.println("""
        [1] Lihat Pesanan Barang
        [2] Masukkan Pesanan
        [3] Mengubah Pesanan
        [4] Batalkan Pesanan
        """);
        System.out.print("Masukkan pilihan   : ");
        int pilihan =  input.nextInt();
        return pilihan;
   
    }   


    public static void pembayaran(){
        // Membuat objek
        ArrayList<String> pay=new ArrayList<String>();//Creating arraylist  
        
        //Menambah elemen ke linkHashSet
        pay.add("Tunai");
        pay.add("Debit");
        pay.add("Gopay");    
        pay.add("Dana ");       
        pay.add("LinkAja");    

        // Menampilkan isi list
        Iterator itr=pay.iterator();  
        int i = 1;
        while(itr.hasNext()){
            System.out.print(i+". "); 
            System.out.println(itr.next());
            i++;
        }  
        System.out.print("Masukkan pilihan : ");
        input.nextInt();
        System.out.println("Pembayaran anda berhasil");
        System.out.println("Terima Kasih Telah Berbelanja");

    }  
}
