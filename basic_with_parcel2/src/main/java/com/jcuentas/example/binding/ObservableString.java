package com.jcuentas.example.binding;

import android.databinding.BaseObservable;

/**
 * Created by Jose Cuentas Turpo on 17/08/2015 - 04:04 PM.
 * E-mail: jcuentast@gmail.com
 */
public class ObservableString extends BaseObservable {
    private String mValue;

    public String get() {
        return mValue != null ? mValue : "";
    }

    public void set(String value) {
        if (!Objects.equals(mValue, value)) {
            mValue = value;
            notifyChange();
        }
    }
    public boolean isEmpty() {
        return mValue == null || mValue.isEmpty();
    }
}
