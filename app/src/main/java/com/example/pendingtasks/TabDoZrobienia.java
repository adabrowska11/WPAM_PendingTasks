package com.example.pendingtasks;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pendingtasks.dane.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabDoZrobienia extends Fragment {

    private ListView listViewTasks;
    private TextView textViewWords;
    private List<Task> tasks;
    private String userId;
    private DatabaseReference databaseTasks;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();


    public TabDoZrobienia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //userId =mAuth.getCurrentUser().toString();
        //databaseTasks = FirebaseDatabase.getInstance().getReference(Tasks.TASKS_PATH).child(userId);
       /* tasks = new ArrayList<>();
        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = tasks.get(position);
            }
        });*/
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_do_zrobienia, container, false);
    }

}
