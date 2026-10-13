import java.util.ArrayList;

class Candidate {
    String name;
    int rollNumber;
    String position;
    int votes;

    // Constructor 1: Without votes
    Candidate(String name, int rollNumber, String position) {
        this(name, rollNumber, position, 0);
    }

    // Constructor 2: With votes
    Candidate(String name, int rollNumber, String position, int votes) {
        this.name = name.trim();
        this.rollNumber = rollNumber;
        this.position = position.trim().toUpperCase();
        this.votes = votes;
    }

    // Validate candidate details
    boolean isValid() {
        return name != null && !name.trim().isEmpty()
                && rollNumber > 0
                && position != null && !position.trim().isEmpty()
                && votes >= 0;
    }

    // Method overloading: Compare with a String
    boolean isDuplicate(String candidateName) {
        return name.equalsIgnoreCase(candidateName.trim());
    }

    // Method overloading: Compare with another Candidate
    boolean isDuplicate(Candidate other) {
        return name.equalsIgnoreCase(other.name);
    }

    // Display candidate details
    void display() {
        System.out.println("\nCandidate Registered Successfully\n");
        System.out.printf("%-20s: %s%n",
                "Candidate Name", name.toUpperCase());
        System.out.printf("%-20s: %d%n",
                "Roll Number", rollNumber);
        System.out.printf("%-20s: %s%n",
                "Position", position);
        System.out.printf("%-20s: %d%n",
                "Votes Received", votes);
    }
}

public class StudentCouncilElection {

    // Check for duplicate nominations
    static boolean isDuplicate(ArrayList<Candidate> candidates,
                               Candidate candidate) {
        for (Candidate c : candidates) {
            if (c.isDuplicate(candidate)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();

        System.out.println(
                "========== STUDENT COUNCIL ELECTION ==========");

        // Create candidates using constructors
        Candidate c1 = new Candidate(
                "Ananya", 101, "President", 125);

        Candidate c2 = new Candidate(
                "Rahul", 102, "President", 98);

        Candidate c3 = new Candidate(
                "ANANYA", 103, "President", 50);

        // Register first candidate
        if (c1.isValid()) {
            candidates.add(c1);
            c1.display();
        }

        // Register second candidate
        if (c2.isValid() && !isDuplicate(candidates, c2)) {
            candidates.add(c2);
            c2.display();
        }

        // Check duplicate candidate
        System.out.println("\nDuplicate Candidate Check:");

        if (isDuplicate(candidates, c3)) {
            System.out.printf("%-20s: %s%n",
                    "Candidate Name", c3.name.toUpperCase());
            System.out.printf("%-20s: Duplicate Nomination%n",
                    "Status");
        } else if (c3.isValid()) {
            candidates.add(c3);
            c3.display();
        }

        // Find the winner for each position
        System.out.println("\n---------- ELECTION RESULTS ----------");

        String[] positions = {
                "PRESIDENT",
                "VICE-PRESIDENT",
                "SECRETARY"
        };

        for (String position : positions) {
            Candidate winner = null;

            for (Candidate c : candidates) {
                if (c.position.equals(position)) {
                    if (winner == null || c.votes > winner.votes) {
                        winner = c;
                    }
                }
            }

            if (winner != null) {
                System.out.printf("%-20s: %s%n",
                        "Position", position);
                System.out.printf("%-20s: %s%n",
                        "Winning Candidate",
                        winner.name.toUpperCase());
                System.out.printf("%-20s: %d%n",
                        "Total Votes", winner.votes);
            }
        }

        System.out.println("=============================================");
    }
}
