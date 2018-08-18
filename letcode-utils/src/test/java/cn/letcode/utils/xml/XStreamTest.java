package cn.letcode.utils.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.junit.Test;

public class XStreamTest {

    @Test
    public void test() {
        String xmlStr = "<xml><field1>1</field1><field2>2</field2></xml>";
        XmlTest xmlTest = (XmlTest) XmlUtils.xmlStrToBean(xmlStr,XmlTest.class,"xml");
        System.out.println(xmlTest.getField1());
        System.out.println(xmlTest.getField2());

        System.out.println(XmlUtils.beanToString(xmlTest));
    }


    @XStreamAlias("xml")
    class XmlTest {
        private String field1;
        private String field2;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }
    }
}
