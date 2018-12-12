package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.ui.main;

import androidx.lifecycle.ViewModel;
import es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.data.model.Record;

class MainFragmentViewModel extends ViewModel {

    private Record record;

    MainFragmentViewModel(Record record) {
        this.record = record;
    }

    public Record getMessage() {
        return record;
    }

    public void setMessage(Record record) {
        this.record = record;
    }

}
