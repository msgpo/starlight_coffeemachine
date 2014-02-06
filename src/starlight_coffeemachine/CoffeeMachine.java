package starlight_coffeemachine;

import java.util.Scanner;

public class CoffeeMachine 
{
	private Cashbox pCashbox;
	private Mixer pMixer;
	private Selector pSelector;
	private Scanner in;
	
	public CoffeeMachine()
	{
		pCashbox = new Cashbox();
		pMixer = new Mixer();
		pSelector = new Selector(pCashbox, pMixer);
		in = new Scanner(System.in);
	}
	
	public boolean doOneAction() 
	{
		String action;
		action = in.next();
		if (action.equals("insert")) {
			int value;
			value = in.nextInt();
			pCashbox.deposit(value);
		} else if (action.equals("select")) {
			String choice;
			choice = in.next();
			try {
				pSelector.select(Selection.valueOf(choice.toUpperCase()));
			} catch (IllegalArgumentException e) {
				return true;
			}
		} else if (action.equals("quit"))
			return false;
		return true;
	}
	
	public static void main(String[] args) 
	{
		CoffeeMachine cm = new CoffeeMachine();
		do
		{
			;
		}
		while (cm.doOneAction());
	}

}
