package ufpb.dcx.AntonioSergio.ListaDeCompras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaListaTest {
    SistemaLista sistema;
    @BeforeEach
    public void setup(){
        this.sistema = new SistemaLista();
    }

    @Test
    public void adicionarERemover(){
        sistema.limparLista();
        assertEquals(0,sistema.produtos.size());
        sistema.adicionarProduto("Arroz",5.0,"Alimento",2);
        sistema.adicionarProduto("Feijão",6.0,"Alimento",3);
        assertEquals(2,sistema.produtos.size());
        sistema.removerProduto("Arroz");
        assertEquals(1,sistema.produtos.size());
        sistema.limparLista();
        assertEquals(0,sistema.produtos.size());
    }
}