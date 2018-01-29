package com.zhg.views.stickytitlerecyclerview;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView mRecyclerView;
    private FragmentManager mFragmentManager;
    private List<String> mLeftRvData = new ArrayList<>();
    private ClassRecyclerViewAdapter mClassRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.left_class_recyvler);
        initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        mClassRecyclerViewAdapter = new ClassRecyclerViewAdapter(this,mLeftRvData);
        mClassRecyclerViewAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mClassRecyclerViewAdapter);
        createFragment();
    }

    private void initData() {
        String[] leftClasses = getResources().getStringArray(R.array.left_class);
        mLeftRvData = Arrays.asList(leftClasses);
    }

    private void createFragment() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment,new DetailFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onItemClick(View itemView, int position) {
        Toast.makeText(this,"position = "+position , Toast.LENGTH_SHORT).show();
    }
}
