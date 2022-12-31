// class transaksi mewarisi class barang implementasi interface diskon
public class Transaction extends Barang implements Diskon{
    public int harga;
    public int diskon;

    //constructor
    public Transaction(Integer harga, Integer diskon){
        this.harga = harga;
        this.diskon = diskon;
    }

    @Override
    public  int harga(Integer harga){
        // Menghitung harga dengan diskon
        this.harga = harga;
        if(harga > 100000 ){
            this.harga = (int)((double)(this.harga*0.80));
        }else if(harga > 50000){
            this.harga = (int)((double)(this.harga*0.85));
        }else if(harga > 25000){
            this.harga = (int)((double)(this.harga*0.90));
        }else{
            this.harga = (int)((double)(this.harga*0.95));
        }
        return this.harga;
    }

    @Override
    public  int Discount(Integer diskon){
        // Menghitung diskon
        this.harga = diskon;
        if(harga > 100000 ){
            this.harga = (int)((double)(this.harga*0.20));
        }else if(harga > 50000){
            this.harga = (int)((double)(this.harga*0.15));
        }else if(harga > 25000){
            this.harga = (int)((double)(this.harga*0.10));
        }else{
            this.harga = (int)((double)(this.harga*0.05));
        }
        return this.harga;
	}
}
