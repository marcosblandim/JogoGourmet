package desafio.objective;

import java.util.ArrayList;
import java.util.List;

public class DishType {
	public String dishTypeName;
	public String dishName;
	List<DishType> subDishTypes = new ArrayList<DishType>();

	public DishType(String dishTypeName, String dishName) {
		this.dishTypeName = dishTypeName;
		this.dishName = dishName;
	}
	
	public void addSubDishType(DishType newSubDishType) {
		this.subDishTypes.add(newSubDishType);
	}
}
