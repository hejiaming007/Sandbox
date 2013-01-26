package designPatterns.memento;

import java.util.LinkedList;
import java.util.List;

public class MementoHelloworld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<EditorMemento> states = new LinkedList<EditorMemento>();
		
		Editor editor = new Editor("editor content....v1.0");
		states.add(editor.save());
		editor.setContent("editor content....v2.0");
		states.add(editor.save());
		editor.setContent("editor content....v3.0");
		states.add(editor.save());
		
		//Restore to v1.0 state.
		editor.restoreToState(states.get(0));
		System.out.println(editor.getContent());//output result: editor content....v1.0
		
	}

}
