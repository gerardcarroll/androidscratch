package com.sprint_two.ronanclancy.slaughtered.frags;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sprint_two.ronanclancy.slaughtered.R;
import com.sprint_two.ronanclancy.slaughtered.adapters.SheepAdapter;
import com.sprint_two.ronanclancy.slaughtered.db.SQLiteHelper;
import com.sprint_two.ronanclancy.slaughtered.models.Sheep;

import java.util.List;

/**
 * MainFragment
 * <p/>
 * Created by ronanclancy on 1/15/16.
 */
public class MainFragment extends Fragment {

    private static final String TOOLBAR_HOME_FRAG_TITLE = "Home";

    private RecyclerView sheepsRecyclerView;

    private List<Sheep> sheeps;

    private SQLiteHelper db;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(TOOLBAR_HOME_FRAG_TITLE);

        db = new SQLiteHelper(getContext());

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        sheepsRecyclerView = (RecyclerView) view.findViewById(R.id.sheep_recycler_view);
        sheepsRecyclerView.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

        return view;
    }


    private void initializeData() {
        sheeps = db.getAllSheeps();
    }

    private void initializeAdapter() {
        SheepAdapter adapter = new SheepAdapter(sheeps, getContext());
        sheepsRecyclerView.setAdapter(adapter);
    }
}
