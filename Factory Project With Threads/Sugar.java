public class Sugar  {
    int weight;
    int usage;
    public Sugar(int weight, int usage) {
        this.weight = weight;
        this.usage = usage;
    }

    public int UseSugar(){
        this.weight-=usage;
        return usage;
    }
    public void Add(int value){
        weight+=value;
    }
}
