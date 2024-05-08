package pt.ipp.isep.dei.mdisc;

public class Edge implements Comparable<Edge> {
    int from;
    int to;
    double cost;

    public Edge(int from, int to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.cost, other.cost);
    }

    @Override
    public String toString() {
        return from + " -- " + to + " [Cost: " + cost + "]";
    }
}
