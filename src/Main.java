import java.util.*;

public class Main {
    public static void main(String[] args) {

        int n = 0;
        int i = 0;
        int j = 0;
        int calculator = 0;

        List<Long> players = new ArrayList<>();

        try {
            //   Scanner scanner = new Scanner(System.in);
            Scanner scanner = new Scanner("2\n" +
                    "2  1");

            n = scanner.nextInt();

            while (scanner.hasNext()){
                players.add(scanner.nextLong());
            }

            scanner.close();

        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
            e.printStackTrace(System.out);
        }
        for (long player : players){
            if(player % 2 == 0){
                i++;
            }else{
                j++;
            }
        }
        if(i != j){
            System.out.println(-1 + " " + -1);
        }else{
            for (int temp = 1; temp < players.size(); temp++){
                int remainderTemp = temp % 2;
                long remainderPlayer = players.get(temp-1) % 2;
                int remainderTempNext = (temp+1) % 2;
                long remainderPlayerNext = players.get(temp) % 2;
                if((remainderTemp == 0 && remainderPlayer != 0 && remainderTempNext != 0 && remainderPlayerNext == 0) ||
                        (remainderTemp != 0 && remainderPlayer == 0 && remainderTempNext == 0 && remainderPlayerNext != 0)){
                    calculator++;
                    System.out.println(players.get(temp) + " " + players.get(temp-1));
                    break;
                }
            }
            if (calculator == 0){
                System.out.println(-1 + " " + -1);
            }
        }
    }
}