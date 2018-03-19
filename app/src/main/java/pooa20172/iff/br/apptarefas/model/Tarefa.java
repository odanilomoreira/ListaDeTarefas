package pooa20172.iff.br.apptarefas.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by lglmo on 31/07/2017.
 */

public class Tarefa extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome;



    public Tarefa() {

    }

    public Tarefa(int id, String nome) {
        this.id = id;
        this.nome = nome;


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
