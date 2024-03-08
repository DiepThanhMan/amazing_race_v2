/*
Bài tập về interface
*/
package amazingracev2;
import data.Dog;
import data.Pet;
import data.DeathRacer;
import data.Motor;
import java.util.*;

public class AmazingRaceV2 {
   
    public static void main(String[] args) {
        runToDead();
    }
    
    public static void playAnonymous(){
        List list = new ArrayList();
        //abstract,interface đó, 20 hàm không có code!!!
        //List list = new List();
        
    }
    
    ///Dẫn dắt vào bài: Mỹ nhân ngư(Mermaid) theo truyền thuyết là ăn thịt thủy thủ
    ///Có một object thuộc class Mermaid phá cách, Ko ăn thịt con người, muốn chơi với con người...
     
    ///object này muốn tham gia cuộc đua kỳ thú
    ///Chỉ cần có hành động của CLB Đua là được rồi
    ///Vậy chỉ cần implements, @Override , có hàm run() và showHowToDeath() 
    ///Không cần làm class riêng để dễ nhân bản ra nhiều object.
        
    
    public static void runToDead(){
        DeathRacer mnnCTT = new DeathRacer() {
           //vùng không gian của class Mermaid mà ta làm biếng làm riêng
           public static final double MAX_SPEED = 50.0;
        
           @Override
            public double runToDead() {
              return new Random().nextDouble() * MAX_SPEED *3;
            }
        
            ///anonymous làm biếng tạo class rời cho cả abstract class và interface
            ///bên abstract class thì ta còn có đặc điểm của Cha cho để xài
            //anonymous của interface, không có info("đua thì đua hỏi han  làm chi")
            @Override
            public void showHowToDead() {
                System.out.printf("|%-20s|%-15s|2015|%5.1f|\n",
                                  "MERMAID-RACER","MNN-CTT",runToDead());
            }
        };    
        
        Dog d1 = new Dog("NGÁO ĐÁ",2021,50.0);
        ///chấm ra full hàm Cha, đủ code hàm Cha, interface DeathRacer
        
        Pet d2 = new Dog("VÀNG ƠI",1950,10.0);
        ///chấm ra full hàm Cha,khai Cha, chạy Ko sợ vì đa hình Con qua mặt,tổ lái con trỏ(Driff con trỏ) được, new Dog mà sợ gì
        
        DeathRacer d3 = new Dog("NANH TRẮNG",1901,20.0);
        ///ngộ nhỡ dấu chấm thì sao: chấm thì xổ full Interface
        ///ép con trỏ được luôn, new Dog mà! 
        
        Motor m1 = new Motor("EXCITER","150.0cm3","58F8-22204");
        DeathRacer m2 =new Motor("WINNER","150.0cm3","56F6-67889");
                       
        //DeathRacer racer[] = {d1,(Dog)d2,d3,m1,m2}; ///chú ý d2 khai báo là Pet, mà Pet thì không tham gia DeathRacer, 
                                                    ///nên để vào mảng racer được phải ép kiểu d2 là Dog ->(Dog)d2
        
        //racer[0] = new Dog(...);
        //racer[1] = new Motor(...);                                            
        //toàn bộ là DeathRacer, đa hình là đa hình trên trên runToDead() showHowTo()
        //Con Motor chạy theo Motor, Con Dog chạy theo Dog
        
        ///khai báo 1 object thuộc class anonymous
        DeathRacer racer[] = {mnnCTT,d1,(Dog)d2,d3,m1,m2};
        
        System.out.println("The racing records");
        for(DeathRacer x : racer){
            x.showHowToDead();
        }
        
    }
}
/*SV feedback sort thành tích đua như sau:
1/ Ở abstract class Pet và class Motor em thêm 1 final variable "race"  
   (em để ở class Cha vì tất cả con đều có "race" này nên để cho Cha giữ luôn): 
   public final double race = run();
2/ Ở hàm runToDead() của class Dog, class Motor em sử dụng biến "race" này để tính toán tiếp:
    public double runToDead() {
        return race * 10; }
3/ Và ở các hàm showRecord() hay những hàm có gọi run() của tất cả class Con em sẽ thay bằng biến "race" này. 
   Em nghĩ khi hàm run() chạy lần đầu tiên nó sẽ trả về giá trị và gán cho biến "race" là final variable 
   nên sẽ không thay đổi trị nữa.
4/ Đối với hàm sort():
   + nếu chỉ sort những class Con đc extends từ class Pet thì em sẽ trỏ đến biến chung final "race"  -->  [index].race
   + nếu sort các class implements từ Interface từ em sẽ trỏ đến hàm chung runToDead()   -->  [index].runToDead()

Hiện tại em code như thế thì thấy thấy đã sort được, 
nhưng không biết em có sót case nào không và em hiểu như vậy đã đúng chưa ạ? 

*/