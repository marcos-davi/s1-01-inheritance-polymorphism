package level3.exercise1;

import java.util.ArrayList;
import java.util.List;

public class NewsroomManager {
    private List<Editor> editors;

    public NewsroomManager(List<Editor> editors) {
        this.editors = new ArrayList<>();

    }


    public boolean addEditor(String name, String dni) {
        if (findEditorByDni(dni) != null) {
            return false;
        }
        Editor newEditor = new Editor(name, dni);
        this.editors.add(newEditor);
        return true;
    }

    public boolean removeEditor(String dni) {
        Editor editorToDelete = findEditorByDni(dni);
        if (editorToDelete == null) {
            return false;
        } else {
            return this.editors.remove(editorToDelete);

        }
    }

    /**
     * //Another code version with removeIf
     * <p>
     * public boolean removeEditor(String dni) {
     * if (dni == null) {
     * return false;
     * }
     * return this.editors.removeIf(editor -> dni.equalsIgnoreCase(editor.getDni()));
     * }
     */

    public boolean assignNewsToEditor(String dni, News news) {
        Editor editorNews = findEditorByDni(dni);
        if (news == null || editorNews == null) {
            return false;
        } else {
            editorNews.addNews(news);
            return true;
        }
    }

    public boolean removeNewsFromEditor(String dni, String headline) {
        Editor editorToRemoveNews = findEditorByDni(dni);
        if (editorToRemoveNews == null) {
            return false;
        }
        return editorToRemoveNews.removeNews(headline);
    }

    public List<News> getNewsByEditor(String dni) {
        Editor editorListNews = findEditorByDni(dni);
        if (editorListNews == null) {
            return null;
        }
        return editorListNews.getNewsList();

    }

    private Editor findEditorByDni(String dni) {
        for (Editor editor : editors) {
            if (editor.getDni().equalsIgnoreCase(dni)) {
                return editor;
            }
        }
        return null;
    }

    public double calculateNewsPrice(String dni, String headline) {
        Editor editor = findEditorByDni(dni);
        if (editor == null) {
            return -1.0;
        }
        News news = findNewsByHeadline(editor, headline);
        if (news == null) {
            return -1.0;
        }
        return news.calculatePrice();
    }

    public int calculateNewsScore(String dni, String headline) {
        Editor editor = findEditorByDni(dni);
        if (editor == null) {
            return -1;
        }
        News news = findNewsByHeadline(editor, headline);
        if (news == null) {
            return -1;
        }
        return news.calculateScore();
    }

    private News findNewsByHeadline(Editor editor, String headline) {
        if(editor == null || headline == null){
            return null;
        }
        for (News news : editor.getNewsList()) {
            if (news.getHeadline().equalsIgnoreCase(headline)) {
                return news;
            }
        }
        return null;
    }


}
