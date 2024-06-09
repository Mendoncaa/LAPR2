package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.PostponeController;
import pt.ipp.isep.dei.esoft.project.controller.TaskCompletionController;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class PostponeUI implements Runnable {
    private final PostponeController controller;

    public PostponeUI() {
        controller = new PostponeController();
    }

    private PostponeController getController() {
        return controller;
    }

    @Override
    public void run() {


    }


    private void submitData(Task task) {
        
    }
}
