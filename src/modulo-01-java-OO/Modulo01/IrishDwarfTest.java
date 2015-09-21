import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void IrishDwarfNasceCom110DeVida() {
        IrishDwarf gimli = new IrishDwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void IrishDwarfNasceVivo() {
        IrishDwarf balin = new IrishDwarf();
        assertEquals(Status.VIVO, balin.getStatus());
    }

    @Test
    public void IrishDwarfNasceCom0DeExperiencia() {
        IrishDwarf balin = new IrishDwarf();
        assertEquals(0, balin.getExperiencia());
    }

    @Test
    public void IrishDwarfNasceComDataNascimentoPadrão() {
        IrishDwarf bofur = new IrishDwarf();
        DataTerceiraEra esperada = new DataTerceiraEra(1,1,1);
        DataTerceiraEra obtida = bofur.getDataNascimento();
        assertEquals(esperada, obtida);
    }

    @Test
    public void IrishDwarfNasceComNomeEDataDeNascimento() {
        DataTerceiraEra esperada = new DataTerceiraEra(12,11,1987);
        IrishDwarf bernardin = new IrishDwarf("Bernardin", new DataTerceiraEra(12, 11, 1987));
        assertEquals(esperada, bernardin.getDataNascimento());
        assertEquals("Bernardin", bernardin.getNome());
    }

    @Test
    public void IrishDwarfNasceComNome() {
        IrishDwarf oin = new IrishDwarf("Oin II");
        assertEquals("Oin II", oin.getNome());
    }

    @Test
    public void IrishDwarfRecebeFlechaEPerde10Vida() {
        // AAA
        // Arrange
        IrishDwarf gimli = new IrishDwarf();
        int vidaEsperada = 100;
        // Act
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void IrishDwarfRecebeFlecha11VezesEVidaÉ0() {
        IrishDwarf gimli = new IrishDwarf();
        int vidaEsperada = 0;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void IrishDwarfRecebeFlecha7VezesEVidaÉ40() {
        IrishDwarf gimli = new IrishDwarf();
        int vidaEsperada = 40;
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void IrishDwarfRecebeFlecha5VezesESobrevive() {
        IrishDwarf gimli = new IrishDwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(Status.VIVO, gimli.getStatus());
    }

    @Test
    public void IrishDwarfRecebeFlecha12VezesEMorre() {
        IrishDwarf gimli = new IrishDwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(Status.MORTO, gimli.getStatus());
    }

    @Test
    public void IrishDwarfRecebeFlecha13VezesEVidaFicaZerada() {
        IrishDwarf gimli = new IrishDwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(0, gimli.getVida());
    }

    @Test
    public void gerarNumeroAnoBissextoVidaEntre80e90() {
        // Arrange
        IrishDwarf uru = new IrishDwarf("Uru", new DataTerceiraEra(01, 01, 2016));
        uru.receberFlechada();
        uru.receberFlechada();
        uru.receberFlechada();
        // Act
        double resultado = uru.gerarNumero();
        // Assert
        assertEquals(-3333.0, resultado, 0.00001);
    }

    @Test
    public void gerarNumeroAnoNaoBissextoNomeSeixas() {
        // Arrange
        IrishDwarf seixas = new IrishDwarf("Seixas", new DataTerceiraEra(01, 01, 2015));
        // Act
        double resultado = seixas.gerarNumero();
        // Assert
        assertEquals(33.0, resultado, 0.00001);
    }

    @Test
    public void gerarNumeroSemEntrarNasCondicoes() {
        // Arrange
        IrishDwarf balin = new IrishDwarf();
        // Act
        double resultado = balin.gerarNumero();
        // Assert
        assertEquals(101.0, resultado, 0.00001);
    }

    @Test
    public void IrishDwarfRecebeFlechaComNumeroSorteNegativo() {
        // Arrange
        IrishDwarf IrishDwarf = new IrishDwarf("Gimli", new DataTerceiraEra(1,1,2000));
        IrishDwarf.receberFlechada();
        IrishDwarf.receberFlechada();
        // Act
        IrishDwarf.receberFlechada();
        // Assert
        assertEquals(2, IrishDwarf.getExperiencia());
        assertEquals(90, IrishDwarf.getVida());   
    }

    @Test
    public void IrishDwarfReceberFlechadaComAnoNormalMeireles() {
        IrishDwarf meireles = new IrishDwarf("Meireles", new DataTerceiraEra(2, 3, 2015));
        meireles.receberFlechada();
        assertEquals(0, meireles.getExperiencia());
        assertEquals(110, meireles.getVida());
    }

    @Test
    public void IrishDwarfReceberFlechadaNormal(){
        IrishDwarf IrishDwarf = new IrishDwarf();
        IrishDwarf.receberFlechada();
        assertEquals(100, IrishDwarf.getVida());
        assertEquals(0, IrishDwarf.getExperiencia());
    }

    @Test
    public void IrishDwarfTentarSorteComSorte() {
        IrishDwarf IrishDwarf = new IrishDwarf("Leprechaun sortudo", new DataTerceiraEra(1, 1, 2000));
        IrishDwarf.receberFlechada();
        IrishDwarf.receberFlechada();
        IrishDwarf.adicionarItem(new Item(3, "Lança"));
        IrishDwarf.adicionarItem(new Item(2, "Poção"));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(6003, "Lança"));
        esperado.adicionarItem(new Item(3002, "Poção"));
        
        IrishDwarf.tentarSorte();
        
        assertEquals(esperado, IrishDwarf.getInventario());
    }

    @Test
    public void IrishDwarfTentarSorteSemSorte() {
        IrishDwarf IrishDwarf = new IrishDwarf();
        IrishDwarf.adicionarItem(new Item(5, "Lança"));
        IrishDwarf.adicionarItem(new Item(25, "Poção"));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item(5, "Lança"));
        esperado.adicionarItem(new Item(25, "Poção"));
        
        IrishDwarf.tentarSorte();
        
        assertEquals(esperado, IrishDwarf.getInventario());
    }

}
