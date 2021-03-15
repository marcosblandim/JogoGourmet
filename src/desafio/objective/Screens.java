package desafio.objective;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Screens {

	private static final JLabel INITIAL_SCREEN_LABEL = new JLabel("Pense em um prato que gosta");

	static {
		INITIAL_SCREEN_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
	}

	static int initialScreen() {
		String title = "Jogo Gourmet";
		String[] ok_options = { "OK" };

		int userResponse = JOptionPane.showOptionDialog(null, INITIAL_SCREEN_LABEL, title, JOptionPane.PLAIN_MESSAGE,
				JOptionPane.PLAIN_MESSAGE, null, ok_options, null);
		return userResponse;
	}

	static int yesNoScreen(String dishIs) {
		String message = String.format("O prato que você pensou é %s?", dishIs);
		String title = "Confirm";

		int userResponse = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		return userResponse;
	}

	static void guessedRightScreen() {
		String message = "Acertei de novo!";
		String title = "Jogo Gourmet";

		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	static DishType newDishTypeScreens(String previousDishName) {
		// get new type dish-name
		String dishNameMessage = "Qual prato você pensou?";
		String newDishName = JOptionPane.showInputDialog(null, dishNameMessage, "Desisto",
				JOptionPane.QUESTION_MESSAGE);

		// get new type name
		String dishTypeMessage = String.format("é ________ mas %s não.", previousDishName);
		String newDishTypeName = JOptionPane.showInputDialog(null, dishTypeMessage, "Complete",
				JOptionPane.QUESTION_MESSAGE);

		DishType newDishType = new DishType(newDishTypeName, newDishName);
		return newDishType;
	}
}
