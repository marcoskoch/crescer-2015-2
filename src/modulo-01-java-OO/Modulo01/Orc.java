
public class Orc
{
    private int vida;
    private Inventario inventario;
    private Status status;
    private String tipo;

    public Orc() {
        this.vida = 100;
        this.inventario = new Inventario();
        this.status = Status.VIVO;
    }

    public Orc(String tipo){
        this();
        if (tipo.equals("Uruk-Hai")) {
          this.tipo = tipo;
          this.vida = 150;
          this.inventario.adicionarItem(new Item(1, "Espada"));
          this.inventario.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
        } else if (tipo.equals("Snaga")) {
          this.tipo = tipo;
          this.vida = 70;
          this.inventario.adicionarItem(new Item(1, "Arco"));
          this.inventario.adicionarItem(new Item(5, "Flecha"));
        } else {
          this.tipo = tipo;
        }
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

    public void receberAtaqueDwarf(){

        boolean escudo = false;

        for(Item item : this.inventario.getItens()){
            if (item.getDescricao().equals("Escudo Uruk Hai")){
                escudo = true;
                break;
            }
        }

        if (escudo){
            this.vida -=5;
        } else {
            this.vida -= 10;
        }

        if (this.vida < 0){
          this.vida = 0;
        }
        if (this.vida == 0) {
            this.status = Status.MORTO;
        }

    }

    public void receberFlechadaElfo(){
        this.vida -= 8;
        if (this.vida < 0){
          this.vida = 0;
        }
        if (this.vida == 0) {
            this.status = Status.MORTO;
        }
    }


    public void atacarAnao(Dwarf dwarf) {
        boolean temArco = false, temFlecha = false, temEspada = false;

        for(Item item : this.inventario.getItens()){
            if (item.getDescricao().equals("Espada")){
                temEspada = true;
                break;
            } else if (item.getDescricao().equals("Arco")){
                temArco = true;
            }
        }

        if(temArco){
            for(Item item : this.inventario.getItens()){
                if (item.getDescricao().equals("Flecha") && item.getQuantidade() > 0){
                    temFlecha = true;
                    item.setQuantidade(item.getQuantidade() - 1);
                    break;
                }
            }
        }

        if (temEspada){
          dwarf.receberFlechada(12);
        } else if (temFlecha && !temEspada){
          dwarf.receberFlechada(8);
        }
    }

    public void atacarElfo(Elfo elfo){
      boolean temArco = false, temFlecha = false, temEspada = false;

      for(Item item : this.inventario.getItens()){
          if (item.getDescricao().equals("Espada")){
              temEspada = true;
              break;
          } else if (item.getDescricao().equals("Arco")){
              temArco = true;
          }
      }

      if(temArco){
          for(Item item : this.inventario.getItens()){
              if (item.getDescricao().equals("Flecha") && item.getQuantidade() > 0){
                  temFlecha = true;
                  item.setQuantidade(item.getQuantidade() - 1);
                  break;
              }
          }
      }

      if (temEspada){
        elfo.receberAtaqueOrc(12);
      } else if (temFlecha && !temEspada){
        elfo.receberAtaqueOrc(8);
      }
    }
}
