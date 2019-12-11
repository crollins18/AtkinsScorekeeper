public class Runner extends Thread{
	
	static Scorekeeper s;
	
public static class T implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
            if (SetTeams.frame.isVisible()) {
                // do the validation
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                  
                }
            }
            else {
            	VisualBoard v = new VisualBoard(s);
            	break;
            }
        }	
	}


}

public Runner()  {
	s = new Scorekeeper();
	SetTeams win = new SetTeams(s);
	new Thread(new T()).start();
}

public static void main (String args[]) throws InterruptedException {
	Runner r = new Runner();
}

}

