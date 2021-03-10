package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TimeLine {
    private List<Event> events;

    public TimeLine() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event getEvent(int index) { return events.get(index); }

    public void execute() {
        int i = 0;
        for (Event event :
                events) {
            System.out.println(++i + " moment: " + event.getEvent());
        }
    }
}

