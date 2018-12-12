package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    private Button btnResetBill;
    private Button btnResetDiners;

    //TODO Dialog to input name of restaurant and save tip record.
    //TODO Make it save data inputed.
    //TODO On save and bill == 0 do nothing
    public MainFragment() {
    }

    @SuppressWarnings("SameParameterValue")
    public static MainFragment newInstance(Record record) {
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
        Objects.requireNonNull(getArguments().getParcelable(ARG_ITEM));

        MainFragmentViewModel viewModel = ViewModelProviders.of(this,
                new MainFragmentViewModelFactory(getArguments().getParcelable(ARG_ITEM))).get(
                MainFragmentViewModel.class);
        setupViews(getView());
    }

    private void setupViews(View view) {
        txtBill = ViewCompat.requireViewById(view, R.id.txtBill);
        txtTipPercent = ViewCompat.requireViewById(view, R.id.txtTipPercent);
        txtDiners = ViewCompat.requireViewById(view, R.id.txtDiners);

        txtTip = ViewCompat.requireViewById(view, R.id.txtTip);
        txtTotal = ViewCompat.requireViewById(view, R.id.txtTotal);
        txtPerDiner = ViewCompat.requireViewById(view, R.id.txtPerDiner);
        txtRounded = ViewCompat.requireViewById(view, R.id.txtRounded);

        btnResetBill = ViewCompat.requireViewById(view, R.id.btnResetBill);
        btnResetDiners = ViewCompat.requireViewById(view, R.id.btnResetDiners);

        setupButtons();

        textChangedListeners();
    }

    private void setupButtons() {
        btnResetBill.setOnClickListener(v -> resetBillCardView());
        btnResetDiners.setOnClickListener(v -> resetDiners());
    }

    private void resetDiners() {
        txtDiners.setText("1");
    }

    private void resetBillCardView() {
        txtTipPercent.setText("10");
        txtBill.setText("0");
    }

    private void textChangedListeners() {
        txtBill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    txtBill.setText("0");
                } else {
                    calculate();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        txtDiners.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    txtDiners.setText("1");
                } else {
                    calculate();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        txtTipPercent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    txtTipPercent.setText("10");
                } else {
                    calculate();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void calculate() {
        double tipPercent = Double.parseDouble(txtTipPercent.getText().toString()) / 100;
        double bill = Double.parseDouble(txtBill.getText().toString());
        double total = bill + (tipPercent * bill);
        txtTotal.setText(Double.toString(total));
        txtTip.setText(Double.toString(tipPercent * bill));

        double diners = Double.parseDouble(txtDiners.getText().toString());
        double perdiner = total / diners;
        double rounded = (perdiner > (int) perdiner) ? (int) perdiner + 1 : perdiner;
        txtPerDiner.setText(Double.toString(perdiner));
        txtRounded.setText(Double.toString(rounded));
    }

}

