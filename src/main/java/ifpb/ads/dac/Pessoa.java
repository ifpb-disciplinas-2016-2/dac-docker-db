package ifpb.ads.dac;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 13/05/2016, 09:35:15
 */
public class Pessoa {

    private int id;
    private String nome;

     
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Pessoa(String nome) {
        this(0, nome);
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
