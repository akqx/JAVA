package Projekt.Czynnosciowe;

import java.util.ArrayList;
import java.util.List;

public class CommandSale {
	private List<Command> commandList = new ArrayList<Command>();

	public void takeOrder(Command command) {
		commandList.add(command);
	}

	public void placeOrders() {

		for (Command order : commandList) {
			order.execute();
		}
		commandList.clear();
	}
}