package com.lf.minhalivraria.model.buscape;

public class Links {
    private Link link;

    public Links() {
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Links{" +
                "link=" + link +
                '}';
    }
}
