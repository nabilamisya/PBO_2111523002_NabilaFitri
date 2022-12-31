import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Barang implements CRUD {

    // Membuat objek
    static Connection connection;
    static Statement stm;
    static ResultSet rs;
    static Scanner input = new  Scanner(System.in);
    Transaction Transaction;
    
    // Membuat properti
    private String nama;
    private int jumlah;
    private int harga;
    private int diskon;
    private int total;
    

    // mendefinisikan koneksi database
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/uaspbo";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void connection() {
        // method koneksi database
        try {
            // registrasi driver yang dipakai
            Class.forName(JDBC_DRIVER);

            // koneksi database
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {
            // kalau error saat koneksi
            e.printStackTrace();
        }
    }

    //Polymorphisme Overridding
    @Override
    public void tampilBarang(){
        String sql = "SELECT * FROM tblbarang ";
         try {
            //inisialisasi
            stm = connection.createStatement();
            rs = stm.executeQuery(sql);

            // Method
            String judul = "Tampil Barang";
            System.out.println("==============================================================================================");
            System.out.printf("\t\t\t      %s\n",judul.toUpperCase());
            System.out.println("==============================================================================================");
            System.out.println("| No pesanan |      Nama Barang      |   Harga   |   Jumlah   |   Diskon   |   Total Harga   |");
            System.out.println("----------------------------------------------------------------------------------------------");
             
            //tampilan barang dari database
            while (rs.next()){
                int no_pesan = rs.getInt("no_pesan");
                String nama = rs.getString("nama_barang");
                int jumlah = rs.getInt("jumlah_barang");
                int harga = rs.getInt("harga_barang");
                int diskon = rs.getInt("diskon");
                int total = rs.getInt("total_harga");
                System.out.println(String.format("| %-10d | %-20s  | %-10d |  %-10d |  %-10d |  %-10d |", no_pesan, nama, harga, jumlah, diskon, total));
            }

            //String method
            char[] str = {'T','e','r','i','m','a',' ','K','a','s','i','h'};
            String str2 = "";

            str2 = String.copyValueOf(str);
            str2 = str2.toUpperCase();
            System.out.printf("\n %s\n",str2);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Polymorphisme Overridding
    @Override
    public void pesan(){
        //Exception
        try {
            //menginput data
            System.out.print("Masukkan no pesan : ");
            int  no_pesan = input.nextInt();
            input.nextLine();
          
            System.out.print("Masukkan nama     : ");
            String nama = input.nextLine();

            System.out.print("Masukkan harga   : ");
            int harga = input.nextInt();

            System.out.print("Masukkan jumlah    : ");
            jumlah = input.nextInt();
            
            //percabangan
            if(harga < 0 || jumlah < 0 || no_pesan < 0){
                throw new IllegalArgumentException("Angka tidak boleh negatif");
            }

            //instansiasi
            Transaction = new Transaction (harga, diskon);
            this.harga = harga * jumlah;
            total = Transaction.harga(this.harga);
            diskon = Transaction.Discount(this.harga);
            
            //query tampil barang
            String sql =  "SELECT * FROM tblbarang";
            stm = connection.createStatement();
            rs =  stm.executeQuery(sql);
           
            while(rs.next()){
                if(no_pesan == rs.getInt("no_pesan")){
                    System.out.println("pesan telah ada");
                    throw new SQLException();
                }   
               
            }

            //query insert barang
            String sql2 =  "INSERT INTO tblbarang (no_pesan,nama_barang,jumlah_barang,harga_barang,diskon,total_harga) VALUE('"+ no_pesan +"','"+ nama +"','"+ jumlah +"','"+ harga +"','"+ diskon +"','"+ total +"')";
            stm.executeUpdate(sql2);
            System.out.println("Barang dimasukkan ke pesanan");

        } 
        catch (IllegalArgumentException  | SQLException e) {
            e.printStackTrace();
        }
    
    }

    //Polymorphisme Overridding
    @Override
    public void ubahBarang(){
        //Execption
        try {
            //memanggil method tampil barang
            tampilBarang();

            //input barang
            System.out.println();
            System.out.print("Masukkan no pesan: ");
            int no_pesan =  input.nextInt();
            input.nextLine();

            System.out.print("Masukkan nama     : ");
            String nama = input.nextLine();

            System.out.print("Masukkan jumlah   : ");
            int harga = input.nextInt();

            System.out.print("Masukkan harga    : ");
            int jumlah = input.nextInt();

            if(harga < 0 || jumlah < 0 || no_pesan < 0){
                throw new IllegalArgumentException("angka tidak boleh negatif");
            }
            
            //instansiasi
            Transaction = new Transaction (harga, diskon);
            this.harga = harga * jumlah;
            total = Transaction.harga(this.harga);
            diskon =  Transaction.Discount(this.harga);
            boolean isFound = false;
          
            //query tampil barang
            String sql =  "SELECT * FROM tblbarang";
            stm = connection.createStatement();
            rs =  stm.executeQuery(sql);
           
            while(rs.next()){
                if(no_pesan == rs.getInt("no_pesan")){
                    isFound = true;
                }   
            }

            //pengecekan barang di database
            if(!isFound){
                throw new SQLException("data tidak ditemukan");
            }
            
            else{
                //query update barang
                String sql2 = "UPDATE penjualan SET no_pesan='"+ no_pesan +"',nama_barang ='"+ nama +"',jumlah_barang ='"+ jumlah +"',harga_barang ='"+ harga +"',diskon = "+ diskon +"', total_harga = "+total+"' WHERE no_pesan= '"+ no_pesan +"'";
                stm.executeUpdate(sql2);
                System.out.println("Barang pesanan berhasil diupdate");
            }
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
       
    }

    //Polymorphisme Overridding
    @Override
    public void hapusBarang(){
        //Exception
        try {
            //Memanggil method
            tampilBarang();
            System.out.println();
            System.out.print("Masukkan no pesan : ");
            int no_pesan = input.nextInt();

            if(no_pesan < 0){
                throw new IllegalArgumentException("angka tidak boleh negatif");
            }

            boolean isFound = false;

            //query tampil barang
            String sql =  "SELECT * FROM tblbarang";
            stm = connection.createStatement();
            rs =  stm.executeQuery(sql);
           
            while(rs.next()){
                if(no_pesan == rs.getInt("no_pesan")){
                    isFound = true;
                }   
            }

            //pengecekan barang
            if(!isFound){
                throw new SQLException("data tidak ditemukan");
            }else{
                //query hapus barang
                String sql2 = "DELETE FROM tblbarang WHERE no_pesan= " +no_pesan;
                stm.executeUpdate(sql2);
                System.out.println("Barang batal di pesan");
            }
        } 
        catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }

       
    }

    //Polymorphisme Overridding
    @Override
    public void cariBarang(){
        //Exception
        try {
            //input keyword pencarian
            System.out.print("masukkan keyword (nama barang/no pesan) : ");
            String keyword = input.next();
            
            //query cari barang
            String sql = "SELECT * FROM tblbarang WHERE no_pesan LIKE '%"+ keyword +"%' OR  nama_barang LIKE '%"+ keyword +"%'";

            //inisialisasi
            stm = connection.createStatement();
            rs =  stm.executeQuery(sql);

            //Menampilkan barang yang dicari
            System.out.println("| No pesanan |      Nama Barang      |  Jumlah  |  Harga  |  Diskon  |  Total Harga  |");
            System.out.println("----------------------------------------------------------------------------------------------");
            
            while(rs.next()){
                    int no_pesan =  rs.getInt("no_pesan");
                    String nama = rs.getString("nama_barang");
                    int jumlah =  rs.getInt("jumlah_barang");
                    int harga=  rs.getInt("harga_barang");
                    int diskon=  rs.getInt("diskon");
                    int total = rs.getInt("total_harga");
                    
                    System.out.println(String.format("| %-10d | %-20s | %-10d | %-10d | %-10d |", no_pesan,nama,jumlah,harga,diskon,total));
            }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }			
    }
}
