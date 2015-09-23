
public class OrcUrukHai extends Orc {

    public OrcUrukHai() {
        super();
        this.vida = 150;
        Item escudoUrukHai = new Item(1, "Escudo Uruk-Hai");
        Item espada = new Item(1, "Espada");
        this.inventario.adicionarItem(escudoUrukHai);
        this.inventario.adicionarItem(espada);
    }
}
