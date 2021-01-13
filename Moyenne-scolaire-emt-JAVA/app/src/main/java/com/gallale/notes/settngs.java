package com.gallale.notes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class settngs extends AppCompatActivity {

    Button btn_reset;
    NoteSQLiteOpenHelper noteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settngs);

        //Helper pour interagir avec la BD
        noteHelper = new NoteSQLiteOpenHelper(this);

        btn_reset = findViewById(R.id.btn_reset);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    private void reset() {
        new AlertDialog.Builder(this)
                .setTitle("Reinitialiser")
                .setMessage("Etes-vous sûr de vouloir tout réinitialiser ?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteDatabase("notes.db");
                        System.exit(0);
                    }
                })
                .setNegativeButton("Annuler", null)

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setIcon(R.drawable.ic_warning)
                .show();
    }

}