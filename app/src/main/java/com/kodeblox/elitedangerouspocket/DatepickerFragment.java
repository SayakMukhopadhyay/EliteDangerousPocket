package com.kodeblox.elitedangerouspocket;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DatepickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private String callingActivity;
    final private int future = 1286;
    private Calendar maxDate;
    private Calendar current;
    private Calendar minDate;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year;
        int month;
        int day;

        current = Calendar.getInstance();

        Bundle arguments = getArguments();

        current = Calendar.getInstance();
        current.setTimeInMillis(arguments.getLong("shownDate"));

        year = current.get(Calendar.YEAR);
        month = current.get(Calendar.MONTH);
        day = current.get(Calendar.DAY_OF_MONTH);

        callingActivity = arguments.getString("callingActivity");
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);

        maxDate = Calendar.getInstance();
        maxDate.set(Calendar.YEAR, maxDate.get(Calendar.YEAR) + future);
        maxDate.set(Calendar.HOUR_OF_DAY, 23);
        maxDate.set(Calendar.MINUTE, 59);
        maxDate.set(Calendar.SECOND, 59);
        maxDate.set(Calendar.MILLISECOND, 999);

        minDate = Calendar.getInstance();
        minDate.clear();
        minDate.set(3301, Calendar.JANUARY, 6);

        datePickerDialog.getDatePicker().setMaxDate(maxDate.getTimeInMillis());
        datePickerDialog.getDatePicker().setMinDate(minDate.getTimeInMillis());

        return datePickerDialog;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        switch (callingActivity) {
            case "GalnetActivity":
                ((GalnetActivity) getActivity()).dateSet(year, month, day);
                break;
            default:
                Toast.makeText(getContext(), "Date Set", Toast.LENGTH_SHORT).show();
        }
    }
}
