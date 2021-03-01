package Domain;

public class Huy {
    public static void main(String[] args) {
        TimeLine timeLine = new TimeLine();

        Event e1 = new NothingEvent();
        timeLine.addEvent(e1);

        DomainObject something = new DomainObject("что-то");
        Place bigWindow = new Place("Край огромного экрана");
        Action lightenUp = new Action("Засветилось");
        Event e2 = new ObjectEvent(something,"на",bigWindow,lightenUp);
        timeLine.addEvent(e2);

        DomainObject star = new DomainObject("Звезда", new String[] {"Красное", "Величиной с тарелку"});
        Place thatPlace = new Place("нему");
        Action crouched = new Action("Ползла");
        Event e3 = new ObjectEvent(star, "по", thatPlace, crouched);

        DomainObject oneMore = new DomainObject("Ещё одна");
        Event e4 = new ObjectEvent(oneMore,crouched);

        Event e5 = new BundleEvent("Бинарная звездная система",new Event[] {e3, e4});
        timeLine.addEvent(e5);

        DomainObject halfMoon = new DomainObject("Полумесяц", new String[] {"Большой", "Красный свет, переходящий в черноту", "ночная сторона планеты"});
        Action appeared = new Action("Возник");
        Event e6 = new ObjectEvent(halfMoon, appeared);
        timeLine.addEvent(e6);

        timeLine.execute();

    }
}
