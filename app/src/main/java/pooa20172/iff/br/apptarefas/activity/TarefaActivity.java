package pooa20172.iff.br.apptarefas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import io.realm.Realm;
import pooa20172.iff.br.apptarefas.R;
import pooa20172.iff.br.apptarefas.adapter.ClickRecyclerViewListener;
import pooa20172.iff.br.apptarefas.adapter.TarefaAdapter;
import pooa20172.iff.br.apptarefas.model.Tarefa;

public class TarefaActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TarefaActivity.this,TarefaDetalheActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }

    private List<Tarefa> getTarefas(){

        return (List)realm.where(Tarefa.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Tarefa tarefa = (Tarefa) object;
        Intent intent = new Intent(TarefaActivity.this,TarefaDetalheActivity.class);
        intent.putExtra("id", tarefa.getId());
        startActivity(intent);

    }

    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_Tarefa);

        recyclerView.setAdapter(new TarefaAdapter(getTarefas(),this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);


    }

    @Override
    public void finish(){
        realm.close();

    }



}
