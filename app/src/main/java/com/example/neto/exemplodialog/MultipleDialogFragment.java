package com.example.neto.exemplodialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class MultipleDialogFragment extends DialogFragment implements DialogInterface.OnMultiChoiceClickListener{

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        boolean [] checked = {true,false,true,false, true};

        return new AlertDialog.Builder(getActivity())
                .setMultiChoiceItems(R.array.linguagens,checked,this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        String [] linguagens = getActivity().getResources().getStringArray(R.array.linguagens);
        String linguagem = linguagens[which];

        if(isChecked){
            Toast.makeText(getActivity(),"Você escolheu a linguagem " + linguagem, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"Você não escolheu a linguagem " + linguagem, Toast.LENGTH_SHORT).show();
        }
    }
}
