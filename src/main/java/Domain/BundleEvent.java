package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BundleEvent implements Event {
    private List<Event> events;

    public String getName() {
        return name;
    }

    private String name;

    public BundleEvent(String name, Event[] event) {
        this.events = new ArrayList<>();
        this.name = name;
        this.events.addAll(Arrays.asList(event));
    }

    @Override
    public String getEvent() {
        return events.stream().map(Event::getEvent).collect(Collectors.joining(", ")) + ": " + name;
    }


}
