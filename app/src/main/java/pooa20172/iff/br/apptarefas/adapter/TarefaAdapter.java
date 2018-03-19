package pooa20172.iff.br.apptarefas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pooa20172.iff.br.apptarefas.R;
import pooa20172.iff.br.apptarefas.model.Tarefa;

/**
 * Created by lglmo on 31/07/2017.
 */

public class TarefaAdapter extends RecyclerView.Adapter {

    private List<Tarefa> tarefas;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public TarefaAdapter(List<Tarefa> tarefas, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {

        this.tarefas = tarefas;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_tarefa, parent, false);
        TarefaViewHolder tarefaViewHolder = new TarefaViewHolder(view);
        return tarefaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        TarefaViewHolder holder = (TarefaViewHolder) viewHolder;

        Tarefa tarefa = tarefas.get(position) ;

        holder.nomeTarefa.setText(tarefa.getNome());




    }

    @Override
    public int getItemCount() {

        return tarefas.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class TarefaViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeTarefa;



        public TarefaViewHolder(View itemView) {
            super(itemView);
            nomeTarefa = (TextView) itemView.findViewById(R.id.nomeTarefa);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(tarefas.get(getLayoutPosition()));

                }
            });


        }
    }
}