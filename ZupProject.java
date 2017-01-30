import java.util.*;

/**
 *
 * @author Rafael
 */
public class ZupProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String initialPosition = "";
        String move = "";
        boolean ok = true;

        for (int i = 0; i < 2; i++) {
            Robot r = new Robot();
            while (ok) {
                System.out.println("Enter the initial position(two integers and a cardinal position): ");
                initialPosition = userInput.nextLine();
                if (r.verifyPosition(initialPosition)) {
                    ok = false;
                }
                else{
                    System.out.println("The input data is invalid");
                }
            }
            ok = true;
            while (ok) {
                System.out.println("Enter the controls(L,R or M): ");
                move = userInput.nextLine();
                if (r.movement(move)) {
                    ok = false;
                }
                else{
                    System.out.println("The input data is invalid");
                }
            }
            ok = true;
            System.out.println(r.getX()+" "+r.getY()+" "+r.getDirection());
        }
    }

}
