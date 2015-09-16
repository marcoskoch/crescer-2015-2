public class Elfo {
    private String nome;
    private int flechas;
    private int exp = 0;

    public Elfo(String nome, int flechas) {
  		this.nome = nome;
  		this.flechas = flechas;
  	}

    public Elfo(String nome){
      this(nome, 42);
    }

	  public void atirarFlecha(){
      flechas--;
      exp++;
    }
}
