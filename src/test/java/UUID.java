import me.bestsamcn.blog.utils.Tools;
import org.junit.Test;

import java.util.Date;

/**
 * @Author: Sam
 * @Date: 2018/11/11 18:44
 */
public class UUID {

    @Test
    public static void main(){
        String id1 = Tools.getUUID();
        String id2 = Tools.getUUID();
        String id3 = Tools.getUUID();

        Date date = new Date(0);
    }

}
