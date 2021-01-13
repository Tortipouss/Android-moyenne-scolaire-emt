package com.gallale.notes;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gallale.notes.adapters.NotesRecyclerAdapter;
import com.gallale.notes.models.Note;
import com.gallale.notes.util.VerticalSpacingItemDecorator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentDivtecInfModules} factory method to
 * create an instance of this fragment.
 */
public class fragmentDivtecInfModules extends Fragment implements
        OnBackPressed,
        NotesRecyclerAdapter.OnNoteListener,
        FloatingActionButton.OnClickListener {

    // ui components
    private RecyclerView mRecyclerView;
    private static View MainView;


    // vars
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNoteRecyclerAdapter;
    private Button btn_confirm;
    private Button btn_cancel;
    private EditText et_note;
    private boolean isAffEditOpen = false;
    private int moduleSelectionne;


    NoteSQLiteOpenHelper noteHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MainView = inflater.inflate(R.layout.fragment_divtec_inf_modules, container, false);

        mRecyclerView = MainView.findViewById(R.id.recyclerViewInf);

        noteHelper = new NoteSQLiteOpenHelper(getActivity());
        btn_confirm = MainView.findViewById(R.id.divtec_inf_mod_button_confirm);
        btn_cancel = MainView.findViewById(R.id.divtec_inf_mod_button_cancel);
        et_note = MainView.findViewById(R.id.divtec_inf_mod_editText);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (setNoteBD(et_note)) {
                    et_note.setText("");
                    affDefault();
                }
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                affDefault();
            }
        });


        if (mNotes.isEmpty()) {
            remplListeDepuisBD(mNotes);
        }

        initRecyclerView();

        ThemeApp();

        // Inflate the layout for this fragment
        return MainView;
    }


    private void insertNotes(String titre, Double value) {
        Note note = new Note();
        note.setNote(titre);
        note.setValue(value);
        mNotes.add(note);
        noteHelper.addNote(note);
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(0);
        mRecyclerView.addItemDecoration(itemDecorator);
        //new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);
        mNoteRecyclerAdapter = new NotesRecyclerAdapter(mNotes, this);
        mRecyclerView.setAdapter(mNoteRecyclerAdapter);
    }


    @Override
    public void onNoteClick(int position) {
        moduleSelectionne = position;
        affEditNote();
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * Passe en affichage Edit note
     */
    public void affEditNote() {
        et_note.setVisibility(View.VISIBLE);
        btn_cancel.setVisibility(View.VISIBLE);
        btn_confirm.setVisibility(View.VISIBLE);
        isAffEditOpen = true;

        mNotes.clear();

        initRecyclerView();
    }

    /**
     * Repasse en affichage par defaut
     */
    private void affDefault() {
        et_note.setVisibility(View.INVISIBLE);
        btn_cancel.setVisibility(View.INVISIBLE);
        btn_confirm.setVisibility(View.INVISIBLE);
        isAffEditOpen = false;
        mNotes.clear();
        moduleSelectionne = -1;
        remplListeDepuisBD(mNotes);
        initRecyclerView();
    }

    /**
     * Remplit la liste en paramettre par le nom des branches EPT de la BD
     *
     * @param listeNote La liste a remplir
     */
    private void remplListeDepuisBD(ArrayList<Note> listeNote) {
        listeNote.clear();
        listeNote.addAll(noteHelper.getAllNotesModules());
    }

    /**
     * Analyse si la saisie est correcte
     *
     * @param valeurSaisie La saisie a analyser
     * @return si la saisie est correcte
     */
    private boolean isSaisieNoteCorrecte(String valeurSaisie) {
        double valeurSaisieDouble;
        if (valeurSaisie.equals("")) {
            return true;
        }
        try {
            valeurSaisieDouble = Double.parseDouble(valeurSaisie);
        } catch (NumberFormatException e) {
            Toast invalidInpt = Toast.makeText(getActivity(), "Saisie incorrecte (utilisez un point comme séparateur)", Toast.LENGTH_SHORT);
            invalidInpt.show();
            return false;
        }

        if (valeurSaisieDouble <= 6.0 && valeurSaisieDouble >= 1) {
            return true;
        } else {
            Toast invalidInpt = Toast.makeText(getActivity(), "Saisie incorrecte (entre 1 et 6 uniquement)", Toast.LENGTH_SHORT);
            invalidInpt.show();
            return false;
        }
    }

    /**
     * Enregistre dans la BD la note entrée
     *
     * @param et l'édit text qui contien la note
     */
    private boolean setNoteBD(EditText et) {
        String valeurSaisie = et.getText().toString();
        Double valeurSaisieDouble;
        if (isSaisieNoteCorrecte(valeurSaisie)) {
            if (!valeurSaisie.equals("")) {
                valeurSaisieDouble = Double.valueOf(valeurSaisie);
            } else {
                valeurSaisieDouble = 0.5;
            }
            String nomBrancheComplet = "M";
            switch (moduleSelectionne) {
                case 0:
                    nomBrancheComplet = nomBrancheComplet.concat("I");
                    break;
                case 1:
                    nomBrancheComplet = nomBrancheComplet.concat("100");
                    break;
                case 2:
                    nomBrancheComplet = nomBrancheComplet.concat("101");
                    break;
                case 3:
                    nomBrancheComplet = nomBrancheComplet.concat("104");
                    break;
                case 4:
                    nomBrancheComplet = nomBrancheComplet.concat("105");
                    break;
                case 5:
                    nomBrancheComplet = nomBrancheComplet.concat("114");
                    break;
                case 6:
                    nomBrancheComplet = nomBrancheComplet.concat("115");
                    break;
                case 7:
                    nomBrancheComplet = nomBrancheComplet.concat("117");
                    break;
                case 8:
                    nomBrancheComplet = nomBrancheComplet.concat("122");
                    break;
                case 9:
                    nomBrancheComplet = nomBrancheComplet.concat("123");
                    break;
                case 10:
                    nomBrancheComplet = nomBrancheComplet.concat("124");
                    break;
                case 11:
                    nomBrancheComplet = nomBrancheComplet.concat("127");
                    break;
                case 12:
                    nomBrancheComplet = nomBrancheComplet.concat("129");
                    break;
                case 13:
                    nomBrancheComplet = nomBrancheComplet.concat("133");
                    break;
                case 14:
                    nomBrancheComplet = nomBrancheComplet.concat("140");
                    break;
                case 15:
                    nomBrancheComplet = nomBrancheComplet.concat("143");
                    break;
                case 16:
                    nomBrancheComplet = nomBrancheComplet.concat("145");
                    break;
                case 17:
                    nomBrancheComplet = nomBrancheComplet.concat("151");
                    break;
                case 18:
                    nomBrancheComplet = nomBrancheComplet.concat("153");
                    break;
                case 19:
                    nomBrancheComplet = nomBrancheComplet.concat("159");
                    break;
                case 20:
                    nomBrancheComplet = nomBrancheComplet.concat("182");
                    break;
                case 21:
                    nomBrancheComplet = nomBrancheComplet.concat("214");
                    break;
                case 22:
                    nomBrancheComplet = nomBrancheComplet.concat("226");
                    break;
                case 23:
                    nomBrancheComplet = nomBrancheComplet.concat("302");
                    break;
                case 24:
                    nomBrancheComplet = nomBrancheComplet.concat("304");
                    break;
                case 25:
                    nomBrancheComplet = nomBrancheComplet.concat("305");
                    break;
                case 26:
                    nomBrancheComplet = nomBrancheComplet.concat("306");
                    break;
                case 27:
                    nomBrancheComplet = nomBrancheComplet.concat("340");
                    break;
                case 28:
                    nomBrancheComplet = nomBrancheComplet.concat("403");
                    break;
                case 29:
                    nomBrancheComplet = nomBrancheComplet.concat("404");
                    break;
                case 30:
                    nomBrancheComplet = nomBrancheComplet.concat("431");
                    break;
                case 31:
                    nomBrancheComplet = nomBrancheComplet.concat("437");
                    break;
            }
            noteHelper.updateNoteValueByName(nomBrancheComplet, valeurSaisieDouble);
            return true;
        }
        return false;
    }

    /**
     * Change le thème de l'application
     */
    private void ThemeApp(){

        int nightModeFlags =
                getContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                mRecyclerView.setBackgroundColor(Color.BLACK);
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:
            case Configuration.UI_MODE_NIGHT_NO:
                mRecyclerView.setBackgroundColor(Color.WHITE);
                break;
        }
    }

    private void deleteNote(Note note) {
        mNotes.remove(note);
        mNoteRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        if (isAffEditOpen) {
            affDefault();
        }
    }

    //ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
    //  @Override
    // public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
    //   return false;
    //}

    //@Override
    //public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    //  deleteNote(mNotes.get(viewHolder.getAdapterPosition()));
    //}
    //};
}