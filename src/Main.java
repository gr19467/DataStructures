import acm.program.GraphicsProgram;
import com.prog2.interfaces.List;

public class Main extends GraphicsProgram {

    void printList(List a){
        // System.out.println("-------------------------------------------------");
        for (int i = 0; i < a.getLength(); i++) {
            System.out.println(a.get(i));
        }
        System.out.println("-------------------------------------------------");
    }

    void test(){
        Calculator calculator = new Calculator();
        add(calculator);
    }

    public static void main(String[] args) {
        Main mainMan = new Main();
        mainMan.test();
    }

}
