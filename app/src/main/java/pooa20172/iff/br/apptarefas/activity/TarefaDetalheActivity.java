package pooa20172.iff.br.apptarefas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import pooa20172.iff.br.apptarefas.R;
import pooa20172.iff.br.apptarefas.model.Tarefa;

public class TarefaDetalheActivity extends AppCompatActivity {
    EditText nome;
    Button btsalvar,btalterar, btdeletar;

    int id;
    Tarefa tarefa;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_detalhe);

        nome = (EditText) findViewById(R.id.ed_nome_tarefa);


        btsalvar = (Button) findViewById(R.id.bt_salvar_tarefa);
        btalterar = (Button) findViewById(R.id.bt_alterar_tarefa);
        btdeletar = (Button) findViewById(R.id.bt_deletar_tarefa);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            tarefa = realm.where(Tarefa.class).equalTo("id",id).findFirst();

            nome.setText(tarefa.getNome());


        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        tarefa.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Tarefa deletada",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Tarefa.class).max("id") !=null)
            proximoID = realm.where(Tarefa.class).max("id").intValue()+1;

        realm.beginTransaction();
        Tarefa tarefa = new Tarefa();
        tarefa.setId(proximoID);
        tarefa.setNome(nome.getText().toString());


        realm.copyToRealm(tarefa);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Tarefa Cadastrada",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();

        tarefa.setNome(nome.getText().toString());


        realm.copyToRealm(tarefa);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Tarefa Alterada",Toast.LENGTH_LONG).show();
        this.finish();

    }
}
