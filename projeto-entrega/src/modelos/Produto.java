/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author pedro.azevedo1
 */
public class Produto {
    
    private int cod;
    private String produto;
    private String fornecedor;


    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
        public String getFornecedor() {
        return fornecedor;
    }
        
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
