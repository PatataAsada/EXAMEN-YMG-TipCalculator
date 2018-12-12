package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.data;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.data.model.Record;

public class DatabaseRecord {
    public DatabaseRecord() {
        updateRecordsLiveData();
    }

    private ArrayList<Record> records = new ArrayList<>();
    private MutableLiveData<List<Record>> recordsLiveData = new MutableLiveData<>();

    public LiveData<List<Record>> getRecords() {
        return recordsLiveData;
    }

    public void deleteRecord(Record record) {
        records.remove(record);
        updateRecordsLiveData();
    }

    private void updateRecordsLiveData() {
        recordsLiveData.setValue(new ArrayList<>(records));
    }

    public void addRecord(Record newRecord) {
        records.add(newRecord);
        updateRecordsLiveData();
    }
}
