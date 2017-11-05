package helloworld;

import javax.ejb.Singleton;

/**
 *
 * @author pauloricardo
 */
@Singleton
public class GuardaNomeBean {

    private String nome = "temp";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
}
