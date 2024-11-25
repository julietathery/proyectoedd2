/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author julietathery
 */
public class funcionesGrafo {
    /**
     * leer el json
     */
    Grafo graph = new Grafo();
    Functions f = new Functions();
    Functions use = new Functions();
    String infoGrafo1 = f.leerBaratheonJson("./src/proyectoedd2/Baratheon.json");
    String infoGrafo2 = f.leerTargeryenJson("./src/proyectoedd2/Targaryen.json");
    Lista family1 = use.getPersonas(infoGrafo1);
    Lista family2 = use.getPersonas(infoGrafo2);
    
    
    
    public Graph arbolcreation(Tree arbol) {
    System.setProperty("org.graphstream.ui", "swing");
    Graph graph = new SingleGraph("Family Tree");

    if (arbol.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El árbol no contiene información.");
        return graph; // Return the empty graph
    }

    // Create a queue for breadth-first traversal
    Queue<NodoArbol> queue = new Queue<>();
    queue.enqueue(arbol.getRoot());

    // Store node IDs to avoid duplicates
    Lista<String> nodeIds = new Lista<>();

    while (!queue.isEmpty()) {
        NodoArbol currentNode = queue.dequeue();
        Family currentData = (Family) currentNode.getData();
        String currentId = currentData.getName() + " " + currentData.getNumber();

        // Check if node already exists
        if (checkNodeIds(currentId, nodeIds)) {
            continue;
        }
        nodeIds.insertFinal(currentId);

        // Create a node in the graph with a label
        Node graphNode = graph.addNode(currentId);
        graphNode.setAttribute("ui.label", currentData.getName());

        // Add children to the queue
        NodoArbol child = currentNode.getSon();
        while (child != null) {
            Family childData = (Family) child.getData();
            String childId = childData.getName() + " " + childData.getNumber();

            graph.addEdge(currentId + "-" + childId, currentId, childId);
            Edge edge = graph.getEdge(currentId + "-" + childId);
            edge.setAttribute("ui.label", "is child of");
            edge.setAttribute("ui.style", "arrow-shape: arrow;");

            queue.enqueue(child);
            child = child.getSib();
        }
    }

    graph.setAttribute("ui.stylesheet", "node { shape: rounded-box; fill-color: lightblue; }");
    graph.display();
    return graph;
}

    
    // Método auxiliar para verificar si un nodo existe en la lista
    private boolean checkNodeIds(String currentId, Lista<String> nodeIds) {
        for (int i = 0; i < nodeIds.getSize(); i++) {
            if (nodeIds.getDato(i).getElement().equals(currentId)) {
                return true;
            }
        }
        return false;
    }
       

    
    
    /**
     * Metodo que permite visualizar el grafo 
     * @param graph 
     */
    
    public void viewGraph(Graph graph) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout()){
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(640, 480);
            }
        };
        frame.setSize(panel.getWidth(), panel.getHeight());
        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false);
        panel.add(viewPanel);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);  
        
    }
    
    
    

    /**
     * metodo que busca un nodo
     * @param root
     * @param member
     * @return 
     */
    private NodoArbol findNode(NodoArbol root, Family member) {
        if (root == null) {
            return null;
        }
        if (root.getData().equals(member)) {
            return root;
        }
        NodoArbol found = findNode(root.getSon(), member); // Buscar en los hijos
        if (found != null) {
            return found;
        }
        return findNode(root.getSib(), member); // Buscar en los hermanos
    }
    
    
    /**
     * Metodo que busca al padre
     * @param member
     * @param familyList
     * @return 
     */
    private Family findParent(Family member, Lista familyList) {
        String fatherName = member.getFather(); // Obtener el nombre del padre
        for (int i = 0; i < familyList.getSize(); i++) {
            Family current = (Family) familyList.getDato(i).getElement();
            if (current.getName().equals(fatherName)) {
                return current; // Retornar el objeto Family del padre
            }
        }
        return null; // Retornar null si no se encuentra el padre
    }
    
   
}

    
    
    
       
        
     
