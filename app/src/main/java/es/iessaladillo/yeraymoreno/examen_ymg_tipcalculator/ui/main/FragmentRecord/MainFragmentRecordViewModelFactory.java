package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.ui.main.FragmentRecord;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.data.model.Record;

class MainFragmentRecordViewModelFactory implements ViewModelProvider.Factory {

    MainFragmentRecordViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new MainFragmentRecordViewModel();
    }

    public ViewModelProvider.Factory get(Class<MainFragmentRecordViewModel> mainFragmentRecordViewModelClass) {
        return null;
    }
}
