
public class Orc
{
    protected int vida;
    protected Inventario inventario;
    protected Status status;

    public Orc() {
        this.vida = 100;
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
