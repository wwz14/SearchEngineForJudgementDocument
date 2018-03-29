/**
 * Created by alice on 18/3/28.
 */
import java.io.FileOutputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
public class JDomDemo {
    public static void main(String[] args) {
        String file = ""; // 文件存放位置
        JDomDemo dj = new JDomDemo();
        dj.createXml(file);
        dj.parserXml(file);
    }
    /**
     * 生成XML
     * @param filePath 文件路径
     */
    public void createXml(String fileName) {
        Element root = new Element("persons");
        Document document = new Document(root);
        Element person = new Element("person");
        root.addContent(person);
        Element name = new Element("name");
        name.setText("java小强");
        person.addContent(name);
        Element sex = new Element("sex");
        sex.setText("man");
        person.addContent(sex);
        Element age = new Element("age");
        age.setText("23");
        person.addContent(age);
        XMLOutputter XMLOut = new XMLOutputter();
        try {
            Format f = Format.getPrettyFormat();
            f.setEncoding("UTF-8");//default=UTF-8
            XMLOut.setFormat(f);
            XMLOut.output(document, new FileOutputStream(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 解析XML
     * @param filePath 文件路径
     */
    public void parserXml(String fileName) {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(fileName);
            Element root = document.getRootElement();
            List persons = root.getChildren("person");
            for (int i = 0; i < persons.size(); i++) {
                Element person = (Element) persons.get(i);
                List pros = person.getChildren();
                for (int j = 0; j < pros.size(); j++) {
                    Element element = (Element) pros.get(j);
                    System.out.println(element.getName() + ":" + element.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
