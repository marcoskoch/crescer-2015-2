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



  public String getNome() {
    return nome;
  }

  public void setNome(String novoNome) {
    this.nome = novoNome;
  }

  public int getFlechas() {
    return this.flechas;
  }

/*
public void setFlechas(int flechas) {
if (flechas > this.flechas)
this.flechas = flechas;
}
*/
}
