package level3.exercise1;

import java.util.ArrayList;
import java.util.List;

public class NewsroomManager {
    private List<Editor> editors;

    public NewsroomManager(List<Editor> editors) {
        this.editors = new ArrayList<>();

    }


    public boolean addEditor(String name, String dni) {
        if(findEditorByDni(dni) != null){
            System.out.println("That editor already exist");
            return false;
        } Editor newEditor = new Editor(name, dni);
        return true;

    }

    private Editor findEditorByDni(String dni){
            for (Editor editor:editors){
                if(editor.getDni().equalsIgnoreCase(dni)){
                    return editor;
                }
            }
        return null;
    }


}
