

public class OrcUrukHai extends Orc {

  public OrcUrukHai() {
      super();
      this.vida = 150;
      this.inventario.adicionarItem(new Item(1, "Espada"));
      this.inventario.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
  }

}
