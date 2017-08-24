/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Conexao;
import database.Utilitarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Categoria;

/**
 *
 * @author Alunos
 */
public class CategoriaDAO {
    
    public int inserir(Categoria categoria){
        int codigoInserido = Utilitarios.NAO_FOI_POSSIVEL_INSERIR;
        String sql = "INSERT INTO categorias(nome, descricao)";
        sql += "\n VALUE(?,?)";
        try{
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescricao());
            ps.execute();
            ResultSet resultado = ps.getGeneratedKeys();
            if(resultado.next()){
                codigoInserido = resultado.getInt("1");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao inserir CategoriaDAO,",
                    JOptionPane.ERROR_MESSAGE);
        }finally{
            Conexao.desconectar();
        }
        return codigoInserido;
    }
    
    public int alterar(Categoria categoria){
        int codigoAlterado = Utilitarios.NAO_FOI_POSSIVEL_ALTERAR;
        
        String sql = "UPDATE categorias SET";
        sql += "\nnome = ?,";
        sql += "\ndescricao = ?,";
        sql += "\nWHERE id = ?";
        try{
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescricao());
            ps.setInt(3, categoria.getId());
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, sqle.getMessage(),"Erro ao tentar alterar CategoriaDAO",
                    JOptionPane.ERROR_MESSAGE);
        }finally{
            Conexao.desconectar();
        }
        
        
        return codigoAlterado;
    }
    
    public int excluir(Categoria categoria){
        int codigoExcluido = Utilitarios.NAO_FOI_POSSIVEL_EXCLUIR;
        return codigoExcluido;
    }
    
    public ArrayList<Categoria> retornarListaCategorias(){
        ArrayList<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT id, nome, descricao \nFROM categorias";
        
        try{
            Statement stmt = Conexao.conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDescricao(rs.getString("descricao"));
                c.setAtivo(rs.getBoolean("ativo"));
                categorias.add(c);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao retornar lista CategoriaDAO",
                    JOptionPane.ERROR_MESSAGE);
        }finally{
            Conexao.desconectar();
        }
        
        
        return categorias;
    }
    
    public Categoria buscarCategoriaPorId(int codigo){
        Categoria categoria = null;
        return categoria;
    }
    
    public Categoria buscarCategoriaPorNome(String nome){
        Categoria categoria = null;
        return categoria;
    }
    
    public ArrayList<Categoria> buscarCategoriasPorStatus(boolean status){
        ArrayList<Categoria> categorias = new ArrayList<>();
        return categorias;
    }
    
}
