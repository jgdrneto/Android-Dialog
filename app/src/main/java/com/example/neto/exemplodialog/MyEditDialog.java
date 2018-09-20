package com.example.neto.exemplodialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class MyEditDialog extends DialogFragment {

    private EditText editText;
    private OnTextListener listener;

    public static void show(FragmentManager fm, OnTextListener listener){
        MyEditDialog dialog = new MyEditDialog();
        dialog.listener = listener;
        dialog.show(fm,"TextDialog");
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Insira um texto aqui: ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(listener!=null) {
                    String text = editText.getText().toString();
                    listener.onSetText(text);
                }
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_my_edit, null);
        editText = view.findViewById(R.id.edt_texto);
        builder.setView(view);
        return builder.create();

    }

    public interface OnTextListener{
        public void onSetText(String text);
    }

}
