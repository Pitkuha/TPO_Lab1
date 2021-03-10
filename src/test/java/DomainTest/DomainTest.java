package DomainTest;

import Domain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DomainTest extends Assert {

    TimeLine timeLine;
    Event test;
    @Before
    public void init() {
        timeLine = new TimeLine();

        DomainObject a = new DomainObject("a");
        DomainObject b = new DomainObject("b");
        DomainObject c = new DomainObject("c");

        Place a_place = new Place("a");

        Action a_action = new Action("a");
        Action b_action = new Action("b");
        Action c_action = new Action("c");

        Event a_event = new NothingEvent();
        Event b_event = new ObjectEvent(a, "a", a_place, a_action);
        Event c_event = new ObjectEvent(b, b_action);

        Event d_event = new ObjectEvent(c, c_action);
        Event e_event = new BundleEvent("e", new Event[]{d_event});

        timeLine.addEvent(a_event);
        timeLine.addEvent(b_event);
        timeLine.addEvent(c_event);
        timeLine.addEvent(e_event);
    }

    @Test
    public void test() throws NullPointerException{


        test = timeLine.getEvent(0);
        NothingEvent a_event = (NothingEvent)test;

        test = timeLine.getEvent(1);
        ObjectEvent b_event = (ObjectEvent)test;
        assertEquals(b_event.getObject().getName(),"a");
        assertEquals(b_event.getPlace().getName(),"a");
        assertEquals(b_event.getAction().getName(),"a");

        test = timeLine.getEvent(2);
        ObjectEvent c_event = (ObjectEvent)test;
        assertEquals(c_event.getObject().getName(), "b");
//        Place temp;
//        assertThrows(NullPointerException.class, () -> c_event.getPlace());
//        Place tmp = c_event.getPlace();
        assertEquals(c_event.getAction().getName(),"b");

        test = timeLine.getEvent(3);
        BundleEvent e_event = (BundleEvent)test;
        assertEquals(e_event.getName(),"e");
    }

    @Test(expected = NullPointerException.class)
    public void test1() throws NullPointerException{
        test = timeLine.getEvent(2);
        ObjectEvent c_event = (ObjectEvent)test;
        c_event.getPlace().getName();
    }
}
