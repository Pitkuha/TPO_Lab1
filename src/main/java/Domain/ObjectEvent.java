package Domain;

public class ObjectEvent implements Event {

    private DomainObject object = null;
    private Place place = null;
    private Action action = null;
    private final String placePretext;

    public ObjectEvent(DomainObject object, String placePretext, Place place, Action action) {
        this.object = object;
        this.place = place;
        this.action = action;
        this.placePretext = placePretext;
    }

    public ObjectEvent(DomainObject object, Action action) {
        this(object, null, null, action);
    }

    @Override
    public String getEvent() {
        return object.getObject() + (place != null ? " " + placePretext + " " + place.getName() : "") + " " + action.getName();
    }

    public DomainObject getObject() {
        return object;
    }

    public Place getPlace() throws NullPointerException{
        return place;
    }

    public Action getAction() {
        return action;
    }
}
