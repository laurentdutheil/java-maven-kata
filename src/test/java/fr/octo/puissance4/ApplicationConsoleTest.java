package fr.octo.puissance4;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationConsoleTest {

	private TestableApplicationConsole applicationConsole;

	@Before
	public void setUp() {
		applicationConsole = new TestableApplicationConsole();
	}

	@Test
	public void AfficherUneGrilleVideDansLaConsole() {

		Grille grilleVide = new Grille();

		applicationConsole.demarrerPartie();

		assertThat( applicationConsole.getMessage() ).isEqualTo(grilleVide.toString());
	}

	@Test
	public void AfficherLeJoueurQuiDoitJouer() {

		String messageAttendu = "jaune colonne [1-7] : ";

		applicationConsole.demarrerPartie();
		applicationConsole.afficherInvitationPourJouer();

		assertThat( applicationConsole.getMessage() ).isEqualTo(messageAttendu);
	}

	@Test
	public void RecupererLaColonneSaisieAuClavier() {

		applicationConsole.demarrerPartie();
		applicationConsole.afficherInvitationPourJouer();

		assertThat( applicationConsole.lireColonneAJouer() ).isEqualTo("3");
	}

	private class TestableApplicationConsole extends ApplicationConsole {

		private String message;

		@Override
		public void print(String message) {
			this.message = message;
		}

		@Override
		public String read() {
			return "3";
		}

		public String getMessage() {
			return message;
		}

	}

}
