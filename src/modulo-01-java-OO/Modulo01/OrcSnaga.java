
public class OrcSnaga extends Orc {

    public OrcSnaga() {
        super();
        this.vida = 70;
        Item arco = new Item(1, "Arco");
        Item flechas = new Item(5, "Flecha");
        this.inventario.adicionarItem(arco);
        this.inventario.adicionarItem(flechas);
    }
}
