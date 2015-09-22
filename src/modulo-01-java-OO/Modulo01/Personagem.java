
public class Personagem {
      protected String nome;
      protected Inventario inventario;
      protected int vida, experiencia;
      protected Status status;

      public Personagem(){
          this.inventario = new Inventario();
          this.status = Status.VIVO;
      }

      public void adicionarItem(Item item) {
          this.inventario.adicionarItem(item);
      }

      public void perderItem(Item item) {
          this.inventario.perderItem(item);
      }

      public Inventario getInventario() {
          return this.inventario;
      }

      public void receberAtaqueDoOrc(Orc orc){
          int danoCausado = orc.getDanoDeAtaque();
          this.vida -= danoCausado;
      }

      public String getNome() {
          return this.nome;
      }

      public int getVida() {
          return this.vida;
      }

      public Status getStatus() {
          return this.status;
      }

      public int getExperiencia() {
          return this.experiencia;
      }
}
