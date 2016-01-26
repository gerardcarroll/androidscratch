package com.sprint_two.ronanclancy.slaughtered.frags;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        dbHelper = new SQLiteHelper(getContext());

        View view = inflater.inflate(R.layout.fragment_sheep, container, false);

        Bundle extras = getArguments();
        final Sheep sheep = extras.getParcelable("sheep");

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle(sheep.name());

        ImageView imageView = (ImageView) view.findViewById(R.id.sheepProfilePic);
        imageView.setImageResource(sheep.photoId());

        TextView txtAge = (TextView) view.findViewById(R.id.txtAgeValue);
        txtAge.setText(sheep.age());

        TextView txtWeight = (TextView) view.findViewById(R.id.txtWeightValue);
        txtWeight.setText(sheep.weight());
        final TextView txtStatus = (TextView) view.findViewById(R.id.txtStatus);
        txtStatus.setText(sheep.alive() == 0 ? "Alive" : "Dead");

        final Button button = (Button) view.findViewById(R.id.button);
        button.setText("Slaughter " + sheep.name());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Really!!!!!!");
                builder.setMessage("Are you sure you want to slaughter " + sheep.name());
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.slaughterSheep(sheep.id());
                        txtStatus.setText("Dead");
                        button.setVisibility(View.GONE);
                        dialog.dismiss();
                        Snackbar.make(getView(), sheep.name() + " is no more :-(", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
