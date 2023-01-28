public class UnmarkCommand extends Command {
    private final int TASK_NUM;

    public UnmarkCommand(String taskNum) {
        this.TASK_NUM = Integer.parseInt(taskNum);
    }

    @Override
    public void execute(TaskList tasksList, TextUi ui, Storage storage) {
        tasksList.unMark(TASK_NUM);
        Task unMarkedTask = tasksList.get(TASK_NUM);
        ui.showUnmarkTaskMessage(unMarkedTask);
        storage.saveToFile(tasksList.getList());
    }

    @Override
    public boolean isExit() {
        return false;
    }

}