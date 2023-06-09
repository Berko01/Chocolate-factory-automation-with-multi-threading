public class Oil {
    int weight;
    int usage;
    public Oil(int weight, int usage) {
        this.weight = weight;
        this.usage = usage;
    }

    public int UseOil(){
        this.weight-=usage;
        return usage;
    }
    public void AddOil(int value){
        weight+=value;
    }
}
