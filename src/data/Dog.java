
package data;
import java.util.Random;

///Chỉ Dog tham gia CLB DeathRacer thì khai báo implements trong class Dog
public class Dog extends Pet implements DeathRacer{
    public static final double MAX_SPEECH = 40;

    public Dog(String name, int yob, double weight) {
        super(name, yob, weight);
    }

    @Override
    public double run() {
       return new Random().nextDouble() * MAX_SPEECH;
    }

    @Override
    public void showRecord() {
        System.out.printf("|%-10s|%-10s|%4d|%4.1f|%4s|%4.1f|\n",
                            "DOG",name,yob,weight," -  ",run());
    }

    ///khi tham gia DeathRacer thì phải có hành động như DeathRacer 
    @Override
    public double runToDead() {
        return run() * 5; //tăng tốc gấp 5 lần so với bình thường
    }

    @Override
    public void showHowToDead() {
        System.out.printf("|%-20s|%-15s|%4d|%4.1f|%4s|%4.1f|\n",
                            "DOG-RACER",name,yob,weight," -  ",runToDead());
    }
    
    
    
}
