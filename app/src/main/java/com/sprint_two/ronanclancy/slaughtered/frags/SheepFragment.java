package com.sprint_two.ronanclancy.slaughtered.frags;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sprint_two.ronanclancy.slaughtered.R;
import com.sprint_two.ronanclancy.slaughtered.db.SQLiteHelper;
import com.sprint_two.ronanclancy.slaughtered.models.Sheep;

/**
 * SheepFragment
 * <p/>
 * Created by ronanclancy on 1/15/16.
 */
public class SheepFragment extends Fragment {
    SQLiteHelper dbHelper;

    public SheepFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper  = new SQLiteHelper(getContext());

        View view = inflater.inflate(R.layout.fragment_sheep, container, false);

        assert ((AppCompatActivity)getActivity()).getSupportActionBar() != null;

        Bundle extras = getArguments();
        Sheep sheep = extras.getParcelable("sheep");

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(sheep.getName());
        ImageView imageView = (ImageView) view.findViewById(R.id.sheepProfilePic);
        imageView.setImageResource(sheep.getPhotoId());

        TextView txtAge = (TextView) view.findViewById(R.id.txtAgeValue);
        txtAge.setText(sheep.getAge());
        return view;
    }

}
