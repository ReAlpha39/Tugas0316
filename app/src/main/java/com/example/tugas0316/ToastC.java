package com.example.tugas0316;

import android.content.Context;
import android.widget.Toast;

public class ToastC {
    public Context context;

    public ToastC(Context _context) {
        this.context = _context;
    }

    public void jkToast() {
        Toast.makeText(context.getApplicationContext(), "Jenis Kelamin harus diisi", Toast.LENGTH_LONG).show();
    }

    public void agamaToast() {
        Toast.makeText(context.getApplicationContext(), "Agama harus diisi", Toast.LENGTH_LONG).show();
    }
}
