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
            return false;
        } Editor newEditor = new Editor(name, dni);
        this.editors.add(newEditor);
        return true;
    }

    public boolean removeEditor(String dni) {
        Editor editorToDelete = findEditorByDni(dni);
        if(editorToDelete == null){
            return false;
        } else {
            return this.editors.remove(editorToDelete);

        }
    }

    /**
     //Another code version with removeIf

     public boolean removeEditor(String dni) {
     if (dni == null) {
     return false;
     }
     return this.editors.removeIf(editor -> dni.equalsIgnoreCase(editor.getDni()));
     }
     */

    public boolean assignNewsToEditor(String dni, News news) {
        Editor editorNews = findEditorByDni(dni);
        if(news == null || editorNews == null){

            return false;
        } else{
             editorNews.addNews(news);
            return true;
        }

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
