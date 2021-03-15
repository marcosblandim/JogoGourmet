package desafio.objective;

import javax.swing.JOptionPane;

public class JogoGourmet {
	public static void main(String[] args) {
		// initialize data
		DishType originDishType = new DishType("Tipo origem", "Bolo de Chocolate");
		DishType firstDishType = new DishType("massa", "Lasanha");

		originDishType.subDishTypes.add(firstDishType);

		startGame(originDishType);
	}

	public static void startGame(DishType dishType) {
		int exitCondition = Screens.initialScreen();

		// game main loop
		while (exitCondition == JOptionPane.OK_OPTION) {
			iterateDishType(dishType);

			exitCondition = Screens.initialScreen();
		}
	}

	private static void iterateDishType(DishType dishType) {

		// ask if the dish is this type
		int typeResp;
		for (DishType subDishType : dishType.subDishTypes) {
			typeResp = Screens.yesNoScreen(subDishType.dishTypeName);

			// repeat the process for the new type
			if (typeResp == JOptionPane.OK_OPTION) {
				iterateDishType(subDishType);
				return;
			}
		}

		// try to guess the dish
		int dishResp = Screens.yesNoScreen(dishType.dishName);
		if (dishResp == JOptionPane.OK_OPTION) {
			Screens.guessedRightScreen();

		// add new type to the one we're iterating through
		} else if (dishResp == JOptionPane.NO_OPTION || dishResp == JOptionPane.CLOSED_OPTION) {
			DishType newDishType = Screens.newDishTypeScreens(dishType.dishName);
			dishType.addSubDishType(newDishType);
		}
	}
}
