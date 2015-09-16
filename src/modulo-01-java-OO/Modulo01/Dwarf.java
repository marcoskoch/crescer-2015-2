

public class Dwarf{
    private String nome;
    private int vida;

    {
      vida = 110;
    }

    public Dwarf(String nome){
      this.nome = nome;
    }

    public void levaFlechada(){
      this.vida = this.vida - 10;
    }
}
