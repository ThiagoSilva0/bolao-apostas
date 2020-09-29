
import br.com.bolao.bean.ImprimiApostaBean;
import br.com.bolao.dao.ApostaDao;
import br.com.bolao.dao.JogoDao;
import br.com.bolao.dao.RodadaDao;
import br.com.bolao.dao.UsuarioDao;
import br.com.bolao.domain.Aposta;
import br.com.bolao.domain.Jogo;
import br.com.bolao.domain.Rodada;
import br.com.bolao.domain.Usuario;
import br.com.bolao.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiag
 */
public class NewClass {

    public static void main(String[] args) {
//        RodadaDao rodadaDao = new RodadaDao();
//        Rodada rodada10 = rodadaDao.buscarPorCodigo(10l);
//        
//        Jogo jogo1 = new Jogo();
//        Jogo jogo2 = new Jogo();
//        Jogo jogo3 = new Jogo();
//        
//        jogo1.setDataJogo(new Date());
//        jogo1.setTimeCasa("Gremio");
//        jogo1.setTimeVisitante("Inter");
//        jogo1.setRodada(rodada10);
//        
//        jogo2.setDataJogo(new Date());
//        jogo2.setTimeCasa("Liverpool");
//        jogo2.setTimeVisitante("City");
//        jogo2.setRodada(rodada10);
//        
//        jogo3.setDataJogo(new Date());
//        jogo3.setTimeCasa("Sport");
//        jogo3.setTimeVisitante("Santa Cruz");
//        jogo3.setRodada(rodada10);
//        
//        JogoDao jogoDao = new JogoDao();
//        jogoDao.salvar(jogo3);
//        jogoDao.salvar(jogo2);
//        jogoDao.salvar(jogo1);
//        

//        ApostaDao apostaDao = new ApostaDao();
//        List<Aposta> apostas = apostaDao.listar();
//        
//        for (Aposta aposta : apostas) {
//            System.out.println(aposta.toString());
//        }
//        RodadaDao rodadaDao = new RodadaDao();
//        Rodada rodadaAberta = new Rodada();
//        List<Rodada> rodadas = rodadaDao.listar();
//
//        for (Rodada rodada : rodadas) {
//            if (rodada.getSituacao().equals("a")) {
//                rodadaAberta = rodada;
//            }
//        }
//
//        UsuarioDao usuarioDao = new UsuarioDao();
//        Usuario usuario = usuarioDao.buscarPorCodigo(1l);
//        
//       
//        JogoDao jogoDao = new JogoDao();
//        
//        Jogo jogo = jogoDao.buscarPorCodigo(1l);
//        
//        Jogo jogoN = new Jogo();
//        jogoN.setRodada(rodadaAberta);
//        jogoN.setTimeCasa(jogo.getTimeCasa());
//        jogoN.setTimeVisitante(jogo.getTimeVisitante());
//        jogoN.setGolCasa(1);
//        jogoN.setGolVisitante(2);
//        
//        jogoDao.salvar(jogoN);
//        Aposta aposta = new Aposta();
//
//    }
//        JogoDao jogoDao = new JogoDao();
//        List<Jogo> jogos = jogoDao.listar();
//        List<Jogo> jogoAberto = new  ArrayList();
//        
//        for (Jogo jogo : jogos) {
//            if(jogo.getRodada().getSituacao().equals("a")){
//                 jogoAberto.add(jogo);
//            }
//        }
//        for (Jogo jogo : jogoAberto) {
//            System.out.println(jogo.getTimeCasa()+" x "+jogo.getTimeVisitante());
//        }
//    }
//        Rodada rodada = new Rodada();
//        RodadaDao rodadaDao = new RodadaDao();
//        rodada.setDataJogo1(new Date());
//        rodada.setDataJogo2(new Date());
//        rodada.setDataJogo3(new Date());
//        rodada.setDataJogo4(new Date());
//        
//        rodada.setData_criacao(new Date());
//        rodada.setData_encerramento(new Date());
//        
//        rodada.setJogo1Casa("França ");
//        rodada.setJogo1Visitante("Brasil");
//
//        rodada.setJogo2Casa("Portugal");
//        rodada.setJogo2Visitante("Grecia");
//
//        rodada.setJogo3Casa("Holanda");
//        rodada.setJogo3Visitante("Dinamarca");
//
//        rodada.setJogo4Casa("Nigeria");
//        rodada.setJogo4Visitante("Africa do sul");
//        
//        rodada.setPreco(2);
//        rodada.setPremio(1000);
//        rodada.setSituacao("a");
//        
//        rodadaDao.salvar(rodada);
//        RodadaDao rodadaDao = new RodadaDao();
//
//        Rodada rodada10 = rodadaDao.buscarPorCodigo(10l);
//        Rodada rodada15 = rodadaDao.buscarPorCodigo(15l);
//        
//
//        rodadaDao.excluir(rodada10);
//        rodadaDao.excluir(rodada15);
//       UsuarioDao usuarioDao = new UsuarioDao();
//       Usuario usuario = usuarioDao.autenticar("tf01", "12345");
//        System.out.println("Usuario "+usuario.toString());
//   UsuarioDao usuarioDao = new UsuarioDao();
//   Usuario usuario = usuarioDao.buscarPorCodigo(6);
//   
//   ApostaDao apostaDao = new ApostaDao();
//   List<Aposta> list = apostaDao.listar();
//   
//   List<Aposta> apostaDoUsuario = new ArrayList<>();
//   
//        for (Aposta aposta : list) {
//            if(aposta.getUsuario().getCodigo() == 1 && aposta.getRodada().getCodigo() == 19){
//            apostaDoUsuario.add(aposta);
//            }
//        }
//        
//        for (Aposta aposta : apostaDoUsuario) {
//            System.out.println(aposta.getCodigo());
//            
//            
//        }
//            String nome = "thiago";
//            String teste = "thiago";
//            
//            if(nome.equals(teste)){
////                System.out.println("igual");
//            
//            }
//            
//            if(new Date().compareTo(new Date()) == 0){
//                System.out.println("igual");
//            }
//                  ApostaDao apostaDao = new ApostaDao();
//                  Aposta aposta = new ApostaDao().buscarPorCodigo(37l);
//                  ImprimiApostaBean imprimiApostaBean = new ImprimiApostaBean();
//                  
//                  imprimiApostaBean.imprimir(aposta);
//        UsuarioDao usuarioDao = new UsuarioDao();
//        Usuario usuario = usuarioDao.buscarPorCodigo(1l);
//
//        RodadaDao rodadaDao = new RodadaDao();
//        Rodada rodada = rodadaDao.buscarPorCodigo(18l);
//
//        ApostaDao apostaDao = new ApostaDao();
//        List<Aposta> apostas = apostaDao.listar();
//
//        List<Aposta> apostasDaRodada = new ArrayList<>();
//        int cont = 0;
//        for (Aposta aposta : apostas) {
//
//            if (aposta.getUsuario().getCodigo() == usuario.getCodigo()
//                    && aposta.getRodada().getCodigo() == rodada.getCodigo()) {
//                apostasDaRodada.add(aposta);
//                cont++;
//            }
//        }
//        
//        for (Aposta aposta : apostasDaRodada) {
//            System.out.println(aposta.toString());
//        }
//        double bruto = cont * rodada.getPreco();
//        double comissao = ((bruto * 15)/100);
//             System.out.println("Total de apostas "+cont);
//             System.out.println("Bruto            "+bruto);
//             System.out.println("Comissão         "+comissao);
//             System.out.println("Liquido a pagar  "+(bruto - comissao));

                 UsuarioDao usuarioDao =  new UsuarioDao();
                 
                 Usuario usuario = usuarioDao.buscarPorLogin("tf01");
                 
                 System.out.println("Usuario "+usuario.getNome());
             
    }
}
