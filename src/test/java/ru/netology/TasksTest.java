package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testSearchSimpleTaskTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertTrue(simpleTask.matches("Позвонить"));
        Assertions.assertFalse(simpleTask.matches("позвонить"));
    }

    @Test
    public void testSearchEpicSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertFalse(epic.matches("молоко"));
    }

    @Test
    public void testSearchMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertTrue(meeting.matches("версии"));
        Assertions.assertFalse(meeting.matches("Версии"));

        Assertions.assertTrue(meeting.matches("Приложение"));
        Assertions.assertFalse(meeting.matches("приложение"));
    }

    @Test
    public void testIdTask() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Task task = new Task(555);
        task.getId();

        Assertions.assertEquals(555, meeting.getId());
    }

    @Test
    public void testGetTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Assertions.assertEquals("Приложение НетоБанка", meeting.getProject());
        Assertions.assertEquals("Во вторник после обеда", meeting.getStart());
        Assertions.assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
    }
}
