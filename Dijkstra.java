import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    /**
     * Creates path from given source to all vertices
     * @param source
     */
    public void calculatePath(Vertex source) {
        source.setDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            Vertex actualVertex = queue.poll();
            for (Edge edge : actualVertex.getAdjacencyList()) {
                Vertex v = edge.getTargetVertex();
                double distance = actualVertex.getDistance() + edge.getWeight();
                if (distance < v.getDistance()) {
                    queue.remove(v);
                    v.setDistance(distance);
                    v.setPrevious(actualVertex);
                    queue.add(v);
                }
            }
        }
    }

    /**
     * Fetches the distance from the pre-computed path from the source
     * @param targetVertex
     * @return
     */
    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPrevious())
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }
}
