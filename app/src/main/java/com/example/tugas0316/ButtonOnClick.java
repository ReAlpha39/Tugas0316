package com.example.tugas0316;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ButtonOnClick {
    
    private Activity activity;
    private Context context;
    
    public ButtonOnClick(Activity _activity, Context _context) {
        this.activity = _activity;
        this.context = _context;
    }

    private RadioGroup radioGroupJK;
    private RadioButton radioButtonJK;
    private RadioGridGroup radioGridGroupAgama;
    private RadioButton radioButtonAgama;

    private int selectedIdAgama;
    private int selectedIdJK;

    private EditText firstName;
    private EditText lastName;
    private EditText tempatL;
    private EditText tglL;
    private EditText alamat;
    private EditText telp;
    private EditText email;
    private EditText pass;
    private EditText rePass;

    private boolean emailPass;
    private boolean passPass;

    public void validateButton() {

        final ToastC toastC = new ToastC(this.context);
        final DialogC dialogC = new DialogC(this.context, this.activity);

        final Validator validator = new Validator();

        radioGroupJK = (RadioGroup) this.activity.findViewById(R.id.radioJK);
        radioGridGroupAgama = (RadioGridGroup) this.activity.findViewById(R.id.radioAgama);
        firstName = (EditText) this.activity.findViewById(R.id.editND);
        lastName = (EditText) this.activity.findViewById(R.id.editNB);
        tempatL = (EditText) this.activity.findViewById(R.id.editTL);
        tglL = (EditText) this.activity.findViewById(R.id.editTGL);
        alamat = (EditText) this.activity.findViewById(R.id.editAL);
        telp = (EditText) this.activity.findViewById(R.id.editTLP);
        email = (EditText) this.activity.findViewById(R.id.editEM);
        pass = (EditText) this.activity.findViewById(R.id.editPASS);
        rePass = (EditText) this.activity.findViewById(R.id.editRePASS);

        Button buttonDaftar = (Button) this.activity.findViewById(R.id.bDaftar);
        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //JK
                mRadioJK();
                if (radioButtonJK == null) {
                    toastC.jkToast();
                }

                //Agama
                mRadioAgama();
                if (radioButtonAgama == null) {
                    toastC.agamaToast();
                }

                //validate
                if (firstName.getText().toString().length() == 0) {
                    firstName.setError("Nama depan Harus diisi");
                } else {

                }
                if (lastName.getText().toString().length() == 0) {
                    lastName.setError("Nama belakang Harus diisi");
                } else {

                }
                if (tempatL.getText().toString().length() == 0) {
                    tempatL.setError("Tempat Lahir Harus diisi");
                } else {

                }
                if (tglL.getText().toString().length() == 0) {
                    tglL.setError("Tanggal Harus diisi");
                } else {

                }
                if (alamat.getText().toString().length() == 0) {
                    alamat.setError("Alamat Harus diisi");
                } else {

                }

                if (telp.getText().toString().length() == 0) {
                    telp.setError("No Telp Harus diisi");
                } else {

                }

                if(!validator.isValidEmail(email.getText().toString())) {
                    email.setError("Error");
                    emailPass = false;
                } else {
                    emailPass = true;
                }
                if (pass.getText().toString().length()<8) {
                    pass.setError("Password minimal 8 digit");
                    passPass = false;
                } else if (validator.passwordCharValidation(pass.getText().toString())) {
                    pass.setError("Password minimal memiliki Uppercase, Lowercase, Number, Symbol");
                    passPass = false;
                } else {
                    passPass = true;
                }
                String passT =   pass.getText().toString();
                String rePassT =  rePass.getText().toString();
                if (!passT.equals(rePassT)) {
                    rePass.setError("Password tidak sesuai");

                } else {

                }

                //validateAll
                if (!firstName.getText().toString().isEmpty() &&
                        !lastName.getText().toString().isEmpty() &&
                        !tempatL.getText().toString().isEmpty() &&
                        !tglL.getText().toString().isEmpty() &&
                        !alamat.getText().toString().isEmpty() &&
                        !telp.getText().toString().isEmpty() &&
                        emailPass &&
                        passPass &&
                        pass.getText().toString().equals(rePass.getText().toString()) &&
                        radioButtonJK != null &&
                        radioButtonAgama != null
                ){
                    String[] data = {
                            firstName.getText().toString(),
                            lastName.getText().toString(),
                            tempatL.getText().toString(),
                            tglL.getText().toString(),
                            alamat.getText().toString(),
                            radioButtonJK.getText().toString(),
                            radioButtonAgama.getText().toString(),
                            telp.getText().toString(),
                            email.getText().toString(),
                            pass.getText().toString(),
                            rePass.getText().toString()
                    };
                    dialogC.dialogConfirm(data);
                }
            }
        });
    }

    private void mRadioJK() {
        selectedIdJK = radioGroupJK.getCheckedRadioButtonId();
        radioButtonJK = (RadioButton) this.activity.findViewById(selectedIdJK);
    }

    private void mRadioAgama() {
        selectedIdAgama = radioGridGroupAgama.getCheckedCheckableImageButtonId();
        radioButtonAgama = (RadioButton) this.activity.findViewById(selectedIdAgama);
    }

    public void activityMainBackButton () {
        Button back = (Button) this.activity.findViewById(R.id.bKembali);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                System.exit(0);
            }
        });
    }
}
