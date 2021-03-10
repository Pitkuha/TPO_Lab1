package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DomainObject {
    private final String name;
    private List<String> descs;

    public DomainObject(String name, String[] descs) {
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
