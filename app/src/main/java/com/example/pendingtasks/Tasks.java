package com.example.pendingtasks;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Tasks extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    //View view_button_new_task = findViewById(R.id.add_Task1);
    //private String userId;
    //private DatabaseReference databaseTasks;
    //private List<Task> tasks;
    //private ListView listViewtasks;
    //private TextView textViewtasks;
    //public static final String USERS_PATH = "Users";
    //public static final String TASKS_PATH = "Tasks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_wykonane));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_do_zrobienia));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_zlecone));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.pager);
        final com.example.pendingtasks.PagerAdapter adapter = new com.example.pendingtasks.PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        //final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        showToast();

        //FloatingActionButton button = (FloatingActionButton) findViewById(R.id.add_Task1);
        //button.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View v) {
         //       Intent intent = new Intent(Tasks.this, NewTask.class);
           //     startActivity(intent);
         //   }
        //});

       //mAuth = FirebaseAuth.getInstance();
        //userId = mAuth.getCurrentUser().toString();
        //databaseTasks = FirebaseDatabase.getInstance().getReference(Tasks.TASKS_PATH).child(userId);


    }

    public void showToast() {
        Toast toast = Toast.makeText(this, "Witaj " + user.getEmail(), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void logOut() {
        mAuth.signOut();
        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void onClick(View view) {
        Intent intent = new Intent(Tasks.this, NewTask.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tasks, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_wylogowanie:
                logOut();
            case R.id.action_new_task:
                onClick();
        }
        return super.onOptionsItemSelected(item);
    }

    private void onClick() {
        finish();
        Intent intent = new Intent(getApplicationContext(), NewTask.class);
        startActivity(intent);
    }
}
