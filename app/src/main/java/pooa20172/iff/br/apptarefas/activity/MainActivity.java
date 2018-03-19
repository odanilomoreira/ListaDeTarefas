package pooa20172.iff.br.apptarefas.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pooa20172.iff.br.apptarefas.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tarefaBT = (Button) findViewById(R.id.bt_tarefas);

        tarefaBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TarefaActivity.class);
                startActivity(intent);

            }
        });


    }
    private Context getContext(){
        return this;
    }

}
