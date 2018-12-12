package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

class MainFragmentViewModelFactory implements ViewModelProvider.Factory {

    private final String message;

    MainFragmentViewModelFactory(String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new MainFragmentViewModel(message);
    }

}
