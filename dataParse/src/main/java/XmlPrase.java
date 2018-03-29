import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import java.util.List;


import java.io.IOException;

/**
 * Created by alice on 18/3/28.
 */
public class XmlPrase {
    public static void main(String[] args) {
        try {
            XmlPrase("/Users/alice/Documents/misworkspace/dataParse/C__文书_民事二审案件_民事二审案件_17.xml");
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void XmlPrase (String filePath) throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(filePath);
        Element root = document.getRootElement();
        List law = root.getChild("QW").getChild("CPFXGC").getChild("CUS_FLFT_FZ_RY").getChildren();

        for(int i = 0; i< law.size();i++){
            Element fatiao = (Element) law.get(i);
            System.out.println(fatiao.getAttribute("value"));
        }

    }
}
