package designPatterns.memento;

public class Editor {
	
	private String editorContents;
	
	public Editor(String editorContents) {
		this.editorContents = editorContents;
	}
	
	public void setContent(String editorContents) {
		this.editorContents = editorContents;
	}
	
	public String getContent() {
		return editorContents;

	}
	

	public void setState(String contents) {

		this.editorContents = contents;

	}

	public EditorMemento save() {
		return new EditorMemento(editorContents);

	}

	public void restoreToState(EditorMemento memento) {
		editorContents = memento.getSavedState();
	}

}
