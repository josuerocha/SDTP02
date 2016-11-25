import java.util.ArrayList;

public class TimeCounter extends Thread {

    public TimeCounter() {

    }

    public void run() {
        try {
            while (true) {
		
		for(int i = 0;i<Servidor.leiloes.size(); i++){

                		String[] sample = Servidor.leiloes.get(i).split(" ");
                
		        	if (sample.length == 5){

					int time = Integer.parseInt(sample[4]);
					time--;
					Servidor.leiloes.set(i, sample[0] + " " + sample[1] + " " + sample[2] + " " + sample[3] + " " + time);
			}
		}

                sleep(1000);
            }

        } 
	
	catch (Exception e) {
            e.printStackTrace();
        }
    }

}

