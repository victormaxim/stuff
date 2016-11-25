import static java.lang.System.out;

class UseAccount {
	public static void main(String args[]) {
		Account myAccount = new Account();
		Obiect mya = new Obiect();
		Account yourAccount = new Account();
		
		
		myAccount.name = "Barry Burd";
		myAccount.address = "222 Cyberspace Lane";
		myAccount.balance = 24;
		
		yourAccount.name = "Jane Q. Public";
		yourAccount.address = "111 Consumer Street";
		yourAccount.balance = 55.63;
		
		myAccount.display();
		//out.print(" plus $");
		out.println(myAccount.getInterest(5.0));
		//out.println(" interest ");
		out.println(myAccount.print("aclalul"));
		
		yourAccount.display();
		double yourInterestRate = 7.00;
		//out.print(" plus $");
		double yourInterestAmount = yourAccount.getInterest(yourInterestRate);
		out.print(yourInterestAmount);
		//out.println(" interest ");
	}
}