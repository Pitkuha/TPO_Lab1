package Domain;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TimeLine {
    private List<Event> events;

    public TimeLine() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void execute() {
        int i = 0;
        for (Event event :
                events) {
            System.out.println(++i + " moment: " + event.getEvent());
        }
    }
}

class NothingEvent implements Event {

    @Override
    public String getEvent() {
        return null;
    }
}

class DomainObject {
    private final String name;
    private List<String> descs;

    DomainObject(String name, String[] descs) {
        this.name = name;
        this.descs = new ArrayList<String>();
        this.descs.addAll(Arrays.asList(descs));
    }

    public DomainObject(String name) {
        this(name, new String[]{});
    }

    public String getName() {
        return name;
    }

    public String getObject() {
        return getName() + (descs.size() > 0 ? " " + String.join(", ", descs) : "");
    }
}

class ObjectEvent implements Event {
    DomainObject object;
    Place place;
    Action action;
    private final String placePretext;

    public ObjectEvent(DomainObject object, String placePretext, Place place, Action action) {
        this.object = object;
        this.place = place;
        this.action = action;
        this.placePretext = placePretext;
    }

    public ObjectEvent(DomainObject object, Action action){
        this(object,null,null,action);
    }

    @Override
    public String getEvent() {
        return object.getObject() + (place != null ? " " + placePretext + " " + place.getName() : "" ) + " " + action.getName();
    }
}

class BundleEvent implements Event{
    private List<Event> events;
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

class EventAttribute {
    private final String name;

    public EventAttribute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Place extends EventAttribute {


    public Place(String name) {
        super(name);
    }
}

class Action extends EventAttribute {

    public Action(String name) {
        super(name);
    }
}
