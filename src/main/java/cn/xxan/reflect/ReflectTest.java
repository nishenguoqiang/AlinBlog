package cn.xxan.reflect;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class ReflectTest {


    public static void main(String[] args) throws Exception{
        String path = "/job-class.xml";
        InputStream is = ReflectTest.class.getResourceAsStream(path);
        UserInfo userInfo = new UserInfo();
        userInfo.setWife("小莉");
        userInfo.setAddress("西安市");
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(is);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for(Element e:elements){
                String name = e.attributeValue("name");
                String clsName = e.attributeValue("class");
                String age = e.elementText("age");
                if ("woman".equals(name)) {
                    Class<?> clazz = Class.forName(clsName);
//                    User user = (User) clazz.getConstructor(String.class, int.class).newInstance("张三", 29);
                    User user = (User)clazz.getConstructor(UserInfo.class).newInstance(userInfo);
                    user.setWife(userInfo.getWife());
                    System.out.println(user.getWife());
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
