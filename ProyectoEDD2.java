/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoedd2;

/**
 *
 * @author julietathery
 */
public class ProyectoEDD2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Interfaz1 ventana = new Interfaz1();
    ventana.setVisible(true);

    // Crear los árboles
    Tree targaryenTree = new Tree();
    Tree baratheonTree = new Tree();

    // Leer los datos de los archivos JSON
    Functions functions = new Functions();
    String infoGrafo1 = functions.leerBaratheonJson("./src/proyectoedd2/Baratheon.json");
    String infoGrafo2 = functions.leerTargeryenJson("./src/proyectoedd2/Targaryen.json");
    Lista family1 = functions.getPersonas(infoGrafo1);
    Lista family2 = functions.getPersonas(infoGrafo2);

    // Insertar nodos en el árbol Targaryen
    for (int i = 0; i < family2.getSize(); i++) {
        Family member = (Family) family2.getDato(i).getElement();
        NodoArbol node = new NodoArbol(member);

        if (i == 0) {
            targaryenTree.create(node.getData()); // Insertar la raíz
        } else {
            Family parentMember = findParent(member, family2); // Implementa este método
            NodoArbol parentNode = targaryenTree.getRoot().findNode(parentMember);
            targaryenTree.insert(node.getData(), parentNode);
        }
    }

    // Insertar nodos en el árbol Baratheon (similar al anterior)
    for (int i = 0; i < family1.getSize(); i++) {
        Family member = (Family) family1.getDato(i).getElement();
        NodoArbol node = new NodoArbol(member);

        if (i == 0) {
            baratheonTree.create(node.getData()); // Insertar la raíz
        } else {
            Family parentMember = findParent(member, family1); // Implementa este método
            NodoArbol parentNode = baratheonTree.getRoot().findNode(parentMember);
            baratheonTree.insert(node.getData(), parentNode);
        }
    }

    funcionesGrafo funciones = new funcionesGrafo();
    funciones.arbolcreation(targaryenTree);
    funciones.arbolcreation(baratheonTree);
    }
    
    private static Family findParent(Family member, Lista familyList) {
        if (member.getFather() == null) {
            return null; // If the member has no father, return null
        }

        String fatherName = member.getFather();
        for (int i = 0; i < familyList.getSize(); i++) {
            Family current = (Family) familyList.getDato(i).getElement();
            if (current.getName().equals(fatherName)) {
                return current;
            }
        }
        return null;
    }
    
    
}
    


