package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.data.model.Record;

class MainFragmentViewModelFactory implements ViewModelProvider.Factory {

    private final Record record;

    MainFragmentViewModelFactory(Record record) {
        this.record = record;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new MainFragmentViewModel(record);
    }

}
