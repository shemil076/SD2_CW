import java.io.*;

// Java program to implement
// a Singly Linked List
public class WaitingList {

    Node head; // head of list

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {

        Patient data;
        Node next;

        // Constructor
        Node(Patient d)
        {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node
    public static WaitingList insert(WaitingList list, Patient data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    // Method to print the WaitingList.
    public static void printList(WaitingList list)
    {
        Node currentPatient = list.head;

        System.out.print("WaitingList: ");

        // Traverse through the WaitingList
        while (currentPatient != null) {
            // Print the data at current node
            System.out.print(currentPatient.data.getPatientFirstName() + " ");

            // Go to next node
            currentPatient = currentPatient.next;
        }
    }


    public static String deleteByvaccineType(WaitingList list, String vaccineType)
    {
        // Store head node
        Node currentPatient = list.head, prev = null;

        //
        // CASE 1:
        // If head node itself holds the vaccineType to be deleted

        if (currentPatient != null && currentPatient.data.getPatientVaccineType() == vaccineType) {
            list.head = currentPatient.next; // Changed head

            // Display the message


            // Return the updated List
            return currentPatient.data.getPatientFirstName();
        }

        //
        // CASE 2:
        // If the vaccineType is somewhere other than at head
        //

        // Search for the vaccineType to be deleted,
        // keep track of the previous node
        // as it is needed to change currentPatient.next
        while (currentPatient != null && currentPatient.data.getPatientVaccineType() != vaccineType) {
            // If currentPatient does not hold vaccineType
            // continue to next node
            prev = currentPatient;
            currentPatient = currentPatient.next;
        }

        // If the vaccineType was present, it should be at currentPatient
        // Therefore the currentPatient shall not be null
        if (currentPatient != null) {
            // Since the vaccineType is at currentPatient
            // Unlink currentPatient from linked list
            prev.next = currentPatient.next;

            // Display the message

        }

        //
        // CASE 3: The vaccineType is not present
        //

        // If vaccineType was not present in linked list
        // currentPatient should be null
        if (currentPatient == null) {
            // Display the message
            System.out.println(vaccineType + " not found");
        }

        // return the List
        return currentPatient.data.getPatientFirstName();
    }
}
