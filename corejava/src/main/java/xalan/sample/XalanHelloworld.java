package xalan.sample;

import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XalanHelloworld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(
					"C:/Users/hejiaming/Desktop/新建文件夹/cdcatalog.xsl"));
			transformer.transform(new StreamSource("C:/Users/hejiaming/Desktop/新建文件夹/cdcatalog1.xml"),
					new StreamResult(new FileOutputStream("output.out")));
			System.out
					.println("************* The result is in output.out *************");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
