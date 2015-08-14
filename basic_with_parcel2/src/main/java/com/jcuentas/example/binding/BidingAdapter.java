package com.jcuentas.example.binding;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.jcuentas.example.R;
import com.jcuentas.example.util.TextWatcherAdapter;

/**
 * Created by Jose Cuentas Turpo on 13/08/2015 - 02:37 PM.
 * E-mail: jcuentast@gmail.com
 */
public class BidingAdapter {

//    @BindingConversion
//    public static String convertBindableToString(ObservableField<String> bindableString) {
//        return bindableString.get();
//    }
//
//    @BindingConversion
//    public static boolean convertBindableToBoolean(ObservableBoolean bindableBoolean) {
//        return bindableBoolean.get();
//    }

    @BindingAdapter("app:visible")
    public static void setFadeVisible(final View view, ObservableBoolean visible) {
        view.animate().cancel();

        if (visible.get()) {
            view.setVisibility(View.VISIBLE);
            view.setAlpha(0);
            view.animate().alpha(1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    view.setAlpha(1);
                }
            });
        } else {
            view.animate().alpha(0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    view.setAlpha(1);
                    view.setVisibility(View.GONE);
                }
            });
        }
    }


    @BindingAdapter("app:bindings")
    public static void bindEditText(EditText editText, final ObservableField text){
        if (editText.getTag(R.id.binded)==null){
            editText.setTag(R.id.binded,true);
            editText.addTextChangedListener( new TextWatcherAdapter(){
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    super.onTextChanged(s, start, before, count);
//                    text.set(s.toString());
                    text.set(s.toString());
                    Log.d("TAG", s.toString());
                    Log.d("TAGs",""+ text.get());

                }
            });
        }
//        String newValue = ((ObservableField<String>)text).get();
        String newValue = String.valueOf(text.get());
//        String newValue = text;
        if (!editText.getText().toString().equals(newValue)) {
            editText.setText(newValue);
        }
    }
}
