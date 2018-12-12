package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.ui.main.FragmentRecord;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.R;

public class MainFragmentRecord extends Fragment {
    public MainFragmentRecord(){}

    @SuppressWarnings("SameParameterValue")
    static MainFragmentRecord newInstance() {
        MainFragmentRecord mainFragmentRecord = new MainFragmentRecord();
        return mainFragmentRecord;
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

        MainFragmentRecordViewModel viewModel = ViewModelProviders.of(this,
                new MainFragmentRecordViewModelFactory().get(
                MainFragmentRecordViewModel.class);
        setupViews(getView());
    }

    private void setupViews(View view) {

    }
}
