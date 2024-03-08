
package data;
import java.util.Random;

//class chính vẫn có đặc điểm, hành vi như bình thường
//nếu tham gia CLB nào thì có thêm hành động của CLB đó, @Override method đó
//Trong Java, 1 Con tối đa 1 Cha, đơn kế thừa(Khác với C++, 1 Con có thể nhiều Cha, đa kế thừa)
//1 Con được quyền tham gia nhiều CLB, khi đó sẽ có method của CLB đó
public class Motor implements DeathRacer {
   public static final double MAX_SPEECH = 180;
           
   private String model; //Exciter 2021,Winner 2020     
   private String volume;//dung tich xylanh
   private String vin;   //biển số(vehicle identifier number)

    public Motor(String model, String volume, String vin) {
        this.model = model;
        this.volume = volume;
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    
    ///hành vi xe máy là chạy, có tốc độ được ghi nhận
    public double run(){
       return new Random().nextDouble() * MAX_SPEECH; //chạy không quá 180km/h (cho chạy ngẫu nhiên)
    }
    ///quay video và gáy tốc độ
    public void showRecord(){            
        System.out.printf("|%-10s|%-15s|%-8s|%11s|%5.1f|\n",
                "MOTOR",model,volume,vin,run());    
                                  ///vin:58F8-567.89;180.0
    }

    @Override
    public double runToDead() {
        return run() * 3; //tăng tốc độ lên gấp 3    
    }

    @Override
    public void showHowToDead() {
        System.out.printf("|%-10s|%-15s|%-8s|%11s|%5.1f|\n",
                "MOTOR-RACER",model,volume,vin,runToDead());    
    }
}
