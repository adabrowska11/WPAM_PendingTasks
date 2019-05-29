package com.example.pendingtasks.listy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pendingtasks.R;
import com.example.pendingtasks.dane.Task;

import java.util.List;

public class TaskList extends ArrayAdapter<Task> {

    private Activity context;
    private List<Task> tasks;

    public TaskList(Activity context, List<Task> tasks) {
        super(context, R.layout.task_list_layout, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.task_list_layout, null, true);
        TextView textViewNazwa = listViewItem.findViewById(R.id.textViewTaskNazwa);
        TextView textViewOpis = listViewItem.findViewById(R.id.textViewTaskOpis);
        TextView textViewData = listViewItem.findViewById(R.id.textViewTaskData);
        TextView textViewCzas = listViewItem.findViewById(R.id.textViewTaskCzas);

        Task task = tasks.get(position);
        textViewNazwa.setText(task.getNazwa());
        textViewOpis.setText(task.getOpis());
        if(textViewData != null && textViewCzas != null) {
            textViewData.setText(task.getData());
            textViewCzas.setText(task.getCzas());
        } else {

        }
        return listViewItem;
    }
}
