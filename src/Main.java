import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.FactAddressValue;
import net.sf.clipsrules.jni.MultifieldValue;
import net.sf.clipsrules.jni.PrimitiveValue;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Environment clips = new Environment();
        clips.loadFromResource("/cool.clp");

        System.out.print(" IS Maged cool [Y/N] ? : ");
        Scanner sc = new Scanner(System.in);
        String o = sc.next();

        if(o .equals("y") || o.equals("Y"))
            clips.eval("(assert (maged cool))");
        if(o.equals("n") || o.equals("N"))
            clips.eval("(assert (maged notcool))");

        clips.run();

        PrimitiveValue value=clips.eval("(facts)");
        String ou = value.toString();
        System.out.println(ou);

        FactAddressValue fv = (FactAddressValue)((MultifieldValue) clips.eval("(find-fact ((?x Coolness)) TRUE)")).get(0);
        String m = fv.getFactSlot("cool").toString();
        System.out.println(m);

    }
}
