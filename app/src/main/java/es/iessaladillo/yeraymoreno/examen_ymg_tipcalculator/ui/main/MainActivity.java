package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.R;
import es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.data.model.Record;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentByTag(MainFragment.class.getSimpleName())
                == null) {
            loadInitialFragment();
        }
    }
    private void loadInitialFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent,
            MainFragment.newInstance(new Record("","",0,10,1)), MainFragment.class.getSimpleName()).commit();
    }
}
