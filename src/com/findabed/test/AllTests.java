package com.findabed.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAutocompletion.class, TestDetailsAnnonce.class,
		testFormulaireInscription.class, TestGestionAnnonces.class,
		TestGestionReservations.class, TestLogin.class,
		TestModifierAnnonce.class, TestProfil.class, testPublication.class,
		TestRecherche.class, TestReservation.class,
		TestSuppressionReservation.class, TestSupressionAnnonce.class,
		TestVisualisation.class })
public class AllTests {

}
