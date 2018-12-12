package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.R;
import es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.data.model.Record;

public class MainFragment extends Fragment {

    private static final String ARG_ITEM = "ARG_ITEM";

    private EditText txtBill;
    private EditText txtTipPercent;
    private EditText txtTip;
    private EditText txtTotal;
    private EditText txtDiners;
    private EditText txtPerDiner;
    private EditText txtRounded;

    private MainFragmentViewModel viewModel;

    public MainFragment() {
    }

    @SuppressWarnings("SameParameterValue")
    static MainFragment newInstance(Record record) {
        MainFragment mainFragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_ITEM, record);
        mainFragment.setArguments(arguments);
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_tipcalculator, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Objects.requireNonNull(getView());
        Objects.requireNonNull(getArguments());
        Objects.requireNonNull(getArguments().getString(ARG_ITEM));
        // Pass argument as initial value of viewModel's message.
        viewModel = ViewModelProviders.of(this,
                new MainFragmentViewModelFactory(getArguments().getString(ARG_ITEM))).get(
                MainFragmentViewModel.class);
        setupViews(getView());
    }

    private void setupViews(View view) {
        txtBill = ViewCompat.requireViewById(view, R.id.txtBill);
        txtTip = ViewCompat.requireViewById(view, R.id.txtTip);
        txtTipPercent = ViewCompat.requireViewById(view, R.id.txtTipPercent);
        txtTotal = ViewCompat.requireViewById(view, R.id.txtTotal);
        txtPerDiner = ViewCompat.requireViewById(view, R.id.txtPerDiner);
        txtDiners = ViewCompat.requireViewById(view, R.id.txtDiners);
        txtRounded = ViewCompat.requireViewById(view, R.id.txtRounded);

        txtTip.setEnabled(false);
        txtPerDiner.setEnabled(false);
        txtRounded.setEnabled(false);
        txtTotal.setEnabled(false);
    }

}

