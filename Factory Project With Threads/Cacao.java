public class Cacao {
    int weight;
    int usage;
    public Cacao(int weight, int usage) {
        this.weight = weight;
        this.usage = usage;
    }

    public int UseCacao(){
        this.weight-=usage;
        return usage;
    }

    public void Add(int value){
        weight+=value;
    }
}
