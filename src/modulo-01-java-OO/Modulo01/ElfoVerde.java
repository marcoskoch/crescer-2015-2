
public class ElfoVerde extends Elfo{

  public ElfoVerde(String nome, int flechas) {
      super(nome, flechas);
  }

  public ElfoVerde(String nome) {
      this(nome, 42);
  }

  public void atirarFlecha(Dwarf dwarf) {
      flechas--;
      experiencia += 2;
      dwarf.receberFlechada();
  }

}
