package freemarker.sample;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerHelloworld {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();;
		cfg.setDirectoryForTemplateLoading(new File("F:/workspaces/eclipse_workspace/corejava/src/main/java/freemarker/sample"));
		
		Map root = new HashMap();
        root.put("message", "hello");
        root.put("username", "Jimmy");
        Template t = cfg.getTemplate("test.xml");
        t.process(root, new OutputStreamWriter(System.out));
//        try
//        {
//            t.process(root, System.out);
//            
//        } catch (TemplateException e)
//        {
//            e.printStackTrace();
//        }

		
		
	}

}
