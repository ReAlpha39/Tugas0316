package com.example.tugas0316;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class DialogC {
    public Context context;
    public Activity activity;

    public DialogC(Context _context, Activity _activity) {
        this.context = _context;
        this.activity = _activity;
    }

    public void dialogConfirm(final String[] data) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Konfirmasi");
        alertDialog.setMessage("Apakah data yang anda masukkan sudah benar?");
        alertDialog.setIcon(R.mipmap.ic_launcher_round);
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "TIDAK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YA",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        dialogResult(data);
                    }
                });
        alertDialog.show();
    }

    public void dialogResult(String[] data) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Alert");
        alertDialog.setIcon(R.mipmap.ic_launcher_round);
        final View customLayout = activity.getLayoutInflater().inflate(R.layout.custom_alert_dialog, null);

        //declare
        TextView tFirstName = customLayout.findViewById(R.id.vND);
        TextView tLastName = customLayout.findViewById(R.id.vNB);
        TextView tTtl = customLayout.findViewById(R.id.vTTL);
        TextView tAlamat = customLayout.findViewById(R.id.vAL);
        TextView tJk = customLayout.findViewById(R.id.vJK);
        TextView tAgama = customLayout.findViewById(R.id.vAgama);
        TextView TTelp = customLayout.findViewById(R.id.vTelp);
        TextView tEmail = customLayout.findViewById(R.id.vEmail);

        Button tOK = customLayout.findViewById(R.id.bCustomDDaftar);
        Button tExit = customLayout.findViewById(R.id.bCustomDKembali);

        //addData
        tFirstName.setText(data[0]);
        tLastName.setText(data[1]);
        tTtl.setText(data[2] + ", "+ data[3]);
        tAlamat.setText(data[4]);
        tJk.setText(data[5]);
        tAgama.setText(data[6]);
        TTelp.setText(data[7]);
        tEmail.setText(data[8]);

        //buttonFuction
        tOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(activity.getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();
            }
        });

        tExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        alertDialog.setView(customLayout);

        alertDialog.show();
    }
}
