package starlight_coffeemachine;

public class Selector 
{
	private Cashbox pCashBox;
	private Mixer pMixer;
	
	public Selector(Cashbox pC, Mixer pM)
	{
		pCashBox = pC;
		pMixer = pM;
	}
	
	public void select(final Selection s)
	{
		int amount = s.priceOf();
		if(pCashBox.haveYou(amount)){
			pMixer.make(s);
			pCashBox.deduct(amount);
		}
		else{
			System.out.println("\tSelector: Insufficient funds");
		}
	}
	
	
}
