package Gartic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Font.PLAIN;

public class InterfaceJogador {
    private JFrame janela;
    private JPanel painel, painel2;
    private JLabel pontuacao, jogador1, jogador2, desenhe, labelareadesenho;
    private JTextField rodada;
    private static JTextField tempo;
    private JTextField p1;
    private JTextField p2;
    private JTextField desenho;
    private JTextField escreva;
    private JTextArea respostas;
    private JMenuBar menu;
    private JMenuBar barra = new JMenuBar();
    private JMenu conectar = new JMenu("Conectar");
    private JMenu limparTela = new JMenu("Limpar Tela");
    private JMenuItem concetarSe = new JMenuItem("Conectar-se");
    private JMenuItem ApagarDesenho = new JMenuItem("Apagar desenho");
    private Gartic gartic;
    
    public InterfaceJogador(Gartic gartic){
    	this.gartic = gartic;
    	montaTela();
    }
    private void montaTela() {
        preparaPainelPrincipal();
        preparaJlabels();
        mostraJanela();
    }

    private void preparaJlabels() {
        pontuacao = new JLabel("Pontuação");
        jogador1 = new JLabel("Jogador1");
        p1 = new JTextField();
        p2 = new JTextField();
        jogador2 = new JLabel("Jogador2");
        rodada = new JTextField("Rodada 1");
        tempo = new JTextField("tempo 50 seg");
        desenhe = new JLabel("Desenhe isto:");
        desenho = new JTextField();
        labelareadesenho = new JLabel("Area de desenho: ");
        escreva = new JTextField("Escreva sua suposição aqui: ");
        respostas = new JTextArea("Respostas:");

        escreva.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                escreva.setText("");
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}});


        pontuacao.setBounds(10, 10, 140, 30);
        jogador1.setBounds(10, 40, 120, 30);
        jogador2.setBounds(10, 70, 120, 30);
        rodada.setBounds(300, 10, 180, 30);
        tempo.setBounds(520, 10, 180, 30);
        p1.setBounds(100, 45, 80, 25);
        p2.setBounds(100, 70, 80, 25);
        desenhe.setBounds(10, 270, 200, 30);
        desenho.setBounds(10, 300, 200, 30);
        labelareadesenho.setBounds(400, 50, 200, 30);
        gartic.painel.setBounds(300,100,450,250);
        escreva.setBounds(300, 500, 400, 30);
        respostas.setBounds(300, 380, 400, 100);

        pontuacao.setFont(new Font("SansSerif", Font.BOLD, 24));
        jogador1.setFont(new Font("SansSerif", PLAIN, 18));
        jogador2.setFont(new Font("SansSerif", PLAIN, 18));
        rodada.setFont(new Font("SansSerif", PLAIN, 18));
        tempo.setFont(new Font("SansSerif", PLAIN, 18));
        p1.setFont(new Font("SansSerif", PLAIN, 18));
        p2.setFont(new Font("SansSerif", PLAIN, 18));
        desenhe.setFont(new Font("SansSerif", PLAIN, 18));
        desenho.setFont(new Font("SansSerif", PLAIN, 18));
        labelareadesenho.setFont(new Font("SansSerif", PLAIN, 18));
        escreva.setFont(new Font("SansSerif", PLAIN, 18));
        respostas.setFont(new Font("SansSerif", PLAIN, 12));
        gartic.painel.setBackground(Color.white);
        
        painel.add(pontuacao);
        painel.add(jogador1);
        painel.add(jogador2);
        painel.add(rodada);
        painel.add(tempo);
        painel.add(p1);
        painel.add(p2);
        painel.add(desenhe);
        painel.add(desenho);
        painel.add(labelareadesenho);
        painel.add(escreva);
        painel.add(respostas);
        painel.add(gartic.painel);
        painel.setBackground(Color.BLUE);
    }

    private void preparaPainelPrincipal() {
        painel = new JPanel();
        painel.setLayout(null);
        painel.setPreferredSize(new Dimension(800, 570));
        painel.setVisible(true);

    }

    private void mostraJanela() {
        janela = new JFrame("Gartic");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(painel);
        janela.setResizable(false);
        janela.pack();
        janela.validate();
        janela.setJMenuBar(barra);
        barra.add(conectar);
        barra.add(limparTela);
        conectar.add(concetarSe);
        limparTela.add(ApagarDesenho);
        janela.setVisible(true);
    }

}