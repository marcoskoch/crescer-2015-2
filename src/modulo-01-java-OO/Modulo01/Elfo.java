public class Elfo {
    private String nome;
    private int flechas = 42;
    private int exp = 1;

    public Elfo(String nome) {
        this.nome = nome;
    }

    public void atirarFlecha(){
      flechas--;
      exp++;
    }
}
