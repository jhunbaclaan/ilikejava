/* 
   made by jhun b.
*/
public class sideactivityrunner // the fun runner
{
    public static void main(String[] args)
    {
        saiyan Goku = new saiyan("Goku", 9001, true);
        Goku.sayName();
        Goku.scouter();
        Goku.eat();
        Goku.eat();        
        Goku.eat();
        Goku.eat();
        Goku.cannotDie();

        System.out.println();
        System.out.println();

        broly BROLY = new broly("BROLY", 190371, false);
        BROLY.scouter();
        BROLY.sayName();
        BROLY.chargeKi();
        BROLY.chargeKi();
        BROLY.chargeKi();
        BROLY.present();
        BROLY.cannotDie();
        
    }
}