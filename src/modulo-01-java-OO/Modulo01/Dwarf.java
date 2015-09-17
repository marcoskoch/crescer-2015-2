
public class Dwarf{
    private String nome;
    private int experiencia;
    private int vida;
    private Status status;

    {
      vida = 110;
      experiencia = 0;
      status = Status.VIVO;
    }
    
    public Dwarf(String nome){
        this.nome = nome;
    }

    public void levaFlechada(){
      this.vida -= 10;
      if (getVida() == 0 ){
        status = Status.MORTO;
      }
    }

    public int getVida(){
      return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
}
