package com.mycompany.classe;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Classe {

    public static void main(String[] args) {

        boolean bool = false;
        double saldo = 0;
        String nome = "", cpf = "", id = "", cel = "";
        int op = 0, c = 0;

        ArrayList<user> listaUser = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "Bem vindo ao banco DR");
        user obj = new user("", "", "", "", 0);
        menu:
        while (op != 7) {

            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha qual funçao deseja realizar\n1-Cadastro\n2-Mostrar usúario\n3-Deletar usuario\n4-Credito\n5-Debito\n6-Trocar celular\n7-Sair", "Banco DR", JOptionPane.QUESTION_MESSAGE));
            //switch case de opçoes para realizar no banco
            switch (op) {

                case 1 -> {
                    do {
                        nome = JOptionPane.showInputDialog("Informe o seu nome");
                        if (nome == null) {
                            continue menu;// Volta para o início do laço de repetição principal se o usuário clicar em cancelar
                        }
                        if ((nome.matches(".*\\d.*") || nome.isBlank())) {
                            JOptionPane.showMessageDialog(null, "O nome não pode conter numeros ou conter espaços vazios");
                        }
                        //verifica se o nome informado pelo usuario não possui numeros ou foi deixado em branco
                    } while (nome.matches(".*\\d.*") || nome.isBlank());

                    do {
                        cpf = JOptionPane.showInputDialog("Informe o seu cpf");
                        if (cpf == null) {
                            continue menu;// Volta para o início do laço de repetição principal se o usuário clicar em cancelar
                        }
                        if (!cpf.matches("\\d{11}")) {
                            JOptionPane.showMessageDialog(null, "O Cpf não pode conter letras ou ser menor que onze digitos");
                        }
                        //verifica se o que o usuario informou possui 11 caracteres e apenas números
                    } while (!cpf.matches("\\d{11}"));

                    do {
                        id = JOptionPane.showInputDialog("Informe o seu id");
                        if (id == null) {
                            continue menu;// Volta para o início do laço de repetição principal se o usuário clicar em cancelar
                        }
                        if (id.matches("\\D") || id.isBlank()) {
                            JOptionPane.showMessageDialog(null, "O Id não pode conter letras ou conter espaços vazios");
                        }
                        //verifica se o que o usuário informou possui letras ou foi deixado em branco
                    } while ((id.matches("\\D") || id.isBlank()));

                    cel = JOptionPane.showInputDialog("Informe o seu celular");
                    if (cel == null) {
                        continue menu;// Volta para o início do laço de repetição principal se o usuário clicar em cancelar
                    }
                    saldo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da sua conta"));
                    //prenchendo o usuario
                    obj = new user(nome, cpf, id, cel, saldo);
                    //adiciona no arrayList cada usuario criado
                    listaUser.add(obj);
                    //informa as informaçoes do usuario criado após ser criado
                    JOptionPane.showMessageDialog(null, "" + obj.toString());
                }

                case 2 -> {
                    //chama o método para mostra os usuários cadastrados
                    obj.showUser(listaUser);

                }
                case 3 -> {
                    //chama o método para deletar os usuários
                    obj.deleteUser(listaUser);

                }
                case 4 -> {
                    //chama o método para adicionar saldo ao usuário
                    obj.addSaldo(listaUser);

                }
                case 5 -> {
                    //chama o método para subtrair o saldo do usuário
                    obj.subSaldo(listaUser);

                }

                case 6 -> {
                    //chama o método para atualizar o celular do usuario
                    obj.atualizaUser(listaUser);

                }
            }
        }
    }
}
