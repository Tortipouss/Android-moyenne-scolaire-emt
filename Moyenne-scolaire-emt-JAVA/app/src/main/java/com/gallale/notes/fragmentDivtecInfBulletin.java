package com.gallale.notes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentDivtecInfBulletin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentDivtecInfBulletin extends Fragment {

    NoteSQLiteOpenHelper noteHelper;
    private View view;
    private ArrayList<TextView> arr_txtViMoy = new ArrayList<>();

    // Crée les textViews
    // region implements MATH
    private TextView moy_math_mi;
    private TextView moy_sem1_math;
    private TextView moy_sem2_math;
    private TextView moy_sem3_math;
    private TextView moy_sem4_math;
    private TextView moy_sem5_math;
    private TextView moy_sem6_math;
    private TextView moy_sem7_math;
    private TextView moy_sem8_math;
    private TextView moy_math_finale;

    // endregion implements
    // region implements Atelier
    private TextView moy_sem1_ate;
    private TextView moy_sem2_ate;
    private TextView moy_sem3_ate;
    private TextView moy_sem4_ate;
    private TextView moy_sem5_ate;
    private TextView moy_sem6_ate;
    private TextView moy_sem7_ate;
    private TextView moy_sem8_ate;

    // endregion implements
    // region implements ANGLAIS
    private TextView moy_sem1_anglais;
    private TextView moy_sem2_anglais;
    private TextView moy_sem3_anglais;
    private TextView moy_sem4_anglais;
    private TextView moy_sem5_anglais;
    private TextView moy_sem6_anglais;
    private TextView moy_sem7_anglais;
    private TextView moy_sem8_anglais;
    private TextView moy_anglais_finale;


    // endregion implements
    // region implements SCIENCE
    private TextView moy_sem1_science;
    private TextView moy_sem2_science;
    private TextView moy_sem3_science;
    private TextView moy_sem4_science;
    private TextView moy_sem5_science;
    private TextView moy_sem6_science;
    private TextView moy_sem7_science;
    private TextView moy_sem8_science;
    private TextView moy_science_finale;

    // endregion implements
    // region implements ECONOMIE
    private TextView moy_sem1_economie;
    private TextView moy_sem2_economie;
    private TextView moy_sem3_economie;
    private TextView moy_sem4_economie;
    private TextView moy_sem5_economie;
    private TextView moy_sem6_economie;
    private TextView moy_sem7_economie;
    private TextView moy_sem8_economie;
    private TextView moy_economie_finale;

    // endregion implements
    // region implements EDUCATION_PHYSIQUE
    private TextView moy_sem1_edu_physique;
    private TextView moy_sem2_edu_physique;
    private TextView moy_sem3_edu_physique;
    private TextView moy_sem4_edu_physique;
    private TextView moy_sem5_edu_physique;
    private TextView moy_sem6_edu_physique;
    private TextView moy_sem7_edu_physique;
    private TextView moy_sem8_edu_physique;
    private TextView moy_edu_physique_finale;
    // endregion implements
    //region implements societe
    private TextView moy_sem1_societe;
    private TextView moy_sem2_societe;
    private TextView moy_sem3_societe;
    private TextView moy_sem4_societe;
    private TextView moy_sem5_societe;
    private TextView moy_sem6_societe;
    private TextView moy_sem7_societe;
    private TextView moy_sem8_societe;
    private TextView moy_societe_finale;
    //endregion implements
    //region implements Langue et Comm
    private TextView moy_sem1_langueEtComm;
    private TextView moy_sem2_langueEtComm;
    private TextView moy_sem3_langueEtComm;
    private TextView moy_sem4_langueEtComm;
    private TextView moy_sem5_langueEtComm;
    private TextView moy_sem6_langueEtComm;
    private TextView moy_sem7_langueEtComm;
    private TextView moy_sem8_langueEtComm;
    private TextView moy_langueEtComm_finale;
    //endregion implements
    //region implements Moyennes totales
    private TextView moy_tot_tot;
    private TextView moy_tot_cg;
    private TextView moy_tot_ept;
    private TextView moy_tot_mod;
    private TextView moy_tot_mod_standard;
    private TextView moy_tot_mod_interEntreprise;
    private TextView moy_ate_finale;
    private TextView moy_ate_finale_doublon;


    //endregion
    //region implements MODULES
    private TextView TxtVi_M100;
    private TextView TxtVi_M101;
    private TextView TxtVi_M104;
    private TextView TxtVi_M105;
    private TextView TxtVi_M114;
    private TextView TxtVi_M115;
    private TextView TxtVi_M117;
    private TextView TxtVi_M122;
    private TextView TxtVi_M123;
    private TextView TxtVi_M124;
    private TextView TxtVi_M127;
    private TextView TxtVi_M129;
    private TextView TxtVi_M133;
    private TextView TxtVi_M140;
    private TextView TxtVi_M143;
    private TextView TxtVi_M145;
    private TextView TxtVi_M151;
    private TextView TxtVi_M153;
    private TextView TxtVi_M159;
    private TextView TxtVi_M182;
    private TextView TxtVi_M214;
    private TextView TxtVi_M226;
    private TextView TxtVi_M302;
    private TextView TxtVi_M304;
    private TextView TxtVi_M305;
    private TextView TxtVi_M306;
    private TextView TxtVi_M340;
    private TextView TxtVi_M403;
    private TextView TxtVi_M404;
    private TextView TxtVi_M431;
    private TextView TxtVi_M437;
    //endregion

    public fragmentDivtecInfBulletin() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (getFragmentManager() != null) {
                Fragment currentFragment = this;
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.detach(currentFragment);
                fragmentTransaction.attach(currentFragment);
                fragmentTransaction.commit();
            }
        }
    }


    public static fragmentDivtecInfBulletin newInstance(String param1, String param2) {
        fragmentDivtecInfBulletin fragment = new fragmentDivtecInfBulletin();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_divtec_inf_bulletin, container, false);
        
        noteHelper = new NoteSQLiteOpenHelper(getActivity());

        initAllTxtView(view);
        remplAllTxtVi(noteHelper);
        moy_tot_mod_standard.setText(String.valueOf(calculMoyenneModNormaux()));
        moy_tot_mod_interEntreprise.setText(String.valueOf(calculMoyenneModInterEntrep()));
        moy_ate_finale.setText(String.valueOf(calculMoyenneAtelier()));
        moy_ate_finale_doublon.setText(moy_ate_finale.getText().toString());
        moy_math_finale.setText(String.valueOf(calculMoyenneMath()));
        moy_anglais_finale.setText(String.valueOf(calculMoyenneAnglais()));
        moy_economie_finale.setText(String.valueOf(calculMoyenneEconomie()));
        moy_edu_physique_finale.setText(String.valueOf(calculMoyenneSport()));
        moy_science_finale.setText(String.valueOf(calculMoyenneScience()));
        moy_langueEtComm_finale.setText(String.valueOf(calculMoyenneLangueEtComm()));
        moy_societe_finale.setText(String.valueOf(calculMoyenneSociete()));
        moy_tot_mod.setText(String.valueOf(calculMoyenneTotMod()));
        moy_tot_ept.setText(String.valueOf(calculMoyenneEpt()));
        moy_tot_cg.setText(String.valueOf(calculMoyenneCg()));
        moy_tot_tot.setText(String.valueOf(calculMoyenneTotTot()));

        //region remplissage arrayListTextViews
        arr_txtViMoy.add(moy_tot_mod_standard);
        arr_txtViMoy.add(moy_tot_mod_interEntreprise);
        arr_txtViMoy.add(moy_ate_finale);
        arr_txtViMoy.add(moy_ate_finale_doublon);
        arr_txtViMoy.add(moy_math_finale);
        arr_txtViMoy.add(moy_anglais_finale);
        arr_txtViMoy.add(moy_economie_finale);
        arr_txtViMoy.add(moy_edu_physique_finale);
        arr_txtViMoy.add(moy_science_finale);
        arr_txtViMoy.add(moy_langueEtComm_finale);
        arr_txtViMoy.add(moy_societe_finale);
        arr_txtViMoy.add(moy_tot_mod);
        arr_txtViMoy.add(moy_tot_ept);
        arr_txtViMoy.add(moy_tot_cg);
        arr_txtViMoy.add(moy_tot_tot);
        //endregion
        changementCouleurFondMoyennes();

        // Inflate the layout for this fragment
        return view;
    }

    //region implements Initialisation
    // Initialise toutes les textViews contenant les notes
    private void initAllTxtView(View view) {
        initTxtViewMath(view);
        initTxtViewScience(view);
        initTxtViewAnglais(view);
        initTxtViewEconomie(view);
        initTxtViewEduPhy(view);
        initTxtViewModules(view);
        initTxtViewMoyTot(view);
        initTxtViewSociete(view);
        initTxtViewLangueEtComm(view);
        initTxtViewAtelier(view);
    }

    // Initialise les textView Math
    private void initTxtViewMath(View view) {
        moy_math_mi = view.findViewById(R.id.divtec_inf_txtvi_math_MI);
        moy_sem1_math = view.findViewById(R.id.divtec_inf_txtvi_math_sem1);
        moy_sem2_math = view.findViewById(R.id.divtec_inf_txtvi_math_sem2);
        moy_sem3_math = view.findViewById(R.id.divtec_inf_txtvi_math_sem3);
        moy_sem4_math = view.findViewById(R.id.divtec_inf_txtvi_math_sem4);
        moy_sem5_math = view.findViewById(R.id.divtec_inf_txtvi_math_sem5);
        moy_sem6_math = view.findViewById(R.id.divtec_inf_txtvi_math_sem6);
        moy_sem7_math = view.findViewById(R.id.divtec_inf_txtvi_math_sem7);
        moy_sem8_math = view.findViewById(R.id.divtec_inf_txtvi_math_sem8);
        moy_math_finale = view.findViewById(R.id.divtec_inf_txtvi_math_finale);
    }

    // Initialise les textView Science
    private void initTxtViewScience(View view) {
        moy_sem1_science = view.findViewById(R.id.divtec_inf_txtvi_science_sem1);
        moy_sem2_science = view.findViewById(R.id.divtec_inf_txtvi_science_sem2);
        moy_sem3_science = view.findViewById(R.id.divtec_inf_txtvi_science_sem3);
        moy_sem4_science = view.findViewById(R.id.divtec_inf_txtvi_science_sem4);
        moy_sem5_science = view.findViewById(R.id.divtec_inf_txtvi_science_sem5);
        moy_sem6_science = view.findViewById(R.id.divtec_inf_txtvi_science_sem6);
        moy_sem7_science = view.findViewById(R.id.divtec_inf_txtvi_science_sem7);
        moy_sem8_science = view.findViewById(R.id.divtec_inf_txtvi_science_sem8);
        moy_science_finale = view.findViewById(R.id.divtec_inf_txtvi_science_finale);
    }

    // Initialise les textView Anglais
    private void initTxtViewAnglais(View view) {
        moy_sem1_anglais = view.findViewById(R.id.divtec_inf_txtvi_anglais_sem1);
        moy_sem2_anglais = view.findViewById(R.id.divtec_inf_txtvi_anglais_sem2);
        moy_sem3_anglais = view.findViewById(R.id.divtec_inf_txtvi_anglais_sem3);
        moy_sem4_anglais = view.findViewById(R.id.divtec_inf_txtvi_anglais_sem4);
        moy_sem5_anglais = view.findViewById(R.id.divtec_inf_txtvi_anglais_sem5);
        moy_sem6_anglais = view.findViewById(R.id.divtec_inf_txtvi_anglais_sem6);
        moy_sem7_anglais = view.findViewById(R.id.divtec_inf_txtvi_anglais_sem7);
        moy_sem8_anglais = view.findViewById(R.id.divtec_inf_txtvi_anglais_sem8);
        moy_anglais_finale = view.findViewById(R.id.divtec_inf_txtvi_anglais_finale);
    }

    // Initialise les textView Economie
    private void initTxtViewEconomie(View view) {
        moy_sem1_economie = view.findViewById(R.id.divtec_inf_txtvi_economie_sem1);
        moy_sem2_economie = view.findViewById(R.id.divtec_inf_txtvi_economie_sem2);
        moy_sem3_economie = view.findViewById(R.id.divtec_inf_txtvi_economie_sem3);
        moy_sem4_economie = view.findViewById(R.id.divtec_inf_txtvi_economie_sem4);
        moy_sem5_economie = view.findViewById(R.id.divtec_inf_txtvi_economie_sem5);
        moy_sem6_economie = view.findViewById(R.id.divtec_inf_txtvi_economie_sem6);
        moy_sem7_economie = view.findViewById(R.id.divtec_inf_txtvi_economie_sem7);
        moy_sem8_economie = view.findViewById(R.id.divtec_inf_txtvi_economie_sem8);
        moy_economie_finale = view.findViewById(R.id.divtec_inf_txtvi_economie_finale);
    }

    // Initialise les textView Physique
    private void initTxtViewEduPhy(View view) {
        moy_sem1_edu_physique = view.findViewById(R.id.divtec_inf_txtvi_edu_physique_sem1);
        moy_sem2_edu_physique = view.findViewById(R.id.divtec_inf_txtvi_edu_physique_sem2);
        moy_sem3_edu_physique = view.findViewById(R.id.divtec_inf_txtvi_edu_physique_sem3);
        moy_sem4_edu_physique = view.findViewById(R.id.divtec_inf_txtvi_edu_physique_sem4);
        moy_sem5_edu_physique = view.findViewById(R.id.divtec_inf_txtvi_edu_physique_sem5);
        moy_sem6_edu_physique = view.findViewById(R.id.divtec_inf_txtvi_edu_physique_sem6);
        moy_sem7_edu_physique = view.findViewById(R.id.divtec_inf_txtvi_edu_physique_sem7);
        moy_sem8_edu_physique = view.findViewById(R.id.divtec_inf_txtvi_edu_physique_sem8);
        moy_edu_physique_finale = view.findViewById(R.id.divtec_inf_txtvi_edu_physique_finale);
    }

    // Initialise les textView Modules
    private void initTxtViewModules(View view) {
        TxtVi_M100 = view.findViewById(R.id.divtec_inf_txtvi_mod_100);
        TxtVi_M101 = view.findViewById(R.id.divtec_inf_txtvi_mod_101);
        TxtVi_M104 = view.findViewById(R.id.divtec_inf_txtvi_mod_104);
        TxtVi_M105 = view.findViewById(R.id.divtec_inf_txtvi_mod_105);
        TxtVi_M114 = view.findViewById(R.id.divtec_inf_txtvi_mod_114);
        TxtVi_M115 = view.findViewById(R.id.divtec_inf_txtvi_mod_115);
        TxtVi_M117 = view.findViewById(R.id.divtec_inf_txtvi_mod_117);
        TxtVi_M122 = view.findViewById(R.id.divtec_inf_txtvi_mod_122);
        TxtVi_M123 = view.findViewById(R.id.divtec_inf_txtvi_mod_123);
        TxtVi_M124 = view.findViewById(R.id.divtec_inf_txtvi_mod_124);
        TxtVi_M127 = view.findViewById(R.id.divtec_inf_txtvi_mod_127);
        TxtVi_M129 = view.findViewById(R.id.divtec_inf_txtvi_mod_129);
        TxtVi_M133 = view.findViewById(R.id.divtec_inf_txtvi_mod_133);
        TxtVi_M140 = view.findViewById(R.id.divtec_inf_txtvi_mod_140);
        TxtVi_M143 = view.findViewById(R.id.divtec_inf_txtvi_mod_143);
        TxtVi_M145 = view.findViewById(R.id.divtec_inf_txtvi_mod_145);
        TxtVi_M151 = view.findViewById(R.id.divtec_inf_txtvi_mod_151);
        TxtVi_M153 = view.findViewById(R.id.divtec_inf_txtvi_mod_153);
        TxtVi_M159 = view.findViewById(R.id.divtec_inf_txtvi_mod_159);
        TxtVi_M182 = view.findViewById(R.id.divtec_inf_txtvi_mod_182);
        TxtVi_M214 = view.findViewById(R.id.divtec_inf_txtvi_mod_214);
        TxtVi_M226 = view.findViewById(R.id.divtec_inf_txtvi_mod_226);
        TxtVi_M302 = view.findViewById(R.id.divtec_inf_txtvi_mod_302);
        TxtVi_M304 = view.findViewById(R.id.divtec_inf_txtvi_mod_304);
        TxtVi_M305 = view.findViewById(R.id.divtec_inf_txtvi_mod_305);
        TxtVi_M306 = view.findViewById(R.id.divtec_inf_txtvi_mod_306);
        TxtVi_M340 = view.findViewById(R.id.divtec_inf_txtvi_mod_340);
        TxtVi_M403 = view.findViewById(R.id.divtec_inf_txtvi_mod_403);
        TxtVi_M404 = view.findViewById(R.id.divtec_inf_txtvi_mod_404);
        TxtVi_M431 = view.findViewById(R.id.divtec_inf_txtvi_mod_431);
        TxtVi_M437 = view.findViewById(R.id.divtec_inf_txtvi_mod_437);

    }

    // Initialise les textView societe
    private void initTxtViewSociete(View view) {
        moy_sem1_societe = view.findViewById(R.id.divtec_inf_txtvi_societe_sem1);
        moy_sem2_societe = view.findViewById(R.id.divtec_inf_txtvi_societe_sem2);
        moy_sem3_societe = view.findViewById(R.id.divtec_inf_txtvi_societe_sem3);
        moy_sem4_societe = view.findViewById(R.id.divtec_inf_txtvi_societe_sem4);
        moy_sem5_societe = view.findViewById(R.id.divtec_inf_txtvi_societe_sem5);
        moy_sem6_societe = view.findViewById(R.id.divtec_inf_txtvi_societe_sem6);
        moy_sem7_societe = view.findViewById(R.id.divtec_inf_txtvi_societe_sem7);
        moy_sem8_societe = view.findViewById(R.id.divtec_inf_txtvi_societe_sem8);
        moy_societe_finale = view.findViewById(R.id.divtec_inf_txtvi_societe_finale);

    }

    // Initialise les textView langue et comm
    private void initTxtViewLangueEtComm(View view) {
        moy_sem1_langueEtComm = view.findViewById(R.id.divtec_inf_txtvi_langueEtComm_sem1);
        moy_sem2_langueEtComm = view.findViewById(R.id.divtec_inf_txtvi_langueEtComm_sem2);
        moy_sem3_langueEtComm = view.findViewById(R.id.divtec_inf_txtvi_langueEtComm_sem3);
        moy_sem4_langueEtComm = view.findViewById(R.id.divtec_inf_txtvi_langueEtComm_sem4);
        moy_sem5_langueEtComm = view.findViewById(R.id.divtec_inf_txtvi_langueEtComm_sem5);
        moy_sem6_langueEtComm = view.findViewById(R.id.divtec_inf_txtvi_langueEtComm_sem6);
        moy_sem7_langueEtComm = view.findViewById(R.id.divtec_inf_txtvi_langueEtComm_sem7);
        moy_sem8_langueEtComm = view.findViewById(R.id.divtec_inf_txtvi_langueEtComm_sem8);
        moy_langueEtComm_finale = view.findViewById(R.id.divtec_inf_txtvi_langueEtComm_finale);
    }

    // Initialise les textView Moyennes totales
    private void initTxtViewMoyTot(View view) {
        moy_tot_tot = view.findViewById(R.id.divtec_inf_txtvi_moy_tot);
        moy_ate_finale = view.findViewById(R.id.divtec_inf_txtvi_moy_atelier);
        moy_tot_cg = view.findViewById(R.id.divtec_inf_txtvi_moy_cg);
        moy_tot_ept = view.findViewById(R.id.divtec_inf_txtvi_moy_ept);
        moy_tot_mod = view.findViewById(R.id.divtec_inf_txtvi_moy_mod);
        moy_tot_mod_standard = view.findViewById(R.id.divtec_inf_txtvi_moy_mod_std);
        moy_tot_mod_interEntreprise = view.findViewById(R.id.divtec_inf_txtvi_moy_mod_interEntreprise);
    }

    // Initialise les textView atelier
    private void initTxtViewAtelier(View view) {
        moy_sem1_ate = view.findViewById(R.id.divtec_inf_txtvi_atelier_sem1);
        moy_sem2_ate = view.findViewById(R.id.divtec_inf_txtvi_atelier_sem2);
        moy_sem3_ate = view.findViewById(R.id.divtec_inf_txtvi_atelier_sem3);
        moy_sem4_ate = view.findViewById(R.id.divtec_inf_txtvi_atelier_sem4);
        moy_sem5_ate = view.findViewById(R.id.divtec_inf_txtvi_atelier_sem5);
        moy_sem6_ate = view.findViewById(R.id.divtec_inf_txtvi_atelier_sem6);
        moy_sem7_ate = view.findViewById(R.id.divtec_inf_txtvi_atelier_sem7);
        moy_sem8_ate = view.findViewById(R.id.divtec_inf_txtvi_atelier_sem8);
        moy_ate_finale = view.findViewById(R.id.divtec_inf_txtvi_atelier_finale);
        moy_ate_finale_doublon = view.findViewById(R.id.divtec_inf_txtvi_moy_atelier);
    }


    //endregion
    //region implements Remplissage
    // Remplit toutes les textView
    public void remplAllTxtVi(NoteSQLiteOpenHelper noteHelper) {
        remplTxtViewMath(noteHelper);
        remplTxtViewAnglais(noteHelper);
        remplTxtViewEconomie(noteHelper);
        remplTxtViewEduPhy(noteHelper);
        remplTxtViewScience(noteHelper);
        remplTxtViewModules(noteHelper);
        remplTxtViewMoyTot(noteHelper);
        remplTxtViewSociete(noteHelper);
        remplTxtViewLangueEtComm(noteHelper);
        remplTxtViewAtelier(noteHelper);
    }

    private void remplTxtViewMath(NoteSQLiteOpenHelper noteHelper) {
        moy_math_mi.setText(String.valueOf(noteHelper.getNoteValueByName("MI")));
        if (moy_math_mi.getText().equals("0.5")) {
            moy_math_mi.setVisibility(View.INVISIBLE);
        }
        moy_sem1_math.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_math_sem1")));
        if (moy_sem1_math.getText().equals("0.5")) {
            moy_sem1_math.setVisibility(View.INVISIBLE);
        }
        moy_sem2_math.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_math_sem2")));
        if (moy_sem2_math.getText().equals("0.5")) {
            moy_sem2_math.setVisibility(View.INVISIBLE);
        }
        moy_sem3_math.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_math_sem3")));
        if (moy_sem3_math.getText().equals("0.5")) {
            moy_sem3_math.setVisibility(View.INVISIBLE);
        }
        moy_sem4_math.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_math_sem4")));
        if (moy_sem4_math.getText().equals("0.5")) {
            moy_sem4_math.setVisibility(View.INVISIBLE);
        }
        moy_sem5_math.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_math_sem5")));
        if (moy_sem5_math.getText().equals("0.5")) {
            moy_sem5_math.setVisibility(View.INVISIBLE);
        }
        moy_sem6_math.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_math_sem6")));
        if (moy_sem6_math.getText().equals("0.5")) {
            moy_sem6_math.setVisibility(View.INVISIBLE);
        }
        moy_sem7_math.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_math_sem7")));
        if (moy_sem7_math.getText().equals("0.5")) {
            moy_sem7_math.setVisibility(View.INVISIBLE);
        }
        moy_sem8_math.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_math_sem8")));
        if (moy_sem8_math.getText().equals("0.5")) {
            moy_sem8_math.setVisibility(View.INVISIBLE);
        }
        moy_math_finale.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_math_finale")));
        if (moy_math_finale.getText().equals("0.5")) {
            moy_math_finale.setVisibility(View.INVISIBLE);
        }

    }

    private void remplTxtViewScience(NoteSQLiteOpenHelper noteHelper) {
        moy_sem1_science.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_science_sem1")));
        if (moy_sem1_science.getText().equals("0.5")) {
            moy_sem1_science.setVisibility(View.INVISIBLE);
        }
        moy_sem2_science.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_science_sem2")));
        if (moy_sem2_science.getText().equals("0.5")) {
            moy_sem2_science.setVisibility(View.INVISIBLE);
        }
        moy_sem3_science.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_science_sem3")));
        if (moy_sem3_science.getText().equals("0.5")) {
            moy_sem3_science.setVisibility(View.INVISIBLE);
        }
        moy_sem4_science.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_science_sem4")));
        if (moy_sem4_science.getText().equals("0.5")) {
            moy_sem4_science.setVisibility(View.INVISIBLE);
        }
        moy_sem5_science.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_science_sem5")));
        if (moy_sem5_science.getText().equals("0.5")) {
            moy_sem5_science.setVisibility(View.INVISIBLE);
        }
        moy_sem6_science.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_science_sem6")));
        if (moy_sem6_science.getText().equals("0.5")) {
            moy_sem6_science.setVisibility(View.INVISIBLE);
        }
        moy_sem7_science.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_science_sem7")));
        if (moy_sem7_science.getText().equals("0.5")) {
            moy_sem7_science.setVisibility(View.INVISIBLE);
        }
        moy_sem8_science.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_science_sem8")));
        if (moy_sem8_science.getText().equals("0.5")) {
            moy_sem8_science.setVisibility(View.INVISIBLE);
        }
        moy_science_finale.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_science_finale")));
        if (moy_science_finale.getText().equals("0.5")) {
            moy_science_finale.setVisibility(View.INVISIBLE);
        }

    }

    private void remplTxtViewAnglais(NoteSQLiteOpenHelper noteHelper) {
        moy_sem1_anglais.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_anglais_sem1")));
        if (moy_sem1_anglais.getText().equals("0.5")) {
            moy_sem1_anglais.setVisibility(View.INVISIBLE);
        }
        moy_sem2_anglais.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_anglais_sem2")));
        if (moy_sem2_anglais.getText().equals("0.5")) {
            moy_sem2_anglais.setVisibility(View.INVISIBLE);
        }
        moy_sem3_anglais.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_anglais_sem3")));
        if (moy_sem3_anglais.getText().equals("0.5")) {
            moy_sem3_anglais.setVisibility(View.INVISIBLE);
        }
        moy_sem4_anglais.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_anglais_sem4")));
        if (moy_sem4_anglais.getText().equals("0.5")) {
            moy_sem4_anglais.setVisibility(View.INVISIBLE);
        }
        moy_sem5_anglais.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_anglais_sem5")));
        if (moy_sem5_anglais.getText().equals("0.5")) {
            moy_sem5_anglais.setVisibility(View.INVISIBLE);
        }
        moy_sem6_anglais.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_anglais_sem6")));
        if (moy_sem6_anglais.getText().equals("0.5")) {
            moy_sem6_anglais.setVisibility(View.INVISIBLE);
        }
        moy_sem7_anglais.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_anglais_sem7")));
        if (moy_sem7_anglais.getText().equals("0.5")) {
            moy_sem7_anglais.setVisibility(View.INVISIBLE);
        }
        moy_sem8_anglais.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_anglais_sem8")));
        if (moy_sem8_anglais.getText().equals("0.5")) {
            moy_sem8_anglais.setVisibility(View.INVISIBLE);
        }
        moy_anglais_finale.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_anglais_finale")));
        if (moy_anglais_finale.getText().equals("0.5")) {
            moy_anglais_finale.setVisibility(View.INVISIBLE);
        }

    }

    private void remplTxtViewEconomie(NoteSQLiteOpenHelper noteHelper) {
        moy_sem1_economie.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_economie_sem1")));
        if (moy_sem1_economie.getText().equals("0.5")) {
            moy_sem1_economie.setVisibility(View.INVISIBLE);
        }
        moy_sem2_economie.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_economie_sem2")));
        if (moy_sem2_economie.getText().equals("0.5")) {
            moy_sem2_economie.setVisibility(View.INVISIBLE);
        }
        moy_sem3_economie.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_economie_sem3")));
        if (moy_sem3_economie.getText().equals("0.5")) {
            moy_sem3_economie.setVisibility(View.INVISIBLE);
        }
        moy_sem4_economie.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_economie_sem4")));
        if (moy_sem4_economie.getText().equals("0.5")) {
            moy_sem4_economie.setVisibility(View.INVISIBLE);
        }
        moy_sem5_economie.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_economie_sem5")));
        if (moy_sem5_economie.getText().equals("0.5")) {
            moy_sem5_economie.setVisibility(View.INVISIBLE);
        }
        moy_sem6_economie.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_economie_sem6")));
        if (moy_sem6_economie.getText().equals("0.5")) {
            moy_sem6_economie.setVisibility(View.INVISIBLE);
        }
        moy_sem7_economie.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_economie_sem7")));
        if (moy_sem7_economie.getText().equals("0.5")) {
            moy_sem7_economie.setVisibility(View.INVISIBLE);
        }
        moy_sem8_economie.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_economie_sem8")));
        if (moy_sem8_economie.getText().equals("0.5")) {
            moy_sem8_economie.setVisibility(View.INVISIBLE);
        }
        moy_economie_finale.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_economie_finale")));
        if (moy_economie_finale.getText().equals("0.5")) {
            moy_economie_finale.setVisibility(View.INVISIBLE);
        }

    }

    private void remplTxtViewEduPhy(NoteSQLiteOpenHelper noteHelper) {
        moy_sem1_edu_physique.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_edu_physique_sem1")));
        if (moy_sem1_edu_physique.getText().equals("0.5")) {
            moy_sem1_edu_physique.setVisibility(View.INVISIBLE);
        }
        moy_sem2_edu_physique.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_edu_physique_sem2")));
        if (moy_sem2_edu_physique.getText().equals("0.5")) {
            moy_sem2_edu_physique.setVisibility(View.INVISIBLE);
        }
        moy_sem3_edu_physique.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_edu_physique_sem3")));
        if (moy_sem3_edu_physique.getText().equals("0.5")) {
            moy_sem3_edu_physique.setVisibility(View.INVISIBLE);
        }
        moy_sem4_edu_physique.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_edu_physique_sem4")));
        if (moy_sem4_edu_physique.getText().equals("0.5")) {
            moy_sem4_edu_physique.setVisibility(View.INVISIBLE);
        }
        moy_sem5_edu_physique.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_edu_physique_sem5")));
        if (moy_sem5_edu_physique.getText().equals("0.5")) {
            moy_sem5_edu_physique.setVisibility(View.INVISIBLE);
        }
        moy_sem6_edu_physique.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_edu_physique_sem6")));
        if (moy_sem6_edu_physique.getText().equals("0.5")) {
            moy_sem6_edu_physique.setVisibility(View.INVISIBLE);
        }
        moy_sem7_edu_physique.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_edu_physique_sem7")));
        if (moy_sem7_edu_physique.getText().equals("0.5")) {
            moy_sem7_edu_physique.setVisibility(View.INVISIBLE);
        }
        moy_sem8_edu_physique.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_edu_physique_sem8")));
        if (moy_sem8_edu_physique.getText().equals("0.5")) {
            moy_sem8_edu_physique.setVisibility(View.INVISIBLE);
        }
        moy_edu_physique_finale.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_edu_physique_finale")));
        if (moy_edu_physique_finale.getText().equals("0.5")) {
            moy_edu_physique_finale.setVisibility(View.INVISIBLE);
        }

    }

    private void remplTxtViewSociete(NoteSQLiteOpenHelper noteHelper) {
        moy_sem1_societe.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_societe_sem1")));
        if (moy_sem1_societe.getText().equals("0.5")) {
            moy_sem1_societe.setVisibility(View.INVISIBLE);
        }
        moy_sem2_societe.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_societe_sem2")));
        if (moy_sem2_societe.getText().equals("0.5")) {
            moy_sem2_societe.setVisibility(View.INVISIBLE);
        }
        moy_sem3_societe.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_societe_sem3")));
        if (moy_sem3_societe.getText().equals("0.5")) {
            moy_sem3_societe.setVisibility(View.INVISIBLE);
        }
        moy_sem4_societe.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_societe_sem4")));
        if (moy_sem4_societe.getText().equals("0.5")) {
            moy_sem4_societe.setVisibility(View.INVISIBLE);
        }
        moy_sem5_societe.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_societe_sem5")));
        if (moy_sem5_societe.getText().equals("0.5")) {
            moy_sem5_societe.setVisibility(View.INVISIBLE);
        }
        moy_sem6_societe.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_societe_sem6")));
        if (moy_sem6_societe.getText().equals("0.5")) {
            moy_sem6_societe.setVisibility(View.INVISIBLE);
        }
        moy_sem7_societe.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_societe_sem7")));
        if (moy_sem7_societe.getText().equals("0.5")) {
            moy_sem7_societe.setVisibility(View.INVISIBLE);
        }
        moy_sem8_societe.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_societe_sem8")));
        if (moy_sem8_societe.getText().equals("0.5")) {
            moy_sem8_societe.setVisibility(View.INVISIBLE);
        }
        moy_societe_finale.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_societe_finale")));
        if (moy_societe_finale.getText().equals("0.5")) {
            moy_societe_finale.setVisibility(View.INVISIBLE);
        }

    }

    private void remplTxtViewLangueEtComm(NoteSQLiteOpenHelper noteHelper) {
        moy_sem1_langueEtComm.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_langueEtComm_sem1")));
        if (moy_sem1_langueEtComm.getText().equals("0.5")) {
            moy_sem1_langueEtComm.setVisibility(View.INVISIBLE);
        }
        moy_sem2_langueEtComm.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_langueEtComm_sem2")));
        if (moy_sem2_langueEtComm.getText().equals("0.5")) {
            moy_sem2_langueEtComm.setVisibility(View.INVISIBLE);
        }
        moy_sem3_langueEtComm.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_langueEtComm_sem3")));
        if (moy_sem3_langueEtComm.getText().equals("0.5")) {
            moy_sem3_langueEtComm.setVisibility(View.INVISIBLE);
        }
        moy_sem4_langueEtComm.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_langueEtComm_sem4")));
        if (moy_sem4_langueEtComm.getText().equals("0.5")) {
            moy_sem4_langueEtComm.setVisibility(View.INVISIBLE);
        }
        moy_sem5_langueEtComm.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_langueEtComm_sem5")));
        if (moy_sem5_langueEtComm.getText().equals("0.5")) {
            moy_sem5_langueEtComm.setVisibility(View.INVISIBLE);
        }
        moy_sem6_langueEtComm.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_langueEtComm_sem6")));
        if (moy_sem6_langueEtComm.getText().equals("0.5")) {
            moy_sem6_langueEtComm.setVisibility(View.INVISIBLE);
        }
        moy_sem7_langueEtComm.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_langueEtComm_sem7")));
        if (moy_sem7_langueEtComm.getText().equals("0.5")) {
            moy_sem7_langueEtComm.setVisibility(View.INVISIBLE);
        }
        moy_sem8_langueEtComm.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_langueEtComm_sem8")));
        if (moy_sem8_langueEtComm.getText().equals("0.5")) {
            moy_sem8_langueEtComm.setVisibility(View.INVISIBLE);
        }
        moy_langueEtComm_finale.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_langueEtComm_finale")));
        if (moy_langueEtComm_finale.getText().equals("0.5")) {
            moy_langueEtComm_finale.setVisibility(View.INVISIBLE);
        }

    }

    private void remplTxtViewModules(NoteSQLiteOpenHelper noteHelper) {
        TxtVi_M100.setText(String.valueOf(noteHelper.getNoteValueByName("M100")));
        if (TxtVi_M100.getText().equals("0.5")) {
            TxtVi_M100.setVisibility(View.INVISIBLE);
        }
        TxtVi_M101.setText(String.valueOf(noteHelper.getNoteValueByName("M101")));
        if (TxtVi_M101.getText().equals("0.5")) {
            TxtVi_M101.setVisibility(View.INVISIBLE);
        }
        TxtVi_M104.setText(String.valueOf(noteHelper.getNoteValueByName("M104")));
        if (TxtVi_M104.getText().equals("0.5")) {
            TxtVi_M104.setVisibility(View.INVISIBLE);
        }
        TxtVi_M105.setText(String.valueOf(noteHelper.getNoteValueByName("M105")));
        if (TxtVi_M105.getText().equals("0.5")) {
            TxtVi_M105.setVisibility(View.INVISIBLE);
        }
        TxtVi_M114.setText(String.valueOf(noteHelper.getNoteValueByName("M114")));
        if (TxtVi_M114.getText().equals("0.5")) {
            TxtVi_M114.setVisibility(View.INVISIBLE);
        }
        TxtVi_M115.setText(String.valueOf(noteHelper.getNoteValueByName("M115")));
        if (TxtVi_M115.getText().equals("0.5")) {
            TxtVi_M115.setVisibility(View.INVISIBLE);
        }
        TxtVi_M117.setText(String.valueOf(noteHelper.getNoteValueByName("M117")));
        if (TxtVi_M117.getText().equals("0.5")) {
            TxtVi_M117.setVisibility(View.INVISIBLE);
        }
        TxtVi_M122.setText(String.valueOf(noteHelper.getNoteValueByName("M122")));
        if (TxtVi_M122.getText().equals("0.5")) {
            TxtVi_M122.setVisibility(View.INVISIBLE);
        }
        TxtVi_M123.setText(String.valueOf(noteHelper.getNoteValueByName("M123")));
        if (TxtVi_M123.getText().equals("0.5")) {
            TxtVi_M123.setVisibility(View.INVISIBLE);
        }
        TxtVi_M124.setText(String.valueOf(noteHelper.getNoteValueByName("M124")));
        if (TxtVi_M124.getText().equals("0.5")) {
            TxtVi_M124.setVisibility(View.INVISIBLE);
        }
        TxtVi_M127.setText(String.valueOf(noteHelper.getNoteValueByName("M127")));
        if (TxtVi_M127.getText().equals("0.5")) {
            TxtVi_M127.setVisibility(View.INVISIBLE);
        }
        TxtVi_M129.setText(String.valueOf(noteHelper.getNoteValueByName("M129")));
        if (TxtVi_M129.getText().equals("0.5")) {
            TxtVi_M129.setVisibility(View.INVISIBLE);
        }
        TxtVi_M133.setText(String.valueOf(noteHelper.getNoteValueByName("M133")));
        if (TxtVi_M133.getText().equals("0.5")) {
            TxtVi_M133.setVisibility(View.INVISIBLE);
        }
        TxtVi_M140.setText(String.valueOf(noteHelper.getNoteValueByName("M140")));
        if (TxtVi_M140.getText().equals("0.5")) {
            TxtVi_M140.setVisibility(View.INVISIBLE);
        }
        TxtVi_M143.setText(String.valueOf(noteHelper.getNoteValueByName("M143")));
        if (TxtVi_M143.getText().equals("0.5")) {
            TxtVi_M143.setVisibility(View.INVISIBLE);
        }
        TxtVi_M145.setText(String.valueOf(noteHelper.getNoteValueByName("M145")));
        if (TxtVi_M145.getText().equals("0.5")) {
            TxtVi_M145.setVisibility(View.INVISIBLE);
        }
        TxtVi_M151.setText(String.valueOf(noteHelper.getNoteValueByName("M151")));
        if (TxtVi_M151.getText().equals("0.5")) {
            TxtVi_M151.setVisibility(View.INVISIBLE);
        }
        TxtVi_M153.setText(String.valueOf(noteHelper.getNoteValueByName("M153")));
        if (TxtVi_M153.getText().equals("0.5")) {
            TxtVi_M153.setVisibility(View.INVISIBLE);
        }
        TxtVi_M159.setText(String.valueOf(noteHelper.getNoteValueByName("M159")));
        if (TxtVi_M159.getText().equals("0.5")) {
            TxtVi_M159.setVisibility(View.INVISIBLE);
        }
        TxtVi_M182.setText(String.valueOf(noteHelper.getNoteValueByName("M182")));
        if (TxtVi_M182.getText().equals("0.5")) {
            TxtVi_M182.setVisibility(View.INVISIBLE);
        }
        TxtVi_M214.setText(String.valueOf(noteHelper.getNoteValueByName("M214")));
        if (TxtVi_M214.getText().equals("0.5")) {
            TxtVi_M214.setVisibility(View.INVISIBLE);
        }
        TxtVi_M226.setText(String.valueOf(noteHelper.getNoteValueByName("M226")));
        if (TxtVi_M226.getText().equals("0.5")) {
            TxtVi_M226.setVisibility(View.INVISIBLE);
        }
        TxtVi_M302.setText(String.valueOf(noteHelper.getNoteValueByName("M302")));
        if (TxtVi_M302.getText().equals("0.5")) {
            TxtVi_M302.setVisibility(View.INVISIBLE);
        }
        TxtVi_M304.setText(String.valueOf(noteHelper.getNoteValueByName("M304")));
        if (TxtVi_M304.getText().equals("0.5")) {
            TxtVi_M304.setVisibility(View.INVISIBLE);
        }
        TxtVi_M305.setText(String.valueOf(noteHelper.getNoteValueByName("M305")));
        if (TxtVi_M305.getText().equals("0.5")) {
            TxtVi_M305.setVisibility(View.INVISIBLE);
        }
        TxtVi_M306.setText(String.valueOf(noteHelper.getNoteValueByName("M306")));
        if (TxtVi_M306.getText().equals("0.5")) {
            TxtVi_M306.setVisibility(View.INVISIBLE);
        }
        TxtVi_M340.setText(String.valueOf(noteHelper.getNoteValueByName("M340")));
        if (TxtVi_M340.getText().equals("0.5")) {
            TxtVi_M340.setVisibility(View.INVISIBLE);
        }
        TxtVi_M403.setText(String.valueOf(noteHelper.getNoteValueByName("M403")));
        if (TxtVi_M403.getText().equals("0.5")) {
            TxtVi_M403.setVisibility(View.INVISIBLE);
        }
        TxtVi_M404.setText(String.valueOf(noteHelper.getNoteValueByName("M404")));
        if (TxtVi_M404.getText().equals("0.5")) {
            TxtVi_M404.setVisibility(View.INVISIBLE);
        }
        TxtVi_M431.setText(String.valueOf(noteHelper.getNoteValueByName("M431")));
        if (TxtVi_M431.getText().equals("0.5")) {
            TxtVi_M431.setVisibility(View.INVISIBLE);
        }
        TxtVi_M437.setText(String.valueOf(noteHelper.getNoteValueByName("M437")));
        if (TxtVi_M437.getText().equals("0.5")) {
            TxtVi_M437.setVisibility(View.INVISIBLE);
        }
    }

    private void remplTxtViewMoyTot(NoteSQLiteOpenHelper noteHelper) {
        moy_tot_cg.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_moy_tot_cg")));
        if (moy_tot_cg.getText().equals("0.5")) {
            moy_tot_cg.setVisibility(View.INVISIBLE);
        }
        moy_tot_ept.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_moy_tot_ept")));
        if (moy_tot_ept.getText().equals("0.5")) {
            moy_tot_ept.setVisibility(View.INVISIBLE);
        }
        moy_tot_mod.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_moy_tot_mod")));
        if (moy_tot_mod.getText().equals("0.5")) {
            moy_tot_mod.setVisibility(View.INVISIBLE);
        }
        moy_tot_mod_interEntreprise.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_moy_tot_mod_interEntreprise")));
        if (moy_tot_mod_interEntreprise.getText().equals("0.5")) {
            moy_tot_mod_interEntreprise.setVisibility(View.INVISIBLE);
        }
        moy_tot_mod_standard.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_moy_tot_mod_standard")));
        if (moy_tot_mod_standard.getText().equals("0.5")) {
            moy_tot_mod_standard.setVisibility(View.INVISIBLE);
        }
        moy_ate_finale.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_moy_tot_atelier")));
        moy_ate_finale_doublon.setText(moy_ate_finale.getText());
        if (moy_ate_finale.getText().equals("0.5")) {
            moy_ate_finale.setVisibility(View.INVISIBLE);
            moy_ate_finale_doublon.setVisibility(View.INVISIBLE);
        }
        moy_tot_tot.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_moy_tot_tot")));
        if (moy_tot_tot.getText().equals("0.5")) {
            moy_tot_tot.setVisibility(View.INVISIBLE);
        }
    }

    private void remplTxtViewAtelier(NoteSQLiteOpenHelper noteHelper) {
        moy_sem1_ate.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_atelier_sem1")));
        if (moy_sem1_ate.getText().equals("0.5")) {
            moy_sem1_ate.setVisibility(View.INVISIBLE);
        }
        moy_sem2_ate.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_atelier_sem2")));
        if (moy_sem2_ate.getText().equals("0.5")) {
            moy_sem2_ate.setVisibility(View.INVISIBLE);
        }
        moy_sem3_ate.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_atelier_sem3")));
        if (moy_sem3_ate.getText().equals("0.5")) {
            moy_sem3_ate.setVisibility(View.INVISIBLE);
        }
        moy_sem4_ate.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_atelier_sem4")));
        if (moy_sem4_ate.getText().equals("0.5")) {
            moy_sem4_ate.setVisibility(View.INVISIBLE);
        }
        moy_sem5_ate.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_atelier_sem5")));
        if (moy_sem5_ate.getText().equals("0.5")) {
            moy_sem5_ate.setVisibility(View.INVISIBLE);
        }
        moy_sem6_ate.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_atelier_sem6")));
        if (moy_sem6_ate.getText().equals("0.5")) {
            moy_sem6_ate.setVisibility(View.INVISIBLE);
        }
        moy_sem7_ate.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_atelier_sem7")));
        if (moy_sem7_ate.getText().equals("0.5")) {
            moy_sem7_ate.setVisibility(View.INVISIBLE);
        }
        moy_sem8_ate.setText(String.valueOf(noteHelper.getNoteValueByName("divtec_inf_atelier_sem8")));
        if (moy_sem8_ate.getText().equals("0.5")) {
            moy_sem8_ate.setVisibility(View.INVISIBLE);
        }
    }

    //endregion
    //region Calcul Moyennes
    private double calculMoyenneAtelier() {
        float moy1 = Float.parseFloat(moy_sem1_ate.getText().toString());
        float moy2 = Float.parseFloat(moy_sem2_ate.getText().toString());
        float moy3 = Float.parseFloat(moy_sem3_ate.getText().toString());
        float moy4 = Float.parseFloat(moy_sem4_ate.getText().toString());
        float moy5 = Float.parseFloat(moy_sem5_ate.getText().toString());
        float moy6 = Float.parseFloat(moy_sem6_ate.getText().toString());
        float moy7 = Float.parseFloat(moy_sem7_ate.getText().toString());
        float moy8 = Float.parseFloat(moy_sem8_ate.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }
        if (moy5 >= 1) {
            sommeTotale += moy5;
            notesActives++;
        }
        if (moy6 >= 1) {
            sommeTotale += moy6;
            notesActives++;
        }
        if (moy7 >= 1) {
            sommeTotale += moy7;
            notesActives++;
        }
        if (moy8 >= 1) {
            sommeTotale += moy8;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_ate_finale.setVisibility(View.VISIBLE);
            moy_ate_finale_doublon.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneModInterEntrep() {
        float m101 = Float.parseFloat(TxtVi_M101.getText().toString());
        float m105 = Float.parseFloat(TxtVi_M105.getText().toString());
        float m127 = Float.parseFloat(TxtVi_M127.getText().toString());
        float m302 = Float.parseFloat(TxtVi_M302.getText().toString());
        float m304 = Float.parseFloat(TxtVi_M304.getText().toString());
        float m305 = Float.parseFloat(TxtVi_M305.getText().toString());
        float m340 = Float.parseFloat(TxtVi_M340.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (m101 >= 1) {
            sommeTotale += m101;
            notesActives++;
        }
        if (m105 >= 1) {
            sommeTotale += m105;
            notesActives++;
        }
        if (m127 >= 1) {
            sommeTotale += m127;
            notesActives++;
        }
        if (m302 >= 1) {
            sommeTotale += m302;
            notesActives++;
        }
        if (m304 >= 1) {
            sommeTotale += m305;
            notesActives++;
        }
        if (m340 >= 1) {
            sommeTotale += m340;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_tot_mod_interEntreprise.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneModNormaux() {
        float m100 = Float.parseFloat(TxtVi_M100.getText().toString());
        float m104 = Float.parseFloat(TxtVi_M104.getText().toString());
        float m114 = Float.parseFloat(TxtVi_M114.getText().toString());
        float m115 = Float.parseFloat(TxtVi_M115.getText().toString());
        float m117 = Float.parseFloat(TxtVi_M117.getText().toString());
        float m122 = Float.parseFloat(TxtVi_M122.getText().toString());
        float m123 = Float.parseFloat(TxtVi_M123.getText().toString());
        float m124 = Float.parseFloat(TxtVi_M124.getText().toString());
        float m129 = Float.parseFloat(TxtVi_M129.getText().toString());
        float m133 = Float.parseFloat(TxtVi_M133.getText().toString());
        float m140 = Float.parseFloat(TxtVi_M140.getText().toString());
        float m143 = Float.parseFloat(TxtVi_M143.getText().toString());
        float m145 = Float.parseFloat(TxtVi_M145.getText().toString());
        float m151 = Float.parseFloat(TxtVi_M151.getText().toString());
        float m153 = Float.parseFloat(TxtVi_M153.getText().toString());
        float m159 = Float.parseFloat(TxtVi_M159.getText().toString());
        float m182 = Float.parseFloat(TxtVi_M182.getText().toString());
        float m214 = Float.parseFloat(TxtVi_M214.getText().toString());
        float m226 = Float.parseFloat(TxtVi_M226.getText().toString());
        float m306 = Float.parseFloat(TxtVi_M306.getText().toString());
        float m403 = Float.parseFloat(TxtVi_M403.getText().toString());
        float m404 = Float.parseFloat(TxtVi_M404.getText().toString());
        float m431 = Float.parseFloat(TxtVi_M431.getText().toString());
        float m437 = Float.parseFloat(TxtVi_M437.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (m100 >= 1) {
            sommeTotale += m100;
            notesActives++;
        }
        if (m104 >= 1) {
            sommeTotale += m104;
            notesActives++;
        }
        if (m114 >= 1) {
            sommeTotale += m114;
            notesActives++;
        }
        if (m115 >= 1) {
            sommeTotale += m115;
            notesActives++;
        }
        if (m117 >= 1) {
            sommeTotale += m117;
            notesActives++;
        }
        if (m122 >= 1) {
            sommeTotale += m122;
            notesActives++;
        }
        if (m123 >= 1) {
            sommeTotale += m123;
            notesActives++;
        }
        if (m124 >= 1) {
            sommeTotale += m124;
            notesActives++;
        }
        if (m129 >= 1) {
            sommeTotale += m129;
            notesActives++;
        }
        if (m133 >= 1) {
            sommeTotale += m133;
            notesActives++;
        }
        if (m140 >= 1) {
            sommeTotale += m140;
            notesActives++;
        }
        if (m143 >= 1) {
            sommeTotale += m143;
            notesActives++;
        }
        if (m145 >= 1) {
            sommeTotale += m145;
            notesActives++;
        }
        if (m151 >= 1) {
            sommeTotale += m151;
            notesActives++;
        }
        if (m153 >= 1) {
            sommeTotale += m153;
            notesActives++;
        }
        if (m159 >= 1) {
            sommeTotale += m159;
            notesActives++;
        }
        if (m182 >= 1) {
            sommeTotale += m182;
            notesActives++;
        }
        if (m214 >= 1) {
            sommeTotale += m214;
            notesActives++;
        }
        if (m226 >= 1) {
            sommeTotale += m226;
            notesActives++;
        }
        if (m306 >= 1) {
            sommeTotale += m306;
            notesActives++;
        }
        if (m403 >= 1) {
            sommeTotale += m403;
            notesActives++;
        }
        if (m404 >= 1) {
            sommeTotale += m404;
            notesActives++;
        }
        if (m431 >= 1) {
            sommeTotale += m431;
            notesActives++;
        }
        if (m437 >= 1) {
            sommeTotale += m437;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_tot_mod_standard.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneEpt() {
        float moy1 = Float.parseFloat(moy_math_finale.getText().toString());
        float moy2 = Float.parseFloat(moy_anglais_finale.getText().toString());
        float moy3 = Float.parseFloat(moy_science_finale.getText().toString());
        float moy4 = Float.parseFloat(moy_economie_finale.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_tot_ept.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneMath() {
        float moy1 = Float.parseFloat(moy_sem1_math.getText().toString());
        float moy2 = Float.parseFloat(moy_sem2_math.getText().toString());
        float moy3 = Float.parseFloat(moy_sem3_math.getText().toString());
        float moy4 = Float.parseFloat(moy_sem4_math.getText().toString());
        float moy5 = Float.parseFloat(moy_sem5_math.getText().toString());
        float moy6 = Float.parseFloat(moy_sem6_math.getText().toString());
        float moy7 = Float.parseFloat(moy_sem7_math.getText().toString());
        float moy8 = Float.parseFloat(moy_sem8_math.getText().toString());
        float moyMi = Float.parseFloat(moy_math_mi.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }
        if (moy5 >= 1) {
            sommeTotale += moy5;
            notesActives++;
        }
        if (moy6 >= 1) {
            sommeTotale += moy6;
            notesActives++;
        }
        if (moy7 >= 1) {
            sommeTotale += moy7;
            notesActives++;
        }
        if (moy8 >= 1) {
            sommeTotale += moy8;
            notesActives++;
        }
        //Compte double
        if (moyMi >= 1) {
            for (int i = 0; i < 2; i++) {
                sommeTotale += moyMi;
                notesActives++;
            }
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_math_finale.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            if (moyMi >= 1) {
                return Double.valueOf(df.format(sommeTotale / notesActives));
            } else {
                return Double.valueOf(df.format(sommeTotale / notesActives));
            }
        }
    }

    private double calculMoyenneScience() {
        float moy1 = Float.parseFloat(moy_sem1_science.getText().toString());
        float moy2 = Float.parseFloat(moy_sem2_science.getText().toString());
        float moy3 = Float.parseFloat(moy_sem3_science.getText().toString());
        float moy4 = Float.parseFloat(moy_sem4_science.getText().toString());
        float moy5 = Float.parseFloat(moy_sem5_science.getText().toString());
        float moy6 = Float.parseFloat(moy_sem6_science.getText().toString());
        float moy7 = Float.parseFloat(moy_sem7_science.getText().toString());
        float moy8 = Float.parseFloat(moy_sem8_science.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }
        if (moy5 >= 1) {
            sommeTotale += moy5;
            notesActives++;
        }
        if (moy6 >= 1) {
            sommeTotale += moy6;
            notesActives++;
        }
        if (moy7 >= 1) {
            sommeTotale += moy7;
            notesActives++;
        }
        if (moy8 >= 1) {
            sommeTotale += moy8;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_science_finale.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneAnglais() {
        float moy1 = Float.parseFloat(moy_sem1_anglais.getText().toString());
        float moy2 = Float.parseFloat(moy_sem2_anglais.getText().toString());
        float moy3 = Float.parseFloat(moy_sem3_anglais.getText().toString());
        float moy4 = Float.parseFloat(moy_sem4_anglais.getText().toString());
        float moy5 = Float.parseFloat(moy_sem5_anglais.getText().toString());
        float moy6 = Float.parseFloat(moy_sem6_anglais.getText().toString());
        float moy7 = Float.parseFloat(moy_sem7_anglais.getText().toString());
        float moy8 = Float.parseFloat(moy_sem8_anglais.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }
        if (moy5 >= 1) {
            sommeTotale += moy5;
            notesActives++;
        }
        if (moy6 >= 1) {
            sommeTotale += moy6;
            notesActives++;
        }
        if (moy7 >= 1) {
            sommeTotale += moy7;
            notesActives++;
        }
        if (moy8 >= 1) {
            sommeTotale += moy8;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_anglais_finale.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneEconomie() {
        float moy1 = Float.parseFloat(moy_sem1_economie.getText().toString());
        float moy2 = Float.parseFloat(moy_sem2_economie.getText().toString());
        float moy3 = Float.parseFloat(moy_sem3_economie.getText().toString());
        float moy4 = Float.parseFloat(moy_sem4_economie.getText().toString());
        float moy5 = Float.parseFloat(moy_sem5_economie.getText().toString());
        float moy6 = Float.parseFloat(moy_sem6_economie.getText().toString());
        float moy7 = Float.parseFloat(moy_sem7_economie.getText().toString());
        float moy8 = Float.parseFloat(moy_sem8_economie.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }
        if (moy5 >= 1) {
            sommeTotale += moy5;
            notesActives++;
        }
        if (moy6 >= 1) {
            sommeTotale += moy6;
            notesActives++;
        }
        if (moy7 >= 1) {
            sommeTotale += moy7;
            notesActives++;
        }
        if (moy8 >= 1) {
            sommeTotale += moy8;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_economie_finale.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneSport() {
        float moy1 = Float.parseFloat(moy_sem1_edu_physique.getText().toString());
        float moy2 = Float.parseFloat(moy_sem2_edu_physique.getText().toString());
        float moy3 = Float.parseFloat(moy_sem3_edu_physique.getText().toString());
        float moy4 = Float.parseFloat(moy_sem4_edu_physique.getText().toString());
        float moy5 = Float.parseFloat(moy_sem5_edu_physique.getText().toString());
        float moy6 = Float.parseFloat(moy_sem6_edu_physique.getText().toString());
        float moy7 = Float.parseFloat(moy_sem7_edu_physique.getText().toString());
        float moy8 = Float.parseFloat(moy_sem8_edu_physique.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }
        if (moy5 >= 1) {
            sommeTotale += moy5;
            notesActives++;
        }
        if (moy6 >= 1) {
            sommeTotale += moy6;
            notesActives++;
        }
        if (moy7 >= 1) {
            sommeTotale += moy7;
            notesActives++;
        }
        if (moy8 >= 1) {
            sommeTotale += moy8;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_edu_physique_finale.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneSociete() {
        float moy1 = Float.parseFloat(moy_sem1_science.getText().toString());
        float moy2 = Float.parseFloat(moy_sem2_science.getText().toString());
        float moy3 = Float.parseFloat(moy_sem3_science.getText().toString());
        float moy4 = Float.parseFloat(moy_sem4_science.getText().toString());
        float moy5 = Float.parseFloat(moy_sem5_science.getText().toString());
        float moy6 = Float.parseFloat(moy_sem6_science.getText().toString());
        float moy7 = Float.parseFloat(moy_sem7_science.getText().toString());
        float moy8 = Float.parseFloat(moy_sem8_science.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }
        if (moy5 >= 1) {
            sommeTotale += moy5;
            notesActives++;
        }
        if (moy6 >= 1) {
            sommeTotale += moy6;
            notesActives++;
        }
        if (moy7 >= 1) {
            sommeTotale += moy7;
            notesActives++;
        }
        if (moy8 >= 1) {
            sommeTotale += moy8;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_societe_finale.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneLangueEtComm() {
        float moy1 = Float.parseFloat(moy_sem1_science.getText().toString());
        float moy2 = Float.parseFloat(moy_sem2_science.getText().toString());
        float moy3 = Float.parseFloat(moy_sem3_science.getText().toString());
        float moy4 = Float.parseFloat(moy_sem4_science.getText().toString());
        float moy5 = Float.parseFloat(moy_sem5_science.getText().toString());
        float moy6 = Float.parseFloat(moy_sem6_science.getText().toString());
        float moy7 = Float.parseFloat(moy_sem7_science.getText().toString());
        float moy8 = Float.parseFloat(moy_sem8_science.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }
        if (moy5 >= 1) {
            sommeTotale += moy5;
            notesActives++;
        }
        if (moy6 >= 1) {
            sommeTotale += moy6;
            notesActives++;
        }
        if (moy7 >= 1) {
            sommeTotale += moy7;
            notesActives++;
        }
        if (moy8 >= 1) {
            sommeTotale += moy8;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_langueEtComm_finale.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneCg() {
        float moy1 = Float.parseFloat(moy_societe_finale.getText().toString());
        float moy2 = Float.parseFloat(moy_langueEtComm_finale.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_tot_cg.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    private double calculMoyenneTotMod() {
        double moy1 = Float.parseFloat(moy_tot_mod_standard.getText().toString());
        double moy2 = Float.parseFloat(moy_tot_mod_interEntreprise.getText().toString());
        int notesActives = 0;

        if (moy1 >= 1) {
            notesActives++;
        }
        if (moy2 >= 1) {
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else if (moy1 < 1) {
            return moy2;
        } else if (moy2 < 1) {
            return moy1;
        } else {
            moy_tot_mod.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format((moy1 * 4 + moy2) / 5));
        }
    }

    private double calculMoyenneTotTot() {
        float moy1 = Float.parseFloat(moy_tot_cg.getText().toString());
        float moy2 = Float.parseFloat(moy_tot_ept.getText().toString());
        float moy3 = Float.parseFloat(moy_tot_mod.getText().toString());
        float moy4 = Float.parseFloat(moy_ate_finale.getText().toString());
        int notesActives = 0;
        float sommeTotale = 0;

        if (moy1 >= 1) {
            sommeTotale += moy1;
            notesActives++;
        }
        if (moy2 >= 1) {
            sommeTotale += moy2;
            notesActives++;
        }
        if (moy3 >= 1) {
            sommeTotale += moy3;
            notesActives++;
        }
        if (moy4 >= 1) {
            sommeTotale += moy4;
            notesActives++;
        }

        if (notesActives < 1) {
            return 0.5;
        } else {
            moy_tot_tot.setVisibility(View.VISIBLE);
            DecimalFormat df = new DecimalFormat("#.##");
            return Double.valueOf(df.format(sommeTotale / notesActives));
        }
    }

    //endregion
    //region couleurs
    private void changementCouleurFondMoyennes() {
        for (int i = 0; i < arr_txtViMoy.size(); i++) {
            double valeur = Double.valueOf(arr_txtViMoy.get(i).getText().toString());
            if (valeur < 4) {
                arr_txtViMoy.get(i).setBackgroundColor(getResources().getColor(R.color.red));
            } else if (valeur >= 4 && valeur <= 4.5) {
                arr_txtViMoy.get(i).setBackgroundColor(getResources().getColor(R.color.orange));
            } else {
                arr_txtViMoy.get(i).setBackgroundColor(getResources().getColor(R.color.green));
            }
        }
    }
    //endregion
}