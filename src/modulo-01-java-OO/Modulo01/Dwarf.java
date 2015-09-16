
public class Dwarf{
    private int vida;

    {
      vida = 110;
    }

    public void levaFlechada(){
      this.vida -= 10;
    }

    public int getVida(){
      return this.vida;
    }
}
