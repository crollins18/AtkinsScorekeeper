public class Runner{
	
	
private static class T implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
            if (SetTeams.frame.isVisible()) {
                // do the validation
                System.out.println("waiting");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    break;
                }
            }
        }	
	}

}

public static void main(String[] args) {
	Scorekeeper s = new Scorekeeper();
	SetTeams win = new SetTeams(s);
	new Thread(new T()).start();
	//VisualBoard v = new VisualBoard(s);
}

}

