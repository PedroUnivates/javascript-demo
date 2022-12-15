/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ferramentas.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Servico;

/**
 *
 * @author jonas
 */
public class ServicoController {

         
    public Servico buscar(int cod) {
        try {
            Servico objServico = null;

            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = "";
            wSql = " SELECT * ";
            wSql += " FROM serviços ";
            wSql += " WHERE cod = ? ";

            try {
                System.out.println("Vai Executar Conexão em buscar Usuario");
                stmt = Conexao.con.prepareStatement(wSql);
                stmt.setInt(1, cod);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    objServico = new Servico();
                    objServico.setCod(rs.getInt("cod"));
                    objServico.setServico(rs.getString("servico"));
                    objServico.setPrestador(rs.getString("prestador"));
                    objServico.setValor(rs.getString("valor"));
                    objServico.setMedida(rs.getString("medida"));

                    return objServico;
                }

            } catch (SQLException ex) {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }

        return null;

    }
    
    public boolean excluir(int cod) {
        
        Conexao.abreConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = Conexao.con.prepareStatement("DELETE FROM serviços WHERE cod=?");
            stmt.setInt(1,cod);
            
            stmt.executeUpdate();
            
            return true;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(Conexao.con,stmt);
        }
    }

    public boolean verificaExistencia(Servico objServico) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = " SELECT * ";
            wSql += " FROM serviços ";
            wSql += " WHERE servico = ? ";
            if(objServico.getCod() > 0){
                wSql += " AND cod <> ? ";
            }

            System.out.println("Vai Executar Conexão em verificaExistencia Usuario");
            stmt = Conexao.con.prepareStatement(wSql);
            stmt.setString(1, objServico.getServico());   
            if(objServico.getCod() > 0){
                stmt.setInt(2, objServico.getCod());   
            }

            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
            return false;
        }

        return false;

    }

    public boolean incluir(Servico objServico) {

        try {

            Conexao.abreConexao();
            PreparedStatement stmt = null;

            stmt = Conexao.con.prepareStatement("INSERT INTO serviços (servico, prestador, valor, medida) VALUES(?,?,?,?)");
            stmt.setString(1, objServico.getServico());
            stmt.setString(2, objServico.getPrestador());
            stmt.setString(3, objServico.getValor());
            stmt.setString(4, objServico.getMedida());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(Conexao.con);
        }

    }

    public void preencherLista(JTable jtbServicos) {

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("cod");
        cabecalhos.add("servico");        
        cabecalhos.add("prestador");
        cabecalhos.add("valor");
        cabecalhos.add("medida");


        Conexao.abreConexao();
        ResultSet result = null;

        try {

            String sql = "";
            sql = "SELECT cod, servico, prestador, valor, medida ";
            sql += " FROM serviços ";
            sql += " ORDER BY servico ";

            result = Conexao.stmt.executeQuery(sql);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt("cod"));
                linha.add(result.getString("servico"));  
                linha.add(result.getString("prestador"));
                linha.add(result.getString("valor"));
                linha.add(result.getString("medida"));

                dadosTabela.add(linha);
            }

        } catch (SQLException e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbServicos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        });

        // permite seleção de apenas uma linha da tabela
        jtbServicos.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbServicos.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(80);
                    break;
                case 1:
                    column.setPreferredWidth(180);
                    break;
                case 2:
                    column.setPreferredWidth(150);
                    break;
            }
        }
        jtbServicos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
    }

    public boolean alterar(Servico objServico){
        
        Conexao.abreConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = Conexao.con.prepareStatement("UPDATE serviços SET servico=?, prestador=?, valor=?, medida=? WHERE cod=? ");
            stmt.setString(1, objServico.getServico());
            stmt.setString(2, objServico.getPrestador());
            stmt.setString(3, objServico.getValor());
            stmt.setString(4, objServico.getMedida());
            stmt.setInt(5, objServico.getCod());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(Conexao.con);
        }
        
    }
    
    /*public boolean excluir(){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM evento WHERE id=?");
            stmt.setInt(1, objEvento.getId());//1º?
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }*/
}

