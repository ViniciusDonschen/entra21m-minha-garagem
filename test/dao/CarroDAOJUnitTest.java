/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import model.Carro;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class CarroDAOJUnitTest {
    
    @Test
    public void inserir(){
        Carro gol = new Carro();
        gol.setNome("Gol");
        gol.setPlaca("FLA-2017");
        gol.setPotencia(100);
        gol.setQuantidadeBatidas((byte)0);
        gol.setQuantidadePortas((byte)4);
        gol.setCor("vermelho");
        gol.setDataCompra(new Date(2017,8,4));
        gol.setAnoFabricacao((short)2017);
        gol.setAnoLancamento((short)2017);
        gol.setChassi("5151874");
        gol.setDescricao("jadhjasdhudf sdhfsudhfusdhhg uahdushdfsdh");
        gol.setEstaFuncional(false);
        gol.setFabricante("VW");
        gol.setPermitidaCirculacao(true);
        gol.setQuilometragem(15887f);
        gol.setTipoPneu((short)17);
        gol.setRenavan(198745);
        
        CarroDAO dao = new CarroDAO();
        dao.truncate();
        int codigo = dao.inserir(gol);
        assertEquals(codigo, 1);
        
        gol.setId(codigo);
        
        Carro carroBuscado = dao.buscarPorId(codigo);
        validarIgualdadeCarro(gol, carroBuscado);
    }
    
    public void validarIgualdadeCarro(Carro carro,Carro outroCarro){
        assertEquals(carro.getId(), outroCarro.getId());
        assertEquals(carro.getAnoFabricacao(), outroCarro.getAnoFabricacao());
        assertEquals(carro.getAnoLancamento(), outroCarro.getAnoLancamento());
        assertEquals(carro.getChassi(), outroCarro.getChassi());
        assertEquals(carro.getCor(), outroCarro.getCor());
        assertEquals(carro.getDataCompra(), outroCarro.getDataCompra());
        assertEquals(carro.getDescricao(), outroCarro.getDescricao());
        assertEquals(carro.getFabricante(), outroCarro.getFabricante());
        assertEquals(carro.getNome(), outroCarro.getNome());
        assertEquals(carro.getPlaca(), outroCarro.getPlaca());
        assertEquals(carro.getPotencia(), outroCarro.getPotencia(),0);
        assertEquals(carro.getQuantidadeBatidas(), outroCarro.getQuantidadeBatidas());
        assertEquals(carro.getQuantidadeBatidas(), outroCarro.getQuantidadePortas());
        assertEquals(carro.getQuilometragem(), outroCarro.getQuilometragem(),0);
        assertEquals(carro.getRenavan(), outroCarro.getRenavan());
        assertEquals(carro.getTipoPneu(), outroCarro.getTipoPneu());
        assertEquals(carro.isEstaFuncional(), outroCarro.isEstaFuncional());
        assertEquals(carro.isPermitidaCirculacao(), outroCarro.isPermitidaCirculacao());
    }
    
    @Test
    public void excluir(){
        Carro gol = new Carro();
        gol.setNome("Gol");
        gol.setPlaca("FLA-2017");
        gol.setPotencia(100);
        gol.setQuantidadeBatidas((byte) 0);
        gol.setQuantidadePortas((byte) 4);
        gol.setCor("vermelho");
        gol.setDataCompra(new Date(2017, 8, 4));
        gol.setAnoFabricacao((short) 2017);
        gol.setAnoLancamento((short) 2017);
        gol.setChassi("5151874");
        gol.setDescricao("jadhjasdhudf sdhfsudhfusdhhg uahdushdfsdh");
        gol.setEstaFuncional(false);
        gol.setFabricante("VW");
        gol.setPermitidaCirculacao(true);
        gol.setQuilometragem(15887f);
        gol.setTipoPneu((short) 17);
        gol.setRenavan(198745);
        CarroDAO dao = new CarroDAO();
        int codigo = dao.inserir(gol);
        
        dao.truncate();
      //  dao.excluir(codigo);
        
        Carro carroBuscado = dao.buscarPorId(codigo);
        assertNull(carroBuscado);
    }
    
    
    @Test
    public void alterar(){
    Carro gol = new Carro();
        gol.setNome("palio");
        gol.setPlaca("PLA-2017");
        gol.setPotencia(100);
        gol.setQuantidadeBatidas((byte)0);
        gol.setQuantidadePortas((byte)4);
        gol.setCor("rosa");
        gol.setDataCompra(new Date(2017,8,4));
        gol.setAnoFabricacao((short)2017);
        gol.setAnoLancamento((short)2017);
        gol.setChassi("55435874");
        gol.setDescricao("jdf sdhdhhg uahdusdh");
        gol.setEstaFuncional(false);
        gol.setFabricante("VuW");
        gol.setPermitidaCirculacao(true);
        gol.setQuilometragem(15887f);
        gol.setTipoPneu((short)17);
        gol.setRenavan(295745);
        
        CarroDAO dao = new CarroDAO();
        dao.truncate();
        int codigo = dao.inserir(gol);
        gol.setId(codigo);
        
        gol.setNome("palio");
        gol.setPlaca("PLA-2017");
        gol.setPotencia(100);
        gol.setQuantidadeBatidas((byte)0);
        gol.setQuantidadePortas((byte)4);
        gol.setCor("rosa");
        gol.setDataCompra(new Date(2017,8,4));
        gol.setAnoFabricacao((short)2017);
        gol.setAnoLancamento((short)2017);
        gol.setChassi("55435874");
        gol.setDescricao("jdf sdhdhhg uahdusdh");
        gol.setEstaFuncional(false);
        gol.setFabricante("VuW");
        gol.setPermitidaCirculacao(true);
        gol.setQuilometragem(15887f);
        gol.setTipoPneu((short)17);
        gol.setRenavan(295745);
        
        Carro carroModificado = dao.buscarPorId(gol.getId());
        validarIgualdadeCarro(gol, carroModificado);
        
    }
}
