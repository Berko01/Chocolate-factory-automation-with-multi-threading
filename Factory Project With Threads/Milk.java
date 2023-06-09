public class Milk {
    
    int weight;
    int usage;
    public Milk(int weight, int usage) {
        this.weight = weight;
        this.usage = usage;
    }

    public int use(){
        this.weight-=usage;
        return usage;
    }

    public void add(int value){
        this.weight+=value;
    }

    
}
