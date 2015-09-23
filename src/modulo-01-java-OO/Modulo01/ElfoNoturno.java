
public class ElfoNoturno extends Elfo {


    {
      this.vida = 100;
    }

    public ElfoNoturno(String nome, int flechas) {
        super(nome, flechas);
    }

    public ElfoNoturno(String nome) {
        super(nome);
    }

//     public double getVida() {
//         return (double) this.vida;
//     }

    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia += 2;
        double novaVida = this.vida * 0.95;
        this.vida = (int) novaVida;
    }
/*
    public void atacarOrc(Orc orc){
        flechas--;
        experiencia++;
        orc.levarAtaque();
    }
    */
}
