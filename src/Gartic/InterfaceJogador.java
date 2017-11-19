package Gartic;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import static java.awt.Font.PLAIN;

public class InterfaceJogador extends JFrame{
    protected JFrame janela;
    protected JPanel painel, painel2;
    protected JLabel pontuacao, jogadorLocal,oponente, desenhe, labelareadesenho ,labelAreaRespostas;
    protected JLabel rodada;
    protected JLabel tempo;
    protected JLabel pontuacaoJogadorLocal;
    protected JLabel pontuacaoOponente;
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
        jogadorLocal = new JLabel("jogadorLocal :");
        pontuacaoJogadorLocal = new JLabel("0");
        pontuacaoOponente = new JLabel("0");
        oponente = new JLabel("oponente :");
        rodada = new JLabel("Rodada 1");
        tempo = new JLabel("Tempo 50 seg");
        desenhe = new JLabel("Desenhe isto:");
        desenho = new JTextField();
        labelareadesenho = new JLabel("Area de desenho: ");
        escreva = new JTextField("Escreva sua suposição aqui: ");
        respostas = new JTextArea("");
        labelAreaRespostas = new JLabel("Respostas : ");
        
        escreva.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                escreva.setText("");
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}});


        pontuacao.setBounds(10, 10, 140, 30);
        jogadorLocal.setBounds(10, 40, 120, 30);
        oponente.setBounds(10, 70, 120, 30);
        rodada.setBounds(10, 140, 180, 30);
        tempo.setBounds(10, 170, 180, 30);
        pontuacaoJogadorLocal.setBounds(125, 45, 80, 25);
        pontuacaoOponente.setBounds(125, 70, 80, 25);
        desenhe.setBounds(10, 270, 200, 30);
        desenho.setBounds(10, 300, 200, 30);
        labelareadesenho.setBounds(300, 10, 200, 30);
        gartic.painel.setBounds(300,50,450,300);
        labelAreaRespostas.setBounds(300,360,100,15);
        escreva.setBounds(300, 500, 400, 30);
        enviar.setBounds(710, 490, 70, 40);
        respostas.setBounds(300, 380, 400, 100);

        pontuacao.setFont(new Font("SansSerif", Font.BOLD, 24));
        jogadorLocal.setFont(new Font("SansSerif", PLAIN, 18));
        oponente.setFont(new Font("SansSerif", PLAIN, 18));
        rodada.setFont(new Font("SansSerif",Font.BOLD,22));
        tempo.setFont(new Font("SansSerif", Font.BOLD, 18));
        pontuacaoJogadorLocal.setFont(new Font("SansSerif", PLAIN, 18));
        pontuacaoOponente.setFont(new Font("SansSerif", PLAIN, 18));
        desenhe.setFont(new Font("SansSerif", PLAIN, 18));
        desenho.setFont(new Font("SansSerif", PLAIN, 18));
        labelareadesenho.setFont(new Font("SansSerif", PLAIN, 18));
        escreva.setFont(new Font("SansSerif", PLAIN, 18));
        respostas.setFont(new Font("SansSerif", PLAIN, 12));
        gartic.painel.setBackground(Color.white);
        
        rodada.setForeground(Color.BLACK);
        tempo.setForeground(Color.BLACK);
        pontuacaoJogadorLocal.setForeground(Color.BLACK);
        pontuacaoOponente.setForeground(Color.BLACK);
        
        desenho.setEnabled(false);
        respostas.setEditable(false);
        
        painel.add(pontuacao);
        painel.add(labelAreaRespostas);
        painel.add(jogadorLocal);
        painel.add(oponente);
        painel.add(rodada);
        painel.add(tempo);
        painel.add(pontuacaoJogadorLocal);
        painel.add(pontuacaoOponente);
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