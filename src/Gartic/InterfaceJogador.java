package Gartic;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import static java.awt.Font.PLAIN;

public class InterfaceJogador extends JFrame{
    protected JFrame janela;
    protected JPanel painel, painel2;
    protected JLabel pontuacao, jogador1, jogador2, desenhe, labelareadesenho;
    protected JTextField rodada;
    protected static JTextField tempo;
    protected JTextField p1;
    protected JTextField p2;
    protected JTextField desenho;
    protected JTextField escreva;
    protected JTextArea respostas;
    protected JMenuBar menu;
    protected JMenuBar barra = new JMenuBar();
    protected JMenu opcoes = new JMenu("Opções");
    protected JMenu limparTela = new JMenu("Limpar Tela");
    protected JMenuItem conectarSe = new JMenuItem("Conectar-se");
    protected JMenuItem desconectar = new JMenuItem("Desconectar");
    protected JMenuItem ApagarDesenho = new JMenuItem("Apagar desenho");
    protected JMenuItem iniciarPartida = new JMenuItem("Iniciar Partida");
    protected Gartic gartic;
    protected JButton enviar = new JButton("Enviar");
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
        tempo = new JTextField("Tempo 50 seg");
        desenhe = new JLabel("Desenhe isto:");
        desenho = new JTextField();
        labelareadesenho = new JLabel("Area de desenho: ");
        escreva = new JTextField("Escreva sua suposição aqui: ");
        respostas = new JTextArea("");

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
        rodada.setBounds(10, 140, 180, 30);
        tempo.setBounds(10, 190, 180, 30);
        p1.setBounds(100, 45, 80, 25);
        p2.setBounds(100, 70, 80, 25);
        desenhe.setBounds(10, 270, 200, 30);
        desenho.setBounds(10, 300, 200, 30);
        labelareadesenho.setBounds(300, 10, 200, 30);
        gartic.painel.setBounds(300,50,450,300);
        escreva.setBounds(300, 500, 400, 30);
        enviar.setBounds(710, 490, 70, 40);
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
        
        respostas.setEditable(false);
        tempo.setEnabled(false);
        rodada.setEnabled(false);
        p1.setEnabled(false);
        p2.setEnabled(false);
        desenho.setEnabled(false);
        
        
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
        painel.add(enviar);
        painel.add(respostas);
        painel.add(gartic.painel);
        painel.setBackground(new Color(204,242,255));
    }

    private void preparaPainelPrincipal() {
        painel = new JPanel();
        painel.setLayout(null);
        painel.setPreferredSize(new Dimension(800, 570));
        painel.setVisible(true);

    }

    private void mostraJanela() {
        this.setTitle("Gartic");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(painel);
        this.setResizable(false);
        this.pack();
        this.validate();
        this.setJMenuBar(barra);
        barra.add(opcoes);
        barra.add(limparTela);
        opcoes.add(conectarSe);
        opcoes.add(desconectar);
        opcoes.add(iniciarPartida);
        limparTela.add(ApagarDesenho);
        this.setVisible(true);
    }
}