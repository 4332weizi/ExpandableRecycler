package io.auxo.expandablerecycler;

import java.util.ArrayList;
import java.util.List;

import io.auxo.widget.er.Node;
import io.auxo.widget.er.SimpleNode;

public class AreaNode extends SimpleNode<Area> {

    public AreaNode(int level, Area value) {
        super(level, value);
        List<Area> children = value.getAreaList();
        if (children == null) {
            children = new ArrayList<>();
        }
        List<Node<Area>> childNodes = new ArrayList<>();
        for (Area area : children) {
            if (area != null) {
                childNodes.add(new AreaNode(level + 1, area));
            }
        }
        setChildNodes(childNodes);
    }
}
