package com.example.addviewbc;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.example.digitalcardscanner.R;

public class Utils {
    public static void displayErrorDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_error);
        builder.setMessage(R.string.dialog_error_message);
        builder.setPositiveButton(R.string.dialog_ok,
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        builder.create().show();
    }
}