import java.lang.reflect.WildcardType;

public class Salt {
    int weight;
    int usage;

    public Salt(int weight, int usage) {
        this.weight = weight;
        this.usage = usage;
    }

    public int UseSalt(){
        this.weight-=usage;
        return usage;

    }

    public void Add(int value){
        weight+=value;
    }
    
}
