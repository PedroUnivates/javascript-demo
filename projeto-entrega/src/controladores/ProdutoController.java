/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author pedro.azevedo1
 */
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
import modelos.Produto;

/**
 *
 * @author jonas
 */
public class ProdutoController {


    
    

    public Produto buscar(int cod) {
        try {
            Produto objProduto = null;

            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = "";
            wSql = " SELECT * ";
            wSql += " FROM produtos ";
            wSql += " WHERE cod = ? ";

            try {
                System.out.println("Vai Executar Conexão em buscar Produto");
                stmt = Conexao.con.prepareStatement(wSql);
                stmt.setInt(1, cod);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    objProduto = new Produto();
                    objProduto.setCod(rs.getInt("cod"));
                    objProduto.setProduto(rs.getString("produto"));
                    objProduto.setFornecedor(rs.getString("fornecedor"));


                    return objProduto;
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
            stmt = Conexao.con.prepareStatement("DELETE FROM produtos WHERE cod=?");
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

    public boolean verificaExistencia(Produto objProduto) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;
            PreparedStatement stmt;

            String wSql = " SELECT * ";
            wSql += " FROM produtos ";
            wSql += " WHERE produto = ? ";
            if(objProduto.getCod() > 0){
                wSql += " AND cod <> ? ";
            }

            System.out.println("Vai Executar Conexão em verificaExistencia Usuario");
            stmt = Conexao.con.prepareStatement(wSql);
            stmt.setString(1, objProduto.getProduto());   
            if(objProduto.getCod() > 0){
                stmt.setInt(2, objProduto.getCod());   
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

    public boolean incluir(Produto objProduto) {

        try {

            Conexao.abreConexao();
            PreparedStatement stmt = null;

            stmt = Conexao.con.prepareStatement("INSERT INTO produtos (produto, fornecedor) VALUES(?,?)");
            stmt.setString(1, objProduto.getProduto());
            stmt.setString(2, objProduto.getFornecedor());


            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(Conexao.con);
        }

    }

    public void preencherLista(JTable jtbProdutos) {

        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Cod");
        cabecalhos.add("Produto");      
        cabecalhos.add("Fornecedor"); 
        


        Conexao.abreConexao();
        ResultSet result = null;

        try {

            String sql = "";
            sql = "SELECT cod, produto, fornecedor";
            sql += " FROM produtos ";
            sql += " ORDER BY produto ";

            result = Conexao.stmt.executeQuery(sql);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt("cod"));
                linha.add(result.getString("produto"));  
                linha.add(result.getString("fornecedor"));
                

                dadosTabela.add(linha);
            }

        } catch (SQLException e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbProdutos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        });

        // permite seleção de apenas uma linha da tabela
        jtbProdutos.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbProdutos.getColumnModel().getColumn(i);
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
        jtbProdutos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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

    public boolean alterar(Produto objProduto){
        
        Conexao.abreConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = Conexao.con.prepareStatement("UPDATE produtos SET produto=?, fornecedor=? WHERE cod=? ");
            stmt.setString(1, objProduto.getProduto());
            stmt.setString(2, objProduto.getFornecedor());
            stmt.setInt(3, objProduto.getCod());
            
            
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

