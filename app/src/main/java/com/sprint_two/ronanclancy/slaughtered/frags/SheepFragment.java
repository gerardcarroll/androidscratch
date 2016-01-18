package com.sprint_two.ronanclancy.slaughtered.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sprint_two.ronanclancy.slaughtered.R;

/**
 * SheepFragment
 * <p/>
 * Created by ronanclancy on 1/15/16.
 */
public class SheepFragment extends Fragment {

    private static final String TOOLBAR_SHEEP_FRAG_TITLE = "Sheep";

    public SheepFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_sheep, container, false);

        assert ((AppCompatActivity)getActivity()).getSupportActionBar() != null;
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(TOOLBAR_SHEEP_FRAG_TITLE);
        return view;
    }

}
