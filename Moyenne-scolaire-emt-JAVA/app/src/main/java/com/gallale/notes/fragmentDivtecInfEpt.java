package com.gallale.notes;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gallale.notes.adapters.NotesRecyclerAdapter;
import com.gallale.notes.models.Note;
import com.gallale.notes.util.VerticalSpacingItemDecorator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentDivtecInfEpt} factory method to
 * create an instance of this fragment.
 */
public class fragmentDivtecInfEpt extends Fragment implements
        OnBackPressed,
        NotesRecyclerAdapter.OnNoteListener,
        FloatingActionButton.OnClickListener {


    // ui components
    private static View MainView;
    private RecyclerView mRecyclerView;
    private RelativeLayout relativeLayout;
    private EditText et_note;
    private static RadioGroup rdgp_annees;
    private RadioButton rbtn1;
    private RadioButton rbtn2;
    private RadioButton rbtn3;
    private RadioButton rbtn4;
    private Button btn_confirm;
    private Button btn_cancel;
    private NotesRecyclerAdapter mNoteRecyclerAdapter;


    // vars
    private ArrayList<Note> mNotes = new ArrayList<>();
    private Boolean isAffSemOpen = false;
    private Boolean isAffEditOpen = false;
    private int semestreSelectionne = 0;
    private static int brancheSelectionne = 100;

    NoteSQLiteOpenHelper noteHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        MainView = inflater.inflate(R.layout.fragment_divtec_inf_ept, container, false);

        mRecyclerView = MainView.findViewById(R.id.divtec_inf_ept_recyclView);
        relativeLayout = MainView.findViewById(R.id.divtec_inf_ept_rlyt);
        et_note = MainView.findViewById(R.id.divtec_inf_ept_editText);
        rdgp_annees = MainView.findViewById(R.id.divtec_inf_ept_rbtgp);
        rbtn1 = MainView.findViewById(R.id.divtec_inf_rb_inf_an1);
        rbtn2 = MainView.findViewById(R.id.divtec_inf_rb_inf_an2);
        rbtn3 = MainView.findViewById(R.id.divtec_inf_rb_inf_an3);
        rbtn4 = MainView.findViewById(R.id.divtec_inf_rb_inf_an4);
        btn_cancel = MainView.findViewById(R.id.divtec_inf_ept_button_cancel);
        btn_confirm = MainView.findViewById(R.id.divtec_inf_ept_button_confirm);

        //Helper pour interagir avec la BD
        noteHelper = new NoteSQLiteOpenHelper(getActivity());

        if (mNotes.isEmpty()) {
            remplListeDepuisBD(mNotes);
        }

        setRadioButtonByDBValue();

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

        if (isAffSemOpen) {
            affSemestre();
        }

        //initialise la recycleView
        initRecyclerView();

        ThemeApp();

        return MainView;
    }


    /**
     * Met en place l'affichage en fonction de la variable mNotes
     */
    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(0);
        mRecyclerView.addItemDecoration(itemDecorator);
        mNoteRecyclerAdapter = new NotesRecyclerAdapter(mNotes, this);
        mRecyclerView.setAdapter(mNoteRecyclerAdapter);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onNoteClick(int position) {

        // Si on est pas en aff semestre
        if (!isAffSemOpen) {
            brancheSelectionne = position;
            affSemestre();
        } else {
            // Selon la note cliquée de l'aff sem on effectue les actions
            switch (position) {
                case 0:
                    affEditNote();
                    semestreSelectionne = 1;
                    break;
                case 1:
                    affEditNote();
                    semestreSelectionne = 2;
                    break;
                case 2:
                    affDefault();
                    semestreSelectionne = 0;
                    break;
            }
        }
    }

    /**
     * Passe en affichage choix du semestre
     */
    private void affSemestre() {
        // Cache la barre du choix des années
        rdgp_annees.setVisibility(View.INVISIBLE);
        et_note.setVisibility(View.INVISIBLE);
        btn_cancel.setVisibility(View.INVISIBLE);
        btn_confirm.setVisibility(View.INVISIBLE);

        mNotes.clear();
        mNotes.add(noteHelper.getNoteByName("Premier semestre"));
        mNotes.add(noteHelper.getNoteByName("Deuxième semestre"));

        Note note = new Note();
        note.setNote("Retour");
        note.setValue(0.5);
        mNotes.add(note);
        initRecyclerView();
        isAffSemOpen = true;
        isAffEditOpen = false;
    }

    /**
     * Passe en affichage Edit note
     */
    private void affEditNote() {
        et_note.setVisibility(View.VISIBLE);
        btn_cancel.setVisibility(View.VISIBLE);
        btn_confirm.setVisibility(View.VISIBLE);
        mNotes.clear();
        isAffEditOpen = true;
        isAffSemOpen = false;
        initRecyclerView();
    }

    /**
     * Repasse en affichage par defaut
     */
    private void affDefault() {
        et_note.setVisibility(View.INVISIBLE);
        btn_cancel.setVisibility(View.INVISIBLE);
        btn_confirm.setVisibility(View.INVISIBLE);
        brancheSelectionne = 100;
        mNotes.clear();
        remplListeDepuisBD(mNotes);
        isAffSemOpen = false;
        isAffEditOpen = false;
        rdgp_annees.setVisibility(View.VISIBLE);
        initRecyclerView();
    }

    /**
     * Remplit la liste en paramettre par le nom des branches EPT de la BD
     *
     * @param listeNote La liste a remplir
     */
    private void remplListeDepuisBD(ArrayList<Note> listeNote) {
        listeNote.clear();
        listeNote.add(noteHelper.getNoteByName("Atelier"));
        listeNote.add(noteHelper.getNoteByName("Math"));
        listeNote.add(noteHelper.getNoteByName("Anglais"));
        listeNote.add(noteHelper.getNoteByName("Economie"));
        listeNote.add(noteHelper.getNoteByName("Education Physique"));
        listeNote.add(noteHelper.getNoteByName("Science"));
    }

    /**
     * Retourne l'index (int) du bouton actuellement selectionné
     *
     * @return l'index (int) du bouton actuellement selectionné
     */
    private static String getRadioButtonActivated(View view) {
        int selectedButton = rdgp_annees.getCheckedRadioButtonId();
        RadioButton radioBtn = view.findViewById(selectedButton);
        return radioBtn.getText().toString();
    }

    /**
     * Memorise dans la BD le dernier bouton radio activé
     */
    private void radioButtonRememberRecall(View view) {
        switch (getRadioButtonActivated(view)) {
            case "Année 1":
                noteHelper.updateNoteValueByName("divtec_inf_rbgp_value", 1.0);
                break;
            case "Année 2":
                noteHelper.updateNoteValueByName("divtec_inf_rbgp_value", 2.0);
                break;
            case "Année 3":
                noteHelper.updateNoteValueByName("divtec_inf_rbgp_value", 3.0);
                break;
            case "Année 4":
                noteHelper.updateNoteValueByName("divtec_inf_rbgp_value", 4.0);
                break;
        }
    }

    /**
     * En fonction de la valeur enregistrée dans la BD
     * va setter le bouton radio
     */
    private void setRadioButtonByDBValue() {
        switch (String.valueOf(noteHelper.getNoteValueByName("divtec_inf_rbgp_value"))) {
            case "1.0":
                rdgp_annees.check(R.id.divtec_inf_rb_inf_an1);
                break;
            case "2.0":
                rdgp_annees.check(R.id.divtec_inf_rb_inf_an2);
                break;
            case "3.0":
                rdgp_annees.check(R.id.divtec_inf_rb_inf_an3);
                break;
            case "4.0":
                rdgp_annees.check(R.id.divtec_inf_rb_inf_an4);
                break;
        }
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
            String nomBrancheComplet = "divtec_inf_";
            String nomBranche = "";
            switch (brancheSelectionne) {
                case 0:
                    nomBranche = "atelier";
                    break;
                case 1:
                    nomBranche = "math";
                    break;
                case 2:
                    nomBranche = "anglais";
                    break;
                case 3:
                    nomBranche = "economie";
                    break;
                case 4:
                    nomBranche = "edu_physique";
                    break;
                case 5:
                    nomBranche = "science";
                    break;
            }

            nomBrancheComplet = nomBrancheComplet.concat(nomBranche + "_sem");

            if (semestreSelectionne == 1) {
                switch (getRadioButtonActivated(MainView)) {
                    case "Année 1":
                        nomBrancheComplet = nomBrancheComplet.concat("1");
                        break;
                    case "Année 2":
                        nomBrancheComplet = nomBrancheComplet.concat("3");
                        break;
                    case "Année 3":
                        nomBrancheComplet = nomBrancheComplet.concat("5");
                        break;
                    case "Année 4":
                        nomBrancheComplet = nomBrancheComplet.concat("7");
                        break;
                }
            } else if (semestreSelectionne == 2) {
                switch (getRadioButtonActivated(MainView)) {
                    case "Année 1":
                        nomBrancheComplet = nomBrancheComplet.concat("2");
                        break;
                    case "Année 2":
                        nomBrancheComplet = nomBrancheComplet.concat("4");
                        break;
                    case "Année 3":
                        nomBrancheComplet = nomBrancheComplet.concat("6");
                        break;
                    case "Année 4":
                        nomBrancheComplet = nomBrancheComplet.concat("8");
                        break;
                }
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
                relativeLayout.setBackgroundColor(Color.BLACK);
                rdgp_annees.setBackgroundColor(Color.BLACK);
                rbtn1.setTextColor(Color.WHITE);
                rbtn2.setTextColor(Color.WHITE);
                rbtn3.setTextColor(Color.WHITE);
                rbtn4.setTextColor(Color.WHITE);
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:
            case Configuration.UI_MODE_NIGHT_NO:
                relativeLayout.setBackgroundColor(Color.WHITE);
                rdgp_annees.setBackgroundColor(Color.WHITE);
                rbtn1.setTextColor(Color.BLACK);
                rbtn2.setTextColor(Color.BLACK);
                rbtn3.setTextColor(Color.BLACK);
                rbtn4.setTextColor(Color.BLACK);
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        radioButtonRememberRecall(MainView);
    }

    @Override
    public void onBackPressed() {
        if (isAffSemOpen) {
            affDefault();
        } else if (isAffEditOpen) {
            affSemestre();
        }
    }

}