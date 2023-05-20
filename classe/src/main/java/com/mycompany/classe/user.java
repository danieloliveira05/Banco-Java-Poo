package com.mycompany.classe;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class user {

    Scanner sc = new Scanner(System.in);

    //atributos da classe
    private String nome;
    private String cpf;
    private String cel;
    private String id;
    private double saldo;

    //construtor
    public user(String nome, String cpf, String id, String cel, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
        this.cel = cel;
        this.saldo = saldo;
    }

    //metodos get/set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    
    public String toString() {
        // Retorna as informações do usuário em forma de escrita
        return """
               
               Nome: """ + this.nome + "\n" + "Cpf: " + this.cpf + "\n" + "id: " + this.id + "\n" + "celular: " + this.cel + "\n" + "saldo: " + this.saldo + "\n";
    }

    //metodos da classe
    public boolean addSaldo(ArrayList<user> listaUser) {
        double aux = 0;
        int i = 0;
        String auxid;
        boolean bool;
        // Solicita ao usuário que informe o ID do usuário que deseja encontrar
        auxid = JOptionPane.showInputDialog(null, "Informe o Id do usuario que deseja encontrar: ", "Debito", JOptionPane.QUESTION_MESSAGE);
        // Percorre a lista de usuários para verificar se algum usuario com o mesmo id informado
        for (i = 0; i < listaUser.size(); i++) {
            //uma variavel booleana recebe true se o id for igual a algum id cadastrado
            bool = listaUser.get(i).getId().equals(auxid);
            //se for verdadeiro pede ao usuario que informe quanto deseja depositar para o usuario informado
            if (bool == true) {
                aux = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe quanto deseja depositar: ", "Debito", JOptionPane.QUESTION_MESSAGE));
                listaUser.get(i).setSaldo(listaUser.get(i).getSaldo() + aux);
                return true;
            }
        }
        //se o id nao for igual a de algum usuario cadastrado não cai no primeiro if
        JOptionPane.showMessageDialog(null, "Usuario não encontrado", "Deposito", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean subSaldo(ArrayList<user> listaUser) {
        double aux = 0;
        int i = 0;
        String auxid;
        boolean bool;
        // Solicita ao usuário que informe o ID do usuário que deseja encontrar
        auxid = JOptionPane.showInputDialog(null, "Informe o Id do usuario que deseja encontrar: ", "Debito", JOptionPane.QUESTION_MESSAGE);
        //verifica se há algum usuario com o id informado
        for (i = 0; i < listaUser.size(); i++) {
            bool = listaUser.get(i).getId().equals(auxid);
            //se for verdadeiro pede ao usuario que informe quanto deseja sacar do usuario informado 
            if (bool == true) {
                aux = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe quanto deseja retirar: ", "Debito", JOptionPane.QUESTION_MESSAGE));
                //verifica se a quantidade que foi informada é maior que a que o usuario possui, se for não realiza a ação
                if (listaUser.get(i).getSaldo() < aux) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                    return false;
                }
                //se for menor ou igual realiza a ação
                if (listaUser.get(i).getSaldo() >= aux) {
                    listaUser.get(i).setSaldo(listaUser.get(i).getSaldo() - aux);
                    return true;
                }
            }
        }
        //se nao encontrar o usuario retorna falso e escreve uma mensagem
        JOptionPane.showMessageDialog(null, "Usuario não encontrado", "Saque", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean deleteUser(ArrayList<user> listaUser) {
        String aux;
        // Solicita ao usuário que informe o ID do usuário que deseja encontrar para deletar
        aux = JOptionPane.showInputDialog(null, "Informe o id do usuario que deseja deletar", "Delete", JOptionPane.QUESTION_MESSAGE);
        //realiza um for para verifica se há algum usuario com o id informado
        for (user obj : listaUser) {
            //se houver remove o usuario com este id, em seguida mostra uma mensagem de usuario removido
            if (obj.getId().equals(aux)) {
                listaUser.remove(obj);
                JOptionPane.showMessageDialog(null, "Usuario removido", "Delete", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        //se nao encontrar o usuario retorna falso e escreve uma mensagem
        JOptionPane.showMessageDialog(null, "Usuario nao encontrado", "Delete", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    public boolean atualizaUser(ArrayList<user> listaUser) {
        String auxid, aux;
        int i = 0;
        boolean bool = false;
        // Solicita ao usuário que informe o ID do usuário que deseja encontrar
        auxid = JOptionPane.showInputDialog(null, "Informe o id do usuario que deseja atualizar", "Alterar", JOptionPane.QUESTION_MESSAGE);
        //verifica se há algum usuario com o mesmo id informado
        for (i = 0; i < listaUser.size(); i++) {
            bool = listaUser.get(i).getId().equals(auxid);
            //se for verdadeiro pede para o usuario informar o novo numero de celular do usuario selecionado
            if (bool == true) {
                aux = JOptionPane.showInputDialog(null, "Informe o novo numero de celular", "Alterar", JOptionPane.QUESTION_MESSAGE);
                listaUser.get(i).setCel(aux);
                return true;
            }
        }
        //se nao encontrar o usuario retorna falso e escreve uma mensagem
        JOptionPane.showMessageDialog(null, "Usuario não encontrado", "Alterar", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean showUser(ArrayList<user> listaUser) {
        String aux;
        int i = 0;
        boolean bool;
        // Solicita ao usuário que informe o ID do usuário que deseja encontrar
        aux = JOptionPane.showInputDialog(null, "Informe o Id do usuario que procuras", "Mostrar usuario", JOptionPane.QUESTION_MESSAGE);
        //verifica se há algum usuario com o mesmo id informado
        for (i = 0; i < listaUser.size(); i++) {
            bool = listaUser.get(i).getId().equals(aux);
            //se for verdadeiro mostra os itens do usuario acionando a funcao toString
            if (bool == true) {
                JOptionPane.showMessageDialog(null, "" + listaUser.get(i).toString());
                return true;

            }
        }
        //se nao encontrar o usuario retorna falso e escreve uma mensagem
        JOptionPane.showMessageDialog(null, "Usuario nao encontrado", "Mostrar usuario", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
