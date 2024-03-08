
package data;
///CLB của những gã thích đua đến chết, gom object chung hành động đua, Ko care chuyện gì khác.
///CLB Đua này gọi là INTERFACE DeathRacer
///Motor, Dog,.. IS A MEMBER OF, IS A DEADRACER
///Interface chỉ quan tâm hành động, chỉ chứa hành động theo cách riêng của nó 
///Interface chứa hàm abstract 
public interface DeathRacer {
    ///public abstract double runToDead(); //Ko cần từ khóa abstract
    public double runToDead();
    public void showHowToDead(); 
}

