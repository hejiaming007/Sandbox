package velocity.sample;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;

public class VelocityHelloworld {

	Template template = null;

	StringWriter writer;

	VelocityContext context = new VelocityContext();

	public VelocityHelloworld() {

	}

	public void loadTemplateFromString() {

		writer = new StringWriter();

		Properties props = new Properties();
		try {
			props.load(ClassLoader.getSystemClassLoader().getResourceAsStream(
					"velocity/sample/velocity_string.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		VelocityEngine ve = new VelocityEngine();
		ve.init(props);

		StringResourceRepository repo = (StringResourceRepository) ve
				.getApplicationAttribute("stringRepo");

		String myTemplateName = "/stringTemplate.vm";
		String stringTemplate = "Hi, ${username}... this is some template!";
		repo.putStringResource(myTemplateName, stringTemplate);

		try {
			template = ve.getTemplate(myTemplateName);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		} catch (ParseErrorException e) {
			e.printStackTrace();
		}

		context.put("username", "jimmy");

		if (template != null) {
			template.merge(context, writer);
		}

		try {
			System.out.println(writer.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void loadTemplateFromClasspath() {

		writer = new StringWriter();

		try {

			Properties props = new Properties();
			try {
				props.load(ClassLoader.getSystemClassLoader()
						.getResourceAsStream(
								"velocity/sample/velocity.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			VelocityEngine ve = new VelocityEngine();
			ve.init(props);

			context.put("list", getNames());

			String templateFile = "velocity/sample/example.vm";

			try {
				template = ve.getTemplate(templateFile);
			} catch (ResourceNotFoundException e) {
				e.printStackTrace();
			} catch (ParseErrorException e) {
				e.printStackTrace();
			}

			if (template != null)
				template.merge(context, writer);

			System.out.println(writer.toString());

			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getNames() {
		ArrayList<String> list = new ArrayList<String>();

		list.add("ArrayList element 1");
		list.add("ArrayList element 2");
		list.add("ArrayList element 3");
		list.add("ArrayList element 4");

		return list;
	}

	public static void main(String[] args) {
		VelocityHelloworld helloworld = new VelocityHelloworld();
		System.out.println("===========================");
		helloworld.loadTemplateFromClasspath();
		System.out.println("===========================");
		helloworld.loadTemplateFromString();
	}
}
