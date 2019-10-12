package com.example.cooless.POJOs;

import java.util.List;

public class Slice {

    private Destination destination;
    private String duration;
    private Origin origin;
    private List<Segment> segments = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Slice() {
    }

    /**
     *
     * @param duration
     * @param segments
     * @param origin
     * @param destination
     */
    public Slice(Destination destination, String duration, Origin origin, List<Segment> segments) {
        super();
        this.destination = destination;
        this.duration = duration;
        this.origin = origin;
        this.segments = segments;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Slice withDestination(Destination destination) {
        this.destination = destination;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Slice withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Slice withOrigin(Origin origin) {
        this.origin = origin;
        return this;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public Slice withSegments(List<Segment> segments) {
        this.segments = segments;
        return this;
    }

}
