package gerenciamento_hardware;

import javax.swing.JOptionPane;

// Telas de cadastro
import view.TelaLaboratorio;
import view.TelaMaquina;
import view.TelaPeca;
import view.TelaManutencao;

// Telas de listagem
import view.TelaListaMaquina;
import view.TelaListaPeca;
import view.TelaListaManutencao;

public class Gerenciamento_hardware {

    public static void main(String[] args) {
        abrirMenu();
    }
    
    public static void abrirMenu() {

        String opcao;

        do {
            opcao = JOptionPane.showInputDialog(
                    "GERENCIAMENTO DE HARDWARE\n\n"
                  + "1 - Cadastrar Laboratório\n"
                  + "2 - Cadastrar Máquina\n"
                  + "3 - Cadastrar Peça\n"
                  + "4 - Cadastrar Manutenção\n"
                  + "5 - Listar Máquinas\n"
                  + "6 - Listar Peças\n"
                  + "7 - Listar Manutenções\n"
                  + "0 - Sair\n\n"
                  + "Escolha uma opção:"
            );

            // Caso o usuário clique em Cancelar
            if (opcao == null) {
                break;
            }

            switch (opcao) {

                case "1":
                    new TelaLaboratorio().setVisible(true);
                    return;

                case "2":
                    new TelaMaquina().setVisible(true);
                    return;

                case "3":
                    new TelaPeca().setVisible(true);
                    return;

                case "4":
                    new TelaManutencao().setVisible(true);
                    return;

                case "5":
                    new TelaListaMaquina().setVisible(true);
                    return;

                case "6":
                    new TelaListaPeca().setVisible(true);
                    return;

                case "7":
                    new TelaListaManutencao().setVisible(true);
                    return;

                case "0":
                    JOptionPane.showMessageDialog(null, "Sistema encerrado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (!opcao.equals("0")); 
    }
}
